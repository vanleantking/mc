import org.scalatest.FunSuite
import mc.checker._
import mc.utils._

/**
  * Created by nhphung on 4/29/17.
  */
class CheckerSuite extends FunSuite with TestChecker {
//  test("not error 401") {
//    val input = "int a;"
//    val expected = ""
//    assert(checkCkr(input,expected,401))
//  }
//
//  test("not error 402") {
//    val input = "int a; int b;"
//    val expected = ""
//    assert(checkCkr(input,expected,402))
//  }
//
//  test("not error 403") {
//    val input = "int a; int b; void main(){}"
//    val expected = ""
//    assert(checkCkr(input,expected,403))
//  }
//
//  test("not error 404") {
//    val input = "int a; int b; void main(){} void r(){}"
//    val expected = ""
//    assert(checkCkr(input,expected,404))
//  }
//
//  test("Redeclare variable 405") {
//    val input = "int a; int a;"
//    val expected = "Undeclared Function: writeIntLn"
//    assert(checkCkr(input,expected,405))
//  }
//
//  test("Redeclare variable 406") {
//    val input = "int a; void main(){} int a;"
//    val expected = "Undeclared Function: writeIntLn"
//    assert(checkCkr(input,expected,406))
//  }
//
//  test("Redeclare variable 407") {
//    val input = "int a, a;"
//    val expected = "Undeclared Function: writeIntLn"
//    assert(checkCkr(input,expected,407))
//  }
//
//  test("Redeclare variable 408") {
//    val input = "int a, b; void r(){} void r(int a){}"
//    val expected = "Undeclared Function: writeIntLn"
//    assert(checkCkr(input,expected,408))
//  }
//
//  test("Redeclare variable 409") {
//    val input = "int a, b; void r(){} void v(int a){}"
//    val expected = "Undeclared Function: writeIntLn"
//    assert(checkCkr(input,expected,409))
//  }
//
//  test("Redeclare variable 410") {
//    val input = "int a, b; void r(int a){} void v(int a){}"
//    val expected = "Undeclared Function: writeIntLn"
//    assert(checkCkr(input,expected,410))
//  }
//
//  test("Redeclare variable 411") {
//    val input = "int a, b; void r(int a, int b){} void v(int a){}"
//    val expected = "Undeclared Function: writeIntLn"
//    assert(checkCkr(input,expected,411))
//  }
//
//  test("Redeclare variable 412") {
//    val input = "int a, b; void r(int a, int a){} void v(int a){}"
//    val expected = "Undeclared Function: writeIntLn"
//    assert(checkCkr(input,expected,412))
//  }
//
//  test("Redeclare variable 413") {
//    val input = "int a, b; void r(int a, int b){int n;} void v(int a){}"
//    val expected = "Undeclared Function: writeIntLn"
//    assert(checkCkr(input,expected,413))
//  }
//
//  test("Redeclare variable 414") {
//    val input = "int a, b; void r(int a, int b){int a;} void v(int a){}"
//    val expected = "Undeclared Function: writeIntLn"
//    assert(checkCkr(input,expected,414))
//  }

  test("Redeclare variable 415") {
    val input = "int a, b; void r(int a, int b){float c;} int c;"
    val expected = "Undeclared Function: writeIntLn"
    assert(checkCkr(input,expected,415))
  }
//  test("Type Mismatch In Expression: getInt") {
//    val input = "void main () {} void main () {}"
//    val expected = "Type Mismatch In Expression: "+CallExpr(Id("getInt"),List(IntLiteral(3))).toString
//    assert(checkCkr(input,expected,402))
//  }
//  test("Type Mismatch In Expression: putIntLn") {
//
//    val input = "void main () {putIntLn();}"
//    val expected = "Type Mismatch In Expression: "+CallExpr(Id("putIntLn"),List()).toString
//    assert(checkCkr(input,expected,403))
//  }
//  test("Check with AST") {
//
//    val input = Program(List(
//      FuncDecl(Id("main"),List(),VoidType,
//        Block(List(),
//          List(CallExpr(Id("putIntLn"),List()))))))
//    val expected = "Type Mismatch In Expression: "+CallExpr(Id("putIntLn"),List()).toString
//    assert(checkAst(input,expected,404))
//  }
//  test("Check with AST putIntLn with float") {
//
//    val input = Program(List(
//      FuncDecl(Id("main"),List(),VoidType,
//        Block(List(),
//          List(CallExpr(Id("putIntLn"),List(FloatLiteral(1.2f))))))))
//    val expected = "Type Mismatch In Expression: "+CallExpr(Id("putIntLn"),List(FloatLiteral(1.2f))).toString
//    assert(checkAst(input,expected,405))
//
//  }

  
}