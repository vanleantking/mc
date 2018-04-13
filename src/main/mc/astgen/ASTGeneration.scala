package mc.astgen
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import java.io.{PrintWriter,File}
import org.antlr.v4.runtime.ANTLRFileStream
import mc.utils._
import scala.collection.JavaConverters._
import org.antlr.v4.runtime.tree._
import mc.parser._
import mc.parser.MCParser._

class ASTGeneration extends MCBaseVisitor[Any] {

  def flatten(l: List[Any]): List[Any] = {
    def _flatten(res: List[Any], rem: List[Any]):List[Any] = rem match {
      case Nil => res
      case (h:List[_])::Nil => _flatten(res, h)
      case (h:List[_])::tail => _flatten(res:::h, tail)
      case h::tail => _flatten(res:::List(h), tail)
    }
    _flatten(List(), l)
  }

  override def visitProgram(ctx:ProgramContext) =
    Program(flatten(ctx.one_decl.asScala.toList.map(s=>visitOne_decl(s)).asInstanceOf[List[Decl]]).asInstanceOf[List[Decl]])

  override def visitOne_decl(ctx: One_declContext) =
    ctx.getChild(0).accept(this)

  override def visitVar_decl(ctx: Var_declContext) = {
    var vtype = ctx.primitivetype.accept(this).asInstanceOf[Type]
    flatten(ctx.variable.asScala.toList.zipWithIndex.map{case (s,i)=> {
      if(ctx.variable(i).getChildCount > 1)
        vtype = ArrayType(IntLiteral(ctx.variable(i).INTLIT().getText.toInt),ctx.primitivetype().accept(this).asInstanceOf[Type])
      VarDecl(Id(ctx.variable(i).IDENTIFIERS().getText.toString),vtype)
    }})
  }

  override def visitFunc_decl(ctx: Func_declContext) = {
    val id = Id(ctx.IDENTIFIERS.getText.toString)
    val blstmt = ctx.block_statement().accept(this).asInstanceOf[Block]
    val typef = ctx.function_type.accept(this).asInstanceOf[Type]
    if (ctx.list_parameter_decl() != null)
      FuncDecl(id, ctx.list_parameter_decl().accept(this).asInstanceOf[List[VarDecl]], typef, blstmt)
    else {
      FuncDecl(id, List[VarDecl](), typef, blstmt)
    }
  }

  //
  override def visitList_parameter_decl(ctx: List_parameter_declContext) = {
    ctx.parameter_decl.asScala.toList.map(s => visit(s).asInstanceOf[VarDecl])
  }

  override def visitParameter_decl(ctx: Parameter_declContext) =
    if (ctx.LSB != null) {
      VarDecl(Id(ctx.IDENTIFIERS().getText.toString), ArrayPointerType(ctx.primitivetype().accept(this).asInstanceOf[Type]))
    } else {
      VarDecl(Id(ctx.IDENTIFIERS().getText.toString), ctx.primitivetype().accept(this).asInstanceOf[Type])
    }

  //
  override def visitFunction_type(ctx: Function_typeContext) =
    if(ctx.array_pointer_type()!=null) {
      ctx.array_pointer_type.accept(this).asInstanceOf[Type]
    } else if(ctx.VOID != null) {
      VoidType
    } else {
      ctx.primitivetype.accept(this).asInstanceOf[Type]
    }

  override def visitArray_pointer_type(ctx: Array_pointer_typeContext) = {
    val ptype = ctx.getChild(0).accept(this).asInstanceOf[Type]
    ArrayPointerType(ptype)
  }

  override def visitOutput_param_pointer(ctx: Output_param_pointerContext) =
    ctx.primitivetype.accept(this).asInstanceOf[Type]


  override def visitBlock_statement(ctx: Block_statementContext) = {
    var stmt = List[Stmt]()
    var decl = List[Decl]()
    if(ctx.statement() != null) {
      stmt = ctx.statement.asScala.toList.map(s => visitStatement(s).asInstanceOf[Stmt])
    }

    if (ctx.var_decl() != null) {
      decl = ctx.var_decl.asScala.toList.map(s=>visitVar_decl(s)).asInstanceOf[List[Decl]]
    }
    Block(flatten(decl).asInstanceOf[List[Decl]], flatten(stmt).asInstanceOf[List[Stmt]])
  }

  override def visitStatement(ctx: StatementContext) = {
    ctx.getChild(0).accept(this).asInstanceOf[Stmt]
  }

  override def visitReturn_statement(ctx: Return_statementContext) =
    if (ctx.expr() != null)
      Return(Some(ctx.expr().accept(this).asInstanceOf[Expr]))
    else Return(None)

  override def visitContinue_statement(ctx: Continue_statementContext) =
    Continue

  override def visitBreak_statement(ctx: Break_statementContext) =
    Break

  override def visitDo_statement(ctx: Do_statementContext) =
    Dowhile(ctx.statement().asScala.toList.map(s=>visitStatement(s)),ctx.expr().accept(this).asInstanceOf[Expr])

  override def visitIf_statement(ctx: If_statementContext) = {
    val expr = ctx.expr().accept(this).asInstanceOf[Expr]
    val thenstmt = ctx.statement(0).accept(this).asInstanceOf[Stmt]
    var some = null
    if (ctx.statement(1) != null) {
      If(expr,thenstmt,Some(ctx.statement(1).accept(this).asInstanceOf[Stmt]))
    } else {
      If(expr,thenstmt,None)
    }
  }

  override def visitFor_statement(ctx: For_statementContext) =
    For(ctx.expr(0).accept(this).asInstanceOf[Expr],ctx.expr(1).accept(this).asInstanceOf[Expr],ctx.expr(2).accept(this).asInstanceOf[Expr],ctx.statement().accept(this).asInstanceOf[Stmt])

  override def visitExpr_statement(ctx: Expr_statementContext) = {
    ctx.expr().accept(this).asInstanceOf[Expr]
  }


  override def visitExpr(ctx: ExprContext): AnyRef = {
    if (ctx.getChildCount() == 1) {
      ctx.term1().accept(this).asInstanceOf[Expr]
    } else {
      BinaryOp(ctx.getChild(1).toString(), ctx.term1().accept(this).asInstanceOf[Expr], ctx.expr().accept(this).asInstanceOf[Expr])
    }
  }

  override def visitTerm1(ctx: Term1Context) = {
    if (ctx.getChildCount == 1) {
      ctx.term2().accept(this).asInstanceOf[Expr]
    } else {
      BinaryOp(ctx.getChild(1).toString(), ctx.term1().accept(this).asInstanceOf[Expr], ctx.term2().accept(this).asInstanceOf[Expr])
    }
  }

  override def visitTerm2(ctx: Term2Context) =
    if (ctx.getChildCount == 1) {
      ctx.term3().accept(this).asInstanceOf[Expr]
    } else {
      BinaryOp(ctx.getChild(1).toString(), ctx.term2().accept(this).asInstanceOf[Expr], ctx.term3().accept(this).asInstanceOf[Expr])
    }

  override def visitTerm3(ctx: Term3Context) = {
    if (ctx.getChildCount() == 1) {
      ctx.term4(0).accept(this).asInstanceOf[Expr]
    } else {
      BinaryOp(ctx.getChild(1).toString(), ctx.term4(0).accept(this).asInstanceOf[Expr], ctx.term4(1).accept(this).asInstanceOf[Expr])
    }
  }

  override def visitTerm4(ctx: Term4Context) =
    if (ctx.getChildCount() == 1) {
      ctx.term5(0).accept(this).asInstanceOf[Expr]
    } else {
      BinaryOp(ctx.getChild(1).toString(), ctx.term5(0).accept(this).asInstanceOf[Expr], ctx.term5(1).accept(this).asInstanceOf[Expr])
    }

  override def visitTerm5(ctx: Term5Context) =
    if (ctx.getChildCount() == 1) {
      ctx.term6.accept(this).asInstanceOf[Expr]
    } else {
      BinaryOp(ctx.getChild(1).toString(), ctx.term5.accept(this).asInstanceOf[Expr], ctx.term6.accept(this).asInstanceOf[Expr])
    }

  override def visitTerm6(ctx: Term6Context) =
    if (ctx.getChildCount() == 1) {
      ctx.term7.accept(this).asInstanceOf[Expr]
    } else {
      BinaryOp(ctx.getChild(1).toString(), ctx.term6.accept(this).asInstanceOf[Expr], ctx.term7.accept(this).asInstanceOf[Expr])
    }

  override def visitTerm7(ctx: Term7Context) =
    if (ctx.getChildCount() == 1) {
      ctx.term8.accept(this).asInstanceOf[Expr]
    } else {
      UnaryOp(ctx.getChild(1).toString(), ctx.term7.accept(this).asInstanceOf[Expr])
    }

  override def visitTerm8(ctx: Term8Context) =
    if (ctx.getChildCount() == 1) {
      ctx.term9.accept(this).asInstanceOf[Expr]
    } else {
//      UnaryOp(ctx.getChild(1).toString(), ctx.term9.accept(this).asInstanceOf[Expr])
      ArrayCell(ctx.term9().accept(this).asInstanceOf[Expr],ctx.expr().accept(this).asInstanceOf[Expr])
    }

  override def visitTerm9(ctx: Term9Context) = {
    if(ctx.getChildCount() == 3) {
      ctx.expr().accept(this).asInstanceOf[Expr]
    } else {
      if(ctx.function_call() != null) {
        ctx.function_call().accept(this).asInstanceOf[Expr]
      } else if(ctx.BOOLEAN_LITERAL() != null) {
        BooleanLiteral(ctx.BOOLEAN_LITERAL().getText.toBoolean)
      }  else if(ctx.INTLIT() != null) {
        IntLiteral(ctx.INTLIT().getText.toInt)
      } else if(ctx.FLOAT_LITERAL() != null) {
        FloatLiteral(ctx.FLOAT_LITERAL().getText.toFloat)
      } else if(ctx.STRINGLIT() != null) {
        StringLiteral(ctx.STRINGLIT().getText)
      } else if(ctx.IDENTIFIERS() != null) {
        Id(ctx.IDENTIFIERS().getText.toString)
      }
    }
  }

  override def visitFunction_call(ctx: Function_callContext) = {
    if (ctx.expr_list() != null)
      CallExpr(Id(ctx.IDENTIFIERS().getText.toString),flatten(ctx.expr_list().accept(this).asInstanceOf[List[Expr]]).asInstanceOf[List[Expr]])
    else {
      CallExpr(Id(ctx.IDENTIFIERS().getText.toString),List[Expr]())
    }
  }

  override def visitExpr_list(ctx: Expr_listContext) = {
    ctx.expr().asScala.toList.map(s=>visitExpr(s).asInstanceOf[Expr])
  }


  override def visitPrimitivetype(ctx: PrimitivetypeContext) = {
    if (ctx.getChild(0).getText == "int") {
      IntType
    } else if (ctx.getChild(0).getText == "boolean") {
      BoolType
    } else if (ctx.getChild(0).getText == "float") {
      FloatType
    } else if (ctx.getChild(0).getText == "string") {
      StringType
    }
  }

}