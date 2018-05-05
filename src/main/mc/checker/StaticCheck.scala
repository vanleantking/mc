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
        val program = visit(ast,null)
        val tc = new TypeChecking(ast)
        tc.visit(ast, program)
    }

    override def visitProgram(ast: Program, c: Any): Any ={
        val builtinFun = listlBuildInFuncs().asInstanceOf[List[Decl]]
        val funcs = ast.decl.filter(p=>p.isInstanceOf[FuncDecl]).asInstanceOf[List[FuncDecl]]
        if(lookupFunc("main",funcs) == null) throw NoEntryPoint
        val proenv = ast.decl.filter(p => p.isInstanceOf[Decl]).foldLeft(List[Decl]())((x,y)=>visit(y,x).asInstanceOf[List[Decl]])
        builtinFun:::proenv
    }


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

    def listlBuildInFuncs() = {
        List(
            FuncDecl(Id("getInt"), List[VarDecl](), IntType, Block(List[Decl](), List[Stmt]())),
            FuncDecl(Id("putInt"), List[VarDecl](VarDecl(Id("i"), IntType)), VoidType, Block(List[Decl](), List[Stmt]())),
            FuncDecl(Id("putIntLn"), List[VarDecl](VarDecl(Id("i"), IntType)), VoidType, Block(List[Decl](), List[Stmt]())),
            FuncDecl(Id("getFloat"), List[VarDecl](), IntType, Block(List[Decl](), List[Stmt]())),
            FuncDecl(Id("putFloat"), List[VarDecl](VarDecl(Id("f"), FloatType)), VoidType, Block(List[Decl](), List[Stmt]())),
            FuncDecl(Id("putFloatLn"), List[VarDecl](VarDecl(Id("f"), FloatType)), VoidType, Block(List[Decl](), List[Stmt]())),
            FuncDecl(Id("putString"), List[VarDecl](VarDecl(Id("s"), StringType)), VoidType, Block(List[Decl](), List[Stmt]())),
            FuncDecl(Id("putStringLn"), List[VarDecl](VarDecl(Id("s"), StringType)), VoidType, Block(List[Decl](), List[Stmt]())),
            FuncDecl(Id("putBool"), List[VarDecl](VarDecl(Id("b"), BoolType)), VoidType, Block(List[Decl](), List[Stmt]())),
            FuncDecl(Id("putBoolLn"), List[VarDecl](VarDecl(Id("b"), BoolType)), VoidType, Block(List[Decl](), List[Stmt]())),
            FuncDecl(Id("putLn"), List[VarDecl](), VoidType, Block(List[Decl](), List[Stmt]()))
        )
    }

    def lookupFunc(Id:String, lst:List[FuncDecl]):FuncDecl = {
        val varid = lookup(Id,lst,(s:FuncDecl)=>s.name.name)
        if(varid != None) varid.get
        else null
    }
    
}

class TypeChecking(ast: AST) extends BaseVisitor with Utils {
    override def visitProgram(ast: Program, c: Any): Any ={
        val env = c.asInstanceOf[List[Decl]]
        val funcs = env.filter(p=>p.isInstanceOf[FuncDecl]).asInstanceOf[List[FuncDecl]]
        if(lookupFunc("main",funcs) == null) throw NoEntryPoint
//        println("something", c)
        ast.decl.map(visit(_,c))
    }

    override def visitFuncDecl(ast: FuncDecl, c: Any): Any = {
        val params = ast.param.asInstanceOf[List[Decl]]
        val vars = ast.body.asInstanceOf[Block].decl.asInstanceOf[List[Decl]]
        val scope = vars:::params:::c.asInstanceOf[List[Decl]]
        val returnType = ast.returnType.asInstanceOf[Type]
        val isReturn = ast.body.asInstanceOf[Block].stmt.filter(p=>p.isInstanceOf[Return]).size == 0
        if (returnType != VoidType && isReturn == true) throw FunctionNotReturn(ast.name.name)
        visit(ast.body, scope)
    }

    override def visitBlock(ast: Block, c: Any): Any = {
        val blscope = ast.decl.asInstanceOf[List[Any]]
        val scope = blscope:::c.asInstanceOf[List[Any]]
        ast.stmt.foldLeft(scope)((x,y) => {
            if(y.isInstanceOf[Expr]){
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
                    scope.asInstanceOf[List[Any]]
                }
            }.asInstanceOf[List[Any]]
        })
    }

    override def visitBinaryOp(ast: BinaryOp, c: Any): Any = {
        val lt = visit(ast.left, c).asInstanceOf[Type]
        val rt = visit(ast.right, c).asInstanceOf[Type]
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
        else {
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

        else {
            // check params match type in function call and function define
            func.param.zip(ast.params).map{case (x, y) =>

                val lhs = x.varType
                val rhs = visit(y,c)
                if(lhs == IntType && rhs != IntType) throw TypeMismatchInExpression(ast)
                if(lhs == FloatType && (rhs != FloatType || rhs != IntType)) throw TypeMismatchInExpression(ast)
                if(lhs == BoolType && rhs != BoolType) throw TypeMismatchInExpression(ast)
                if(lhs == StringType && rhs != StringType) throw TypeMismatchInExpression(ast)
                if(lhs == ArrayPointerType && (rhs == ArrayType || rhs == ArrayPointerType)) {
                    if (lhs.asInstanceOf[ArrayPointerType].eleType == rhs.asInstanceOf[ArrayPointerType].eleType)
                        throw TypeMismatchInExpression(ast)
                }
            }
        }

        func.returnType
    }

    override def visitArrayCell(ast: ArrayCell, c: Any): Any = {
        val arr = visit(ast.arr, c).asInstanceOf[Type]
        val idx = visit(ast.idx, c).asInstanceOf[Type]

        if (arr.isInstanceOf[ArrayType])
            arr.asInstanceOf[ArrayType].eleType
        else arr.asInstanceOf[ArrayPointerType].eleType
    }


    override def visitIf(ast: If, c: Any): Any = {
        val env = c.asInstanceOf[List[Any]]
        if (visit(ast.expr, c).asInstanceOf[Type] != BoolType) throw TypeMismatchInStatement(ast)
        ast.elseStmt match {
            case None => None
            case Some(t) => visit(t,c)
        }
        val thenStmt = visit(ast.thenStmt,c)
        c

    }

    override def visitFor(ast: For, c: Any): Any = {
        if (ast.expr1.accept(this, c).asInstanceOf[Type] != IntType) throw TypeMismatchInStatement(ast)
        if (ast.expr3.accept(this, c).asInstanceOf[Type] != IntType) throw TypeMismatchInStatement(ast)
        if (ast.expr2.accept(this, c).asInstanceOf[Type] != BoolType) throw TypeMismatchInStatement(ast)
        visit(ast.loop, c)
        c
    }

    override def visitDowhile(ast: Dowhile, c: Any): Any = {
        val exp = visit(ast.exp, c).asInstanceOf[Type]
        if(exp != BoolType) throw TypeMismatchInStatement(ast)
        ast.sl.map(x=>visit(x,c))
        c
    }
//
    override def visitReturn(ast: Return, c: Any): Any = {
        println("visit return", ast, c)
        val funcdecl = c.asInstanceOf[List[Any]].filter(p=>p.isInstanceOf[FuncDecl]).asInstanceOf[List[FuncDecl]]
        val funcType = lookupReturn(ast.toString, funcdecl).returnType
        val returnType = ast.expr match {
            case None => null
            case Some(t) => visit(t,c).asInstanceOf[Type]
        }
        if(funcType == VoidType && returnType != null)  throw TypeMismatchInStatement(ast)

        if(funcType == IntType && returnType != IntType) throw TypeMismatchInStatement(ast)

        if(funcType == FloatType && returnType != IntType && returnType != FloatType) throw TypeMismatchInStatement(ast)

        if(funcType == BoolType && returnType != BoolType) throw TypeMismatchInStatement(ast)
    }

    override def visitIntType(ast: IntType.type, c: Any): Any = IntType

    override def visitFloatType(ast: FloatType.type, c: Any): Any = FloatType

    override def visitBoolType(ast: BoolType.type, c: Any): Any = BoolType

    override def visitStringType(ast: StringType.type, c: Any): Any = StringType

    override def visitVoidType(ast: VoidType.type, c: Any): Any = VoidType

    override def visitArrayType(ast: ArrayType, c: Any): Any = ArrayType

    override def visitIntLiteral(ast: IntLiteral, c: Any): Any = IntType

    override def visitFloatLiteral(ast: FloatLiteral, c: Any): Any = FloatType

    override def visitStringLiteral(ast: StringLiteral, c: Any): Any = StringType

    override def visitBooleanLiteral(ast: BooleanLiteral, c: Any): Any = BoolType

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

    def lookupReturn(Id: String, lst:List[FuncDecl]): FuncDecl = {
        lst match {
            case List() => null
            case head::tail => {
                val rt = head.body.asInstanceOf[Block].stmt.filter(p=>p.isInstanceOf[Return])
                if(rt.size > 0 && rt(0).asInstanceOf[Return].toString == Id)
                    head.asInstanceOf[FuncDecl]
                else lookupReturn(Id, tail)
            }
        }
    }

}
