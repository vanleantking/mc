package mc.checker

/**
 * @author nhphung
 */

import mc.parser._
import mc.utils.{Decl, _}
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
        println("scope", c)
        ast.stmt.map(visit(_,c))
    }

    override def visitBinaryOp(ast: BinaryOp, c: Any): Any = {
        if (ast.op.toString == "=="){
            if (ast.left.isInstanceOf[ArrayType] || ast.left.isInstanceOf[ArrayPointerType]) {
                throw TypeMismatchInExpression(ast)
            }
        }
        val lhs = visit(ast.left,c)
        val rhs = visit(ast.right, c)
    }

    override def visitId(ast: Id, c: Any): Any = {
        val vars = c.asInstanceOf[List[Decl]].filter(p=>p.isInstanceOf[VarDecl])
        // check undeclare for identifiers
        if(!vars.asInstanceOf[List[Decl]].exists(x => x.asInstanceOf[VarDecl].variable.name.toString == ast.name.toString))
            throw Undeclared(Identifier,ast.name.toString)
    }

    override def visitCallExpr(ast: CallExpr, c: Any): Any = {
        val funcs = c.asInstanceOf[List[Decl]].filter(p=>p.isInstanceOf[FuncDecl])
        // check undeclare for function call
        if(!funcs.asInstanceOf[List[Decl]].exists(x => x.asInstanceOf[FuncDecl].name.name == ast.method.name.toString))
            throw Undeclared(Function,ast.method.name.toString)


        // TODO Need to check mismatch in size of params not match,...


        // check undeclare for parameters
        ast.params.map(visit(_,c))
    }

    override def visitArrayCell(ast: ArrayCell, c: Any): Any = {
        val arr = visit(ast.arr, c)
        val idx = visit(ast.idx, c)

        if (!arr.isInstanceOf[ArrayType] || !idx.isInstanceOf[IntLiteral]) throw TypeMismatchInExpression(ast)
    }

    override def visitIntType(ast: IntType.type, c: Any): Any = IntType

    override def visitFloatType(ast: FloatType.type, c: Any): Any = FloatType

    override def visitBoolType(ast: BoolType.type, c: Any): Any = BoolType

    override def visitStringType(ast: StringType.type, c: Any): Any = StringType

    override def visitVoidType(ast: VoidType.type, c: Any): Any = VoidType

    override def visitArrayType(ast: ArrayType, c: Any): Any = ArrayType

}
