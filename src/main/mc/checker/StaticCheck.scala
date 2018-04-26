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
            println("program", program)
        } catch {
            case Redeclared(k,n) => throw new Redeclared(k,n)
            case Undeclared(k,n) => throw new Undeclared(k,n)
        }
    }

    override def visitProgram(ast: Program, c: Any): Any =
        ast.decl.filter(p => p.isInstanceOf[Decl]).foldLeft(List[Decl]())((x,y)=>visit(y,x).asInstanceOf[List[Decl]])

    override def visitVarDecl(ast: VarDecl, c: Any): Any = {
        var vardecl = c.asInstanceOf[List[Decl]].filter(p=>p.isInstanceOf[VarDecl]).toList
        if (vardecl.exists(x => x.asInstanceOf[VarDecl].variable.name.toString == ast.variable.name.toString))
            throw Redeclared(Variable, ast.variable.name.toString)
        else ast.asInstanceOf[Decl] :: c.asInstanceOf[List[Decl]]
    }

    override def visitFuncDecl(ast: FuncDecl, c: Any): Any = {
        var funcdecl = c.asInstanceOf[List[Decl]].filter(p=>p.isInstanceOf[FuncDecl])
        if (funcdecl.exists(x => x.asInstanceOf[FuncDecl].name.toString == ast.name.toString))
            throw Redeclared(Function, ast.name.toString)

        var params = List[VarDecl]()
        if(ast.param.size > 0)
            params = ast.param.foldLeft(List[VarDecl]())((x,y) => visitParam(y,x).asInstanceOf[List[VarDecl]])
        var body = visit(ast.body, params).asInstanceOf[List[Decl]]
//        val func = List(params, body)
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
