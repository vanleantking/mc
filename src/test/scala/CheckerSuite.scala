//import org.scalatest.FunSuite
//import mc.checker._
//import mc.utils._
//
///**
//  * Created by nhphung on 4/29/17.
//  */
//class CheckerSuite extends FunSuite with TestChecker {
//  test("not error 401") {
//    val input = "void main() {int a;}"
//    val expected = ""
//    assert(checkCkr(input,expected,401))
//  }
//
//  test("not error 402") {
//    val input = "void main() {int a; int b;}"
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
//    val input = "void main() {int a; int a}"
//    val expected = "Redeclared Variable: a"
//    assert(checkCkr(input,expected,405))
//  }
//
//  test("Redeclare variable 406") {
//    val input = "int a; void main(){} int a;"
//    val expected = "Redeclared Variable: a"
//    assert(checkCkr(input,expected,406))
//  }
//
//  test("Redeclare variable 407") {
//    val input = "int a, a;void main() {}"
//    val expected = "Redeclared Variable: a"
//    assert(checkCkr(input,expected,407))
//  }
//
//  test("Redeclare variable 408") {
//    val input = "int a, b; void r(){} void r(int a){} void main() {}"
//    val expected = "Redeclared Function: r"
//    assert(checkCkr(input,expected,408))
//  }
//
//  test("Redeclare variable 409") {
//    val input = "void main() {} int a, b; void r(){} void v(int a){}"
//    val expected = ""
//    assert(checkCkr(input,expected,409))
//  }
//
//  test("Redeclare variable 410") {
//    val input = "void main() {} int a, b; void r(int a){} void v(int a){}"
//    val expected = ""
//    assert(checkCkr(input,expected,410))
//  }
//
//  test("Redeclare variable 411") {
//    val input = "void main() {} int a, b; void r(int a, int b){} void v(int a){}"
//    val expected = ""
//    assert(checkCkr(input,expected,411))
//  }
//
//  test("Redeclare variable 412") {
//    val input = "void main() {} int a, b; void r(int a, int a){} void v(int a){}"
//    val expected = "Redeclared Parameter: a"
//    assert(checkCkr(input,expected,412))
//  }
//
//  test("Redeclare variable 413") {
//    val input = "void main() {} int a, b; void r(int a, int b){int n;} void v(int a){}"
//    val expected = ""
//    assert(checkCkr(input,expected,413))
//  }
//
//  test("Redeclare variable 414") {
//    val input = "void main() {} int a, b; void r(int a, int a){int f;} void v(int a){}"
//    val expected = "Redeclared Parameter: a"
//    assert(checkCkr(input,expected,414))
//  }
//
//  test("Redeclare variable 415") {
//    val input = "void main() {} int a, b; void r(int a, int b){float c;} int b;"
//    val expected = "Redeclared Variable: b"
//    assert(checkCkr(input,expected,415))
//  }
//
//  test("Not error 416") {
//    val input = "int a, b; void r(int a, int b){float c;} int c; void main(){int a;}"
//    val expected = ""
//    assert(checkCkr(input,expected,416))
//  }
//
//  test("Redeclare variable 417") {
//    val input = "void main() {} int a, b; void r(int a, int b){float c[3]; c=a+b; c[2] = a/b+b;} int d;"
//    val expected = "Type Mismatch In Expression: BinaryOp(=,Id(c),BinaryOp(+,Id(a),Id(b)))"
//    assert(checkCkr(input, expected, 417))
//  }
//
//
//
//
//  test("Redeclare variable 418") {
//    val input = "void main() {} int a, b; void a(){int c;}"
//    val expected = "Redeclared Function: a"
//    assert(checkCkr(input,expected,418))
//  }
//
//  test("Redeclare variable 419") {
//    val input = "void main() {} void a(){int c;} int a, b; "
//    val expected = "Redeclared Variable: a"
//    assert(checkCkr(input,expected,419))
//  }
//
//  test("Redeclare variable 420") {
//    val input = "void main() {} void a(int v){int c;} int d, b; "
//    val expected = ""
//    assert(checkCkr(input,expected,420))
//  }
//
//  test("Redeclare variable 421") {
//    val input = "void main() {} void a(int v){int c;e=a+b;} int d, b; "
//    val expected = "Undeclared Identifier: e"
//    assert(checkCkr(input, expected, 421))
//  }
//
//
//  test("Redeclare variable 422") {
//    val input = "void main() {} void a(int v){int c;func()=a+b;} int d, b; "
//    val expected = "Undeclared Function: func"
//    assert(checkCkr(input,expected,422))
//  }
//
//  test("Redeclare variable 423") {
//    val input = "void main() {} void a(int v){int c;e[3]=a+b;} int d, b; "
//    val expected = "Undeclared Identifier: e"
//    assert(checkCkr(input,expected,423))
//  }
//
//  test("Redeclare variable 424") {
//    val input = "void main() {} void a(int v){int c;e(3,c)[3]=a+b;} int d, b; "
//    val expected = "Undeclared Function: e"
//    assert(checkCkr(input, expected, 424))
//  }
//
//  test("Redeclare variable 425") {
//    val input = "void main() {} void a(int v){int c;e(3,c)[3]=a+b;} int d, b; int[] e(){} "
//    val expected = "Type Mismatch In Expression: CallExpr(Id(e),List(IntLiteral(3),Id(c)))"
//    assert(checkCkr(input, expected, 425))
//  }
//
//  test("Redeclare variable 426") {
//    val input = "void main() {} void a(int v){int c;e(3,c)[3]=a+b;} int d, b; int[] e(boolean r, int c){} "
//    val expected = "Type Mismatch In Expression: CallExpr(Id(e),List(IntLiteral(3),Id(c)))"
//    assert(checkCkr(input, expected, 426))
//  }
//
//  test("Redeclare variable 427") {
//    val input = "void main() {} void a(int v){int c;e(3,c)[3]=a+b;} int d, b; int[] e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: CallExpr(Id(e),List(IntLiteral(3),Id(c)))"
//    assert(checkCkr(input, expected, 427))
//  }
//
//  test("Redeclare variable 428") {
//    val input = "void main() {} void a(int v){int c;e(true,c)[3]=a+b;} int d, b; int[] e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: CallExpr(Id(e),List(BooleanLiteral(true),Id(c)))"
//    assert(checkCkr(input, expected, 428))
//  }
//
//  test("Redeclare variable 429") {
//    val input = "void main() {} void a(int v){int c;e(\"buzz\",c)[3]=a+b; func(3) = g+c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Undeclared Identifier: a"
//    assert(checkCkr(input, expected, 429))
//  }
//
//  test("Redeclare variable 430") {
//    val input = "void main() {} void a(int v){int c;e(\"buzz\",c)[3]=v+b; func(3) = g+c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Undeclared Function: func"
//    assert(checkCkr(input, expected, 430))
//  }
//
//  test("Redeclare variable 431") {
//    val input = "void main() {} void a(int v){int c;c = v+!c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: UnaryOp(!,Id(c))"
//    assert(checkCkr(input, expected, 431))
//  }
//
//  test("Redeclare variable 432") {
//    val input = "void main() {} void a(int v){float c;c = v+!c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: UnaryOp(!,Id(c))"
//    assert(checkCkr(input, expected, 432))
//  }
//
//  test("Redeclare variable 433") {
//    val input = "void main() {} void a(int v){string c;c = v+!c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: UnaryOp(!,Id(c))"
//    assert(checkCkr(input, expected, 433))
//  }
//
//  test("Redeclare variable 434") {
//    val input = "void main() {} void a(int v){boolean c;c = v+!c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: BinaryOp(+,Id(v),UnaryOp(!,Id(c)))"
//    assert(checkCkr(input, expected, 434))
//  }
//
//  test("Redeclare variable 435") {
//    val input = "void main() {} void a(boolean v){boolean c;c = v+!c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: BinaryOp(+,Id(v),UnaryOp(!,Id(c)))"
//    assert(checkCkr(input, expected, 435))
//  }
//
//  test("Redeclare variable 436") {
//    val input = "void main() {} void a(boolean v){boolean c;c = v-!c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: BinaryOp(-,Id(v),UnaryOp(!,Id(c)))"
//    assert(checkCkr(input, expected, 436))
//  }
//
//  test("Redeclare variable 437") {
//    val input = "void main() {} void a(boolean v){boolean c;c = v>c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: BinaryOp(>,Id(v),Id(c))"
//    assert(checkCkr(input, expected, 437))
//  }
//
//  test("Redeclare variable 438") {
//    val input = "void main() {} void a(boolean v){boolean c;c = v>=c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: BinaryOp(>=,Id(v),Id(c))"
//    assert(checkCkr(input, expected, 438))
//  }
//
//  test("Redeclare variable 439") {
//    val input = "void main() {} void a(boolean v){boolean c;c = v<c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: BinaryOp(<,Id(v),Id(c))"
//    assert(checkCkr(input, expected, 439))
//  }
//
//  test("Redeclare variable 440") {
//    val input = "void main() {} void a(boolean v){boolean c;c = v<=c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: BinaryOp(<=,Id(v),Id(c))"
//    assert(checkCkr(input, expected, 440))
//  }
//
//  test("Redeclare variable 441") {
//    val input = "void main() {} void a(boolean v){boolean c;c = v||c;} int d, b; int[] e(string g, int c){} "
//    val expected = "Function Not Return: e"
//    assert(checkCkr(input, expected, 441))
//  }
//
//  test("Redeclare variable 442") {
//    val input = "void main() {} void a(boolean v){boolean c;c = v&&c;} int d, b; int e(string g, int c){ return c;} "
//    val expected = ""
//    assert(checkCkr(input, expected, 442))
//  }
//
//  test("Redeclare variable 443") {
//    val input = "void main() {} void a(boolean v){boolean c;c = v&&!c;} int d, b; int e(string g, int c){ return c;} "
//    val expected = ""
//    assert(checkCkr(input, expected, 443))
//  }
//
//  test("Redeclare variable 444") {
//    val input = "void main() {} void a(boolean v){boolean c;int f,i; c = v||c&&(f>i);} int d, b;"
//    val expected = ""
//    assert(checkCkr(input, expected, 444))
//  }
//
//  test("Redeclare variable 445") {
//    val input = "void main() {} void a(boolean v){boolean c;int f,i; c = v||c/(f>i);} int d, b;"
//    val expected = "Type Mismatch In Expression: BinaryOp(/,Id(c),BinaryOp(>,Id(f),Id(i)))"
//    assert(checkCkr(input, expected, 445))
//  }
//
//  test("Redeclare variable 446") {
//    val input = "void main() {} void a(boolean v){boolean c;int f,i; c = v||c+(f>i);} int d, b;"
//    val expected = "Type Mismatch In Expression: BinaryOp(+,Id(c),BinaryOp(>,Id(f),Id(i)))"
//    assert(checkCkr(input, expected, 446))
//  }
//
//  test("Redeclare variable 447") {
//    val input = "void main() {} void a(boolean v){boolean c;int f,i; c = v||c-(f>i);} int d, b;"
//    val expected = "Type Mismatch In Expression: BinaryOp(-,Id(c),BinaryOp(>,Id(f),Id(i)))"
//    assert(checkCkr(input, expected, 447))
//  }
//
//  test("Redeclare variable 448") {
//    val input = "void main() {} void a(boolean v){boolean c;int f,i; c = v||c*(f>i);} int d, b;"
//    val expected = "Type Mismatch In Expression: BinaryOp(*,Id(c),BinaryOp(>,Id(f),Id(i)))"
//    assert(checkCkr(input, expected, 448))
//  }
//
//  test("Redeclare variable 449") {
//    val input = "void main() {} void a(boolean v){boolean c;int f,i; c = v||c&&(f>i);} int d, b;"
//    val expected = ""
//    assert(checkCkr(input, expected, 449))
//  }
//
//  test("Redeclare variable 450") {
//    val input = "void main() {} void a(boolean v){boolean c;int f,i; c = v||c&&!(f>i);} int d, b;"
//    val expected = ""
//    assert(checkCkr(input, expected, 450))
//  }
//
//  test("Redeclare variable 451") {
//    val input = "void main() {} void a(boolean v){boolean c;int f,i; c = v||c&&!e(\"buzz\",d)[2];} int d, b; string[] e(string g, int c){return g} "
//    val expected = "Type Mismatch In Expression: UnaryOp(!,ArrayCell(CallExpr(Id(e),List(StringLiteral(buzz),Id(d))),IntLiteral(2)))"
//    assert(checkCkr(input, expected, 451))
//  }
//
//  test("Redeclare variable 452") {
//    val input = "void main() {} void a(boolean v){boolean c;int f,i; c = v||c&&!e(\"buzz\",d)[2];} int d, b;float e(string g, float c){return c} "
//    val expected = "Type Mismatch In Expression: CallExpr(Id(e),List(StringLiteral(buzz),Id(d)))"
//    assert(checkCkr(input, expected, 452))
//  }
//
//  test("Redeclare variable 453") {
//    val input = "void main() {} void a(boolean v){boolean c;int f,i; c = v||c&&!e(\"buzz\",d)[2];} int d, b; string e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: ArrayCell(CallExpr(Id(e),List(StringLiteral(buzz),Id(d))),IntLiteral(2))"
//    assert(checkCkr(input, expected, 453))
//  }
//
//  test("Redeclare variable 454") {
//    val input = "void main() {} void a(boolean v){boolean c;int f,i; c = v||c&&!e(\"buzz\",d)[2];} int d, b; boolean e(string g, int c){ return true;} "
//    val expected = "Type Mismatch In Expression: ArrayCell(CallExpr(Id(e),List(StringLiteral(buzz),Id(d))),IntLiteral(2))"
//    assert(checkCkr(input, expected, 454))
//  }
//
//  test("Redeclare variable 455") {
//    val input = "void main() {} void a(boolean v){boolean c;int f,i; c = v||c&&!(f%i==0);} int d, b; boolean[] e(string g, int c){return true;} "
//    val expected = ""
//    assert(checkCkr(input, expected, 455))
//  }
//
//  test("Redeclare variable 456") {
//    val input = "void main() {} void a(boolean v){boolean c;int f; float i; c = v||c&&!(f%i==0);} int d, b; boolean[] e(string g, int c){return true;} "
//    val expected = "Type Mismatch In Expression: BinaryOp(%,Id(f),Id(i))"
//    assert(checkCkr(input, expected, 456))
//  }
//
//  test("Redeclare variable 457") {
//    val input = "void main() {} void a(boolean v){boolean c;int f; float i; e(\"buzz\", f) = v;} int d, b; void e(string g, int c){} "
//    val expected = "Type Mismatch In Expression: BinaryOp(=,CallExpr(Id(e),List(StringLiteral(buzz),Id(f))),Id(v))"
//    assert(checkCkr(input, expected, 457))
//  }
////////
////////  test("Redeclare variable 427") {
////////    val input = "void a(int v){int c;v(g)[b]=d+b;} int d, b; int v(){} "
////////    val expected = "Redeclared Variable: a"
////////    assert(checkCkr(input,expected,427))
////////  }
//////
////////  test("Redeclare variable 428") {
////////    val input = "int a, b; void r(int a, int b){float c[3]; c[3]=a+b; c[2] = a/b+b;} int d;"
////////    val expected = ""
////////    assert(checkCkr(input,expected,428))
////////  }
//////
////////  test("Redeclare variable 428") {
////////    val input = "int foo() {goo(foo());} int goo(int b) {goo(goo(4,2));}"
////////    val expected = "Redeclared Variable: a"
////////    assert(checkCkr(input,expected,428))
////////  }
//
//  test("Undeclared Function") {
//    val input = "void main () {writeIntLn(3);}"
//    val expected = "Undeclared Function: writeIntLn"
//    assert(checkCkr(input,expected,458))
//  }
//  test("Type Mismatch In Expression: getInt") {
//    val input = "void main () {getInt(3);}"
//    val expected = "Type Mismatch In Expression: "+CallExpr(Id("getInt"),List(IntLiteral(3))).toString
//    assert(checkCkr(input,expected,459))
//  }
//  test("Type Mismatch In Expression: putIntLn") {
//
//    val input = "void main () {putIntLn();}"
//    val expected = "Type Mismatch In Expression: "+CallExpr(Id("putIntLn"),List()).toString
//    assert(checkCkr(input,expected,460))
//  }
//  test("Check with AST") {
//
//    val input = Program(List(
//      FuncDecl(Id("main"),List(),VoidType,
//        Block(List(),
//          List(CallExpr(Id("putIntLn"),List()))))))
//    val expected = "Type Mismatch In Expression: "+CallExpr(Id("putIntLn"),List()).toString
//    assert(checkAst(input,expected,461))
//  }
//  test("Check with AST putIntLn with float") {
//
//    val input = Program(List(
//      FuncDecl(Id("main"),List(),VoidType,
//        Block(List(),
//          List(CallExpr(Id("putIntLn"),List(FloatLiteral(1.2f))))))))
//    val expected = "Type Mismatch In Expression: "+CallExpr(Id("putIntLn"),List(FloatLiteral(1.2f))).toString
//    assert(checkAst(input,expected,462))
//
//  }
//  test("Type Mismatch In Expression: putIntLn 463") {
//    val input = "void main () {int a;if(true==true) v=v+4;}"
//    val expected = "Undeclared Identifier: v"
//    assert(checkCkr(input,expected,463))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 464") {
//    val input = "void main () {int a;if(true==true) {v=v+4;}}"
//    val expected = "Undeclared Identifier: v"
//    assert(checkCkr(input,expected,464))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 465") {
//    val input = "void main () {int a;if(true==true) {int v;v=v+4;}}"
//    val expected = ""
//    assert(checkCkr(input,expected,465))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 466") {
//    val input = "void main () {int a;if(a+2) {int v;v=v+4;}}"
//    val expected = "Type Mismatch In Statement: If(BinaryOp(+,Id(a),IntLiteral(2)),Block(List(VarDecl(Id(v),IntType)),List(BinaryOp(=,Id(v),BinaryOp(+,Id(v),IntLiteral(4))))),None)"
//    assert(checkCkr(input,expected,466))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 467") {
//    val input = "void main () {int a;if(a-5>3) {int v;v=a+4;}}"
//    val expected = ""
//    assert(checkCkr(input,expected,467))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 468") {
//    val input = "void main () {int a;if(a>3) {int v;a=v+4;}}"
//    val expected = ""
//    assert(checkCkr(input,expected,468))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 469") {
//    val input = "void main () {int a;if(a-3) {int v;v=v+4;}}"
//    val expected = "Type Mismatch In Statement: If(BinaryOp(-,Id(a),IntLiteral(3)),Block(List(VarDecl(Id(v),IntType)),List(BinaryOp(=,Id(v),BinaryOp(+,Id(v),IntLiteral(4))))),None)"
//    assert(checkCkr(input,expected,469))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 470") {
//    val input = "void main () {int a;if(a) {int v;v=v+4;}}"
//    val expected = "Type Mismatch In Statement: If(Id(a),Block(List(VarDecl(Id(v),IntType)),List(BinaryOp(=,Id(v),BinaryOp(+,Id(v),IntLiteral(4))))),None)"
//    assert(checkCkr(input,expected,470))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 471") {
//    val input = "void main () {boolean a;if(a) {int v;v=v+4;}}"
//    val expected = ""
//    assert(checkCkr(input,expected,471))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 472") {
//    val input = "void main () {boolean a;if(a) {int v;v=v+4;} else v = v-4;}"
//    val expected = "Undeclared Identifier: v"
//    assert(checkCkr(input,expected,472))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 473") {
//    val input = "void main () {boolean a;if(a) {int v;v=v+4;} else a = a-4;}"
//    val expected = "Type Mismatch In Expression: BinaryOp(-,Id(a),IntLiteral(4))"
//    assert(checkCkr(input,expected,473))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 474") {
//    val input = "void main () {boolean a;if(a) {int v;v=v+4;} else {int a; float v; a = a-4; v=a/v-a*v;}}"
//    val expected = ""
//    assert(checkCkr(input,expected,474))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 475") {
//    val input = "void main () {boolean a;if(a) {int v;v=v+4;} else {int a; float v; a = m-4; v=a/v-a*v;}}"
//    val expected = "Undeclared Identifier: m"
//    assert(checkCkr(input,expected,475))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 476") {
//    val input = "int m;void main () {boolean a;if(a) {int v;v=v+4;} else {int a; float v; a = m-4; v=a/v-a*v;}}"
//    val expected = ""
//    assert(checkCkr(input,expected,476))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 477") {
//    val input = "int g(int b){return b;} int m;void main () {boolean a;if(a) {int v;v=v+4;} else if(m>3) {int h;m=m-5;} else m=m*2+g(m);}"
//    val expected = ""
//    assert(checkCkr(input,expected,477))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 478") {
//    val input = "int g(int b){return b;} int m;void main () {boolean a;if(a) {int v;v=v+4;} else if(m>3) {int h;m=m-5;} else m=m*2+g(a);}"
//    val expected = "Type Mismatch In Expression: CallExpr(Id(g),List(Id(a)))"
//    assert(checkCkr(input,expected,478))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 479") {
//    val input = "int main(int b){ return b;}"
//    val expected = ""
//    assert(checkCkr(input,expected,479))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 480") {
//    val input = "int main(int b){ b=b+2;}"
//    val expected = "Function Not Return: main"
//    assert(checkCkr(input,expected,480))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 481") {
//    val input = "int main(boolean b){return b;}"
//    val expected = "Type Mismatch In Statement: Return(Some(Id(b)))"
//    assert(checkCkr(input,expected,481))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 482") {
//    val input = "void main(boolean b){return b;}"
//    val expected = "Type Mismatch In Statement: Return(Some(Id(b)))"
//    assert(checkCkr(input,expected,482))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 483") {
//    val input = "int main(boolean b){return a(b);} int a(boolean b){}"
//    val expected = "Function Not Return: a"
//    assert(checkCkr(input,expected,483))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 484") {
//    val input = "int main(boolean b){return a(b);} boolean a(boolean b){}"
//    val expected = "Type Mismatch In Statement: Return(Some(CallExpr(Id(a),List(Id(b)))))"
//    assert(checkCkr(input,expected,484))
//  }
//
//  test("Type Mismatch In Expression: putIntLn 485") {
//    val input = "int main(boolean b){return a(b);} int a(boolean b){return 3;}"
//    val expected = ""
//    assert(checkCkr(input,expected,485))
//  }
//
//  test("a for 486") {
//    val input =
//      """
//            void main()
//            {
//            do
//               {
//                  break;
//               } while (true);
//
//            }
//          """.stripMargin
//    val expected = ""
//    assert(checkCkr(input,expected,486))
//  }
//
//  test("a for 487") {
//    val input =
//      """
//            void main()
//            {
//            do
//               {
//                  if(true) false;
//                  break;
//               }{} while (true);
//
//            }
//          """.stripMargin
//    val expected = ""
//    assert(checkCkr(input,expected,487))
//  }
//
//  test("a for 488") {
//    val input ="void main(int a, float b) {int i;for(i;i<5;i=i+1) break; }"
//    val expected = ""
//    assert(checkCkr(input,expected,488))
//  }
//
//  test("a for 489") {
//    val input ="void main(int a, float b) {int i;for(i;i<5;i=i+1) {if(i==3) break;} }"
//    val expected = ""
//    assert(checkCkr(input,expected,489))
//  }
//
//  test("a for 490") {
//    val input ="void main(int a, float b) {int i;for(i;i<5;i=i+1) continue; }"
//    val expected = ""
//    assert(checkCkr(input,expected,490))
//  }
//
//  test("a for 491") {
//    val input ="void main(int a, float b) {int i;for(i;i<5;i=i+1) {if(i==3) continue;} }"
//    val expected = ""
//    assert(checkCkr(input,expected,491))
//  }
//
//  test("a for 492") {
//    val input ="int foo() {goo(foo(),2.1+4/4-2.0);} int goo(int b,float c) {goo(goo(4,2.0),4+2/2-2);}"
//    val expected = "No Entry Point"
//    assert(checkCkr(input,expected,492))
//  }
//
//  test("a for 493") {
//    val input ="int main() {goo(foo(),2.1+4/4-2.0);} int goo(int b,float c) {goo(goo(4,2.0),4+2/2-2);}"
//    val expected = "Function Not Return: main"
//    assert(checkCkr(input,expected,493))
//  }
//
//  test("a for 494") {
//    val input ="void main() {goo(foo(),2*4/4*2.0);} int goo(int b,float c) {goo(goo(4,2.0),4*2/2*2);}"
//    val expected = "Undeclared Function: foo"
//    assert(checkCkr(input,expected,494))
//  }
//
//  test("xxx") {
//    val input = """
//    void main(){
//     int a,b;
//     a = b;
//    }
//    void f(int c[]){
//     return true;
//    } """
//    val expected ="Type Mismatch In Statement: Return(Some(BooleanLiteral(true)))"
//    assert(checkCkr(input, expected, 495))
//  }
//
//    test("a simple test variable decl 496") {
//      val input = "int a;void main() {int v,f,y; boolean u;u=(v+3)>=(y-3)&&!(f>a);f=f/4+5/6*3--2*(a+3);}"
//      val expected = ""
//
//      assert(checkCkr(input, expected, 496))
//    }
//    test("a assignment array 497") {
//      val input = "void main(){int a[7],b,c;float f; a[6] = func(b,c);f=1.1e-2;int t; t=\"this\'s a string\";}"
//      val expected = "Undeclared Function: func"
//      assert(checkCkr(input, expected, 497))
//    }
//
//    test("a assignment array 498") {
//      val input = "void main(){int a[5], b[6]; boolean c, f[4],r; c = f&&r||!r==f;}"
//      val expected = "Type Mismatch In Expression: BinaryOp(&&,Id(f),Id(r))"
//      assert(checkCkr(input, expected, 498))
//    }
//
//    test("a assignment array 499") {
//      val input = "int a,b,c,t; int function(int a, int u){return a;} void main(){a=b=c=function(t,u);}"
//      val expected = "Undeclared Identifier: u"
//      assert(checkCkr(input, expected, 499))
//    }
//
//    test("a assignment array 500") {
//      val input = "void function(int i, int j){} void main(){int i,j; for(i=0;i<=5;i=i+1) {for(j=i;j<5;j=j+1) function(i,j);}}"
//      val expected = ""
//      assert(checkCkr(input, expected, 500))
//    }
//
//  test("a assignment array 501") {
//    val input = "int main(int a, int u){int b; return a;a=b+u;if(b>0) b=0;}"
//    val expected = "Unreachable Statement: BinaryOp(=,Id(a),BinaryOp(+,Id(b),Id(u)))"
//    assert(checkCkr(input, expected, 501))
//  }
//
//  test("a assignment array 502") {
//    val input = "int main(int a, int u){int b; a=b+u;if(b>0) b=0; return a;}"
//    val expected = ""
//    assert(checkCkr(input, expected, 502))
//  }
//
//  test("a assignment array 503") {
//    val input = "int main(int a, int u){int b; a=b+u;if(b>0) b=0; return a;} void foo(){}"
//    val expected = ""
//    assert(checkCkr(input, expected, 503))
//  }
//
//  test("zzzzzzzzzz") {
//    val input = """
//   void main(){}
//    void foo (float a[]);
//   void goo (float x[]){
//     float y[10];
//     int z[10];
//     foo(x);
//     foo(z);
//   }"""
//    val expected = """Type Mismatch In Expression: CallExpr(Id("foo"),List(Id("z")))"""
//    assert(checkCkr(input, expected, 555))
//  }
//
//
//}