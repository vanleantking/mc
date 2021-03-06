/**
  *	@author Nguyen Hua Phung
  *	@version 1.0
  *	23/10/2015
  * 	This file provides a simple version of code generator
  *
  */

package mc.codegen





//import mc.checker._
import mc.utils._
import java.io.{PrintWriter, File}


object CodeGenerator extends Utils {
  val libName = "io"
  def init() = List(Symbol("getInt",FunctionType(List(),IntType),CName(libName)),
    Symbol("putInt",FunctionType(List(IntType),VoidType),CName(libName)),
    Symbol("putIntLn",FunctionType(List(IntType),VoidType),CName(libName)),
    Symbol("getFloat",FunctionType(List(),FloatType),CName(libName)),
    Symbol("putFloat",FunctionType(List(FloatType),VoidType),CName(libName)),
    Symbol("putFloatLn",FunctionType(List(FloatType),VoidType),CName(libName)),
    Symbol("putBool",FunctionType(List(BoolType),VoidType),CName(libName)),
    Symbol("putBoolLn",FunctionType(List(BoolType),VoidType),CName(libName)),
    Symbol("putString",FunctionType(List(StringType),VoidType),CName(libName)),
    Symbol("putStringLn",FunctionType(List(StringType),VoidType),CName(libName)),
    Symbol("putLn",FunctionType(List(),VoidType),CName(libName)))


  def gen(ast:AST,dir:File) = {

    val gl = init()
    val gc = new CodeGenVisitor(ast,gl,dir)
    gc.visit(ast, null);
  }
}




case class ClassType(cname:String) extends Type
case class FunctionType(input:List[Type],output:Type) extends Type



//case class SubContext(emit:Emitter,decl:List[Decl])

case class SubBody(frame:Frame,sym:List[Symbol])

case class Access(val frame:Frame,val sym:List[Symbol],val isLeft:Boolean = true,val isFirst:Boolean = true)

trait Val
case class Index(value:Int) extends Val
case class CName(value:String) extends Val

case class Symbol(name:String,typ:Type, value:Val)






class CodeGenVisitor(astTree:AST,env:List[Symbol],dir:File) extends BaseVisitor with Utils {

  val className = "MCClass"
  val path = dir.getPath()
  val emit = new Emitter(path+"/"+className+".j")

  override def visitProgram(ast:Program,c:Any) = {


    emit.printout(emit.emitPROLOG(className, "java.lang.Object"))
    val newEnv = ast.decl.filter(_.isInstanceOf[VarDecl]).foldLeft(env) ((e,x)=> {
      val vdecl = x.asInstanceOf[VarDecl]
      //ast.decl.filter(p=>p.isInstanceOf[VarDecl]).foldLeft(env)((e,x)=>
      emit.printout(emit.emitATTRIBUTE(vdecl.variable.name, vdecl.varType,false, ""))
      Symbol(vdecl.variable.name, vdecl.varType, CName(className)) :: e})

//    val glEnv2 = ast.decl.filter(_.isInstanceOf[FuncDecl]).foldLeft(newEnv)((x, y) => {
//      val funcs = y.asInstanceOf[FuncDecl]
//      Symbol(funcs.name.name,
//        FunctionType(funcs.param.foldRight(List[Type]())((a, b) => a.varType :: b), funcs.returnType),
//        CName(className)) :: x
//    })

    ast.decl.filter(p=>p.isInstanceOf[FuncDecl]).foldLeft(SubBody(null,newEnv))((e,x) => visit(x,e).asInstanceOf[SubBody])
    // generate default constructor
    genMETHOD(
      FuncDecl(Id("<init>"),List(),null,Block(List(),List())),c,new Frame("<init>",VoidType))
    emit.emitEPILOG()
    c
  }



  /** generate code for default constructor

    *  @param consdecl the function declaration whose code will be generated by this method
    *  @param frame the frame where the initialization happen
    *  @param o the referencing environment
    */
  def genMETHOD(consdecl:FuncDecl,o:Any,frame:Frame) = {

    val isInit = consdecl.returnType == null
    val isMain = consdecl.name.name == "main" && consdecl.param.length == 0 && consdecl.returnType == VoidType
    val returnType = if (isInit) VoidType else consdecl.returnType
    val methodName = if (isInit) "<init>" else consdecl.name.name
    val intype = if (isMain) List(ArrayPointerType(StringType)) else List()
    val mtype =  FunctionType(intype,returnType)

    emit.printout(emit.emitMETHOD(methodName, mtype, !isInit, frame))
    frame.enterScope(true);

    val glenv = o.asInstanceOf[List[Symbol]]

    // Generate code for parameter declarations
    if (isInit) emit.printout(emit.emitVAR(frame.getNewIndex,"this",ClassType(className),frame.getStartLabel,frame.getEndLabel,frame))
    if (isMain) emit.printout(emit.emitVAR(frame.getNewIndex,"args",ArrayPointerType(StringType),frame.getStartLabel,frame.getEndLabel,frame))

    val body = consdecl.body.asInstanceOf[Block]

    //Generate code for statements
    if (isInit) {
      emit.printout(emit.emitREADVAR("this",ClassType(className),0,frame))
      emit.printout(emit.emitINVOKESPECIAL(frame))
    }
    // generate code for local declarations
    val newenv = body.decl.foldLeft(List[Symbol]())((x,y) => visit(y, SubBody(frame, x)).asInstanceOf[List[Symbol]])
    // start label khai bao sau khai bao, bat dau phan ma
    emit.printout(emit.emitLABEL(frame.getStartLabel(),frame))

//    val subBody = body.decl.foldLeft(Access(frame, glenv, true, false))((x, y) => visit(y, x).asInstanceOf[Access])

    body.stmt.map(x=>{
      if (x.isInstanceOf[Expr])
        visit(x, Access(frame, newenv:::glenv, false, true))
      else visit(x,SubBody(frame, newenv:::glenv))})

//    body.stmt.map(x=>visit(x,SubBody(frame,newenv)))

    emit.printout(emit.emitLABEL(frame.getEndLabel(),frame))
    if (returnType == VoidType) emit.printout(emit.emitRETURN(VoidType,frame))
    emit.printout(emit.emitENDMETHOD(frame))
    frame.exitScope()
  }

  override def visitFuncDecl(ast:FuncDecl,o:Any) = {
    val subctxt = o.asInstanceOf[SubBody]
    val frame = new Frame(ast.name.name,ast.returnType)
    genMETHOD(ast,subctxt.sym,frame)
    SubBody(null,Symbol(ast.name.name,FunctionType(List(),ast.returnType),CName(className))::subctxt.sym)
  }



  override def visitCallExpr(ast:CallExpr,o:Any) = {
    val ctxt = o.asInstanceOf[Access]
    val frame = ctxt.frame
    val nenv = ctxt.sym
    val sym = lookup(ast.method.name,nenv,(x:Symbol)=>x.name).get
    val cname = sym.value.asInstanceOf[CName].value
    val ctype = sym.typ

    val in = ast.params.foldLeft(("",List[Type]()))((y,x)=>
    {
      val (str1,typ1) = visit(x,new Access(frame,nenv,false,true)).asInstanceOf[(String,Type)]

      (y._1 + str1,y._2 :+ typ1)
    }
    )
    emit.printout(in._1)

    emit.printout(emit.emitINVOKESTATIC(cname+"/"+ast.method.name,ctype,frame))


  }

  override def visitIntLiteral(ast:IntLiteral,o:Any) = {
    val ctxt = o.asInstanceOf[Access]
    val frame = ctxt.frame
    (emit.emitPUSHICONST(ast.value, frame),IntType)
  }

  override def visitFloatLiteral(ast: FloatLiteral, c: Any): Any = {
    val ctxt = c.asInstanceOf[Access]
    val frame = ctxt.frame.asInstanceOf[Frame]
    (emit.emitPUSHFCONST(ast.value.toString, frame), FloatType)
  }

  override def visitBooleanLiteral(ast: BooleanLiteral, c: Any): Any = {
    val ctxt = c.asInstanceOf[Access]
    val frame = ctxt.frame.asInstanceOf[Frame]
    (emit.emitPUSHICONST(ast.value.toString, frame), BoolType)
  }

  override def visitStringLiteral(ast: StringLiteral, c: Any): Any = {
    val ctxt = c.asInstanceOf[Access]
    val frame = ctxt.frame.asInstanceOf[Frame]
    (emit.emitPUSHCONST("\""+ast.value.toString+"\"", StringType, frame), StringType)
  }

  override def visitBlock(ast: Block, c: Any): Any = {
    val ctxt = c.asInstanceOf[SubBody]
    val frame = ctxt.frame
    val lstenv = ctxt.sym

    frame.enterScope(false)
    val newEnv = ast.decl.filter(_.isInstanceOf[VarDecl]).foldLeft(lstenv)((a, b) => visit(b, SubBody(frame, a)).asInstanceOf[List[Symbol]])
    emit.printout(emit.emitLABEL(frame.getStartLabel(),frame))
    ast.stmt.foreach(stmt => if(stmt.isInstanceOf[Expr]) visit(stmt, Access(frame, lstenv:::newEnv, false, true)) else visit(stmt, SubBody(frame, lstenv:::newEnv)))
    emit.printout(emit.emitLABEL(frame.getEndLabel(),frame))
    frame.exitScope()
    c

  }

  override def visitVarDecl(ast: VarDecl, c: Any): Any = {
    val ctxt = c.asInstanceOf[SubBody]
    val frame = if(ctxt.frame != null) ctxt.frame else new Frame(ast.variable.name,ast.varType)
    val env = ctxt.sym
    val idx = frame.getNewIndex()
    if (ctxt.frame != null) {
      emit.printout(emit.emitVAR(idx, ast.variable.name, ast.varType, frame.getStartLabel(), frame.getEndLabel(), frame))
      env :+ Symbol(ast.variable.name, ast.varType, Index(idx))
    } else {
      emit.printout(emit.emitATTRIBUTE(ast.variable.name, ast.varType, false, ""))
      env :+ Symbol(ast.variable.name, ast.varType, CName(ast.variable.name))
    }
  }

  override def visitBinaryOp(ast: BinaryOp, c: Any): Any = {
    val ctxt = c.asInstanceOf[Access]
    val frame = ctxt.frame
    var left = ast.left.accept(this, c).asInstanceOf[(String, Type)]
    var right = ast.right.accept(this, c).asInstanceOf[(String, Type)]
    var typeop = left._2

    if (ast.op == "=") {
      left = ast.left.accept(this,Access(frame,ctxt.sym,true,false)).asInstanceOf[(String, Type)]
      var cnv = {
        if (left._2 == FloatType && right._2 == IntType)
          emit.emitI2F(frame)
        else ""
      }
      emit.printout(right._1 + cnv + left._1)
      (right._1 + cnv + left._1,left._2)
    } else {
      if (left._2 == IntType && right._2 == FloatType) {
        typeop = right._2
      }
      var op = ""
      ast.op match {
        case "+" | "-" | "*" | "/" => {
          if (ast.op == "+" || ast.op == "-") {
            op = emit.emitADDOP(ast.op, typeop, frame)
          } else if (ast.op == "*" || ast.op == "/") {
            op = emit.emitMULOP(ast.op, typeop, frame)
          }
          if (left._2 == right._2) {
            (left._1 + right._1 + op, left._2)
          } else {
            if (left._2 == FloatType && right._2 == IntType) {
              (left._1 + right._1 + emit.emitI2F(frame) + op, typeop)
            } else if (left._2 == IntType && right._2 == FloatType) {
              (left._1 + emit.emitI2F(frame) + right._1 + op, typeop)
            }
          }
        }
        case "&&" | "||" => {
          if (ast.op == "&&") {
            op = emit.emitANDOP(frame)
          } else op = emit.emitOROP(frame)
          (left._1 + right._1 + op, BoolType)
        }
        case "%" => {
          op = emit.emitMOD(frame)
          (left._1 + right._1 + op, left._2)
        }
        case ">" | ">=" | "<" | "<=" | "==" | "!=" => {
          op = emit.emitREOP(ast.op, typeop, frame)
          (left._1 + right._1 + op, BoolType)
        }
      }
    }
  }

  override def visitUnaryOp(ast: UnaryOp, c: Any): Any = {
    val ctxt = c.asInstanceOf[Access]
    val frame = ctxt.frame
    val body = visit(ast.body, c).asInstanceOf[(String, Type)]
    ast.op match {
      case "!" => (body._1 + emit.emitNOT(body._2, frame), body._2)
      case "-" => (body._1 + emit.emitNEGOP(body._2, frame), body._2)
    }

  }

  override def visitId(ast: Id, c: Any): Any = {
    val ctxt = c.asInstanceOf[Access]
    val frame = ctxt.frame
    val sym = ctxt.sym
    val symbol = lookup(ast.name, sym, (s:Symbol) => s.name).get

    if (symbol.value.isInstanceOf[CName]) {
      if (ctxt.isLeft){
        (emit.emitPUTSTATIC(className + "." + ast.name, symbol.typ, frame), symbol.typ)
      }
      else{
        (emit.emitGETSTATIC(className + "." + ast.name, symbol.typ, frame), symbol.typ)
      }
    } else {
      val symval = symbol.value.asInstanceOf[Index].value
      if (ctxt.isLeft && !ctxt.isFirst){
        (emit.emitWRITEVAR(ast.name, symbol.typ, symval, frame), symbol.typ)
      }
      else {
        (emit.emitREADVAR(ast.name, symbol.typ, symval, frame), symbol.typ)
      }
    }
  }

  override def visitIf(ast: If, c: Any): Any = {
    val ctxt = c.asInstanceOf[SubBody]
    val frame = ctxt.frame
    val expr = if (ast.expr.isInstanceOf[Expr]) visit(ast.expr,Access(frame, ctxt.sym, false, false)).asInstanceOf[(String, Type)]
    else visit(ast.expr,SubBody(frame, ctxt.sym)).asInstanceOf[(String, Type)]

    val label1 = frame.getNewLabel()
    val label2 = frame.getNewLabel()
    emit.printout(expr._1)
    emit.printout(emit.emitIFFALSE(label1, frame))
    if(ast.thenStmt.isInstanceOf[Expr])
      visit(ast.thenStmt, Access(frame, ctxt.sym, false, false))
    else visit(ast.thenStmt, SubBody(frame, ctxt.sym))
    ast.elseStmt match {
      case Some(stmt) => {
        emit.printout(emit.emitGOTO(label2, frame))
        emit.printout(emit.emitLABEL(label1,frame))
        if (stmt.isInstanceOf[Expr])
          visit(stmt, Access(frame, ctxt.sym, false, false))
        else visit(stmt, SubBody(frame, ctxt.sym))
        emit.printout(emit.emitLABEL(label2,frame))
      }
      case None => {
        emit.printout(emit.emitLABEL(label1,frame))
      }
    }
    c
  }

  override def visitDowhile(ast: Dowhile, c: Any): Any = {
    val ctxt = c.asInstanceOf[SubBody]
    val frame = ctxt.frame
    val expr = if (ast.exp.isInstanceOf[Expr]) visit(ast.exp,Access(frame, ctxt.sym, false, false)).asInstanceOf[(String, Type)]
    else visit(ast.exp,SubBody(frame, ctxt.sym)).asInstanceOf[(String, Type)]
    frame.enterLoop()
    val label1 = frame.getContinueLabel()
    val label2 = frame.getBreakLabel()
    emit.printout(emit.emitLABEL(label1,frame))
    ast.sl.foreach(x=>{
      if (x.isInstanceOf[Expr])
        visit(x, Access(frame, ctxt.sym, false, true))
      else visit(x,SubBody(frame, ctxt.sym))}
    )
    emit.printout(expr._1)
    emit.printout(emit.jvm.emitIFEQ(label2))//emitIFFALSE(label2, frame))
    emit.printout(emit.emitGOTO(label1, frame))
    emit.printout(emit.emitLABEL(label2,frame))
    frame.exitLoop()
    c
  }

  override def visitContinue(ast: Continue.type, c: Any): Any = {
    val ctxt = c.asInstanceOf[SubBody]
    val frame = ctxt.frame
    emit.printout(emit.emitGOTO(frame.getContinueLabel(), frame))
    c
  }

  override def visitBreak(ast: Break.type, c: Any): Any = {
    val ctxt = c.asInstanceOf[SubBody]
    val frame = ctxt.frame
    emit.printout(emit.emitGOTO(frame.getBreakLabel(), frame))
    c
  }

  override def visitFor(ast: For, c: Any): Any = {
    val ctxt = c.asInstanceOf[SubBody]
    val frame = ctxt.frame
    val expr1 = if (ast.expr1.isInstanceOf[Expr]) visit(ast.expr1,Access(frame, ctxt.sym, false, false)).asInstanceOf[(String, Type)]
    else visit(ast.expr1,SubBody(frame, ctxt.sym)).asInstanceOf[(String, Type)]
    val expr2 = if (ast.expr2.isInstanceOf[Expr]) visit(ast.expr2,Access(frame, ctxt.sym, false, false)).asInstanceOf[(String, Type)]
    else visit(ast.expr2,SubBody(frame, ctxt.sym)).asInstanceOf[(String, Type)]
    val expr3 = if (ast.expr3.isInstanceOf[Expr]) visit(ast.expr3,Access(frame, ctxt.sym, false, false)).asInstanceOf[(String, Type)]
    else visit(ast.expr3,SubBody(frame, ctxt.sym)).asInstanceOf[(String, Type)]

    frame.enterLoop()
    val label1 = frame.getContinueLabel()
    val label2 = frame.getBreakLabel()
    emit.printout(expr1._1)
    emit.printout(emit.emitLABEL(label1,frame))
    emit.printout(expr2._1)
    emit.printout(emit.jvm.emitIFEQ(label2))
    if (ast.loop.isInstanceOf[Expr])
      visit(ast.loop, Access(frame, ctxt.sym, false, true))
    else visit(ast.loop,SubBody(frame, ctxt.sym))
    emit.printout(expr3._1)
    emit.printout(emit.emitGOTO(label1, frame))
    emit.printout(emit.emitLABEL(label2,frame))
    frame.exitLoop()
    c
  }

//  override def visitReturn(ast: Return, c: Any): Any = {
//    val ctxt = c.asInstanceOf[SubBody]
//    val frame = ctxt.frame
//    ast.expr match {
//      case Some(stmt) => {
//        val expr = if(stmt.isInstanceOf[Expr])
//          visit(stmt, Access(frame, ctxt.sym, false, false)).asInstanceOf[(String, Type)]
//        else
//          visit(stmt, SubBody(frame, ctxt.sym)).asInstanceOf[(String, Type)]
//
//        emit.printout(expr._1)
//        emit.printout(emit.emitRETURN(expr._2, frame))
//      }
//      case None => emit.printout(emit.emitRETURN(VoidType, frame))
//    }
//  }

//  override def visitReturn(ast: Return, c: Any): Any =  {
//    val ctxt = c.asInstanceOf[SubBody]
//    val frame = ctxt.frame
//    //val accss = Access(frame,ctxt.sym,false,true)
//    var exp = if (ast.expr.nonEmpty) {
//      val ret = if(ast.expr.get.isInstanceOf[Expr])
//                visit(ast.expr.get, Access(frame, ctxt.sym, false, false)).asInstanceOf[(String, Type)]
//              else
//                visit(ast.expr.get, SubBody(frame, ctxt.sym)).asInstanceOf[(String, Type)]
////      visit(ast.expr.get,ctxt).asInstanceOf[(String, Type)]
//      emit.printout(ret._1)
//      ret._2
//    } else
//      VoidType
//    emit.printout(emit.emitRETURN(exp,frame))
//  }

}