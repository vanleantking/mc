/**
  *	@author Nguyen Hua Phung
  *	@version 1.0
  *	23/10/2015
  * 	This file provides a simple version of code generator
  *
  */

package mc.codegen





import mc.checker._
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
    ast.decl.foldLeft(SubBody(null,env))((e,x) => visit(x,e).asInstanceOf[SubBody])
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

    frame.enterScope(true)
    val newEnv = ast.decl.filter(_.isInstanceOf[VarDecl]).foldLeft(lstenv)((a, b) => visit(b, SubBody(frame, a)).asInstanceOf[List[Symbol]])
    emit.printout(emit.emitLABEL(frame.getStartLabel(),frame))
    ast.stmt.foreach(stmt => visit(stmt, Access(frame, newEnv:::lstenv, false, true)))
    emit.printout(emit.emitLABEL(frame.getEndLabel(),frame))
    frame.exitScope()

  }

  override def visitVarDecl(ast: VarDecl, c: Any): Any = {
    val ctxt = c.asInstanceOf[SubBody]
    val frame = ctxt.frame
    val env = ctxt.sym
    val idx = frame.getNewIndex()
    emit.printout(emit.emitVAR(idx, ast.variable.name, ast.varType, frame.getStartLabel(), frame.getEndLabel(), frame))
    env :+ Symbol(ast.variable.name, ast.varType, Index(idx))
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
    val symval = symbol.value.asInstanceOf[Index].value
    if (ctxt.isLeft && !ctxt.isFirst){
      (emit.emitWRITEVAR(ast.name, symbol.typ, symval, frame), symbol.typ)
    }
    else{
      (emit.emitREADVAR(ast.name, symbol.typ, symval, frame), symbol.typ)
    }

  }

}