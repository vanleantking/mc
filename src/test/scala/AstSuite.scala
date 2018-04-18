import mc.utils.{VarDecl, _}
import org.scalatest.FunSuite

/**
  * Created by nhphung on 4/29/17.
  */
class AstSuite_bk extends FunSuite with TestAst {
  /**
    * Testcases nộp
    */
  test("a variable declare with int type") {
    val input = "int a;"
    val expected = Program(List(VarDecl(Id("a"),IntType)))
    assert(checkAst(input,expected,201))
  }

  test("a variable declare with float type") {
    val input = "float a;"
    val expected = Program(List(VarDecl(Id("a"),FloatType)))
    assert(checkAst(input,expected,202))
  }

  test("a variable declare with bool type") {
    val input = "boolean a;"
    val expected = Program(List(VarDecl(Id("a"),BoolType)))
    assert(checkAst(input,expected,203))
  }

  test("a variable declare with string type") {
    val input = "string f;"
    val expected = Program(List(VarDecl(Id("f"),StringType)))
    assert(checkAst(input,expected,204))
  }

  test("mix variable declare with string type") {
    val input = "string f; int b;"
    val expected = Program(List(VarDecl(Id("f"),StringType),VarDecl(Id("b"),IntType)))
    assert(checkAst(input,expected,205))
  }

  test("a variable declare with array type") {
    val input = "int a[4];int f,g;"
    val expected = Program(List(VarDecl(Id("a"),ArrayType(IntLiteral(4),IntType)),VarDecl(Id("f"),IntType),VarDecl(Id("g"),IntType)))
    assert(checkAst(input,expected,206))
  }

  test("a variable list declare same type with string type") {
    val input = "string a,f, b[3];"
    val expected = Program(List(VarDecl(Id("a"),StringType),VarDecl(Id("f"),StringType),VarDecl(Id("b"),ArrayType(IntLiteral(3),StringType))))
    assert(checkAst(input,expected,207))
  }

  test("a variable list declare same type with int type") {
    val input = "int a,f, b[3];"
    val expected = Program(List(VarDecl(Id("a"),IntType),VarDecl(Id("f"),IntType),VarDecl(Id("b"),ArrayType(IntLiteral(3),IntType))))
    assert(checkAst(input,expected,208))
  }

  test("a variable list declare same type with float type") {
    val input = "float a,f, b[3];"
    val expected = Program(List(VarDecl(Id("a"),FloatType),VarDecl(Id("f"),FloatType),VarDecl(Id("b"),ArrayType(IntLiteral(3),FloatType))))
    assert(checkAst(input,expected,209))
  }

  test("a variable list declare same type with bool type") {
    val input = "boolean a,f, b[3];"
    val expected = Program(List(VarDecl(Id("a"),BoolType),VarDecl(Id("f"),BoolType),VarDecl(Id("b"),ArrayType(IntLiteral(3),BoolType))))
    assert(checkAst(input,expected,210))
  }

  test("a variable list declare diferrent type with bool type") {
    val input = "boolean b[3]; boolean g;"
    val expected = Program(List(VarDecl(Id("b"),ArrayType(IntLiteral(3),BoolType)),VarDecl(Id("g"),BoolType)))
    assert(checkAst(input,expected,211))
  }
  //
  test("a variable list declare diferrent type with int type") {
    val input = "int a[4];int a;"
    val expected = Program(List(VarDecl(Id("a"),ArrayType(IntLiteral(4),IntType)),VarDecl(Id("a"),IntType)))
    assert(checkAst(input,expected,212))
  }

  test("a variable list declare diferrent type with float type") {
    val input = "float a[4];float a;"
    val expected = Program(List(VarDecl(Id("a"),ArrayType(IntLiteral(4),FloatType)),VarDecl(Id("a"),FloatType)))
    assert(checkAst(input,expected,213))
  }

  test("a variable list declare diferrent type with mix type") {
    val input = "string a[4];string a;"
    val expected = Program(List(VarDecl(Id("a"),ArrayType(IntLiteral(4),StringType)),VarDecl(Id("a"),StringType)))
    assert(checkAst(input,expected,214))
  }

  test("a simple empty main int type") {
    val input = "int main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(),List()))))
    assert(checkAst(input,expected,215))
  }

  test("a simple empty main float type") {
    val input = "float main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),FloatType,Block(List(),List()))))
    assert(checkAst(input,expected,216))
  }

  test("a simple empty main boolean type") {
    val input = "boolean main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),BoolType,Block(List(),List()))))
    assert(checkAst(input,expected,217))
  }

  test("a simple empty main string type") {
    val input = "string main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),StringType,Block(List(),List()))))
    assert(checkAst(input,expected,218))
  }

  test("a simple empty main void type") {
    val input = "void main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List()))))
    assert(checkAst(input,expected,219))
  }

  test("a simple empty main int array type") {
    val input = "int[] main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),ArrayPointerType(IntType),Block(List(),List()))))
    assert(checkAst(input,expected,220))
  }

  test("a simple empty main string array type") {
    val input = "string[] main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),ArrayPointerType(StringType),Block(List(),List()))))
    assert(checkAst(input,expected,221))
  }

  test("a simple empty main string float type") {
    val input = "float[] main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),ArrayPointerType(FloatType),Block(List(),List()))))
    assert(checkAst(input,expected,222))
  }

  test("a simple empty main string boolean type") {
    val input = "boolean[] main () {}"
    val expected = Program(List(FuncDecl(Id("main"),List(),ArrayPointerType(BoolType),Block(List(),List()))))
    assert(checkAst(input,expected,223))
  }

  test("a simple empty main string void type with parameter list") {
    val input = "void main (int a, int b) {}"
    val expected = Program(List(FuncDecl(Id("main"),List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),IntType)),VoidType,Block(List(),List()))))
    assert(checkAst(input,expected,224))
  }

  test("a simple empty main void type with parameter list 225") {
    val input = "void main (int a, int b[]) {}"
    val expected = Program(List(FuncDecl(Id("main"),List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),ArrayPointerType(IntType))),VoidType,Block(List(),List()))))
    assert(checkAst(input,expected,225))
  }

  test("a simple empty main int type with parameter list 226") {
    val input = "int[] main (int a, int b[]) {}"
    val expected = Program(List(FuncDecl(Id("main"),List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),ArrayPointerType(IntType))),ArrayPointerType(IntType),Block(List(),List()))))
    assert(checkAst(input,expected,226))
  }

  test("a simple empty main int type with parameter list 227") {
    val input = "boolean[] a(int a, int b[]) { int a; return ;}"
    val expected = Program(List(FuncDecl(Id("a"),List(VarDecl(Id("a"),IntType), VarDecl(Id("b"),ArrayPointerType(IntType))),ArrayPointerType(BoolType),Block(List(VarDecl(Id("a"),IntType)),List(Return(None))))))
    assert(checkAst(input,expected,227))
  }

  test("a simple empty main int type with parameter list 228") {
    val input = "float[] a(int a, int b[]) { int a; return 3;}"
    val expected = Program(List(FuncDecl(Id("a"),List(VarDecl(Id("a"),IntType), VarDecl(Id("b"),ArrayPointerType(IntType))),ArrayPointerType(FloatType),Block(List(VarDecl(Id("a"),IntType)),List(Return(Some(IntLiteral(3))))))))
    assert(checkAst(input,expected,228))
  }

  test("a simple empty main int type with parameter list 229") {
    val input = "string[] a(int a, int b[]) { int a; return f(3)+4;}"
    val expected = Program(List(FuncDecl(Id("a"),List(VarDecl(Id("a"),IntType), VarDecl(Id("b"),ArrayPointerType(IntType))),ArrayPointerType(StringType),Block(List(VarDecl(Id("a"),IntType)),List(Return(Some(BinaryOp("+",CallExpr(Id("f"),List(IntLiteral(3))),IntLiteral(4)))))))))
    assert(checkAst(input,expected,229))
  }

  test("a simple empty main int type with parameter list 230") {
    val input = "int[] a(int a[], boolean b[]) { int a; function[f(4,y) + 5] + 4 = (f(t,u) + 4)*6;}"
    val expected = Program(List(FuncDecl(Id("a"),List(VarDecl(Id("a"),ArrayPointerType(IntType)),VarDecl(Id("b"),ArrayPointerType(BoolType))),ArrayPointerType(IntType),Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",BinaryOp("+",ArrayCell(Id("function"),BinaryOp("+",CallExpr(Id("f"),List(IntLiteral(4),Id("y"))),IntLiteral(5))),IntLiteral(4)),BinaryOp("*",BinaryOp("+",CallExpr(Id("f"),List(Id("t"),Id("u"))),IntLiteral(4)),IntLiteral(6))))))))
    assert(checkAst(input,expected,230))
  }

  test("a simple empty main int type with parameter list 231") {
    val input = "int a(int a[]) { int a;if(true==true) v=v+4;}"
    val expected = Program(List(FuncDecl(Id("a"),List(VarDecl(Id("a"),ArrayPointerType(IntType))),IntType,Block(List(VarDecl(Id("a"),IntType)),List(If(BinaryOp("==",BooleanLiteral(true),BooleanLiteral(true)),BinaryOp("=",Id("v"),BinaryOp("+",Id("v"),IntLiteral(4))),None))))))
    assert(checkAst(input,expected,231))
  }

  test("a simple empty main int type with parameter list 232") {
    val input = "int a(int a) { int a;f = -3+4--5;f(-2);}"
    val expected = Program(List(FuncDecl(Id("a"),List(VarDecl(Id("a"),IntType)),IntType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",Id("f"),BinaryOp("-",BinaryOp("+",UnaryOp("-",IntLiteral(3)),IntLiteral(4)),UnaryOp("-",IntLiteral(5)))),CallExpr(Id("f"),List(UnaryOp("-",IntLiteral(2)))))))))
    assert(checkAst(input,expected,232))
  }


  test("a simple empty main int type with parameter list 233") {
    val input = "int a(int a) { int a; a[f(x)+3] = funct[3] + g(y,u)+ 6;}"
    val expected = Program(List(FuncDecl(Id("a"),List(VarDecl(Id("a"),IntType)),IntType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",ArrayCell(Id("a"),BinaryOp("+",CallExpr(Id("f"),List(Id("x"))),IntLiteral(3))),BinaryOp("+",BinaryOp("+",ArrayCell(Id("funct"),IntLiteral(3)),CallExpr(Id("g"),List(Id("y"),Id("u")))),IntLiteral(6))))))))
    assert(checkAst(input,expected,233))
  }

  test("a simple empty main int type with parameter list 234") {
    val input = "int test() {do {v=v+1;func(y,b) + 4;} while(true);}"
    val expected = Program(List(FuncDecl(Id("test"),List(),IntType,Block(List(),List(Dowhile(List(Block(List(),List(BinaryOp("=",Id("v"),BinaryOp("+",Id("v"),IntLiteral(1))),BinaryOp("+",CallExpr(Id("func"),List(Id("y"),Id("b"))),IntLiteral(4))))),BooleanLiteral(true)))))))
    assert(checkAst(input,expected,234))
  }

  test("a simple empty main int type with parameter list 235") {
    val input = "int test() {do v=v+1; while(true);}"
    val expected = Program(List(FuncDecl(Id("test"),List(),IntType,Block(List(),List(Dowhile(List(BinaryOp("=",Id("v"),BinaryOp("+",Id("v"),IntLiteral(1)))),BooleanLiteral(true)))))))
    assert(checkAst(input,expected,235))
  }

  test("a simple program has a simple call putIntLn 236") {
    val input = "void main () {putIntLn(5);}"
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(),List(CallExpr(Id("putIntLn"),List(IntLiteral(5))))))))
    assert(checkAst(input,expected,236))
  }

  test("a simple empty main int type with parameter list 237") {
    val input = "int test() {if(true) v=v+5;}"
    val expected = Program(List(FuncDecl(Id("test"),List(),IntType,Block(List(),List(If(BooleanLiteral(true),BinaryOp("=",Id("v"),BinaryOp("+",Id("v"),IntLiteral(5))),None))))))
    assert(checkAst(input,expected,237))
  }

  test("a simple empty main int type with parameter list 238") {
    val input = "int test() {if(r||false) func(t,y);}"
    val expected = Program(List(FuncDecl(Id("test"),List(),IntType,Block(List(),List(If(BinaryOp("||",Id("r"),BooleanLiteral(false)),CallExpr(Id("func"),List(Id("t"),Id("y"))),None))))))
    assert(checkAst(input,expected,238))
  }

  test("a simple empty main int type with parameter list 239") {
    val input = "int test() {if(r||false) v = v+1; else v=v--1;}"
    val expected = Program(List(FuncDecl(Id("test"),List(),IntType,Block(List(),List(If(BinaryOp("||",Id("r"),BooleanLiteral(false)),BinaryOp("=",Id("v"),BinaryOp("+",Id("v"),IntLiteral(1))),Some(BinaryOp("=",Id("v"),BinaryOp("-",Id("v"),UnaryOp("-",IntLiteral(1)))))))))))
    assert(checkAst(input,expected,239))
  }
//
  test("a simple empty main int type with parameter list 240") {
    val input = "int test() {v = f&&r||e&&e;}"
    val expected = Program(List(FuncDecl(Id("test"),List(),IntType,Block(List(),List(BinaryOp("=",Id("v"),BinaryOp("||",BinaryOp("&&",Id("f"),Id("r")),BinaryOp("&&",Id("e"),Id("e")))))))))
    assert(checkAst(input,expected,240))
  }

  test("a simple empty main int type with parameter list 241") {
    val input = "int test() {v = !(f&&r)||e&&!e;}"
    val expected = Program(List(FuncDecl(Id("test"),List(),IntType,Block(List(),List(BinaryOp("=",Id("v"),BinaryOp("||",UnaryOp("!",BinaryOp("&&",Id("f"),Id("r"))),BinaryOp("&&",Id("e"),UnaryOp("!",Id("e"))))))))))
    assert(checkAst(input,expected,241))
  }
//
  test("a simple empty main int type with parameter list 242") {
    val input = "int test() {v = !f==(r&&e)&&!e;}"
    val expected = Program(List(FuncDecl(Id("test"),List(),IntType,Block(List(),List(BinaryOp("=",Id("v"),BinaryOp("&&",BinaryOp("==",UnaryOp("!",Id("f")),BinaryOp("&&",Id("r"),Id("e"))),UnaryOp("!",Id("e")))))))))
    assert(checkAst(input,expected,242))
  }
//
  test("a simple empty main int type with parameter list 243") {
    val input = "int test() {if(v) !v&&function(); else if(!v) function(); else return;}"
    val expected = Program(List(FuncDecl(Id("test"),List(),IntType,Block(List(),List(If(Id("v"),BinaryOp("&&",UnaryOp("!",Id("v")),CallExpr(Id("function"),List())),Some(If(UnaryOp("!",Id("v")),CallExpr(Id("function"),List()),Some(Return(None))))))))))
    assert(checkAst(input,expected,243))
  }

  test("a simple test variable decl 244") {
    val input = "int a;void main(int a, float b) {} int[] v(){int a,b;for(i;i<5;i=i+1) if(i==3) continue;}"
    val expected = Program(List(VarDecl(Id("a"),IntType),FuncDecl(Id("main"),List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),FloatType)),VoidType,Block(List(),List())),FuncDecl(Id("v"),List(),ArrayPointerType(IntType),Block(List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),IntType)),List(For(Id("i"),BinaryOp("<",Id("i"),IntLiteral(5)),BinaryOp("=",Id("i"),BinaryOp("+",Id("i"),IntLiteral(1))),If(BinaryOp("==",Id("i"),IntLiteral(3)),Continue,None)))))))

    assert(checkAst(input,expected,244))
  }

  test("a simple test variable decl 245") {
    val input = "int a;void main() {u=(v+3)>=(y-3)&&!(f||u);f=f/4+5/6*3--2*(u+3);}"
    val expected = Program(List(VarDecl(Id("a"),IntType),FuncDecl(Id("main"),List(),VoidType,Block(List(),List(BinaryOp("=",Id("u"),BinaryOp("&&",BinaryOp(">=",BinaryOp("+",Id("v"),IntLiteral(3)),BinaryOp("-",Id("y"),IntLiteral(3))),UnaryOp("!",BinaryOp("||",Id("f"),Id("u"))))),BinaryOp("=",Id("f"),BinaryOp("-",BinaryOp("+",BinaryOp("/",Id("f"),IntLiteral(4)),BinaryOp("*",BinaryOp("/",IntLiteral(5),IntLiteral(6)),IntLiteral(3))),BinaryOp("*",UnaryOp("-",IntLiteral(2)),BinaryOp("+",Id("u"),IntLiteral(3))))))))))

    assert(checkAst(input,expected,245))
  }
  test("a assignment array 246") {
    val input = "int a(){a[6] = func(b,c);f=1.1e-2;int t; t=\"this\'s a string\";}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(VarDecl(Id("t"),IntType)),List(BinaryOp("=",ArrayCell(Id("a"),IntLiteral(6)),CallExpr(Id("func"),List(Id("b"),Id("c")))),BinaryOp("=",Id("f"),FloatLiteral(1.1e-2.toFloat)),BinaryOp("=",Id("t"),StringLiteral("this's a string")))))))
    assert(checkAst(input,expected,246))
  }

  test("a assignment array 247") {
    val input = "int a(){int a[5], b[6], c; boolean c, f[4]; c = f&&r||!r==f;}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(VarDecl(Id("a"),ArrayType(IntLiteral(5),IntType)),VarDecl(Id("b"),ArrayType(IntLiteral(6),IntType)),VarDecl(Id("c"),IntType),VarDecl(Id("c"),BoolType),VarDecl(Id("f"),ArrayType(IntLiteral(4),BoolType))),List(BinaryOp("=",Id("c"),BinaryOp("||",BinaryOp("&&",Id("f"),Id("r")),BinaryOp("==",UnaryOp("!",Id("r")),Id("f")))))))))
    assert(checkAst(input,expected,247))
  }

  test("a assignment array 248") {
    val input = "int a(){a=b=c=function(t,u);}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(),List(BinaryOp("=",Id("a"),BinaryOp("=",Id("b"),BinaryOp("=",Id("c"),CallExpr(Id("function"),List(Id("t"),Id("u")))))))))))
    assert(checkAst(input,expected,248))
  }

  test("a assignment array 249") {
    val input = "int a(){for(i=0;i<=5;i=i+1) {for(j=i;j<5;j=j+1) function(i,j);}}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(),List(For(BinaryOp("=",Id("i"),IntLiteral(0)),BinaryOp("<=",Id("i"),IntLiteral(5)),BinaryOp("=",Id("i"),BinaryOp("+",Id("i"),IntLiteral(1))),Block(List(),List(For(BinaryOp("=",Id("j"),Id("i")),BinaryOp("<",Id("j"),IntLiteral(5)),BinaryOp("=",Id("j"),BinaryOp("+",Id("j"),IntLiteral(1))),CallExpr(Id("function"),List(Id("i"),Id("j"))))))))))))
    assert(checkAst(input,expected,249))
  }

  test("a assignment array 250") {
    val input = "int a(){for(i=0;i<=5;i=i+1) {for(j=i;j<5;j=j+1) break;}}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(),List(For(BinaryOp("=",Id("i"),IntLiteral(0)),BinaryOp("<=",Id("i"),IntLiteral(5)),BinaryOp("=",Id("i"),BinaryOp("+",Id("i"),IntLiteral(1))),Block(List(),List(For(BinaryOp("=",Id("j"),Id("i")),BinaryOp("<",Id("j"),IntLiteral(5)),BinaryOp("=",Id("j"),BinaryOp("+",Id("j"),IntLiteral(1))),Break)))))))))
    assert(checkAst(input,expected,250))
  }

  test("a assignment array 251") {
    val input = "int a(){int a;a = b%1/2;a=a*a+1/2;return a;}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",Id("a"),BinaryOp("/",BinaryOp("%",Id("b"),IntLiteral(1)),IntLiteral(2))),BinaryOp("=",Id("a"),BinaryOp("+",BinaryOp("*",Id("a"),Id("a")),BinaryOp("/",IntLiteral(1),IntLiteral(2)))),Return(Some(Id("a"))))))))
    assert(checkAst(input,expected,251))
  }

  test("a assignment array 252") {
    val input = "int a(){int a;a(c[f(x)],b[x],d);}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(VarDecl(Id("a"),IntType)),List(CallExpr(Id("a"),List(ArrayCell(Id("c"),CallExpr(Id("f"),List(Id("x")))),ArrayCell(Id("b"),Id("x")),Id("d"))))))))
    assert(checkAst(input,expected,252))
  }

  test("a for 253") {
    val input = "int a(){for(i=func(d);i<=5;i=i+1) c = fc(i)+f[i-1]*2;}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(),List(For(BinaryOp("=",Id("i"),CallExpr(Id("func"),List(Id("d")))),BinaryOp("<=",Id("i"),IntLiteral(5)),BinaryOp("=",Id("i"),BinaryOp("+",Id("i"),IntLiteral(1))),BinaryOp("=",Id("c"),BinaryOp("+",CallExpr(Id("fc"),List(Id("i"))),BinaryOp("*",ArrayCell(Id("f"),BinaryOp("-",Id("i"),IntLiteral(1))),IntLiteral(2))))))))))
    assert(checkAst(input,expected,253))
  }


  test("a simple empty main int type with parameter list 254") {
    val input = "int test() {do {v=v+1;func(y,b) + 4;} while(callfunc(x,f[y])>=5);}"
    val expected = Program(List(FuncDecl(Id("test"),List(),IntType,Block(List(),List(Dowhile(List(Block(List(),List(BinaryOp("=",Id("v"),BinaryOp("+",Id("v"),IntLiteral(1))),BinaryOp("+",CallExpr(Id("func"),List(Id("y"),Id("b"))),IntLiteral(4))))),BinaryOp(">=",CallExpr(Id("callfunc"),List(Id("x"),ArrayCell(Id("f"),Id("y")))),IntLiteral(5))))))))

    assert(checkAst(input,expected,254))
  }

  test("a simple empty main int type with parameter list 255") {
    val input = "int test() {do {v=v+1;func(y,b) + 4;}{int a; a=a%6/7+8*2;} while(callfunc(x,f[y])>=5);}"
    val expected = Program(List(FuncDecl(Id("test"),List(),IntType,Block(List(),List(Dowhile(List(Block(List(),List(BinaryOp("=",Id("v"),BinaryOp("+",Id("v"),IntLiteral(1))),BinaryOp("+",CallExpr(Id("func"),List(Id("y"),Id("b"))),IntLiteral(4)))),Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",Id("a"),BinaryOp("+",BinaryOp("/",BinaryOp("%",Id("a"),IntLiteral(6)),IntLiteral(7)),BinaryOp("*",IntLiteral(8),IntLiteral(2))))))),BinaryOp(">=",CallExpr(Id("callfunc"),List(Id("x"),ArrayCell(Id("f"),Id("y")))),IntLiteral(5))))))))

    assert(checkAst(input,expected,255))
  }

  test("a for 256") {
    val input = "int a(){for(i=func(d);i<=5;i=i+1) do {v=v+1;func(y,b) + 4;} while(callfunc(x,f[y])>=5);}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(),List(For(BinaryOp("=",Id("i"),CallExpr(Id("func"),List(Id("d")))),BinaryOp("<=",Id("i"),IntLiteral(5)),BinaryOp("=",Id("i"),BinaryOp("+",Id("i"),IntLiteral(1))),Dowhile(List(Block(List(),List(BinaryOp("=",Id("v"),BinaryOp("+",Id("v"),IntLiteral(1))),BinaryOp("+",CallExpr(Id("func"),List(Id("y"),Id("b"))),IntLiteral(4))))),BinaryOp(">=",CallExpr(Id("callfunc"),List(Id("x"),ArrayCell(Id("f"),Id("y")))),IntLiteral(5)))))))))
    assert(checkAst(input,expected,256))
  }

  test("a for 257") {
    val input = "int a(){if(c==b&&e&&!(r>=f)) do {v=v+1;func(y,b) + 4;} while(callfunc(x,f[y])>=5); else return;}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(),List(If(BinaryOp("&&",BinaryOp("&&",BinaryOp("==",Id("c"),Id("b")),Id("e")),UnaryOp("!",BinaryOp(">=",Id("r"),Id("f")))),Dowhile(List(Block(List(),List(BinaryOp("=",Id("v"),BinaryOp("+",Id("v"),IntLiteral(1))),BinaryOp("+",CallExpr(Id("func"),List(Id("y"),Id("b"))),IntLiteral(4))))),BinaryOp(">=",CallExpr(Id("callfunc"),List(Id("x"),ArrayCell(Id("f"),Id("y")))),IntLiteral(5))),Some(Return(None))))))))
    assert(checkAst(input,expected,257))
  }

  test("a for 258") {
    val input = "int a(){if(c==b&&e&&!(r>=f)) for(i=func(d);i<=5;i=i+1) call(f)+r; else return;}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(),List(If(BinaryOp("&&",BinaryOp("&&",BinaryOp("==",Id("c"),Id("b")),Id("e")),UnaryOp("!",BinaryOp(">=",Id("r"),Id("f")))),For(BinaryOp("=",Id("i"),CallExpr(Id("func"),List(Id("d")))),BinaryOp("<=",Id("i"),IntLiteral(5)),BinaryOp("=",Id("i"),BinaryOp("+",Id("i"),IntLiteral(1))),BinaryOp("+",CallExpr(Id("call"),List(Id("f"))),Id("r"))),Some(Return(None))))))))
    assert(checkAst(input,expected,258))
  }

  test("a for 259") {
    val input = "int a(){do {if(c==b&&e&&!(r>=f)) v=v+1; else break;} while(callfunc(x,f[y])>=5);}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(),List(Dowhile(List(Block(List(),List(If(BinaryOp("&&",BinaryOp("&&",BinaryOp("==",Id("c"),Id("b")),Id("e")),UnaryOp("!",BinaryOp(">=",Id("r"),Id("f")))),BinaryOp("=",Id("v"),BinaryOp("+",Id("v"),IntLiteral(1))),Some(Break))))),BinaryOp(">=",CallExpr(Id("callfunc"),List(Id("x"),ArrayCell(Id("f"),Id("y")))),IntLiteral(5))))))))
    assert(checkAst(input,expected,259))
  }

  test("a for 260") {
    val input = "int a(){do {if(c==b&&e&&!(r>=f)) f[c(r)+2] = call(b)[r-2]+3; else break;} while(true);}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(),List(Dowhile(List(Block(List(),List(If(BinaryOp("&&",BinaryOp("&&",BinaryOp("==",Id("c"),Id("b")),Id("e")),UnaryOp("!",BinaryOp(">=",Id("r"),Id("f")))),BinaryOp("=",ArrayCell(Id("f"),BinaryOp("+",CallExpr(Id("c"),List(Id("r"))),IntLiteral(2))),BinaryOp("+",ArrayCell(CallExpr(Id("call"),List(Id("b"))),BinaryOp("-",Id("r"),IntLiteral(2))),IntLiteral(3))),Some(Break))))),BooleanLiteral(true)))))))
    assert(checkAst(input,expected,260))
  }

  test("a for 261") {
    val input = "int a(){if(b==funct(a,b,c)&&r||!t) for(f;f<10;f=f+1) b=true; }"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(),List(If(BinaryOp("||",BinaryOp("&&",BinaryOp("==",Id("b"),CallExpr(Id("funct"),List(Id("a"),Id("b"),Id("c")))),Id("r")),UnaryOp("!",Id("t"))),For(Id("f"),BinaryOp("<",Id("f"),IntLiteral(10)),BinaryOp("=",Id("f"),BinaryOp("+",Id("f"),IntLiteral(1))),BinaryOp("=",Id("b"),BooleanLiteral(true))),None))))))
    assert(checkAst(input,expected,261))
  }

  test("a for 262") {
    val input = "int a; float a,b,c;int a(){return fun();} float fun(){return a/3>=(r-5);}"
    val expected = Program(List(VarDecl(Id("a"),IntType),VarDecl(Id("a"),FloatType),VarDecl(Id("b"),FloatType),VarDecl(Id("c"),FloatType),FuncDecl(Id("a"),List(),IntType,Block(List(),List(Return(Some(CallExpr(Id("fun"),List())))))),FuncDecl(Id("fun"),List(),FloatType,Block(List(),List(Return(Some(BinaryOp(">=",BinaryOp("/",Id("a"),IntLiteral(3)),BinaryOp("-",Id("r"),IntLiteral(5))))))))))
    assert(checkAst(input,expected,262))
  }

  test("a for 263") {
    val input = "int a; string a[10],c;int a(){return a[f(r)[3]-2] == f(i,r)[t-2]+2;}"
    val expected = Program(List(VarDecl(Id("a"),IntType),VarDecl(Id("a"),ArrayType(IntLiteral(10),StringType)),VarDecl(Id("c"),StringType),FuncDecl(Id("a"),List(),IntType,Block(List(),List(Return(Some(BinaryOp("==",ArrayCell(Id("a"),BinaryOp("-",ArrayCell(CallExpr(Id("f"),List(Id("r"))),IntLiteral(3)),IntLiteral(2))),BinaryOp("+",ArrayCell(CallExpr(Id("f"),List(Id("i"),Id("r"))),BinaryOp("-",Id("t"),IntLiteral(2))),IntLiteral(2))))))))))
    assert(checkAst(input,expected,263))
  }

  test("a for 264") {
    val input = "boolean main(){if(m>3) if(n>2) if (true) return 3; else return m>=n; else return false;}"
    val expected = Program(List(FuncDecl(Id("main"),List(),BoolType,Block(List(),List(If(BinaryOp(">",Id("m"),IntLiteral(3)),If(BinaryOp(">",Id("n"),IntLiteral(2)),If(BooleanLiteral(true),Return(Some(IntLiteral(3))),Some(Return(Some(BinaryOp(">=",Id("m"),Id("n")))))),Some(Return(Some(BooleanLiteral(false))))),None))))))
    assert(checkAst(input,expected,264))
  }

  test("a for 265") {
    val input = "boolean main(){if(call(f)>=3&&f<7) return 3; else if(f>7) return 5; else return 6;}"
    val expected = Program(List(FuncDecl(Id("main"),List(),BoolType,Block(List(),List(If(BinaryOp("&&",BinaryOp(">=",CallExpr(Id("call"),List(Id("f"))),IntLiteral(3)),BinaryOp("<",Id("f"),IntLiteral(7))),Return(Some(IntLiteral(3))),Some(If(BinaryOp(">",Id("f"),IntLiteral(7)),Return(Some(IntLiteral(5))),Some(Return(Some(IntLiteral(6))))))))))))
    assert(checkAst(input,expected,265))
  }

  test("a for 266") {
    val input = "boolean main(){if(call(f)>=3&&f<7) {int a; a= 5; for(f;f<a+call(t)[r];f=f+1) b=true; t=y+7*fun(t)[3];}else return 6;}"
    val expected = Program(List(FuncDecl(Id("main"),List(),BoolType,Block(List(),List(If(BinaryOp("&&",BinaryOp(">=",CallExpr(Id("call"),List(Id("f"))),IntLiteral(3)),BinaryOp("<",Id("f"),IntLiteral(7))),Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",Id("a"),IntLiteral(5)),For(Id("f"),BinaryOp("<",Id("f"),BinaryOp("+",Id("a"),ArrayCell(CallExpr(Id("call"),List(Id("t"))),Id("r")))),BinaryOp("=",Id("f"),BinaryOp("+",Id("f"),IntLiteral(1))),BinaryOp("=",Id("b"),BooleanLiteral(true))),BinaryOp("=",Id("t"),BinaryOp("+",Id("y"),BinaryOp("*",IntLiteral(7),ArrayCell(CallExpr(Id("fun"),List(Id("t"))),IntLiteral(3))))))),Some(Return(Some(IntLiteral(6))))))))))
    assert(checkAst(input,expected,266))
  }

  test("a for 267") {
    val input = "boolean main(){if(call(f)>=3&&f<7) {int a; a= 5; for(f;f<a+call(t)[r];f=f+1) b=true; t=y+7*fun(t)[3];}else return 6;}"
    val expected = Program(List(FuncDecl(Id("main"),List(),BoolType,Block(List(),List(If(BinaryOp("&&",BinaryOp(">=",CallExpr(Id("call"),List(Id("f"))),IntLiteral(3)),BinaryOp("<",Id("f"),IntLiteral(7))),Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",Id("a"),IntLiteral(5)),For(Id("f"),BinaryOp("<",Id("f"),BinaryOp("+",Id("a"),ArrayCell(CallExpr(Id("call"),List(Id("t"))),Id("r")))),BinaryOp("=",Id("f"),BinaryOp("+",Id("f"),IntLiteral(1))),BinaryOp("=",Id("b"),BooleanLiteral(true))),BinaryOp("=",Id("t"),BinaryOp("+",Id("y"),BinaryOp("*",IntLiteral(7),ArrayCell(CallExpr(Id("fun"),List(Id("t"))),IntLiteral(3))))))),Some(Return(Some(IntLiteral(6))))))))))
    assert(checkAst(input,expected,267))
  }

  test("a for 268") {
    val input = "boolean main(){ int a, b, c; float f[5]; a=b=2; if(a=b) f[0] = 1.0;}"
    val expected = Program(List(FuncDecl(Id("main"),List(),BoolType,Block(List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),IntType),VarDecl(Id("c"),IntType),VarDecl(Id("f"),ArrayType(IntLiteral(5),FloatType))),List(BinaryOp("=",Id("a"),BinaryOp("=",Id("b"),IntLiteral(2))),If(BinaryOp("=",Id("a"),Id("b")),BinaryOp("=",ArrayCell(Id("f"),IntLiteral(0)),FloatLiteral(1.0.toFloat)),None))))))
    assert(checkAst(input,expected,268))
  }

  test("a for 269") {
    val input = "int i; int f(){ return 200; } void main (){ int main; main=f(); putIntLn (i);{int i; int main; int f; main=f=i=100; putIntLn (i); putIntLn(main); putIntLn(f);} putIntLn(main); }"
    val expected = Program(List(VarDecl(Id("i"),IntType),FuncDecl(Id("f"),List(),IntType,Block(List(),List(Return(Some(IntLiteral(200)))))),FuncDecl(Id("main"),List(),VoidType,Block(List(VarDecl(Id("main"),IntType)),List(BinaryOp("=",Id("main"),CallExpr(Id("f"),List())),CallExpr(Id("putIntLn"),List(Id("i"))),Block(List(VarDecl(Id("i"),IntType),VarDecl(Id("main"),IntType),VarDecl(Id("f"),IntType)),List(BinaryOp("=",Id("main"),BinaryOp("=",Id("f"),BinaryOp("=",Id("i"),IntLiteral(100)))),CallExpr(Id("putIntLn"),List(Id("i"))),CallExpr(Id("putIntLn"),List(Id("main"))),CallExpr(Id("putIntLn"),List(Id("f"))))),CallExpr(Id("putIntLn"),List(Id("main"))))))))
    assert(checkAst(input,expected,269))
  }

  test("a for 270") {
    val input = "void main() {int a[100]; float b[5], boolean f[3]; f[2] = true; b[1] = 4.565e-1; v[1] = \"this false\";}"
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(VarDecl(Id("a"),ArrayType(IntLiteral(100),IntType)),VarDecl(Id("b"),ArrayType(IntLiteral(5),FloatType)),VarDecl(Id("f"),ArrayType(IntLiteral(3),FloatType))),List(BinaryOp("=",ArrayCell(Id("f"),IntLiteral(2)),BooleanLiteral(true)),BinaryOp("=",ArrayCell(Id("b"),IntLiteral(1)),FloatLiteral(0.4565.toFloat)),BinaryOp("=",ArrayCell(Id("v"),IntLiteral(1)),StringLiteral("this false")))))))
    assert(checkAst(input,expected,270))
  }

  test("a for 271") {
    val input = "void main(int a[]) {if (v!=b) {int a; a = 100%6/4;b(r)+a;} else return v;}"
    val expected = Program(List(FuncDecl(Id("main"),List(VarDecl(Id("a"),ArrayPointerType(IntType))),VoidType,Block(List(),List(If(BinaryOp("!=",Id("v"),Id("b")),Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",Id("a"),BinaryOp("/",BinaryOp("%",IntLiteral(100),IntLiteral(6)),IntLiteral(4))),BinaryOp("+",CallExpr(Id("b"),List(Id("r"))),Id("a")))),Some(Return(Some(Id("v"))))))))))
    assert(checkAst(input,expected,271))
  }

  test("a for 272") {
    val input = "boolean main(int b[]) {int a; a=a+1;a=a--1;a=a%v/a; !a; a=true; a=false; return a;}"
    val expected = Program(List(FuncDecl(Id("main"),List(VarDecl(Id("b"),ArrayPointerType(IntType))),BoolType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",Id("a"),BinaryOp("+",Id("a"),IntLiteral(1))),BinaryOp("=",Id("a"),BinaryOp("-",Id("a"),UnaryOp("-",IntLiteral(1)))),BinaryOp("=",Id("a"),BinaryOp("/",BinaryOp("%",Id("a"),Id("v")),Id("a"))),UnaryOp("!",Id("a")),BinaryOp("=",Id("a"),BooleanLiteral(true)),BinaryOp("=",Id("a"),BooleanLiteral(false)),Return(Some(Id("a"))))))))
    assert(checkAst(input,expected,272))
  }

  test("a for 273") {
    val input = "int a() {int a; a = 5; a = a(t)[g(x)+3] + 6; a=a/5%7--4+2;}"
    val expected = Program(List(FuncDecl(Id("a"),List(),IntType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",Id("a"),IntLiteral(5)),BinaryOp("=",Id("a"),BinaryOp("+",ArrayCell(CallExpr(Id("a"),List(Id("t"))),BinaryOp("+",CallExpr(Id("g"),List(Id("x"))),IntLiteral(3))),IntLiteral(6))),BinaryOp("=",Id("a"),BinaryOp("+",BinaryOp("-",BinaryOp("%",BinaryOp("/",Id("a"),IntLiteral(5)),IntLiteral(7)),UnaryOp("-",IntLiteral(4))),IntLiteral(2))))))))
    assert(checkAst(input,expected,273))
  }

  test("a for 274") {
    val input = "int a[100]; string b[200], c[5]; int a() {int a; a[3] = 5; a[5] = a(t)[g(x)+3] + 6; b[10]= \"buzzz\";}"
    val expected = Program(List(VarDecl(Id("a"),ArrayType(IntLiteral(100),IntType)),VarDecl(Id("b"),ArrayType(IntLiteral(200),StringType)),VarDecl(Id("c"),ArrayType(IntLiteral(5),StringType)),FuncDecl(Id("a"),List(),IntType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",ArrayCell(Id("a"),IntLiteral(3)),IntLiteral(5)),BinaryOp("=",ArrayCell(Id("a"),IntLiteral(5)),BinaryOp("+",ArrayCell(CallExpr(Id("a"),List(Id("t"))),BinaryOp("+",CallExpr(Id("g"),List(Id("x"))),IntLiteral(3))),IntLiteral(6))),BinaryOp("=",ArrayCell(Id("b"),IntLiteral(10)),StringLiteral("buzzz")))))))
    assert(checkAst(input,expected,274))
  }

  test("a for 275") {
    val input = "float a[100]; int a() {int b; a[3] = 5.5; a[5] = 5e4; a[10] = 5e5-2; a[9] = 5.5e5-2; a[8] = .3e-2;}"
    val expected = Program(List(VarDecl(Id("a"),ArrayType(IntLiteral(100),FloatType)),FuncDecl(Id("a"),List(),IntType,Block(List(VarDecl(Id("b"),IntType)),List(BinaryOp("=",ArrayCell(Id("a"),IntLiteral(3)),FloatLiteral(5.5.toFloat)),BinaryOp("=",ArrayCell(Id("a"),IntLiteral(5)),FloatLiteral(50000.0.toFloat)),BinaryOp("=",ArrayCell(Id("a"),IntLiteral(10)),BinaryOp("-",FloatLiteral(500000.0.toFloat),IntLiteral(2))),BinaryOp("=",ArrayCell(Id("a"),IntLiteral(9)),BinaryOp("-",FloatLiteral(550000.0.toFloat),IntLiteral(2))),BinaryOp("=",ArrayCell(Id("a"),IntLiteral(8)),FloatLiteral(0.003.toFloat)))))))
    assert(checkAst(input,expected,275))
  }

  test("a for 276") {
    val input = "float a() {int a; a = a*1*3*5; a = a%1%3%7; a = a/1/3/7/9; a = a+b+c+d;}"
    val expected = Program(List(FuncDecl(Id("a"),List(),FloatType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",Id("a"),BinaryOp("*",BinaryOp("*",BinaryOp("*",Id("a"),IntLiteral(1)),IntLiteral(3)),IntLiteral(5))),BinaryOp("=",Id("a"),BinaryOp("%",BinaryOp("%",BinaryOp("%",Id("a"),IntLiteral(1)),IntLiteral(3)),IntLiteral(7))),BinaryOp("=",Id("a"),BinaryOp("/",BinaryOp("/",BinaryOp("/",BinaryOp("/",Id("a"),IntLiteral(1)),IntLiteral(3)),IntLiteral(7)),IntLiteral(9))),BinaryOp("=",Id("a"),BinaryOp("+",BinaryOp("+",BinaryOp("+",Id("a"),Id("b")),Id("c")),Id("d"))))))))
    assert(checkAst(input,expected,276))
  }

  test("a for 277") {
    val input = "float a() {int a; a = a&&b&&c&&d; a=b=c=d&&e&&t;}"
    val expected = Program(List(FuncDecl(Id("a"),List(),FloatType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",Id("a"),BinaryOp("&&",BinaryOp("&&",BinaryOp("&&",Id("a"),Id("b")),Id("c")),Id("d"))),BinaryOp("=",Id("a"),BinaryOp("=",Id("b"),BinaryOp("=",Id("c"),BinaryOp("&&",BinaryOp("&&",Id("d"),Id("e")),Id("t"))))))))))
    assert(checkAst(input,expected,277))
  }

  test("a for 278") {
    val input = "float a() {int a; a= a&&b||!c==d;}"
    val expected = Program(List(FuncDecl(Id("a"),List(),FloatType,Block(List(VarDecl(Id("a"),IntType)),List(BinaryOp("=",Id("a"),BinaryOp("||",BinaryOp("&&",Id("a"),Id("b")),BinaryOp("==",UnaryOp("!",Id("c")),Id("d")))))))))
    assert(checkAst(input,expected,278))
  }

  test("a for 279") {
    val input = "float a() {b = (fun(a,g) +- g[6])*fun2(e)[5*x-1];}"
    val expected = Program(List(FuncDecl(Id("a"),List(),FloatType,Block(List(),List(BinaryOp("=",Id("b"),BinaryOp("*",BinaryOp("+",CallExpr(Id("fun"),List(Id("a"),Id("g"))),UnaryOp("-",ArrayCell(Id("g"),IntLiteral(6)))),ArrayCell(CallExpr(Id("fun2"),List(Id("e"))),BinaryOp("-",BinaryOp("*",IntLiteral(5),Id("x")),IntLiteral(1))))))))))
    assert(checkAst(input,expected,279))
  }

  test("a for 280") {
    val input = "float a() {b = function(2)[3+x] / goo[3];}"
    val expected = Program(List(FuncDecl(Id("a"),List(),FloatType,Block(List(),List(BinaryOp("=",Id("b"),BinaryOp("/",ArrayCell(CallExpr(Id("function"),List(IntLiteral(2))),BinaryOp("+",IntLiteral(3),Id("x"))),ArrayCell(Id("goo"),IntLiteral(3)))))))))
    assert(checkAst(input,expected,280))
  }

  test("a for 281") {
    val input = "float a() {b = function(2)[3+x] == goo[3];}"
    val expected = Program(List(FuncDecl(Id("a"),List(),FloatType,Block(List(),List(BinaryOp("=",Id("b"),BinaryOp("==",ArrayCell(CallExpr(Id("function"),List(IntLiteral(2))),BinaryOp("+",IntLiteral(3),Id("x"))),ArrayCell(Id("goo"),IntLiteral(3)))))))))
    assert(checkAst(input,expected,281))
  }

  test("a for 282") {
    val input = "float a() {b = function(2)[3+x] && goo[3];}"
    val expected = Program(List(FuncDecl(Id("a"),List(),FloatType,Block(List(),List(BinaryOp("=",Id("b"),BinaryOp("&&",ArrayCell(CallExpr(Id("function"),List(IntLiteral(2))),BinaryOp("+",IntLiteral(3),Id("x"))),ArrayCell(Id("goo"),IntLiteral(3)))))))))
    assert(checkAst(input,expected,282))
  }

  test("a for 283") {
    val input = "float a() {b = function(2)[3+x] && !goo[3];}"
    val expected = Program(List(FuncDecl(Id("a"),List(),FloatType,Block(List(),List(BinaryOp("=",Id("b"),BinaryOp("&&",ArrayCell(CallExpr(Id("function"),List(IntLiteral(2))),BinaryOp("+",IntLiteral(3),Id("x"))),UnaryOp("!",ArrayCell(Id("goo"),IntLiteral(3))))))))))
    assert(checkAst(input,expected,283))
  }

  test("a for 284") {
    val input = "float a() {b = -(-(-(b)))-b;}"
    val expected = Program(List(FuncDecl(Id("a"),List(),FloatType,Block(List(),List(BinaryOp("=",Id("b"),BinaryOp("-",UnaryOp("-",UnaryOp("-",UnaryOp("-",Id("b")))),Id("b"))))))))
    assert(checkAst(input,expected,284))
  }

  test("a for 285") {
    val input =
      """
        int main()
        {
           // printf() displays the string inside quotation
           printf("Hello, World!");
           return 0;
        }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(),List(CallExpr(Id("printf"),List(StringLiteral("Hello, World!"))),Return(Some(IntLiteral(0))))))))
    assert(checkAst(input,expected,285))
  }

  test("a for 286") {
    val input =
      """
        void main()
       {
        string ch;
        printf("Enter some text (type a period to quit)...");
       do {
              ch = getchar();
              putchar(ch+1);

       } while (ch != ".");
       printf("Enter some text (type a period to quit)...");
       while ( ch = getchar() != "."); putchar(ch-1);
       }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(VarDecl(Id("ch"),StringType)),List(CallExpr(Id("printf"),List(StringLiteral("Enter some text (type a period to quit)..."))),Dowhile(List(Block(List(),List(BinaryOp("=",Id("ch"),CallExpr(Id("getchar"),List())),CallExpr(Id("putchar"),List(BinaryOp("+",Id("ch"),IntLiteral(1))))))),BinaryOp("!=",Id("ch"),StringLiteral("."))),CallExpr(Id("printf"),List(StringLiteral("Enter some text (type a period to quit)..."))),BinaryOp("=",Id("ch"),BinaryOp("!=",CallExpr(Id("getchar"),List()),StringLiteral("."))),CallExpr(Id("putchar"),List(BinaryOp("-",Id("ch"),IntLiteral(1)))))))))
    assert(checkAst(input,expected,286))
  }

  test("a for 287") {
    val input =
      """
        int main()
       {
         int n, c;

         printf("Enter a number");
         scanf("%d", n);

         if (n == 2)
           printf("Prime number.");
         else
         {
           for (c = 2; c <= n - 1; c=c+1)
           {
             if (n % c == 0)
               break;
           }
           if (c != n)
             printf("Not prime.");
            else
              printf("Prime number.");
         }
         return 0;
       }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(VarDecl(Id("n"),IntType),VarDecl(Id("c"),IntType)),List(CallExpr(Id("printf"),List(StringLiteral("Enter a number"))),CallExpr(Id("scanf"),List(StringLiteral("%d"),Id("n"))),If(BinaryOp("==",Id("n"),IntLiteral(2)),CallExpr(Id("printf"),List(StringLiteral("Prime number."))),Some(Block(List(),List(For(BinaryOp("=",Id("c"),IntLiteral(2)),BinaryOp("<=",Id("c"),BinaryOp("-",Id("n"),IntLiteral(1))),BinaryOp("=",Id("c"),BinaryOp("+",Id("c"),IntLiteral(1))),Block(List(),List(If(BinaryOp("==",BinaryOp("%",Id("n"),Id("c")),IntLiteral(0)),Break,None)))),If(BinaryOp("!=",Id("c"),Id("n")),CallExpr(Id("printf"),List(StringLiteral("Not prime."))),Some(CallExpr(Id("printf"),List(StringLiteral("Prime number."))))))))),Return(Some(IntLiteral(0))))))))
    assert(checkAst(input,expected,287))
  }

  test("a for 288") {
    val input =
      """
        void main()
        {
            int array[100], n, c;

            printf("Enter number of elements in array");
            scanf("%d", n);

            printf("Enter %d elements", n);

            for (c = 0; c < n; c=c+1)
                scanf("%d", array[c]);

            printf("The array elements are:");

            for (c = 0; c < n; c=c+1)
                printf("%d", array[c]);

            return 0;
        }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(VarDecl(Id("array"),ArrayType(IntLiteral(100),IntType)),VarDecl(Id("n"),IntType),VarDecl(Id("c"),IntType)),List(CallExpr(Id("printf"),List(StringLiteral("Enter number of elements in array"))),CallExpr(Id("scanf"),List(StringLiteral("%d"),Id("n"))),CallExpr(Id("printf"),List(StringLiteral("Enter %d elements"),Id("n"))),For(BinaryOp("=",Id("c"),IntLiteral(0)),BinaryOp("<",Id("c"),Id("n")),BinaryOp("=",Id("c"),BinaryOp("+",Id("c"),IntLiteral(1))),CallExpr(Id("scanf"),List(StringLiteral("%d"),ArrayCell(Id("array"),Id("c"))))),CallExpr(Id("printf"),List(StringLiteral("The array elements are:"))),For(BinaryOp("=",Id("c"),IntLiteral(0)),BinaryOp("<",Id("c"),Id("n")),BinaryOp("=",Id("c"),BinaryOp("+",Id("c"),IntLiteral(1))),CallExpr(Id("printf"),List(StringLiteral("%d"),ArrayCell(Id("array"),Id("c"))))),Return(Some(IntLiteral(0))))))))
    assert(checkAst(input,expected,288))
  }

  test("a for 289") {
    val input =
      """
        void main()
        {
          int n, next, c;
          first = 0; second = 1;

          printf("Enter the number of terms");
          scanf("%d", n);

          printf("First %d terms of Fibonacci series are:", n);

          for (c = 0; c < n; c=c+1)
          {
            if (c <= 1)
              next = c;
            else
            {
              next = first + second;
              first = second;
              second = next;
            }
            printf("%d", next);
          }

          return 0;
        }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),VoidType,Block(List(VarDecl(Id("n"),IntType),VarDecl(Id("next"),IntType),VarDecl(Id("c"),IntType)),List(BinaryOp("=",Id("first"),IntLiteral(0)),BinaryOp("=",Id("second"),IntLiteral(1)),CallExpr(Id("printf"),List(StringLiteral("Enter the number of terms"))),CallExpr(Id("scanf"),List(StringLiteral("%d"),Id("n"))),CallExpr(Id("printf"),List(StringLiteral("First %d terms of Fibonacci series are:"),Id("n"))),For(BinaryOp("=",Id("c"),IntLiteral(0)),BinaryOp("<",Id("c"),Id("n")),BinaryOp("=",Id("c"),BinaryOp("+",Id("c"),IntLiteral(1))),Block(List(),List(If(BinaryOp("<=",Id("c"),IntLiteral(1)),BinaryOp("=",Id("next"),Id("c")),Some(Block(List(),List(BinaryOp("=",Id("next"),BinaryOp("+",Id("first"),Id("second"))),BinaryOp("=",Id("first"),Id("second")),BinaryOp("=",Id("second"),Id("next")))))),CallExpr(Id("printf"),List(StringLiteral("%d"),Id("next")))))),Return(Some(IntLiteral(0))))))))
    assert(checkAst(input,expected,289))
  }

  test("a for 290") {
    val input =
      """
        int main()
        {
           int i, num, p;
           p = 0;
           printf("Please enter a number: ");
           scanf("%d", num);
           for(i=1; i<=num; i=i+1)
           {
              if(num%i==0)
              {
                 p=p+1;
              }
           }
           if(p==2)
           {
              printf("Entered number is %d and it is a prime number.",num);
           }
           else
           {
              printf("Entered number is %d and it is not a prime number.",num);
           }
        }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(VarDecl(Id("i"),IntType),VarDecl(Id("num"),IntType),VarDecl(Id("p"),IntType)),List(BinaryOp("=",Id("p"),IntLiteral(0)),CallExpr(Id("printf"),List(StringLiteral("Please enter a number: "))),CallExpr(Id("scanf"),List(StringLiteral("%d"),Id("num"))),For(BinaryOp("=",Id("i"),IntLiteral(1)),BinaryOp("<=",Id("i"),Id("num")),BinaryOp("=",Id("i"),BinaryOp("+",Id("i"),IntLiteral(1))),Block(List(),List(If(BinaryOp("==",BinaryOp("%",Id("num"),Id("i")),IntLiteral(0)),Block(List(),List(BinaryOp("=",Id("p"),BinaryOp("+",Id("p"),IntLiteral(1))))),None)))),If(BinaryOp("==",Id("p"),IntLiteral(2)),Block(List(),List(CallExpr(Id("printf"),List(StringLiteral("Entered number is %d and it is a prime number."),Id("num"))))),Some(Block(List(),List(CallExpr(Id("printf"),List(StringLiteral("Entered number is %d and it is not a prime number."),Id("num"))))))))))))
    assert(checkAst(input,expected,290))
  }

  test("a for 291") {
    val input =
      """
        int main()
        {
           int f1, f2, fib_ser, cnt, lmt;
            f1=1;f2=1;cnt=2;
           printf("Please enter the limit of the Fibonacci series :");
           scanf("%d",lmt);
           printf("Fibonacci series is: %d %d ",f1,f2);

           do
           {
              fib_ser=f1+f2;
              cnt = cnt+1;
              printf("%d",fib_ser);
              f1=f2;
              f2=fib_ser;
           } while(cnt < lmt);
           return 0;
        }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(VarDecl(Id("f1"),IntType),VarDecl(Id("f2"),IntType),VarDecl(Id("fib_ser"),IntType),VarDecl(Id("cnt"),IntType),VarDecl(Id("lmt"),IntType)),List(BinaryOp("=",Id("f1"),IntLiteral(1)),BinaryOp("=",Id("f2"),IntLiteral(1)),BinaryOp("=",Id("cnt"),IntLiteral(2)),CallExpr(Id("printf"),List(StringLiteral("Please enter the limit of the Fibonacci series :"))),CallExpr(Id("scanf"),List(StringLiteral("%d"),Id("lmt"))),CallExpr(Id("printf"),List(StringLiteral("Fibonacci series is: %d %d "),Id("f1"),Id("f2"))),Dowhile(List(Block(List(),List(BinaryOp("=",Id("fib_ser"),BinaryOp("+",Id("f1"),Id("f2"))),BinaryOp("=",Id("cnt"),BinaryOp("+",Id("cnt"),IntLiteral(1))),CallExpr(Id("printf"),List(StringLiteral("%d"),Id("fib_ser"))),BinaryOp("=",Id("f1"),Id("f2")),BinaryOp("=",Id("f2"),Id("fib_ser"))))),BinaryOp("<",Id("cnt"),Id("lmt"))),Return(Some(IntLiteral(0))))))))
    assert(checkAst(input,expected,291))
  }

  test("a for 292") {
    val input =
      """
       int main ()          /* Main function */
       {
           printf ("This is a C basic program ");
           total = sum (1, 1);
           printf ("Sum of two numbers : %d ", total);
           return 0;
       }

       int sum (int a, int b) /* User defined function */
       {
           return a + b;      /* definition section */
       }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(),List(CallExpr(Id("printf"),List(StringLiteral("This is a C basic program "))),BinaryOp("=",Id("total"),CallExpr(Id("sum"),List(IntLiteral(1),IntLiteral(1)))),CallExpr(Id("printf"),List(StringLiteral("Sum of two numbers : %d "),Id("total"))),Return(Some(IntLiteral(0)))))),FuncDecl(Id("sum"),List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),IntType)),IntType,Block(List(),List(Return(Some(BinaryOp("+",Id("a"),Id("b")))))))))
    assert(checkAst(input,expected,292))
  }

  test("a for 293") {
    val input =
      """
        int main()
        {
           int number, t, rev, rmndr;

        rev = 0;
           printf("Please enter a number to check Palindrome : ");
           scanf("%d",number);
           printf("Entered number: %d", number);

           t = number;

           do
           {
              rmndr = number%10;
              rev = rev*10 + rmndr;
              number = number/10;
           } while (number > 0);
           printf("Reversed number: %d", rev);

           if(t == rev)
           {
              printf("Entered number %d is a palindrome", t);
           }
           else
           {
              printf("Entered number %d is not a palindrome", t);
           }
           return 0;
        }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(VarDecl(Id("number"),IntType),VarDecl(Id("t"),IntType),VarDecl(Id("rev"),IntType),VarDecl(Id("rmndr"),IntType)),List(BinaryOp("=",Id("rev"),IntLiteral(0)),CallExpr(Id("printf"),List(StringLiteral("Please enter a number to check Palindrome : "))),CallExpr(Id("scanf"),List(StringLiteral("%d"),Id("number"))),CallExpr(Id("printf"),List(StringLiteral("Entered number: %d"),Id("number"))),BinaryOp("=",Id("t"),Id("number")),Dowhile(List(Block(List(),List(BinaryOp("=",Id("rmndr"),BinaryOp("%",Id("number"),IntLiteral(10))),BinaryOp("=",Id("rev"),BinaryOp("+",BinaryOp("*",Id("rev"),IntLiteral(10)),Id("rmndr"))),BinaryOp("=",Id("number"),BinaryOp("/",Id("number"),IntLiteral(10)))))),BinaryOp(">",Id("number"),IntLiteral(0))),CallExpr(Id("printf"),List(StringLiteral("Reversed number: %d"),Id("rev"))),If(BinaryOp("==",Id("t"),Id("rev")),Block(List(),List(CallExpr(Id("printf"),List(StringLiteral("Entered number %d is a palindrome"),Id("t"))))),Some(Block(List(),List(CallExpr(Id("printf"),List(StringLiteral("Entered number %d is not a palindrome"),Id("t"))))))),Return(Some(IntLiteral(0))))))))
    assert(checkAst(input,expected,293))
  }

  test("a for 294") {
    val input =
      """
        int main()
       {
          string str[5], i;
          i=0;
          int str_len;

          printf("Please enter a word to check Palindrome : ");
          scanf("%s",str);
          printf("Entered word: %s", str);

          do
          {
             str_len = strlen(str) - (i+1);

             if (str[i] == str[str_len])
             {
                if (i == str_len || i+1 == str_len)
                {
                   printf("Entered word %s is a palindrome", str);
                   break;
                }
                i = i+1;
             }
             else
             {
                printf("Entered word %s is not a palindrome", str);
                break;
             }
          } while(1);
          return 0;
       }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(VarDecl(Id("str"),ArrayType(IntLiteral(5),StringType)),VarDecl(Id("i"),StringType),VarDecl(Id("str_len"),IntType)),List(BinaryOp("=",Id("i"),IntLiteral(0)),CallExpr(Id("printf"),List(StringLiteral("Please enter a word to check Palindrome : "))),CallExpr(Id("scanf"),List(StringLiteral("%s"),Id("str"))),CallExpr(Id("printf"),List(StringLiteral("Entered word: %s"),Id("str"))),Dowhile(List(Block(List(),List(BinaryOp("=",Id("str_len"),BinaryOp("-",CallExpr(Id("strlen"),List(Id("str"))),BinaryOp("+",Id("i"),IntLiteral(1)))),If(BinaryOp("==",ArrayCell(Id("str"),Id("i")),ArrayCell(Id("str"),Id("str_len"))),Block(List(),List(If(BinaryOp("||",BinaryOp("==",Id("i"),Id("str_len")),BinaryOp("==",BinaryOp("+",Id("i"),IntLiteral(1)),Id("str_len"))),Block(List(),List(CallExpr(Id("printf"),List(StringLiteral("Entered word %s is a palindrome"),Id("str"))),Break)),None),BinaryOp("=",Id("i"),BinaryOp("+",Id("i"),IntLiteral(1))))),Some(Block(List(),List(CallExpr(Id("printf"),List(StringLiteral("Entered word %s is not a palindrome"),Id("str"))),Break))))))),IntLiteral(1)),Return(Some(IntLiteral(0))))))))
    assert(checkAst(input,expected,294))
  }

  test("a for 295") {
    val input =
      """
        int main(){

             float a, b, c;

             printf("Please enter 3 numbers:");

             scanf("%f %f %f", a, b, c);

             if(a>=b && a>=c)

                printf("The largest number is %f", a);

             if(b>=a && b>=c)

                printf("The largest number is %f", b);

             if(c>=a && c>=b)

                printf("The largest number is %f", c);

             return 0;

       }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(VarDecl(Id("a"),FloatType),VarDecl(Id("b"),FloatType),VarDecl(Id("c"),FloatType)),List(CallExpr(Id("printf"),List(StringLiteral("Please enter 3 numbers:"))),CallExpr(Id("scanf"),List(StringLiteral("%f %f %f"),Id("a"),Id("b"),Id("c"))),If(BinaryOp("&&",BinaryOp(">=",Id("a"),Id("b")),BinaryOp(">=",Id("a"),Id("c"))),CallExpr(Id("printf"),List(StringLiteral("The largest number is %f"),Id("a"))),None),If(BinaryOp("&&",BinaryOp(">=",Id("b"),Id("a")),BinaryOp(">=",Id("b"),Id("c"))),CallExpr(Id("printf"),List(StringLiteral("The largest number is %f"),Id("b"))),None),If(BinaryOp("&&",BinaryOp(">=",Id("c"),Id("a")),BinaryOp(">=",Id("c"),Id("b"))),CallExpr(Id("printf"),List(StringLiteral("The largest number is %f"),Id("c"))),None),Return(Some(IntLiteral(0))))))))
    assert(checkAst(input,expected,295))
  }

  test("a for 296") {
    val input =
      """
        int main()

         {

           int a,b,c, sum;

           float d;

           printf("Please enter 3 numbers");

           scanf("%d%d%d",a,b,c);

           sum=a+b+c;

           d=(a+b+c)/3;

           printf("Sum is %d", sum);

           printf("Average is  %f",d);

           return 0;

         }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),IntType),VarDecl(Id("c"),IntType),VarDecl(Id("sum"),IntType),VarDecl(Id("d"),FloatType)),List(CallExpr(Id("printf"),List(StringLiteral("Please enter 3 numbers"))),CallExpr(Id("scanf"),List(StringLiteral("%d%d%d"),Id("a"),Id("b"),Id("c"))),BinaryOp("=",Id("sum"),BinaryOp("+",BinaryOp("+",Id("a"),Id("b")),Id("c"))),BinaryOp("=",Id("d"),BinaryOp("/",BinaryOp("+",BinaryOp("+",Id("a"),Id("b")),Id("c")),IntLiteral(3))),CallExpr(Id("printf"),List(StringLiteral("Sum is %d"),Id("sum"))),CallExpr(Id("printf"),List(StringLiteral("Average is  %f"),Id("d"))),Return(Some(IntLiteral(0))))))))
    assert(checkAst(input,expected,296))
  }

  test("a for 297") {
    val input =
      """
        int main()

        {

           int n, rev;
           rev = 0;

           printf("Please enter a number to reverse");

           scanf("%d",n);



           do
           {

              rev = rev * 10;

              rev = rev + n%10;

              n = n/10;

           } while (n != 0);



           printf("The reverse of entered number is %d", rev);

           return 0;

        }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(VarDecl(Id("n"),IntType),VarDecl(Id("rev"),IntType)),List(BinaryOp("=",Id("rev"),IntLiteral(0)),CallExpr(Id("printf"),List(StringLiteral("Please enter a number to reverse"))),CallExpr(Id("scanf"),List(StringLiteral("%d"),Id("n"))),Dowhile(List(Block(List(),List(BinaryOp("=",Id("rev"),BinaryOp("*",Id("rev"),IntLiteral(10))),BinaryOp("=",Id("rev"),BinaryOp("+",Id("rev"),BinaryOp("%",Id("n"),IntLiteral(10)))),BinaryOp("=",Id("n"),BinaryOp("/",Id("n"),IntLiteral(10)))))),BinaryOp("!=",Id("n"),IntLiteral(0))),CallExpr(Id("printf"),List(StringLiteral("The reverse of entered number is %d"),Id("rev"))),Return(Some(IntLiteral(0))))))))
    assert(checkAst(input,expected,297))
  }

  test("a for 298") {
    val input =
      """
        int factorial(int a){}
        int  main()
        {
            int i = 8;
            printf("Factorial of the number %d is %d", i, factorial(i));
            return 0;
        }
        int factorial( int i)
        {
           if(i < 2)
           {
              return 1;
           }
           return i * factorial(i - 1);
        }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("factorial"),List(VarDecl(Id("a"),IntType)),IntType,Block(List(),List())),FuncDecl(Id("main"),List(),IntType,Block(List(VarDecl(Id("i"),IntType)),List(CallExpr(Id("printf"),List(StringLiteral("Factorial of the number %d is %d"),Id("i"),CallExpr(Id("factorial"),List(Id("i"))))),Return(Some(IntLiteral(0)))))),FuncDecl(Id("factorial"),List(VarDecl(Id("i"),IntType)),IntType,Block(List(),List(If(BinaryOp("<",Id("i"),IntLiteral(2)),Block(List(),List(Return(Some(IntLiteral(1))))),None),Return(Some(BinaryOp("*",Id("i"),CallExpr(Id("factorial"),List(BinaryOp("-",Id("i"),IntLiteral(1))))))))))))
    assert(checkAst(input,expected,298))
  }

  test("a for 299") {
    val input =
      """
        int main() {
           float radius, area;

           printf("Enter the radius of Circle : ");
           scanf("%d", radius);

           area = 3.14 * radius * radius;
           printf("Area of Circle : %f", area);

           return (0);
        }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(VarDecl(Id("radius"),FloatType),VarDecl(Id("area"),FloatType)),List(CallExpr(Id("printf"),List(StringLiteral("Enter the radius of Circle : "))),CallExpr(Id("scanf"),List(StringLiteral("%d"),Id("radius"))),BinaryOp("=",Id("area"),BinaryOp("*",BinaryOp("*",FloatLiteral(3.14.toFloat),Id("radius")),Id("radius"))),CallExpr(Id("printf"),List(StringLiteral("Area of Circle : %f"),Id("area"))),Return(Some(IntLiteral(0))))))))
    assert(checkAst(input,expected,299))
  }

  test("a for 300") {
    val input =
      """
        int main() {
          int a, b, c;
          printf("Enter value of a, b & c : ");
          scanf("%d %d %d", a, b, c);

          if ((a > b) && (a > c))
             printf("a is greatest");

          if ((b > c) && (b > a))
             printf("b is greatest");

          if ((c > a) && (c > b))
             printf("c is greatest");

          return(0);
       }
      """.stripMargin
    val expected = Program(List(FuncDecl(Id("main"),List(),IntType,Block(List(VarDecl(Id("a"),IntType),VarDecl(Id("b"),IntType),VarDecl(Id("c"),IntType)),List(CallExpr(Id("printf"),List(StringLiteral("Enter value of a, b & c : "))),CallExpr(Id("scanf"),List(StringLiteral("%d %d %d"),Id("a"),Id("b"),Id("c"))),If(BinaryOp("&&",BinaryOp(">",Id("a"),Id("b")),BinaryOp(">",Id("a"),Id("c"))),CallExpr(Id("printf"),List(StringLiteral("a is greatest"))),None),If(BinaryOp("&&",BinaryOp(">",Id("b"),Id("c")),BinaryOp(">",Id("b"),Id("a"))),CallExpr(Id("printf"),List(StringLiteral("b is greatest"))),None),If(BinaryOp("&&",BinaryOp(">",Id("c"),Id("a")),BinaryOp(">",Id("c"),Id("b"))),CallExpr(Id("printf"),List(StringLiteral("c is greatest"))),None),Return(Some(IntLiteral(0))))))))
    assert(checkAst(input,expected,300))
  }




}
