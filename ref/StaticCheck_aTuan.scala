package mc.checker

/**
 * Student name: Thanh-Dang Diep
 * Student ID: 1670019
 */

/**
 * @author nhphung
 */

import mc.parser._
import mc.utils._
import java.io.{PrintWriter, File}
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree._
import scala.collection.JavaConverters._

trait Utils {
	def lookUp(Id:String, env:List[Decl]):Option[Decl] = env match {
		case List() => None
		case head::tail => if (head.isInstanceOf[VarDecl]) {
					if (head.asInstanceOf[VarDecl].variable.name == Id) Some(head) else lookUp(Id, tail)
				}
				else {//(head.isInstanceOf[FuncDecl])
					if (head.asInstanceOf[FuncDecl].name.name == Id) Some(head) else lookUp(Id, tail)
				}
	} 

	def lookUpToGet1(Id:String, env:List[Decl]) = {
		val res = lookUp(Id, env)
		if (res == None) throw Undeclared(Identifier, Id)
		else res.get
	}

	def lookUpToGet2(Id:String, env:List[Decl]) = {
                val res = lookUp(Id, env)
                if (res == None) throw Undeclared(Function, Id)
                else res.get
        }


	def lookUpToInsert(Id:String, env:List[Decl]) = {
		val res = lookUp(Id, env)
		res != None
	}
} 

class StaticChecker(ast:AST) extends Visitor with Utils {

	def check() = ast.accept(this, null)

	override def visitProgram(ast: Program, c: Any): Any = {
		val builtInFunc = List( 
					FuncDecl(Id("getInt"), List[VarDecl](), IntType, Block(List[Decl](), List[Stmt]())),
					FuncDecl(Id("putInt"), List[VarDecl](VarDecl(Id("i"), IntType)), VoidType, 
													Block(List[Decl](), List[Stmt]())),
					FuncDecl(Id("putIntLn"), List[VarDecl](VarDecl(Id("i"), IntType)), VoidType, 
													Block(List[Decl](), List[Stmt]())),
					FuncDecl(Id("getFloat"), List[VarDecl](), IntType, Block(List[Decl](), List[Stmt]())),
					FuncDecl(Id("putFloat"), List[VarDecl](VarDecl(Id("f"), FloatType)), VoidType, 
													Block(List[Decl](), List[Stmt]())),
					FuncDecl(Id("putFloatLn"), List[VarDecl](VarDecl(Id("f"), FloatType)), VoidType, 
													Block(List[Decl](), List[Stmt]())),
					FuncDecl(Id("putBool"), List[VarDecl](VarDecl(Id("b"), BoolType)), VoidType, 
													Block(List[Decl](), List[Stmt]())),
					FuncDecl(Id("putBoolLn"), List[VarDecl](VarDecl(Id("b"), BoolType)), VoidType, 
													Block(List[Decl](), List[Stmt]())),
					FuncDecl(Id("putString"), List[VarDecl](VarDecl(Id("s"), StringType)), VoidType, 
													Block(List[Decl](), List[Stmt]())),
					FuncDecl(Id("putStringLn"), List[VarDecl](VarDecl(Id("s"), StringType)), VoidType, 
													Block(List[Decl](), List[Stmt]())),
					FuncDecl(Id("putLn"), List[VarDecl](), VoidType, Block(List[Decl](), List[Stmt]())) 
																)

		val builtInEnv = List(builtInFunc).asInstanceOf[List[List[Decl]]]
		val varList = ast.decl.filter(_.isInstanceOf[VarDecl]).asInstanceOf[List[VarDecl]]
		val funcList = ast.decl.filter(_.isInstanceOf[FuncDecl]).asInstanceOf[List[FuncDecl]]
		val env = varList.foldLeft(builtInEnv)((a, b) => b.accept(this, List(a, true)).asInstanceOf[List[List[Decl]]])
		val newEnv = funcList.foldLeft(env)((a, b) => b.accept(this, a).asInstanceOf[List[List[Decl]]])
                null
        }

  	override def visitVarDecl(ast: VarDecl, c: Any): Any = {
		val env = c.asInstanceOf[List[Any]](0).asInstanceOf[List[List[Decl]]]
		val id = ast.variable.name
		val tmpEnv = { 
			if (lookUpToInsert(id, env(0))) {
				if (c.asInstanceOf[List[Any]](1).asInstanceOf[Boolean]) throw Redeclared(Variable, id)
				else throw Redeclared(Parameter, id)
			}
			else ast :: env(0)
		}
		tmpEnv :: env.drop(1)
	}

  	override def visitFuncDecl(ast: FuncDecl, c: Any): Any = {
		val env = c.asInstanceOf[List[List[Decl]]]
		val id = ast.name.name
		val tmpEnv = { 
			if (lookUpToInsert(id, env(0))) throw Redeclared(Function, id)
			else ast :: env(0)
		}
		val tmpEnv1 = tmpEnv :: env.drop(1)
		val tmpEnv2 = List[Decl]() :: tmpEnv1
		val newEnv = ast.param.foldLeft(tmpEnv2)((a, b) => b.accept(this, List(a, false)).asInstanceOf[List[List[Decl]]])
		val bodyEnv = ast.body.accept(this, List(newEnv, false, false)).asInstanceOf[List[Any]]
		if (bodyEnv(1).asInstanceOf[Boolean] == false) throw FunctionNotReturn(id)
		tmpEnv1
	}

 	override def visitIntType(ast: IntType.type, c: Any): Any = IntType

 	override def visitFloatType(ast: FloatType.type, c: Any): Any = FloatType
	
  	override def visitBoolType(ast: BoolType.type, c: Any): Any = BoolType

  	override def visitStringType(ast: StringType.type, c: Any): Any = StringType

  	override def visitVoidType(ast: VoidType.type, c: Any): Any = VoidType

  	override def visitArrayType(ast: ArrayType, c: Any): Any = ArrayType(ast.dimen, ast.eleType)

  	override def visitArrayPointerType(ast: ArrayPointerType, c: Any): Any = ArrayPointerType(ast.eleType)
		
  	override def visitBinaryOp(ast: BinaryOp, c: Any): Any = {
		val lt = ast.left.accept(this, c).asInstanceOf[Type]
		val rt = ast.right.accept(this, c).asInstanceOf[Type]
		if (ast.op == "+" || ast.op == "-" || ast.op == "*" || ast.op == "/") {
			if (lt == IntType) {
				if (rt == IntType) IntType
				else if (rt == FloatType) FloatType
				else throw TypeMismatchInExpression(ast)
			}
			else if (lt == FloatType) {
				if (rt == IntType || rt == FloatType) FloatType
				else throw TypeMismatchInExpression(ast)
			}
			else throw TypeMismatchInExpression(ast)
		}
		else if (ast.op == "<" || ast.op == "<=" || ast.op == ">" || ast.op == ">=") {
			if (lt == BoolType) throw TypeMismatchInExpression(ast)
			else if (rt == BoolType) throw TypeMismatchInExpression(ast)
			else BoolType
		}
		else if (ast.op == "==" || ast.op == "!=") {
			if (lt == BoolType) {
				if (rt == BoolType) BoolType
				else throw TypeMismatchInExpression(ast)
			}
			else if (lt == IntType)
			{
				if (rt == IntType) BoolType
				else throw TypeMismatchInExpression(ast)
			}
			else throw TypeMismatchInExpression(ast)
		}
		else if (ast.op == "&&" || ast.op == "||") {
			if (lt == BoolType && rt == BoolType) BoolType
			else if (lt != BoolType) throw TypeMismatchInExpression(ast)
			else throw TypeMismatchInExpression(ast)
		}
		else {	//(ast.op == "=")
			if (lt == IntType) {
				if (rt == IntType) IntType
				else throw TypeMismatchInExpression(ast)
			}
			else if (lt == FloatType) {
				if (rt == IntType || rt == FloatType) FloatType
				else throw TypeMismatchInExpression(ast)
			}
			else if (lt == BoolType) {
				if (rt == BoolType) BoolType
				else throw TypeMismatchInExpression(ast)
			}
			else if (lt == StringType) {
				if (rt == StringType) StringType
				else throw TypeMismatchInExpression(ast)
			}
			else if (lt.isInstanceOf[ArrayPointerType]) {
				if (rt.isInstanceOf[ArrayPointerType]) {
					if (lt.asInstanceOf[ArrayPointerType].eleType == rt.asInstanceOf[ArrayPointerType].eleType)
						lt.asInstanceOf[ArrayPointerType]
					else throw TypeMismatchInExpression(ast)
				}
				else throw TypeMismatchInExpression(ast)
			}
			else throw TypeMismatchInExpression(ast)
		}
	}

  	override def visitUnaryOp(ast: UnaryOp, c: Any): Any = {
		val tmp = ast.body.accept(this, c).asInstanceOf[Type]
		if (ast.op == "!") {
			if (tmp == BoolType) BoolType
			else throw TypeMismatchInExpression(ast)
		}
		else { 	//(ast.op == "+" || ast.op == "-")
			if (tmp == BoolType) throw TypeMismatchInExpression(ast)
			else tmp
		}
	}

  	override def visitCallExpr(ast: CallExpr, c: Any): Any = {
		val env = c.asInstanceOf[List[Any]](0).asInstanceOf[List[List[Decl]]].flatten
		val result = lookUpToGet2(ast.method.name, env).asInstanceOf[FuncDecl]
		if (ast.params.length != result.param.length) throw TypeMismatchInExpression(ast)
		else {
			result.param.zip(ast.params).map {case (x, y) => 
				val lt = x.varType
				val rt = y.accept(this, c)
				if (lt == IntType) {
					if (rt != IntType) throw TypeMismatchInExpression(ast)
                        	}
                        	else if (lt == FloatType) {
                                	if (rt != IntType && rt != FloatType) throw TypeMismatchInExpression(ast)
                        	}
                        	else if (lt == BoolType) {
                                	if (rt != BoolType) throw TypeMismatchInExpression(ast)
                        	}
				else if (lt == StringType) {
					if (rt != StringType) throw TypeMismatchInExpression(ast)
				}
                        	else {	//(lt.isInstanceOf[ArrayPointerType])
                                	if (rt.isInstanceOf[ArrayPointerType]) {
                                        	if (lt.asInstanceOf[ArrayPointerType].eleType != rt.asInstanceOf[ArrayPointerType].eleType)
                                        		throw TypeMismatchInExpression(ast)
                                	}
                                	else throw TypeMismatchInExpression(ast)
                        	}
			}
		}
		result.returnType
	}
	
  	override def visitId(ast: Id, c: Any): Any = {
		val env = c.asInstanceOf[List[Any]](0).asInstanceOf[List[List[Decl]]].flatten
		val result = lookUpToGet1(ast.name, env)
		result.asInstanceOf[VarDecl].varType
	}

  	override def visitArrayCell(ast: ArrayCell, c: Any): Any = {
		val e1 = ast.arr.accept(this, c).asInstanceOf[Type]
		val e2 = ast.idx.accept(this, c).asInstanceOf[Type]
		if (e1.isInstanceOf[ArrayType] == false)
			throw TypeMismatchInExpression(ast)
		if (e2 != IntType)
			throw TypeMismatchInExpression(ast)
		e1.asInstanceOf[ArrayType].eleType
	}

  	override def visitBlock(ast: Block, c: Any): Any = {
		val tmpEnv = c.asInstanceOf[List[Any]]
		val env = tmpEnv(0).asInstanceOf[List[List[Decl]]]
		val newEnv = ast.decl.foldLeft(env)((a, b) => b.accept(this, List(a, true)).asInstanceOf[List[List[Decl]]])
		val newEnv1 = List(newEnv, tmpEnv(1), tmpEnv(2)).asInstanceOf[List[Any]]
		val bodyEnv = ast.stmt.foldLeft(newEnv1)((a, b) => 
			if (b.isInstanceOf[Expr]) {
				b.accept(this, a)
				a.asInstanceOf[List[Any]]
			}
			else {
				if (b.isInstanceOf[Block]) {
					val tmpEnv1 = a.asInstanceOf[List[Any]]
					b.accept(this, List(List[Decl]() :: tmpEnv1(0).asInstanceOf[List[List[Decl]]], 
											tmpEnv1(1), tmpEnv1(2))).asInstanceOf[List[Any]]
				}
				else b.accept(this, a).asInstanceOf[List[Any]]
			}).asInstanceOf[List[Any]]
		List(tmpEnv(0), bodyEnv(1), tmpEnv(2))
	}

  	override def visitIf(ast: If, c: Any): Any = {
		val env = c.asInstanceOf[List[Any]]
		val tmpEnv = env(0).asInstanceOf[List[List[Decl]]]
		if (ast.expr.accept(this, c).asInstanceOf[Type] != BoolType) throw TypeMismatchInStatement(ast)
		if (env(1) == true) c
		else {	//(env(1) == false)
			if (ast.elseStmt != None) {
				val returnPath = List(ast.thenStmt, ast.elseStmt.get).map(x => 
						if (x.isInstanceOf[Block]) x.accept(this, List(List[Decl]() :: tmpEnv, env(1), env(2)))
						else x.accept(this, c)).asInstanceOf[List[Any]]
				if (returnPath.filter(_.isInstanceOf[Type] == false).forall(x => x.asInstanceOf[List[Any]](1) == true)) 
					List(env(0), true, env(2))
				else c
			}
			else {
				if (ast.thenStmt.isInstanceOf[Block]) ast.thenStmt.accept(this, List(List[Decl]() :: tmpEnv, env(1), env(2)))
				else ast.thenStmt.accept(this, c)
				c
			}
		}
	}

  	override def visitFor(ast: For, c: Any): Any = {
		val env = c.asInstanceOf[List[Any]]
		val tmpEnv = env(0).asInstanceOf[List[List[Decl]]]
		if (ast.expr1.accept(this, c).asInstanceOf[Type] != IntType) throw TypeMismatchInStatement(ast)
		if (ast.expr3.accept(this, c).asInstanceOf[Type] != IntType) throw TypeMismatchInStatement(ast)
		if (ast.expr2.accept(this, c).asInstanceOf[Type] != BoolType) throw TypeMismatchInStatement(ast)
		val newEnv = if (ast.loop.isInstanceOf[Block]) ast.loop.accept(this, List(List[Decl]() :: tmpEnv, env(1), true))
				else ast.loop.accept(this, List(env(0), env(1), true))
		if (newEnv.isInstanceOf[Type]) List(env(0), env(1), false)	
		else {
           		val loopEnv = newEnv.asInstanceOf[List[Any]]
			List(loopEnv(0),  loopEnv(1), false)
		}
	}
 
 	override def visitBreak(ast: Break.type, c: Any): Any = {
		val env = c.asInstanceOf[List[Any]]
		if (env(2).asInstanceOf[Boolean] == false) throw BreakNotInLoop
		c
	}

  	override def visitContinue(ast: Continue.type, c: Any): Any = {
		val env = c.asInstanceOf[List[Any]]
		if (env(2).asInstanceOf[Boolean] == false) throw ContinueNotInLoop
		c
	}

  	override def visitReturn(ast: Return, c: Any): Any = {
		val env = c.asInstanceOf[List[Any]]
		val expEnv = env(0).asInstanceOf[List[List[Decl]]].flatten.filter(_.isInstanceOf[FuncDecl]).asInstanceOf[List[FuncDecl]]
		val funcType = expEnv(0).returnType
		val returnType = if (ast.expr == null) null else ast.expr.accept(this, c)
		if (funcType == VoidType) {
			if (returnType != null) throw TypeMismatchInStatement(ast)
		}
		else if (funcType == IntType) {
			if (returnType != IntType) throw TypeMismatchInStatement(ast)
		}
		else if (funcType == FloatType) {
			if (returnType != IntType && returnType != FloatType) throw TypeMismatchInStatement(ast)
		}
		else {	//(funcType == BoolType)
			if (returnType != BoolType) throw TypeMismatchInStatement(ast)
		}
		List(env(0), true, env(2))
	}
	
  	override def visitRepeat(ast: Repeat, c: Any): Any = {
		val env = c.asInstanceOf[List[Any]]
		val tmpEnv = env(0).asInstanceOf[List[List[Decl]]]
		if (ast.exp.accept(this, c).asInstanceOf[Type] != BoolType) throw TypeMismatchInStatement(ast)
		val returnPath = ast.sl.map(x => if (x.isInstanceOf[Block]) x.accept(this, List(List[Decl]() :: tmpEnv, env(1), env(2)))
						else x.accept(this, c)).asInstanceOf[List[Any]]
		val returnPath1 = returnPath.filter(_.isInstanceOf[Type] == false).exists(x => x.asInstanceOf[List[Any]](1) == true)
		List(env(0), returnPath1, env(2))
	}

  	override def visitIntLiteral(ast: IntLiteral, c: Any): Any = IntType

  	override def visitFloatLiteral(ast: FloatLiteral, c: Any): Any = FloatType

 	override def visitStringLiteral(ast: StringLiteral, c: Any): Any = StringType

  	override def visitBooleanLiteral(ast: BooleanLiteral, c: Any): Any = BoolType
	
}
