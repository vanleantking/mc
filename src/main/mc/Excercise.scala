package mc

import mc.utils._


object Excercise {
  def my_filter(lst: Program) : List[Decl] = lst.decl.filter(p=>p.isInstanceOf[VarDecl])

  def main(args: Array[String]): Unit = {
    println(my_filter(Program(List(FuncDecl(Id("a"),List[VarDecl](),null,null),FuncDecl(Id("a"),List[VarDecl](),null,null), FuncDecl(Id("a"),List[VarDecl](),null,null), VarDecl(Id("b"),ArrayType(IntLiteral(5),IntType)), FuncDecl(Id("a"),List[VarDecl](),null,null)))))
  }
}
