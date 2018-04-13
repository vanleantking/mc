import org.scalatest.FunSuite
import mc.utils._
import mc.astgen.ASTGeneration

/**
  * Created by nhphung on 4/29/17.
  */
class AstSuite extends FunSuite with TestAst {
  /**
    * Testcases nộp
    */
  //  test("a variable declare with int type") {
//    val input = "int a;"
//    val expected = Program(List(VarDecl(Id("a"),IntType)))
//    assert(checkAst(input,expected,201))
//  }
//
//  test("a variable declare with float type") {
//    val input = "float a;"
//    val expected = Program(List(VarDecl(Id("a"),FloatType)))
//    assert(checkAst(input,expected,202))
//  }
//
//  test("a variable declare with bool type") {
//    val input = "boolean a;"
//    val expected = Program(List(VarDecl(Id("a"),BoolType)))
//    assert(checkAst(input,expected,203))
//  }
//
//  test("a variable declare with string type") {
//    val input = "string f;"
//    val expected = Program(List(VarDecl(Id("f"),StringType)))
//    assert(checkAst(input,expected,204))
//  }
//
//  test("mix variable declare with string type") {
//    val input = "string f; int b;"
//    val expected = Program(List(VarDecl(Id("f"),StringType),VarDecl(Id("b"),IntType)))
//    assert(checkAst(input,expected,205))
//  }
//
//  test("a variable declare with array type") {
//    val input = "int a[4];int f,g;"
//    val expected = Program(List(VarDecl(Id("a"),ArrayType(IntLiteral(4),IntType)),VarDecl(Id("f"),IntType),VarDecl(Id("g"),IntType)))
//    assert(checkAst(input,expected,206))
//  }
//
//  test("a variable list declare same type with string type") {
//    val input = "string a,f, b[3];"
//    val expected = Program(List(VarDecl(Id("a"),StringType),VarDecl(Id("f"),StringType),VarDecl(Id("b"),ArrayType(IntLiteral(3),StringType))))
//    assert(checkAst(input,expected,207))
//  }
//
//  test("a variable list declare same type with int type") {
//    val input = "int a,f, b[3];"
//    val expected = Program(List(VarDecl(Id("a"),IntType),VarDecl(Id("f"),IntType),VarDecl(Id("b"),ArrayType(IntLiteral(3),IntType))))
//    assert(checkAst(input,expected,208))
//  }
//
//  test("a variable list declare same type with float type") {
//    val input = "float a,f, b[3];"
//    val expected = Program(List(VarDecl(Id("a"),FloatType),VarDecl(Id("f"),FloatType),VarDecl(Id("b"),ArrayType(IntLiteral(3),FloatType))))
//    assert(checkAst(input,expected,209))
//  }
//
//  test("a variable list declare same type with bool type") {
//    val input = "boolean a,f, b[3];"
//    val expected = Program(List(VarDecl(Id("a"),BoolType),VarDecl(Id("f"),BoolType),VarDecl(Id("b"),ArrayType(IntLiteral(3),BoolType))))
//    assert(checkAst(input,expected,210))
//  }
//
//  test("a variable list declare diferrent type with bool type") {
//    val input = "boolean b[3]; boolean g;"
//    val expected = Program(List(VarDecl(Id("b"),ArrayType(IntLiteral(3),BoolType)),VarDecl(Id("g"),BoolType)))
//    assert(checkAst(input,expected,211))
//  }
////
//  test("a variable list declare diferrent type with int type") {
//    val input = "int a[4];int a;"
//    val expected = Program(List(VarDecl(Id("a"),ArrayType(IntLiteral(4),IntType)),VarDecl(Id("a"),IntType)))
//    assert(checkAst(input,expected,212))
//  }
//
//  test("a variable list declare diferrent type with float type") {
//    val input = "float a[4];float a;"
//    val expected = Program(List(VarDecl(Id("a"),ArrayType(IntLiteral(4),FloatType)),VarDecl(Id("a"),FloatType)))
//    assert(checkAst(input,expected,213))
//  }
//
//  test("a variable list declare diferrent type with mix type") {
//    val input = "string a[4];string a;"
//    val expected = Program(List(VarDecl(Id("a"),ArrayType(IntLiteral(4),StringType)),VarDecl(Id("a"),StringType)))
//    assert(checkAst(input,expected,214))
//  }
//
//  test("a simple empty main int type") {
//    val input = "int main () {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(),List()))))
//    assert(checkAst(input,expected,215))
//  }
//
//  test("a simple empty main float type") {
//    val input = "float main () {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),FloatType,Block(List(),List()))))
//    assert(checkAst(input,expected,216))
//  }
//
//  test("a simple empty main boolean type") {
//    val input = "boolean main () {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),BoolType,Block(List(),List()))))
//    assert(checkAst(input,expected,217))
//  }
//
//  test("a simple empty main string type") {
//    val input = "string main () {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),StringType,Block(List(),List()))))
//    assert(checkAst(input,expected,218))
//  }
//
//  test("a simple empty main void type") {
//    val input = "void main () {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,219))
//  }
//
//  test("a simple empty main int array type") {
//    val input = "int[] main () {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),ArrayPointerType(IntType),Block(List(),List()))))
//    assert(checkAst(input,expected,220))
//  }
//
//  test("a simple empty main string array type") {
//    val input = "string[] main () {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),ArrayPointerType(StringType),Block(List(),List()))))
//    assert(checkAst(input,expected,221))
//  }
//
//  test("a simple empty main string float type") {
//    val input = "float[] main () {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),ArrayPointerType(FloatType),Block(List(),List()))))
//    assert(checkAst(input,expected,222))
//  }
//
//  test("a simple empty main string boolean type") {
//    val input = "boolean[] main () {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),ArrayPointerType(BoolType),Block(List(),List()))))
//    assert(checkAst(input,expected,223))
//  }
//
//  test("a simple empty main string void type with parameter list") {
//    val input = "void main (int a, int b) {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),IntType)),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,224))
//  }
//
//  test("a simple empty main void type with parameter list 225") {
//    val input = "void main (int a, int b[5]) {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),ArrayType(IntLiteral(5),IntType))),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,225))
//  }
//
//  test("a simple empty main int type with parameter list 226") {
//    val input = "int[] main (int a, int b[5]) {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),ArrayType(IntLiteral(5),IntType))),ArrayPointerType(IntType),Block(List(),List()))))
//    assert(checkAst(input,expected,226))
//  }

  /**
    * Test ast generation
    */
  test("a simple empty main int type with parameter list 227") {
    val input = "int a(int a) { int a; a[f(3)+4] = funct[3] + g()+ 6;function(u,v) + 4 = (f(t,u) + 4)*6;}"
    val expected = Program(List(FuncDecl(Id("a"),List(VarDecl(Id("a"),IntType)),IntType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",BinaryOp("+",CallExpr(Id("func"),List(Id("u"),Id("v"))),IntLiteral(4)),BinaryOp("+",IntLiteral(3),IntLiteral(4))))))))
    assert(checkAst(input,expected,227))
  }

//  test("a simple empty main int type with parameter list 228") {
//    val input = "int[] a(int a[], boolean b[]) { int a; function[f(4,y) + 5] + 4 = (f(t,u) + 4)*6;}"
//    val expected = Program(List(FuncDecl(Id("a"),List(VarDecl(Id("a"),IntType)),IntType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",BinaryOp("+",CallExpr(Id("func"),List(Id("u"),Id("v"))),IntLiteral(4)),BinaryOp("+",IntLiteral(3),IntLiteral(4))))))))
//    assert(checkAst(input,expected,228))
//  }

//
  test("a simple empty main int type with parameter list 228") {
    val input = "int a(int a) { int a; a[f(x)+3] = funct[3] + g(y,u)+ 6;}"
    val expected = Program(List(FuncDecl(Id("a"),List(VarDecl(Id("a"),IntType)),IntType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",BinaryOp("+",CallExpr(Id("func"),List(Id("u"),Id("v"))),IntLiteral(4)),BinaryOp("+",IntLiteral(3),IntLiteral(4))))))))
    assert(checkAst(input,expected,228))
  }

  test("a simple empty main int type with parameter list 229") {
    val input = "int[] test() {}"
    val expected = Program(List(FuncDecl(Id("a"),List(VarDecl(Id("a"),IntType)),IntType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",BinaryOp("+",CallExpr(Id("func"),List(Id("u"),Id("v"))),IntLiteral(4)),BinaryOp("+",IntLiteral(3),IntLiteral(4))))))))
    assert(checkAst(input,expected,229))
  }




  /**
    * Test casse nộp
    */
  //  test("a simple program has a simple call putIntLn") {
//    val input = "void main () {putIntLn(5);}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List(CallExpr(Id("putIntLn"),List(IntLiteral(5))))))))
//    assert(checkAst(input,expected,215))
//  }
//
//  test("a simple test variable decl") {
//    val input = "int a;int a,b[5],f;"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List(CallExpr(Id("putIntLn"),List(IntLiteral(5))))))))
//
//    assert(checkAst(input,expected,216))
//  }
//
//  test("a simple complext variable decl") {
//    val input = "int a;int a,b[5],f;"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List(CallExpr(Id("putIntLn"),List(IntLiteral(5))))))))
//    assert(checkAst(input,expected,217))
//  }
//
//  test("a int function") {
//    val input = "int a(int a, int b[4]) {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,218))
//  }
//
//  test("a float function") {
//    val input = "int a(int a, int b[4]) {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,219))
//  }
//
//  test("a bool function") {
//    val input = "int a(int a, int b[4]) {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,220))
//  }
//
//  test("a string function") {
//    val input = "string a(int a, int b[4]) {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,221))
//  }
//
//  test("a simple string function") {
//    val input = "string a() {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,222))
//  }
//
//  test("a simple int function") {
//    val input = "int a() {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,223))
//  }
//
//  test("a simple bool function") {
//    val input = "boolean a() {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,224))
//  }
//
//  test("a simple float function") {
//    val input = "boolean a() {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,225))
//  }
//
//  test("a simple void function") {
//    val input = "void a() {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,226))
//  }
//
//  test("a void function") {
//    val input = "void a(int a, int b[6]) {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,227))
//  }
//
//  test("a array pointer float function") {
//    val input = "float[] a() {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,228))
//  }
//
//  test("a array pointer int function") {
//    val input = "int[] a() {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,229))
//  }
//
//  test("a array pointer bool function") {
//    val input = "boolean[] a() {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,230))
//  }
//
//  test("a array pointer string function") {
//    val input = "string[] a() {}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,231))
//  }
//
//  test("a array pointer string function declare") {
//    val input = "string[] a() {int a,v[3];int b}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,232))
//  }
//
//  test("a int function with break statement") {
//    val input = "int a() {break;}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,233))
//  }
//
//  test("a int function with continue statement") {
//    val input = "int a() {continue;}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,234))
//  }
//
//  test("a int function with no else if statement") {
//    val input = "int a() {if(true==true) d = d+5;}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,235))
//  }
//
//  test("a int function with if else statement") {
//    val input = "int a() {if(true==true) d = d+5; else d = d-5;}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,236))
//  }
//
//  test("a int function with if nested else statement") {
//    val input = "int a() {if(true==true) d = d+5; else if(false==true) d = d-5; else d=d-1;}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,237))
//  }
//
//  test("a int function with call function expr statement") {
//    val input = "int a() {b();}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,238))
//  }
//
//  test("a int function with complex statement") {
//    val input = "int a() {v=b();if(v==true) g=g+2; else g=g-3;}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,239))
//  }
//
//  test("a multi function") {
//    val input = "int a(){} int main(){}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,240))
//  }
//
//  test("a multi function and declare") {
//    val input = "int a; float b[5];int a(){} int main(){}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,241))
//  }

//  test("a function call") {
//    val input = "int a(){func(a,b);}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,242))
//  }
//
//  test("a function call assignment") {
//    val input = "int a(){v=func(a,b)+7;}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,243))
//  }
//
//  test("a function call if statement") {
//    val input = "int a(){if(i>0) func(t,u);}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,244))
//  }
//
//  test("a assignment array") {
//    val input = "int a(){a[6] = func(b,c);}"
//    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
//    assert(checkAst(input,expected,245))
//  }




}
