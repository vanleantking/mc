package bkool.checker

/**
 * @Student Name: Bui Cong Tuan
 * @Student ID: 13070273
 */

import bkool.parser._
import bkool.utils._
import java.io.{ PrintWriter, File }
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree._
import scala.collection.JavaConverters._

class StaticChecker(ast: AST) {

  def check() =
    {
      try {
        val globalGen = new GlobalGeneration();
        val globalEnv = globalGen.visit(ast, null).asInstanceOf[SymbolList]
        println("----- check.globalEnv: " + globalEnv)

//        val localGen = new LocalGeneration(globalEnv);
//        val localEnv = localGen.visit(ast, SymbolList(List[Symbol]()))
//        println("----- check.localEnv: " + localEnv)

        val tc = new TypeChecking(globalEnv)
        tc.visit(ast, globalEnv)


      } catch {
        case Undeclared(k, n) => throw Undeclared(k, n)
        case Redeclared(k, n) => throw Redeclared(k, n)
        case CannotAssignToConstant(s) => throw CannotAssignToConstant(s)
        case TypeMismatchInExpression(exp) => throw TypeMismatchInExpression(exp)
        case TypeMismatchInStatement(stmt) => throw TypeMismatchInStatement(stmt)
        case TypeMismatchInConstant(cons) => throw TypeMismatchInConstant(cons)
        case CannotAccessPrivateAttribute(cName, attr) => throw CannotAccessPrivateAttribute(cName, attr)
        case MethodNotReturn(m) => throw MethodNotReturn(m)
        case BreakNotInLoop(line) => throw BreakNotInLoop(line)
        case ContinueNotInLoop(line) => throw ContinueNotInLoop(line)
        case NotConstantExpression(exp) => throw NotConstantExpression(exp)
        //case _: Throwable => throw BreakNotInLoop(0)
      }
    }

}

// ------------------------------------------------------------------------------------------
// --- GlobalGeneration
// ------------------------------------------------------------------------------------------

class GlobalGeneration extends BaseVisitor with MyUtils {

  override def visitProgram(ast: Program, c: Context) =
    {
      println("------------ visitProgram!")
      ast.decl.foldLeft(buildIOSymbol())((x, y) => visit(y, x).asInstanceOf[SymbolList])
    }

  override def visitClassDecl(ast: ClassDecl, c: Context) = {
    println("------------ visitClassDecl!")
    val env = c.asInstanceOf[SymbolList].list
    val newenv = if (env.exists(x => x.name == ast.name.toString())) throw Redeclared(Class, ast.name.toString())
        else Symbol(ast.name.toString(), ClassType(ast.name.toString()), Class, Instance
            , ast.decl.foldLeft(SymbolList(List[Symbol]()))((x, y) => visit(y, x).asInstanceOf[SymbolList]))  :: env
    //ast.decl.foldLeft(SymbolList(List[Symbol]()).asInstanceOf[Context])((x, y) => visit(y, x).asInstanceOf[SymbolList])
    SymbolList(newenv)
    //println("------------ visitClassDecl.newenv: " + newenv)
    
    
  }

  override def visitMethodDecl(ast: MethodDecl, c: Context) = {
    println("------------ visitMethodDecl!")
    val env = c.asInstanceOf[SymbolList].list
    println("------------ visitMethodDecl.env: " + env)
    if (env.exists(x => x.name == ast.name.toString())) throw Redeclared(Method, ast.name.name)
    
    val declenv = visit(ast.body,SymbolList(List[Symbol]())).asInstanceOf[SymbolList]
    println("------------ visitMethodDecl.declenv: " + declenv)
    //val paramenv = ast.param.foldLeft(SymbolList(List[Symbol]()))((x, y) => visit(y, x).asInstanceOf[SymbolList])
    val paramenv = ast.param.foldLeft(declenv)((x, y) => visit(y, x).asInstanceOf[SymbolList])
    println("------------ visitMethodDecl.paramenv: " + paramenv)
    
    val newenv = if (env.exists(x => x.name == ast.name.toString())) throw Redeclared(Method, ast.name.name)
                  else Symbol(ast.name.toString(), ast.returnType, if (ast.returnType != null) Method 
                                                                    else SpecialMethod, ast.kind
                                                                    ,paramenv) :: env

    SymbolList(newenv)
  }
  
    override def visitParamDecl(ast: ParamDecl, c: Context): Object = {
    println("------------ visitParamDecl!")
    val oldenv = c.asInstanceOf[SymbolList].list
    val newenv = if (oldenv.exists(x => x.name == ast.id.toString())) throw Redeclared(Parameter, ast.id.toString())
        else Symbol(ast.id.toString(), ast.paramType, Parameter, Instance, null) :: oldenv
    SymbolList(newenv)
  }

  override def visitAttributeDecl(ast: AttributeDecl, c: Context) = {
    println("------------ visitAttributeDecl!")
    val decl = ast.decl
    val env = c.asInstanceOf[SymbolList].list
    println("------------ visitAttributeDecl.env: " + env)
    decl match {
      case VarDecl(a, b) => {
        val newenv = if (env.exists(x => x.name == a.toString())) throw Redeclared(Attribute, a.toString())
        else Symbol(a.toString(), b, Variable, ast.kind, null) :: env
        SymbolList(newenv)
      }
      case ConstDecl(a, b, _) => {
        val newenv = if (env.exists(x => x.name == a.toString())) throw Redeclared(Attribute, a.toString())
        else Symbol(a.toString(), b, Constant, ast.kind, null) :: env
        SymbolList(newenv)
      }
    }
  }

  override def visitBlock(ast: Block, c: Context) = {
    println("------------ visitBlock!")
    val env = c.asInstanceOf[SymbolList]
    ast.decl.foldLeft(env)((x, y) => visit(y, x).asInstanceOf[SymbolList])
  }

  override def visitVarDecl(ast: VarDecl, c: Context) = {
    println("------------ visitVarDecl!")
    val env = c.asInstanceOf[SymbolList]
    visit(ast.varType, env)
    val oldenv = env.list
    val newenv = if (oldenv.exists(x => x.name == ast.variable.toString())) throw Redeclared(Variable, ast.variable.toString())
    else Symbol(ast.variable.toString(), ast.varType, Variable, Instance, null) :: oldenv
    SymbolList(newenv)
  }

  override def visitConstDecl(ast: ConstDecl, c: Context) = {
    println("------------ visitConstDecl!")
    val env = c.asInstanceOf[SymbolList]

    val oldenv = env.list
    val newenv = if (oldenv.exists(x => x.name == ast.id.toString())) throw Redeclared(Constant, ast.id.toString())
    else Symbol(ast.id.toString(), ast.constType, Constant, Instance, null) :: oldenv
    SymbolList(newenv)
  }
  
}


// ------------------------------------------------------------------------------------------
// --- LocalGeneration - not use
// ------------------------------------------------------------------------------------------

class LocalGeneration(glList: SymbolList) extends BaseVisitor with MyUtils {
  override def visitProgram(ast: Program, c: Context) 
  //= ast.decl.foldLeft(buildIOSymbol())((x, y) => visit(y, x).asInstanceOf[SymbolList])
  = ast.decl.map(visit(_, c)).asInstanceOf[List[SymbolList]]

  override def visitClassDecl(ast: ClassDecl, c: Context) = {
    println("------------Local: visitClassDecl!")
    ast.decl.map(visit(_, c)).asInstanceOf[List[SymbolList]]
    
  }

  override def visitParamDecl(ast: ParamDecl, c: Context): Object = {
    println("------------Local: visitParamDecl!")
    val oldenv = c.asInstanceOf[SymbolList].list
    val newenv = if (oldenv.exists(x => x.name == ast.id.toString())) throw Redeclared(Parameter, ast.id.toString())
        else Symbol(ast.id.toString(), ast.paramType, Parameter, Instance, null) :: oldenv
    SymbolList(newenv)
  }

  override def visitMethodDecl(ast: MethodDecl, c: Context) = {
    println("------------Local: visitMethodDecl!")
    val paramenv = ast.param.foldLeft(SymbolList(List[Symbol]()))((x, y) => visit(y, x).asInstanceOf[SymbolList])
    val declenv = visit(ast.body,c)
    //SymbolList(paramenv)
    c
  }

  override def visitAttributeDecl(ast: AttributeDecl, c: Context) = {
    println("------------Local: visitAttributeDecl!")
    val decl = ast.decl
    val env = c.asInstanceOf[SymbolList].list
    decl match {
      case VarDecl(a, b) => {
        val newenv = if (env.exists(x => x.name == a.toString())) throw Redeclared(Attribute, a.toString())
        else Symbol(a.toString(), b, Variable, ast.kind, null) :: env
        SymbolList(newenv)
      }
      case ConstDecl(a, b, _) => {
        val newenv = if (env.exists(x => x.name == a.toString())) throw Redeclared(Attribute, a.toString())
        else Symbol(a.toString(), b, Constant, ast.kind, null) :: env
        SymbolList(newenv)
      }
    }
  }

  override def visitBlock(ast: Block, c: Context) = {
    println("------------Local: visitBlock!")
    //val newenv = ast.decl.foldLeft(glList)((x, y) => visit(y, x).asInstanceOf[SymbolList])
    //SymbolList(glList.list ++ newenv.list)
    ast.decl.foldLeft(glList)((x, y) => visit(y, x).asInstanceOf[SymbolList])
    //ast.decl.map(visit(_, c)).asInstanceOf[List[SymbolList]]
  }

  override def visitVarDecl(ast: VarDecl, c: Context) = {
    println("------------TC: visitVarDecl!")
    val env = c.asInstanceOf[SymbolList]
    visit(ast.varType, env)
    val oldenv = env.list
    val newenv = if (oldenv.exists(x => x.name == ast.variable.toString())) throw Redeclared(Variable, ast.variable.toString())
    else Symbol(ast.variable.toString(), ast.varType, Variable, Instance, null) :: oldenv
    //val locenv = ClassSymbolList(env.name, env.parent, SymbolList(newenv))
    //locenv
    SymbolList(newenv)
  }

  override def visitConstDecl(ast: ConstDecl, c: Context) = {
    println("------------TC: visitConstDecl!")
    val env = c.asInstanceOf[SymbolList]

    val oldenv = env.list
    val newenv = if (oldenv.exists(x => x.name == ast.id.toString())) throw Redeclared(Constant, ast.id.toString())
    else Symbol(ast.id.toString(), ast.constType, Constant, Instance, null) :: oldenv
    //val locenv = ClassSymbolList(env.name, env.parent, SymbolList(newenv))
    //locenv
    SymbolList(newenv)
  }
}


// ------------------------------------------------------------------------------------------
// --- TypeChecking & Undeclare
// ------------------------------------------------------------------------------------------
class TypeChecking(glList: SymbolList) extends BaseVisitor with MyUtils {

  var parammeterFlag = false
  var memberAccessFlag = false
  var assignmentFlag = false
  var methodReturnType: Type = VoidType
  var loopLevel = 0

  override def visitProgram(ast: Program, c: Context) =
    {
      println("------------TC: visitProgram!")
      ast.decl.map(visit(_, c))
    }

  override def visitClassDecl(ast: ClassDecl, c: Context) = {
    println("------------TC: visitClassDecl!")
    ast.decl.map(visit(_, c))
  }

  override def visitMethodDecl(ast: MethodDecl, c: Context) =
    {
      println("------------TC: visitMethodDecl!")
      visit(ast.body,c)

    }

  override def visitAttributeDecl(ast: AttributeDecl, c: Context) = {
    println("------------TC: visitAttributeDecl!")
    val decl = ast.decl
    val env = c.asInstanceOf[SymbolList].list
    decl match {
      case VarDecl(a, b) => {
        val newenv = if (env.exists(x => x.name == a.toString())) throw Redeclared(Attribute, a.toString())
        else Symbol(a.toString(), b, Variable, ast.kind, null) :: env
        SymbolList(newenv)
      }
      case ConstDecl(a, b, _) => {
        val newenv = if (env.exists(x => x.name == a.toString())) throw Redeclared(Attribute, a.toString())
        else Symbol(a.toString(), b, Constant, ast.kind, null) :: env
        SymbolList(newenv)
      }
    }
  }

  override def visitBlock(ast: Block, c: Context) = {
    println("------------TC: visitBlock!")
     //ast.decl.foldLeft(glList)((x, y) => visit(y, x).asInstanceOf[SymbolList])
     ast.stmt.map(visit(_, c))
  }

  override def visitParamDecl(ast: ParamDecl, c: Context): Object = {
    println("------------TC: visitParamDecl!")
    ast.id
  }
  
  override def visitAssign(ast: Assign, c: Context): Object = 
  {
    println("------------TC: visitAssign!")
    println("------------TC: visitAssign.ast.leftHandSide: " + ast.leftHandSide)
    val rhsType = visit(ast.expr, c)
    val lhsType = visit(ast.leftHandSide, c)
    ast.leftHandSide match {
        case id: Id => lookup(id.toString(), c.asInstanceOf[SymbolList].list) match {
          case None => null
          case Some(i) => i.zkind match {
            case Constant => throw CannotAssignToConstant(ast)
            case _ => null
          }
        }

        case arrayCell: ArrayCell => null
        case fieldAccess: FieldAccess =>
          lookup(fieldAccess.field.toString(), c.asInstanceOf[SymbolList].list) match {
            case None => null
            case Some(a) => a.zkind match {
              case Constant => throw CannotAssignToConstant(ast)
              case _ => null
            }
          }
      }

      // check type coerce
      // TODO how about class type? ex: Shape s; s := new Triangle
      //TODO the array type can check here
//      (lhsType, rhsType) match {
//        case (IntType, IntType) => IntType
//        case (FloatType, IntType | FloatType) => FloatType
//        case (BoolType, BoolType) => BoolType
//        case (a, b) => if (canCoerce(a.asInstanceOf[Type], b.asInstanceOf[Type], c)) a else throw TypeMismatchInStatement(ast)
//        //if (a == b) a else throw TypeMismatchInStatement(ast)
//
//      }
  }

  
  override def visitId(ast: Id, c: Context): Object = 
  {
    println("------------TC: visitId!")
      val a = lookup(ast.toString(), c.asInstanceOf[SymbolList].list) match {
        case None => throw Undeclared(Identifier, ast.toString())
        case Some(x) => null
      }
      lookupType(ast.toString(), c)
  }

}

class BaseVisitor extends Visitor {
  override def visit(ast: AST, c: Context): Object = ast.accept(this, c)
  override def visitProgram(ast: Program, c: Context): Object = c
  override def visitVarDecl(ast: VarDecl, c: Context): Object = c
  override def visitConstDecl(ast: ConstDecl, c: Context): Object = c
  override def visitParamDecl(ast: ParamDecl, c: Context): Object = c
  override def visitClassDecl(ast: ClassDecl, c: Context): Object = c
  override def visitMethodDecl(ast: MethodDecl, c: Context): Object = c
  override def visitAttributeDecl(ast: AttributeDecl, c: Context): Object = c

  override def visitInstance(ast: Instance.type, c: Context): Object = Instance
  override def visitStatic(ast: Static.type, c: Context): Object = Static

  override def visitIntType(ast: IntType.type, c: Context): Object = IntType
  override def visitFloatType(ast: FloatType.type, c: Context): Object = FloatType
  override def visitBoolType(ast: BoolType.type, c: Context): Object = BoolType
  override def visitStringType(ast: StringType.type, c: Context): Object = StringType
  override def visitVoidType(ast: VoidType.type, c: Context): Object = VoidType
  override def visitArrayType(ast: ArrayType, c: Context): Object = ArrayType
  override def visitClassType(ast: ClassType, c: Context): Object = ClassType

  override def visitBinaryOp(ast: BinaryOp, c: Context): Object = c
  override def visitUnaryOp(ast: UnaryOp, c: Context): Object = c
  override def visitNewExpr(ast: NewExpr, c: Context): Object = c
  override def visitCallExpr(ast: CallExpr, c: Context): Object = c
  override def visitId(ast: Id, c: Context): Object = ast.name
  override def visitArrayCell(ast: ArrayCell, c: Context): Object = c
  override def visitFieldAccess(ast: FieldAccess, c: Context): Object = c
  override def visitBlock(ast: Block, c: Context): Object = c
  override def visitAssign(ast: Assign, c: Context): Object = c
  override def visitIf(ast: If, c: Context): Object = c
  override def visitCall(ast: Call, c: Context): Object = c
  override def visitFor(ast: For, c: Context): Object = c
  override def visitBreak(ast: Break.type, c: Context): Object = c
  override def visitContinue(ast: Continue.type, c: Context): Object = c
  override def visitReturn(ast: Return, c: Context): Object = c
  override def visitIntLiteral(ast: IntLiteral, c: Context): Object = IntLiteral
  override def visitFloatLiteral(ast: FloatLiteral, c: Context): Object = FloatLiteral
  override def visitStringLiteral(ast: StringLiteral, c: Context): Object = StringLiteral
  override def visitBooleanLiteral(ast: BooleanLiteral, c: Context): Object = BooleanLiteral
  override def visitNullLiteral(ast: NullLiteral.type, c: Context): Object = NullLiteral
  override def visitSelfLiteral(ast: SelfLiteral.type, c: Context): Object = SelfLiteral
}

case class Statement(isReturn: Boolean) extends Context
case class Symbol(name: String, ztype: Type, zkind: Kind, zsiKind: SIKind, list: SymbolList) extends Context
case class SymbolList(list: List[Symbol]) extends Context
//case class ClassSymbolList(name: String, parent: String, symlst: SymbolList) extends Context
//case class GlobalSymbolList(list: List[ClassSymbolList]) extends Context
case class MethodType(returnType: Type, param: SymbolList) extends Type
object NullType extends Type

trait MyUtils {
  def buildIOSymbol(): SymbolList =
    {
      val v1 = Symbol("io", ClassType("io"), Class, Static, null)
      val v2 = Symbol("readInt", IntType, Class, Static, null)
      val v3 = Symbol("anArg", IntType, Class, Static, null)
      val v4 = Symbol("writeInt", VoidType, Class, Static, null)
      val v5 = Symbol("writeIntLn", VoidType, Class, Static, null)
      //SymbolList(List[Symbol](v1, v2, v3, v4, v5))
      SymbolList(List[Symbol]())
    }

//  def buildGlobalSymbol(): GlobalSymbolList =
//    {
//      GlobalSymbolList(List[ClassSymbolList](ClassSymbolList("", "", buildIOSymbol)))
//    }

  //  def lookup(name: String, symbols: SymbolList) = {
  //    symbols.list.find(_.name == name)
  //  }

  def lookup(name: String, symbols: List[Symbol]) = {
    symbols.find(_.name == name)
  }
  
  def lookupType(name: String, c: Context) = {
    lookup(name, c.asInstanceOf[SymbolList].list) match {
      case None => null
      case Some(a) => a.ztype
    }
  }
  
//  def lookup[T](name: String, lst: List[T], func: T => String): Option[T] = lst match {
//    case List() => None
//    case head :: tail => if (func(head) == name) Some(head) else lookup(name, tail, func)
//  }

  //  def lookupType(name: String, c: Context) = {
  //    lookup(name, c.asInstanceOf[SymbolList].list) match {
  //      case None => null
  //      case Some(a) => a.ztype
  //    }
  //  }

//  def checkType(lhs: Type, rhs: Type, lst: List[ClassSymbolList]): Boolean = {
//    lhs match {
//      case VoidType => false
//      case ClassType(t) => {
//        rhs match {
//          case ClassType(r) => {
//            if (r == t) true
//            else {
//              val currentClass = lookup(r, lst, (x: ClassSymbolList) => x.name)
//              currentClass match {
//                case None => false
//                case Some(x) => checkType(lhs, ClassType(x.parent), lst)
//              }
//            }
//          }
//          case NullType => true
//          case _ => false
//        }
//      }
//      case ArrayType(ldim, ltype) => {
//        rhs match {
//          case ArrayType(rdim, rtype) => {
//            if (checkType(ltype, rtype, lst) == true && ldim == rdim) true
//            else false
//          }
//          case NullType => true
//          case _ => false
//        }
//      }
//      case FloatType => {
//        if (rhs == FloatType || rhs == IntType) true
//        else false
//      }
//      case _ => {
//        if (rhs == lhs) true
//        else false
//      }
//    }
//  }
//
//  def checkSuperclass(current: ClassSymbolList, that: String, lst: List[ClassSymbolList]): Boolean = {
//    if (current.name == that) true
//    else {
//      if (current.parent == "") false
//      else {
//        val parentClass = lookup(current.parent, lst, (x: ClassSymbolList) => x.name)
//        parentClass match {
//          case None => false
//          case Some(t) => checkSuperclass(t, that, lst)
//        }
//      }
//    }
//  }

}

// ------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------
// --------------------------------------------
//trait Bct_AST
//case class Bct_Program(val decl: List[Bct_ClassDecl]) extends Bct_AST
//case class Bct_ClassDecl(val name: Id, val parent: Id, val decl: List[Bct_MemDecl]) extends Bct_AST { def getName = name.name }
//
//trait Bct_Decl extends Bct_AST { def getName: String }
//case class Bct_VarDecl(val variable: Id, val varType: Type) extends Bct_Decl { def getName = variable.name }
//case class Bct_ConstDecl(val id: Id, val constType: Type, val const: Expr) extends Bct_Decl { def getName = id.name }
//case class Bct_ParamDecl(val id: Id, val paramType: Type) extends Bct_Decl { def getName = id.name }
//
//trait Bct_MemDecl extends Bct_AST { def getName: String }
//case class Bct_MethodDecl(val name: Id, val param: List[Bct_ParamDecl], val returnType: Type,val body: Stmt) extends Bct_MemDecl { def getName = name.name }
//case class Bct_AttributeDecl(val decl: Bct_Decl) extends Bct_MemDecl { def getName = decl.getName }
//
//trait Bct_Stmt extends Bct_AST
//case class Bct_Block(val decl: List[Bct_Decl], val stmt: List[Bct_Stmt]) extends Bct_Stmt
//case class Bct_Assign(val leftHandSide: LHS, val expr: Expr) extends Bct_Stmt
//case class Bct_If(val expr: Expr, val thenStmt: Stmt, val elseStmt: Option[Stmt]) extends Bct_Stmt
//case class Bct_Call(val parent: Expr, val method: Id, val params: List[Expr]) extends Bct_Stmt
//case class Bct_For(val idx: String, val expr1: Expr, val up: Boolean, val expr2: Expr, val loop: Stmt) extends Bct_Stmt
//object Bct_Break extends Bct_Stmt
//object Bct_Continue extends Bct_Stmt
//case class Bct_Return(val expr: Expr) extends Bct_Stmt
// ------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------
//
//class TestGeneration(glList: GlobalSymbolList) extends BaseVisitor with MyUtils {
//
//  override def visitProgram(ast: Program, c: Context) =
//    {
//      println("------------TS: visitProgram!")
//      ast.decl.map(visit(_, null))
//    }
//
//  override def visitClassDecl(ast: ClassDecl, c: Context) = {
//    println("------------TS: visitClassDecl!")
//    Bct_ClassDecl(ast.name, (if (ast.parent != null) ast.parent else Id("")), ast.decl.map(visit(_, null)).asInstanceOf[List[Bct_MemDecl]])
//  }
//
//  override def visitMethodDecl(ast: MethodDecl, c: Context) =
//    {
//      println("------------TS: visitMethodDecl!")
//      Bct_MethodDecl(
//        ast.name, ast.param.map(visit(_, c)).asInstanceOf[List[Bct_ParamDecl]], ast.returnType
//        ,visit(ast.body,c).asInstanceOf[Stmt])
//
//    }
//
//  override def visitAttributeDecl(ast: AttributeDecl, c: Context) = {
//    println("------------TS: visitAttributeDecl!")
//    ast.decl
//  }
//
//  override def visitBlock(ast: Block, c: Context) = {
//    println("------------TS: visitBlock!")
//    val decl = ast.decl.map(visit(_, c)).asInstanceOf[List[Bct_Decl]]
//    val stmt = ast.stmt.map(visit(_, c)).asInstanceOf[List[Bct_Stmt]]
//    Bct_Block(decl, stmt)
//  }
//
//  override def visitParamDecl(ast: ParamDecl, c: Context): Object = {
//    println("------------TS: visitParamDecl!")
//    ast.id
//  }
//
//  override def visitVarDecl(ast: VarDecl, c: Context) = {
//    println("------------TS: visitVarDecl!")
//    ast.variable
//  }
//
//  override def visitConstDecl(ast: ConstDecl, c: Context) = {
//    println("------------TS: visitConstDecl!")
//    ast.const
//  }
//
//}
//
