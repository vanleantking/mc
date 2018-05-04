package mc.checker

/**
 * @author nhphung
 */

import mc.parser._
import mc.utils.{Decl, Id, _}
import java.io.{File, PrintWriter}

//import mc.codegen.Val
import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree._

import scala.collection.JavaConverters._



class StaticChecker(ast:AST) extends BaseVisitor with Utils {
    
    def check() = {
        try {
            val program = visit(ast,null)
            val tc = new TypeChecking(ast)
            tc.visit(ast, program)
        } catch {
            case Redeclared(k,n) => throw new Redeclared(k,n)
            case Undeclared(k,n) => throw new Undeclared(k,n)
        }
    }

    override def visitProgram(ast: Program, c: Any): Any =
        ast.decl.filter(p => p.isInstanceOf[Decl]).foldLeft(List[Decl]())((x,y)=>visit(y,x).asInstanceOf[List[Decl]])

    override def visitVarDecl(ast: VarDecl, c: Any): Any = {
        var vardecl = c.asInstanceOf[List[Decl]]//.filter(p=>p.isInstanceOf[VarDecl]).toList
        if (vardecl.filter(p=>p.isInstanceOf[VarDecl]).exists(x => x.asInstanceOf[VarDecl].variable.name.toString == ast.variable.name.toString))
            throw Redeclared(Variable, ast.variable.name.toString)

        if (vardecl.filter(p=>p.isInstanceOf[FuncDecl]).exists(x => x.asInstanceOf[FuncDecl].name.name.toString == ast.variable.name.toString))
            throw Redeclared(Variable, ast.variable.name.toString)
        ast.asInstanceOf[Decl] :: c.asInstanceOf[List[Decl]]
    }

    override def visitFuncDecl(ast: FuncDecl, c: Any): Any = {
        var funcdecl = c.asInstanceOf[List[Decl]]//.filter(p=>p.isInstanceOf[FuncDecl])
        if (funcdecl.filter(p=>p.isInstanceOf[FuncDecl]).exists(x => x.asInstanceOf[FuncDecl].name.toString == ast.name.toString))
            throw Redeclared(Function, ast.name.name.toString)

        if (funcdecl.filter(p=>p.isInstanceOf[VarDecl]).exists(x => x.asInstanceOf[VarDecl].variable.name.toString == ast.name.name.toString))
            throw Redeclared(Function, ast.name.name.toString)
        var params = List[VarDecl]()
        if(ast.param.size > 0)
            params = ast.param.foldLeft(List[VarDecl]())((x,y) => visitParam(y,x).asInstanceOf[List[VarDecl]])

        if (params.exists(x=>x.variable.name == ast.name.name.toString))
            throw Redeclared(Parameter, ast.name.name.toString)
        var body = visit(ast.body, params).asInstanceOf[List[Decl]]
        ast.asInstanceOf[Decl]::c.asInstanceOf[List[Decl]]

    }

    def visitParam(ast: VarDecl, c: Any): Any = {
        val params = c.asInstanceOf[List[VarDecl]].filter(p=>p.isInstanceOf[VarDecl])
        if (params.exists(x => x.variable.name.toString == ast.variable.name.toString))
            throw Redeclared(Parameter, ast.variable.name.toString)
        else ast.asInstanceOf[Decl] :: params
    }

    override def visitBlock(ast: Block, c: Any): Any = {
        val params = c.asInstanceOf[List[VarDecl]].filter(p=>p.isInstanceOf[VarDecl])
        val body = ast.decl.filter(p=>p.isInstanceOf[VarDecl]).foldLeft(List[VarDecl]())((x,y)=>visit(y,params).asInstanceOf[List[VarDecl]])
        body
    }
    
}

class TypeChecking(ast: AST) extends BaseVisitor with Utils {
    override def visitProgram(ast: Program, c: Any): Any ={
        val env = c.asInstanceOf[List[Decl]]
        println("something", c)
        ast.decl.map(visit(_,c))
    }

    override def visitFuncDecl(ast: FuncDecl, c: Any): Any = {
        val params = ast.param.asInstanceOf[List[Decl]]
        val vars = ast.body.asInstanceOf[Block].decl.asInstanceOf[List[Decl]]
        val scope = vars:::params:::c.asInstanceOf[List[Decl]]
        visit(ast.body, scope)
    }

    override def visitBlock(ast: Block, c: Any): Any = {
        val blscope = ast.decl.asInstanceOf[List[Any]]
        val scope = blscope:::c.asInstanceOf[List[Any]]
        println("scope", c)
        ast.stmt.foldLeft(scope)((x,y) => {
            println("block", y)
                if(y.isInstanceOf[Expr]){
                    println("block in check", y)
                    visit(y,scope)
                    scope.asInstanceOf[List[Any]]
                }
                else{
                    if(y.isInstanceOf[Block]) {
                        val cBlock = y.asInstanceOf[Block].decl.asInstanceOf[List[Any]]
                        val childscope =  cBlock::: scope
                        visit(y, childscope)
                        scope.asInstanceOf[List[Any]]

                    } else {
                      visit(y,scope)
                    }
                }.asInstanceOf[List[Any]]
        })
    }

    override def visitBinaryOp(ast: BinaryOp, c: Any): Any = {
        println("enter visit binary", ast)
        val lt = visit(ast.left, c).asInstanceOf[Type]
        val rt = visit(ast.right, c).asInstanceOf[Type]
        println(ast.left, ast.right, lt, rt, ast.left)
        if (ast.op == "+" || ast.op == "-" || ast.op == "*" || ast.op == "/") {
            println("type", lt, rt, ast, ast.left)
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
        val tmp = visit(ast.body, c).asInstanceOf[Type]
        if (ast.op == "!") {
            if (tmp == BoolType) BoolType
            else throw TypeMismatchInExpression(ast)
        }
        else {
            if (tmp == BoolType) throw TypeMismatchInExpression(ast)
            else tmp
        }
    }

    override def visitId(ast: Id, c: Any): Any = {
        val vars = c.asInstanceOf[List[Decl]].filter(p=>p.isInstanceOf[VarDecl])
        // check undeclare for identifiers
        val id = lookupId(ast.name.toString, vars.asInstanceOf[List[VarDecl]])
        println("visit id", id)
        if (id == null)
            throw Undeclared(Identifier,ast.name.toString)
        id.varType
    }

    override def visitCallExpr(ast: CallExpr, c: Any): Any = {
        val funcs = c.asInstanceOf[List[Decl]].filter(p=>p.isInstanceOf[FuncDecl])
        // check undeclare for function call
        if(!funcs.asInstanceOf[List[FuncDecl]].exists(x => x.name.name == ast.method.name.toString))
            throw Undeclared(Function,ast.method.name.toString)

        // check undeclare for parameters
        ast.params.map(visit(_,c))

        // check match params number in function call
        val func = lookupFunc(ast.method.name, funcs.asInstanceOf[List[FuncDecl]])
        if (func != null && func.param.size != ast.params.size) throw TypeMismatchInExpression(ast)

        // check params match type in function call and function define
        func.param.zip(ast.params).map{case (x, y) =>
            val lhs = x.varType
            val rhs = visit(y,c).asInstanceOf[VarDecl].varType
            if (lhs == IntType && rhs != IntType) throw TypeMismatchInExpression(ast)
            else if(lhs == FloatType && (rhs != FloatType || rhs != IntType)) throw TypeMismatchInExpression(ast)
            else if(lhs == BoolType && rhs != BoolType) throw TypeMismatchInExpression(ast)
            else if(lhs == StringType && rhs != StringType) throw TypeMismatchInExpression(ast)
            else {
              if (rhs.isInstanceOf[ArrayPointerType]) {
                  if (lhs.asInstanceOf[ArrayPointerType].eleType != rhs.asInstanceOf[ArrayPointerType].eleType)
                    throw TypeMismatchInExpression(ast)
              }
              else throw TypeMismatchInExpression(ast)
            }
        }
        func.returnType
    }

    override def visitArrayCell(ast: ArrayCell, c: Any): Any = {
        val arr = visit(ast.arr, c).asInstanceOf[Type]
        val idx = visit(ast.idx, c).asInstanceOf[Type]

//        if (arr != ArrayType || idx != IntType) throw TypeMismatchInExpression(ast)
        arr.asInstanceOf[ArrayType].eleType
    }


//    override def visitIf(ast: If, c: Any): Any = {
//        val env = c.asInstanceOf[List[Any]]
//        val tmpEnv = env(0).asInstanceOf[List[List[Decl]]]
//        if (visit(ast.expr, c).asInstanceOf[Type] != BoolType) throw TypeMismatchInStatement(ast)
//        if (env(1) == true) c
//        else {	//(env(1) == false)
//            if (ast.elseStmt != None) {
//                val returnPath = List(ast.thenStmt, ast.elseStmt.get).map(x =>
//                    if (x.isInstanceOf[Block]) x.accept(this, List(List[Decl]() :: tmpEnv, env(1), env(2)))
//                    else x.accept(this, c)).asInstanceOf[List[Any]]
//                if (returnPath.filter(_.isInstanceOf[Type] == false).forall(x => x.asInstanceOf[List[Any]](1) == true))
//                    List(env(0), true, env(2))
//                else c
//            }
//            else {
//                if (ast.thenStmt.isInstanceOf[Block]) ast.thenStmt.accept(this, List(List[Decl]() :: tmpEnv, env(1), env(2)))
//                else ast.thenStmt.accept(this, c)
//                c
//            }
//        }
//    }
//
//    override def visitFor(ast: For, c: Any): Any = {
//        val env = c.asInstanceOf[List[Any]]
//        val tmpEnv = env(0).asInstanceOf[List[List[Decl]]]
//        if (ast.expr1.accept(this, c).asInstanceOf[Type] != IntType) throw TypeMismatchInStatement(ast)
//        if (ast.expr3.accept(this, c).asInstanceOf[Type] != IntType) throw TypeMismatchInStatement(ast)
//        if (ast.expr2.accept(this, c).asInstanceOf[Type] != BoolType) throw TypeMismatchInStatement(ast)
//        val newEnv = if (ast.loop.isInstanceOf[Block]) ast.loop.accept(this, List(List[Decl]() :: tmpEnv, env(1), true))
//        else ast.loop.accept(this, List(env(0), env(1), true))
//        if (newEnv.isInstanceOf[Type]) List(env(0), env(1), false)
//        else {
//          val loopEnv = newEnv.asInstanceOf[List[Any]]
//          List(loopEnv(0),  loopEnv(1), false)
//        }
//    }
//
//    override def visitReturn(ast: Return, c: Any): Any = {
//        val env = c.asInstanceOf[List[Any]]
//        val expEnv = env(0).asInstanceOf[List[List[Decl]]].flatten.filter(_.isInstanceOf[FuncDecl]).asInstanceOf[List[FuncDecl]]
//        val funcType = expEnv(0).returnType
//        val returnType = if (ast.expr == null) null else visit(ast.expr.asInstanceOf[AST], c)
//        if (funcType == VoidType) {
//          if (returnType != null) throw TypeMismatchInStatement(ast)
//        }
//        else if (funcType == IntType) {
//          if (returnType != IntType) throw TypeMismatchInStatement(ast)
//        }
//        else if (funcType == FloatType) {
//          if (returnType != IntType && returnType != FloatType) throw TypeMismatchInStatement(ast)
//        }
//        else {	//(funcType == BoolType)
//          if (returnType != BoolType) throw TypeMismatchInStatement(ast)
//        }
//        List(env(0), true, env(2))
//    }

    override def visitIntType(ast: IntType.type, c: Any): Any = IntType

    override def visitFloatType(ast: FloatType.type, c: Any): Any = FloatType

    override def visitBoolType(ast: BoolType.type, c: Any): Any = BoolType

    override def visitStringType(ast: StringType.type, c: Any): Any = StringType

    override def visitVoidType(ast: VoidType.type, c: Any): Any = VoidType

    override def visitArrayType(ast: ArrayType, c: Any): Any = ArrayType

    def lookupFunc(Id:String, lst:List[FuncDecl]):FuncDecl = {
        val varid = lookup(Id,lst,(s:FuncDecl)=>s.name.name)
        if(varid != None) varid.get
        else null
    }

    def lookupId(Id:String, lst:List[VarDecl]):VarDecl = {
        val varid = lookup(Id,lst,(s:VarDecl)=>s.variable.name)
        if(varid != None) varid.get
        else null
    }

}
