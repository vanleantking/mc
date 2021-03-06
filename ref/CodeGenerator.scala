/**
  * Student Nguyễn Quốc Dũng:
  * Student ID: 1770470
  */

/**
 *	@author Nguyen Hua Phung
 *	@version 1.0
 *	23/10/2015
 * 	This file provides a simple version of code generator
 *
 */
package mc.codegen
import java.io.File

import mc.utils._

object CodeGenerator extends Utils
{
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

  def gen(ast:AST,dir:File) =
  {
	val gl = init()
	val gc = new CodeGenVisitor(ast,gl,dir)
	gc.visit(ast, null)
  }
}
//====================================================//
case class ClassType(cname:String) extends Type

case class SubContext(emit:Emitter,decl:List[Decl])

case class SubBody(frame:Frame,sym:List[Symbol]) 

class Access(val frame:Frame,val sym:List[Symbol],val isLeft:Boolean,val isFirst:Boolean)

trait Val
  case class Index(value:Int) extends Val
  case class CName(value:String) extends Val
  case class Symbol(name:String,typ:Type, value:Val)
  case class FunctionType(input:List[Type],output:Type) extends Type

//====================================================//
class CodeGenVisitor(astTree:AST,env:List[Symbol],dir:File) extends BaseVisitor with Utils
{
  val className = "MCClass"
  val path = dir.getPath()
  val emit = new Emitter(path+"/"+className+".j")

  //---------------------------------------------------//
   override def visitProgram(ast:Program,c:Any) =
   {
     emit.printout(emit.emitPROLOG(className, "java.lang.Object"))
     ast.decl.foldLeft(SubBody(null,env))((e,x) => visit(x,e).asInstanceOf[SubBody])
	 println("buzzzzz")
      // generate default constructor

//	 genMETHOD(
//            FuncDecl(ast.asInstanceOf[FuncDecl].name,List(),null,Block(List(),List())),
//	   		c,
//	   		new Frame("<init>",ast.asInstanceOf[FuncDecl].returnType))
//	 genMETHOD(
//	   FuncDecl(Id("<init>"),List(),null,Block(List(),List())),c,new Frame("<init>",VoidType))
	 println("xxxxxx")
     emit.emitEPILOG()
     c
   }
  //---------------------------------------------------//
  override def visitFuncDecl(ast:FuncDecl,o:Any) =
  {
    val subctxt = o.asInstanceOf[SubBody]
    val frame = new Frame(ast.name.name,ast.returnType)
    genMETHOD(ast,subctxt.sym,frame)

    SubBody(null,Symbol(ast.name.name,FunctionType(List(),ast.returnType),CName(className))::subctxt.sym)
  }
  //---------------------------------------------------//
  override def visitCallExpr(ast:CallExpr,o:Any) =
  {
    val ctxt = o.asInstanceOf[SubBody]
    val frame = ctxt.frame
    val nenv = ctxt.sym
    val sym = lookup(ast.method.name,nenv,(x:Symbol)=>x.name).get
    val cname = sym.value.asInstanceOf[CName].value
    val ctype = sym.typ

    val in = ast.params.foldLeft(("",List[Type]()))((y,x)=>{
        val (str1,typ1) = visit(x,new Access(frame,nenv,false,true)).asInstanceOf[(String,Type)]
        (y._1 + str1,y._2 :+ typ1)
      })

    emit.printout(in._1)
    emit.printout(emit.emitINVOKESTATIC(cname+"/"+ast.method,ctype,frame))
	println("enter vsiit call r", in._1)
  }
  //---------------------------------------------------//
  override def visitBlock(ast: Block, c: Any): Any =
  {

  }

  override def visitId(ast: Id, c: Any): Any =
  {

  }

  //---------------------------------------------------//
  override def visitVarDecl(ast: VarDecl, c: Any): Any =
  {
	val varctxt = c.asInstanceOf[SubBody]
	val frame = varctxt.frame
	val venv = varctxt.sym
	val idx = frame.getNewIndex()
	emit.printout(emit.emitVAR(idx,ast.variable.name,ast.varType,frame.getStartLabel(),frame.getEndLabel(),frame))
	venv :+ (ast.variable.name, ast.varType, Index(idx))
  }
  //---------------------------------------------------//
  override def visitIntLiteral(ast:IntLiteral,o:Any) =
  {
    val ctxt = o.asInstanceOf[Access]
    val frame = ctxt.frame
    (emit.emitPUSHICONST(ast.value, frame),IntType)
  }
  //---------------------------------------------------//
  override def visitFloatLiteral(ast: FloatLiteral, o: Any)  =
  {
	val ctxt = o.asInstanceOf[Access]
	val frame = ctxt.frame
	(emit.emitPUSHFCONST(ast.value.toString, frame),FloatType)
  }
  //---------------------------------------------------//
  override def visitStringLiteral(ast: StringLiteral, o: Any): Any =
  {
	val ctxt = o.asInstanceOf[Access]
	val frame = ctxt.frame
	(emit.emitPUSHCONST(ast.value,StringType,frame),StringType)
  }
  //---------------------------------------------------//
  override def visitBooleanLiteral(ast: BooleanLiteral, o: Any): Any =
  {
	val ctxt = o.asInstanceOf[Access]
	val frame = ctxt.frame
	(emit.emitPUSHCONST(ast.value.toString,BoolType,frame),BoolType)
  }
  //---------------------------------------------------//
  /** generate code for default constructor
	*
	*  @param consdecl the function declaration whose code will be generated by this method
	*  @param frame    the frame where the initialization happen
	*  @param o        the referencing environment
	*/
  def genMETHOD(consdecl:FuncDecl,o:Any,frame:Frame) =
  {
	val isInit = consdecl.returnType == null
	val isMain = consdecl.name.name == "main" && consdecl.param.isEmpty && consdecl.returnType == VoidType

	val returnType =
	  if (isInit)
		VoidType
	  else
		consdecl.returnType

	val methodName =
	  if (isInit)
		"<init>"
	  else
		consdecl.name.name

	val intype =
	  if (isMain)
		List(ArrayPointerType(StringType))
	  else
		List()

	val mtype =  FunctionType(intype,returnType)

	emit.printout(emit.emitMETHOD(methodName.toString, mtype, !isInit, frame))

	frame.enterScope(true)

	val glenv = o.asInstanceOf[List[Symbol]]
	println("uuuuuuu", isMain, frame.getNewIndex, consdecl.toString)

	// Generate code for parameter declarations
	if (isInit)
	  emit.printout(emit.emitVAR(frame.getNewIndex,"this",ClassType(className),frame.getStartLabel,frame.getEndLabel,frame))
	if (isMain)
	  emit.printout(emit.emitVAR(frame.getNewIndex,"args",ArrayPointerType(StringType),frame.getStartLabel,frame.getEndLabel,frame))

	val body = consdecl.body.asInstanceOf[Block]

	emit.printout(emit.emitLABEL(frame.getStartLabel(),frame))
	//Generate code for statements
	if (isInit)
	{
	  emit.printout(emit.emitREADVAR("this",ClassType(className),0,frame))
	  emit.printout(emit.emitINVOKESPECIAL(frame))
	}

	body.stmt.map(x=>visit(x,SubBody(frame,glenv)))

	emit.printout(emit.emitLABEL(frame.getEndLabel(),frame))
	if (returnType == VoidType)
	  emit.printout(emit.emitRETURN(VoidType,frame))
	emit.printout(emit.emitENDMETHOD(frame))
	frame.exitScope()
  }
  //---------------------------------------------------//


}