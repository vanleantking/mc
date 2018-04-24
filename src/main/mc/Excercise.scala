package mc

import javax.rmi.CORBA.Util
import mc.utils._


object Excercise extends BaseVisitor with Utils {

  //question 1
  def my_filter(lst: Program) : List[Decl] = lst.decl.filter(p=>p.isInstanceOf[VarDecl])

  def main(args: Array[String]): Unit = {
    println(my_filter(Program(List(FuncDecl(Id("a"),List[VarDecl](),null,null),FuncDecl(Id("a"),List[VarDecl](),null,null), FuncDecl(Id("a"),List[VarDecl](),null,null), VarDecl(Id("b"),ArrayType(IntLiteral(5),IntType)), FuncDecl(Id("a"),List[VarDecl](),null,null)))))
  }


  // question 2
//  def checkDuplicate(lst: List[VarDecl]) : Boolean = {
//    if(lst.size == 1) false
//    else if(lookup(lst.head.variable.name, lst.tail, (x:VarDecl)=>x.variable.name))
//    else checkDuplicate(lst.tail)
//  }

  //question 3
  override def visitProgram (ast: Program, c: Any) =
    ast.decl.filter(p=>p.isInstanceOf[FuncDecl]).exists(visit(_,c).asInstanceOf[Boolean])

//  override def visitFuncDecl(ast: FuncDecl, c:Any) =
//    checkDuplicate(ast.param)

//  def checkDuplicateLocal(ast: Program) : Boolean =
//    ast.decl.filter(p=>p.isInstanceOf[FuncDecl]).for

//  def question2(lst:List[VarDecl]):Boolean =    {
//    if(lst.size == 1) false
//    else if (lookup(lst.head.variable.name,lst.tail,(s:VarDecl)=>s.variable.name != None))
//      true
//    else question2(lst.tail)
//  }


}
