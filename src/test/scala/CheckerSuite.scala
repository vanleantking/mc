import org.scalatest.FunSuite
import mc.checker._
import mc.utils._

/**
  * Created by nhphung on 4/29/17.
  */
class CheckerSuite extends FunSuite with TestChecker {
  test("not error 401") {
    val input = "int a;"
    val expected = ""
    assert(checkCkr(input,expected,401))
  }

  test("not error 402") {
    val input = "int a; int b;"
    val expected = ""
    assert(checkCkr(input,expected,402))
  }

  test("not error 403") {
    val input = "int a; int b; void main(){}"
    val expected = ""
    assert(checkCkr(input,expected,403))
  }

  test("not error 404") {
    val input = "int a; int b; void main(){} void r(){}"
    val expected = ""
    assert(checkCkr(input,expected,404))
  }

  test("Redeclare variable 405") {
    val input = "int a; int a;"
    val expected = "Redeclared Variable: a"
    assert(checkCkr(input,expected,405))
  }

  test("Redeclare variable 406") {
    val input = "int a; void main(){} int a;"
    val expected = "Redeclared Variable: a"
    assert(checkCkr(input,expected,406))
  }

  test("Redeclare variable 407") {
    val input = "int a, a;"
    val expected = "Redeclared Variable: a"
    assert(checkCkr(input,expected,407))
  }

  test("Redeclare variable 408") {
    val input = "int a, b; void r(){} void r(int a){}"
    val expected = "Redeclared Function: r"
    assert(checkCkr(input,expected,408))
  }

  test("Redeclare variable 409") {
    val input = "int a, b; void r(){} void v(int a){}"
    val expected = ""
    assert(checkCkr(input,expected,409))
  }

  test("Redeclare variable 410") {
    val input = "int a, b; void r(int a){} void v(int a){}"
    val expected = ""
    assert(checkCkr(input,expected,410))
  }

  test("Redeclare variable 411") {
    val input = "int a, b; void r(int a, int b){} void v(int a){}"
    val expected = ""
    assert(checkCkr(input,expected,411))
  }

  test("Redeclare variable 412") {
    val input = "int a, b; void r(int a, int a){} void v(int a){}"
    val expected = "Redeclared Parameter: a"
    assert(checkCkr(input,expected,412))
  }

  test("Redeclare variable 413") {
    val input = "int a, b; void r(int a, int b){int n;} void v(int a){}"
    val expected = ""
    assert(checkCkr(input,expected,413))
  }

  test("Redeclare variable 414") {
    val input = "int a, b; void r(int a, int a){int f;} void v(int a){}"
    val expected = "Redeclared Parameter: a"
    assert(checkCkr(input,expected,414))
  }

  test("Redeclare variable 415") {
    val input = "int a, b; void r(int a, int b){float c;} int b;"
    val expected = "Redeclared Variable: b"
    assert(checkCkr(input,expected,415))
  }

  test("Not error 416") {
    val input = "int a, b; void r(int a, int b){float c;} int c; void main(){int a;}"
    val expected = ""
    assert(checkCkr(input,expected,416))
  }

  test("Redeclare variable 417") {
    val input = "int a, b; void r(int a, int b){float c[3]; c=a+b; c[2] = a/b+b;} int d;"
    val expected = "Type Mismatch In Expression: BinaryOp(=,Id(c),BinaryOp(+,Id(a),Id(b)))"
    assert(checkCkr(input, expected, 417))
  }




  test("Redeclare variable 418") {
    val input = "int a, b; void a(){int c;}"
    val expected = "Redeclared Function: a"
    assert(checkCkr(input,expected,418))
  }

  test("Redeclare variable 419") {
    val input = "void a(){int c;} int a, b; "
    val expected = "Redeclared Variable: a"
    assert(checkCkr(input,expected,419))
  }

  test("Redeclare variable 420") {
    val input = "void a(int v){int c;} int d, b; "
    val expected = ""
    assert(checkCkr(input,expected,420))
  }

  test("Redeclare variable 421") {
    val input = "void a(int v){int c;e=a+b;} int d, b; "
    val expected = "Undeclared Identifier: e"
    assert(checkCkr(input, expected, 421))
  }


  test("Redeclare variable 422") {
    val input = "void a(int v){int c;func()=a+b;} int d, b; "
    val expected = "Undeclared Function: func"
    assert(checkCkr(input,expected,422))
  }

  test("Redeclare variable 423") {
    val input = "void a(int v){int c;e[3]=a+b;} int d, b; "
    val expected = "Undeclared Identifier: e"
    assert(checkCkr(input,expected,423))
  }

  test("Redeclare variable 424") {
    val input = "void a(int v){int c;e(3,c)[3]=a+b;} int d, b; "
    val expected = "Undeclared Function: e"
    assert(checkCkr(input, expected, 424))
  }

  test("Redeclare variable 425") {
    val input = "void a(int v){int c;e(3,c)[3]=a+b;} int d, b; int[] e(){} "
    val expected = "Type Mismatch In Expression: CallExpr(Id(e),List(IntLiteral(3),Id(c)))"
    assert(checkCkr(input, expected, 425))
  }

  test("Redeclare variable 426") {
    val input = "void a(int v){int c;e(3,c)[3]=a+b;} int d, b; int[] e(boolean r, int c){} "
    val expected = "Type Mismatch In Expression: CallExpr(Id(e),List(IntLiteral(3),Id(c)))"
    assert(checkCkr(input, expected, 426))
  }

  test("Redeclare variable 427") {
    val input = "void a(int v){int c;e(3,c)[3]=a+b;} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: CallExpr(Id(e),List(IntLiteral(3),Id(c)))"
    assert(checkCkr(input, expected, 427))
  }

  test("Redeclare variable 428") {
    val input = "void a(int v){int c;e(true,c)[3]=a+b;} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: CallExpr(Id(e),List(BooleanLiteral(true),Id(c)))"
    assert(checkCkr(input, expected, 428))
  }

  test("Redeclare variable 429") {
    val input = "void a(int v){int c;e(\"buzz\",c)[3]=a+b; func(3) = g+c;} int d, b; int[] e(string g, int c){} "
    val expected = "Undeclared Identifier: a"
    assert(checkCkr(input, expected, 429))
  }

  test("Redeclare variable 430") {
    val input = "void a(int v){int c;e(\"buzz\",c)[3]=v+b; func(3) = g+c;} int d, b; int[] e(string g, int c){} "
    val expected = "Undeclared Function: func"
    assert(checkCkr(input, expected, 430))
  }

  test("Redeclare variable 431") {
    val input = "void a(int v){int c;c = v+!c;} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: UnaryOp(!,Id(c))"
    assert(checkCkr(input, expected, 431))
  }

  test("Redeclare variable 432") {
    val input = "void a(int v){float c;c = v+!c;} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: UnaryOp(!,Id(c))"
    assert(checkCkr(input, expected, 432))
  }

  test("Redeclare variable 433") {
    val input = "void a(int v){string c;c = v+!c;} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: UnaryOp(!,Id(c))"
    assert(checkCkr(input, expected, 433))
  }

  test("Redeclare variable 434") {
    val input = "void a(int v){boolean c;c = v+!c;} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: BinaryOp(+,Id(v),UnaryOp(!,Id(c)))"
    assert(checkCkr(input, expected, 434))
  }

  test("Redeclare variable 435") {
    val input = "void a(boolean v){boolean c;c = v+!c;} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: BinaryOp(+,Id(v),UnaryOp(!,Id(c)))"
    assert(checkCkr(input, expected, 435))
  }

  test("Redeclare variable 436") {
    val input = "void a(boolean v){boolean c;c = v-!c;} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: BinaryOp(-,Id(v),UnaryOp(!,Id(c)))"
    assert(checkCkr(input, expected, 436))
  }

  test("Redeclare variable 437") {
    val input = "void a(boolean v){boolean c;c = v>c;} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: BinaryOp(>,Id(v),Id(c))"
    assert(checkCkr(input, expected, 437))
  }

  test("Redeclare variable 438") {
    val input = "void a(boolean v){boolean c;c = v>=c;} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: BinaryOp(>=,Id(v),Id(c))"
    assert(checkCkr(input, expected, 438))
  }

  test("Redeclare variable 439") {
    val input = "void a(boolean v){boolean c;c = v<c;} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: BinaryOp(<,Id(v),Id(c))"
    assert(checkCkr(input, expected, 439))
  }

  test("Redeclare variable 440") {
    val input = "void a(boolean v){boolean c;c = v<=c;} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: BinaryOp(<=,Id(v),Id(c))"
    assert(checkCkr(input, expected, 440))
  }

  test("Redeclare variable 441") {
    val input = "void a(boolean v){boolean c;c = v||c;} int d, b; int[] e(string g, int c){} "
    val expected = ""
    assert(checkCkr(input, expected, 441))
  }

  test("Redeclare variable 442") {
    val input = "void a(boolean v){boolean c;c = v&&c;} int d, b; int[] e(string g, int c){} "
    val expected = ""
    assert(checkCkr(input, expected, 442))
  }

  test("Redeclare variable 443") {
    val input = "void a(boolean v){boolean c;c = v&&!c;} int d, b; int[] e(string g, int c){} "
    val expected = ""
    assert(checkCkr(input, expected, 443))
  }

  test("Redeclare variable 444") {
    val input = "void a(boolean v){boolean c;int f,i; c = v||c&&(f>i);} int d, b; int[] e(string g, int c){} "
    val expected = ""
    assert(checkCkr(input, expected, 444))
  }

  test("Redeclare variable 445") {
    val input = "void a(boolean v){boolean c;int f,i; c = v||c/(f>i);} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: BinaryOp(/,Id(c),BinaryOp(>,Id(f),Id(i)))"
    assert(checkCkr(input, expected, 445))
  }

  test("Redeclare variable 446") {
    val input = "void a(boolean v){boolean c;int f,i; c = v||c+(f>i);} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: BinaryOp(+,Id(c),BinaryOp(>,Id(f),Id(i)))"
    assert(checkCkr(input, expected, 446))
  }

  test("Redeclare variable 447") {
    val input = "void a(boolean v){boolean c;int f,i; c = v||c-(f>i);} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: BinaryOp(-,Id(c),BinaryOp(>,Id(f),Id(i)))"
    assert(checkCkr(input, expected, 447))
  }

  test("Redeclare variable 448") {
    val input = "void a(boolean v){boolean c;int f,i; c = v||c*(f>i);} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: BinaryOp(*,Id(c),BinaryOp(>,Id(f),Id(i)))"
    assert(checkCkr(input, expected, 448))
  }

  test("Redeclare variable 449") {
    val input = "void a(boolean v){boolean c;int f,i; c = v||c&&(f>i);} int d, b; int[] e(string g, int c){} "
    val expected = ""
    assert(checkCkr(input, expected, 449))
  }

  test("Redeclare variable 450") {
    val input = "void a(boolean v){boolean c;int f,i; c = v||c&&!(f>i);} int d, b; int[] e(string g, int c){} "
    val expected = ""
    assert(checkCkr(input, expected, 450))
  }

  test("Redeclare variable 451") {
    val input = "void a(boolean v){boolean c;int f,i; c = v||c&&!e(\"buzz\",d)[2];} int d, b; int[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: UnaryOp(!,ArrayCell(CallExpr(Id(e),List(StringLiteral(buzz),Id(d))),IntLiteral(2)))"
    assert(checkCkr(input, expected, 451))
  }

  test("Redeclare variable 452") {
    val input = "void a(boolean v){boolean c;int f,i; c = v||c&&!e(\"buzz\",d)[2];} int d, b; float[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: UnaryOp(!,ArrayCell(CallExpr(Id(e),List(StringLiteral(buzz),Id(d))),IntLiteral(2)))"
    assert(checkCkr(input, expected, 452))
  }

  test("Redeclare variable 453") {
    val input = "void a(boolean v){boolean c;int f,i; c = v||c&&!e(\"buzz\",d)[2];} int d, b; string[] e(string g, int c){} "
    val expected = "Type Mismatch In Expression: UnaryOp(!,ArrayCell(CallExpr(Id(e),List(StringLiteral(buzz),Id(d))),IntLiteral(2)))"
    assert(checkCkr(input, expected, 453))
  }

  test("Redeclare variable 454") {
    val input = "void a(boolean v){boolean c;int f,i; c = v||c&&!e(\"buzz\",d)[2];} int d, b; boolean[] e(string g, int c){} "
    val expected = ""
    assert(checkCkr(input, expected, 454))
  }
//
//  test("Redeclare variable 425") {
//    val input = "void a(int v){int c;c[3]=d+b;} int d, b; "
//    val expected = "Redeclared Variable: a"
//    assert(checkCkr(input,expected,425))
//  }
//
//  test("Redeclare variable 426") {
//    val input = "void a(int v){int c;v(b)[b]=d+b;} int d, b; int v(){} "
//    val expected = "Redeclared Variable: a"
//    assert(checkCkr(input,expected,426))
//  }
//
//  test("Redeclare variable 427") {
//    val input = "void a(int v){int c;v(g)[b]=d+b;} int d, b; int v(){} "
//    val expected = "Redeclared Variable: a"
//    assert(checkCkr(input,expected,427))
//  }

//  test("Redeclare variable 428") {
//    val input = "int a, b; void r(int a, int b){float c[3]; c[3]=a+b; c[2] = a/b+b;} int d;"
//    val expected = ""
//    assert(checkCkr(input,expected,428))
//  }

//  test("Redeclare variable 428") {
//    val input = "int foo() {goo(foo());} int goo(int b) {goo(goo(4,2));}"
//    val expected = "Redeclared Variable: a"
//    assert(checkCkr(input,expected,428))
//  }
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