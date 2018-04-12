//import org.scalatest.FunSuite
//
///**
//  * Created by nhphung on 4/28/17.
//  */
//class LexerSuite extends FunSuite with TestLexer {
//
//  test("a simple identifier") {
//    val input = "abc"
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,1))
//  }
//  test("half function declare") {
//    val input = "main int {"
//    val expect = """IDENTIFIERS,INT,LP,EOF"""
//    assert(checkLex(input,expect,2))
//  }
//  test("open and close parentheses"){
//    val input = "} int main {"
//    val expect = """RP,INT,IDENTIFIERS,LP,EOF"""
//    assert(checkLex(input,expect,3))
//  }
//
//  test("test block comment"){
//    val input = "/* this is comment */"
//    val expect = """EOF"""
//    assert(checkLex(input,expect,4))
//  }
//
//  test("test block and new line comment"){
//    val input = """/* this is
//      new line
//      comment*/"""
//    val expect = """EOF"""
//    assert(checkLex(input,expect,5))
//  }
//
//  test("test line comment"){
//    val input = "//this is comment"
//    val expect = """EOF"""
//    assert(checkLex(input,expect,6))
//  }
//
//  test("test block comment mix lexer"){
//    val input = """/* this is block comment */
//      int abc()"""
//    val expect = """INT,IDENTIFIERS,LB,RB,EOF"""
//    assert(checkLex(input,expect,7))
//  }
//
//  test("test line mix block comment"){
//    val input = "/* //this is comment */"
//    val expect = """EOF"""
//    assert(checkLex(input,expect,8))
//  }
//
//  test("test index array type"){
//    val input = "a[4]"
//    val expect = """IDENTIFIERS,LSB,INTLIT,RSB,EOF"""
//    assert(checkLex(input,expect,9))
//  }
//
//  test("test add op index array type"){
//    val input = "a[4]++b[3]+v[2]"
//    val expect = """IDENTIFIERS,LSB,INTLIT,RSB,ADD,ADD,IDENTIFIERS,LSB,INTLIT,RSB,ADD,IDENTIFIERS,LSB,INTLIT,RSB,EOF"""
//    assert(checkLex(input,expect,10))
//  }
//
//  test("test keyword mix string"){
//    val input = "abcfor"
//    val expect = """IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,11))
//  }
//
//  test("test int mix string"){
//    val input = "0x12ABaD"
//    val expect = """INTLIT,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,12))
//  }
//
//  test("test hexa number mix string"){
//    val input = "0x12ABaDvvyh"
//    val expect = """INTLIT,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,13))
//  }
//
//  test("test float number with dec part"){
//    val input = "1.3"
//    val expect = """FLOAT_LITERAL,EOF"""
//    assert(checkLex(input,expect,14))
//  }
//
//  test("test float with ex part"){
//    val input = "1.3e435"
//    val expect = """FLOAT_LITERAL,EOF"""
//    assert(checkLex(input,expect,15))
//  }
//
//  test("test float number full part"){
//    val input = "1.3e-12"
//    val expect = """FLOAT_LITERAL,EOF"""
//    assert(checkLex(input,expect,16))
//  }
//
//  test("test operator"){
//    val input = "a||b==c"
//    val expect = """IDENTIFIERS,OR,IDENTIFIERS,EQU,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,17))
//  }
//
//  test("test compare"){
//    val input = "a>=c"
//    val expect = """IDENTIFIERS,GE,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,18))
//  }
//
//  test("test bracket operator"){
//    val input = "a*(b+c/(d+c))"
//    val expect = """IDENTIFIERS,MUL,LB,IDENTIFIERS,ADD,IDENTIFIERS,FDIV,LB,IDENTIFIERS,ADD,IDENTIFIERS,RB,RB,EOF"""
//    assert(checkLex(input,expect,19))
//  }
//
//  test("test assignment express"){
//    val input = "foo(2)[3+x] = a[b[2]] +3"
//    val expect = """IDENTIFIERS,LB,INTLIT,RB,LSB,INTLIT,ADD,IDENTIFIERS,RSB,ASSIGN,IDENTIFIERS,LSB,IDENTIFIERS,LSB,INTLIT,RSB,RSB,ADD,INTLIT,EOF"""
//    assert(checkLex(input,expect,20))
//  }
//
//  test("test return express"){
//    val input = "return a[4]+3;"
//    val expect = """RETURN,IDENTIFIERS,LSB,INTLIT,RSB,ADD,INTLIT,SEMI,EOF"""
//    assert(checkLex(input,expect,21))
//  }
//
//  test("test if statement"){
//    val input = "if(true) a=b+c"
//    val expect = """IF,LB,BOOLEAN_LITERAL,RB,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,22))
//  }
//
//  test("test break"){
//    val input = "break;"
//    val expect = """BREAK,SEMI,EOF"""
//    assert(checkLex(input,expect,23))
//  }
//
//  test("test void main function"){
//    val input =
//      """void main() {
//        int a;
//        }"""
//    val expect = """VOID,IDENTIFIERS,LB,RB,LP,INT,IDENTIFIERS,SEMI,RP,EOF"""
//    assert(checkLex(input,expect,24))
//  }
//
//  test("test for statement"){
//    val input = "for(i;i<3;i=i+1) a=b+a;"
//    val expect =
//      """FOR,LB,IDENTIFIERS,SEMI,IDENTIFIERS,LT,INTLIT,SEMI,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,INTLIT,RB,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SEMI,EOF"""
//    assert(checkLex(input,expect,25))
//  }
//
//  test("test var declare"){
//    val input = "int a[];"
//    val expect =
//      """INT,IDENTIFIERS,LSB,RSB,SEMI,EOF"""
//    assert(checkLex(input,expect,26))
//  }
//
//  test("test array with size declare"){
//    val input = "int a[6];"
//    val expect =
//      """INT,IDENTIFIERS,LSB,INTLIT,RSB,SEMI,EOF"""
//    assert(checkLex(input,expect,27))
//  }
//
//  test("test many variables declare"){
//    val input = "int i,j,k[5]"
//    val expect =
//      """INT,IDENTIFIERS,COMMA,IDENTIFIERS,COMMA,IDENTIFIERS,LSB,INTLIT,RSB,EOF"""
//    assert(checkLex(input,expect,28))
//  }
//
//  test("test function declare"){
//    val input = "int abc(){}"
//    val expect =
//      """INT,IDENTIFIERS,LB,RB,LP,RP,EOF"""
//    assert(checkLex(input,expect,29))
//  }
//
//  test("test function with parameters declare"){
//    val input = "int abc(int a, float b, int c[]){}"
//    val expect =
//      """INT,IDENTIFIERS,LB,INT,IDENTIFIERS,COMMA,FLOAT,IDENTIFIERS,COMMA,INT,IDENTIFIERS,LSB,RSB,RB,LP,RP,EOF"""
//    assert(checkLex(input,expect,30))
//  }
//
//  test("test function with parameters declare not complete"){
//    val input = "int abc(int ,){}"
//    val expect =
//      """INT,IDENTIFIERS,LB,INT,COMMA,RB,LP,RP,EOF"""
//    assert(checkLex(input,expect,31))
//  }
//
//  test("test variable declare not complete"){
//    val input = "int [],"
//    val expect =
//      """INT,LSB,RSB,COMMA,EOF"""
//    assert(checkLex(input,expect,32))
//  }
//
//  test("test if statement expr statement"){
//    val input = "if(3==3) c++;"
//    val expect =
//      """IF,LB,INTLIT,EQU,INTLIT,RB,IDENTIFIERS,ADD,ADD,SEMI,EOF"""
//    assert(checkLex(input,expect,33))
//  }
//
//  test("test if statement intlit statement"){
//    val input = "if(3) c++;"
//    val expect =
//      """IF,LB,INTLIT,RB,IDENTIFIERS,ADD,ADD,SEMI,EOF"""
//    assert(checkLex(input,expect,34))
//  }
//
//  test("test if statement identifiers statement"){
//    val input = "if(c) c++;"
//    val expect =
//      """IF,LB,IDENTIFIERS,RB,IDENTIFIERS,ADD,ADD,SEMI,EOF"""
//    assert(checkLex(input,expect,35))
//  }
//
//  test("test signed int"){
//    val input = "-12453"
//    val expect =
//      """SUB,INTLIT,EOF"""
//    assert(checkLex(input,expect,36))
//  }
//
//  test("test not signed integer"){
//    val input = "!-34"
//    val expect =
//      """NOT,SUB,INTLIT,EOF"""
//    assert(checkLex(input,expect,37))
//  }
//
//  test("test assign not signed integer"){
//    val input = "a=!b"
//    val expect =
//      """IDENTIFIERS,ASSIGN,NOT,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,38))
//  }
//
//  test("test assign expression"){
//    val input = "a=b+c--d"
//    val expect =
//      """IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SUB,SUB,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,39))
//  }
//
//  test("test assign function call"){
//    val input = "a=function()"
//    val expect =
//      """IDENTIFIERS,ASSIGN,IDENTIFIERS,LB,RB,EOF"""
//    assert(checkLex(input,expect,40))
//  }
//
//  test("test assign function call with parameters list"){
//    val input = "a=function(b,c)"
//    val expect =
//      """IDENTIFIERS,ASSIGN,IDENTIFIERS,LB,IDENTIFIERS,COMMA,IDENTIFIERS,RB,EOF"""
//    assert(checkLex(input,expect,41))
//  }
//
//  test("test return function call"){
//    val input = "return function(b,c)"
//    val expect =
//      """RETURN,IDENTIFIERS,LB,IDENTIFIERS,COMMA,IDENTIFIERS,RB,EOF"""
//    assert(checkLex(input,expect,42))
//  }
//
//  test("test function call statement"){
//    val input = "function(b,c);"
//    val expect =
//      """IDENTIFIERS,LB,IDENTIFIERS,COMMA,IDENTIFIERS,RB,SEMI,EOF"""
//    assert(checkLex(input,expect,43))
//  }
//
//  test("test function expression statement"){
//    val input = "i++;"
//    val expect =
//      """IDENTIFIERS,ADD,ADD,SEMI,EOF"""
//    assert(checkLex(input,expect,44))
//  }
//
//  test("test function do while empty statement"){
//    val input = "do while(1);"
//    val expect =
//      """DO,WHILE,LB,INTLIT,RB,SEMI,EOF"""
//    assert(checkLex(input,expect,45))
//  }
//
//  test("test function do while one statement"){
//    val input = "do c++; while(1);"
//    val expect =
//      """DO,IDENTIFIERS,ADD,ADD,SEMI,WHILE,LB,INTLIT,RB,SEMI,EOF"""
//    assert(checkLex(input,expect,46))
//  }
//
//  test("test function do while block statement"){
//    val input = "do a=b+c; c=g-v; while(1);"
//    val expect =
//      """DO,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SEMI,IDENTIFIERS,ASSIGN,IDENTIFIERS,SUB,IDENTIFIERS,SEMI,WHILE,LB,INTLIT,RB,SEMI,EOF"""
//    assert(checkLex(input,expect,47))
//  }
//
//  test("test function do while expr call for block statement"){
//    val input = "do a=b+c; c=g-v; while(func(a,b));"
//    val expect =
//      """DO,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SEMI,IDENTIFIERS,ASSIGN,IDENTIFIERS,SUB,IDENTIFIERS,SEMI,WHILE,LB,IDENTIFIERS,LB,IDENTIFIERS,COMMA,IDENTIFIERS,RB,RB,SEMI,EOF"""
//    assert(checkLex(input,expect,48))
//  }
//
//  test("test if else statement"){
//    val input = "if(true==false) a=b+c; else c=g-v;"
//    val expect =
//      """IF,LB,BOOLEAN_LITERAL,EQU,BOOLEAN_LITERAL,RB,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SEMI,ELSE,IDENTIFIERS,ASSIGN,IDENTIFIERS,SUB,IDENTIFIERS,SEMI,EOF"""
//    assert(checkLex(input,expect,49))
//  }
//
//  test("test if nested else  statement"){
//    val input = "if(true==false) a=b+c; else if(3==3) c=g-v; else c=g+v;"
//    val expect =
//      """IF,LB,BOOLEAN_LITERAL,EQU,BOOLEAN_LITERAL,RB,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SEMI,ELSE,IF,LB,INTLIT,EQU,INTLIT,RB,IDENTIFIERS,ASSIGN,IDENTIFIERS,SUB,IDENTIFIERS,SEMI,ELSE,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SEMI,EOF"""
//    assert(checkLex(input,expect,50))
//  }
//
//  test("test float div statement"){
//    val input = "a/b"
//    val expect =
//      """IDENTIFIERS,FDIV,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,51))
//  }
//
//  test("test nested block comment inside line comment"){
//    val input = """//this is a /*comment
//       and new line*/"""
//    val expect =
//      """IDENTIFIERS,IDENTIFIERS,IDENTIFIERS,MUL,FDIV,EOF"""
//    assert(checkLex(input,expect,52))
//  }
//
//  test("test string") {
//    val input = "\"this is a string \""
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,53))
//  }
//
//  test("test string with other escape") {
//    val input = "\"this is a string with other escape \b \' \' \""
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,54))
//  }
//
//  test("test string with tab") {
//    val input = "\"this is a string with other escape \t \""
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,55))
//  }
//
//  test("test string with nested string") {
//    val input = "\"this is a string with other escape \\\"hello world\\\" \""
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,56))
//  }
//
//  test("test string with back slash string") {
//    val input = "\"this is a string with other escape \\\\ \""
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,57))
//  }
//
//  test("test string with new line") {
//    val input = "\"this is a string with other escape \\n \""
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,58))
//  }
//
//  test("test float with empty zero") {
//    val input = ".1E2"
//    val expect = "FLOAT_LITERAL,EOF"
//    assert(checkLex(input,expect,59))
//  }
//
//  test("test float with non decimal") {
//    val input = "12e-2"
//    val expect = "FLOAT_LITERAL,EOF"
//    assert(checkLex(input,expect,60))
//  }
//
//  test("test int type with negative sign") {
//    val input = "-12"
//    val expect = "SUB,INTLIT,EOF"
//    assert(checkLex(input,expect,61))
//  }
//
//  test("test float type with negative sign") {
//    val input = "-12e-2"
//    val expect = "SUB,FLOAT_LITERAL,EOF"
//    assert(checkLex(input,expect,62))
//  }
//
//  test("test float type type with negative sign") {
//    val input = "!--12e-2"
//    val expect = "NOT,SUB,SUB,FLOAT_LITERAL,EOF"
//    assert(checkLex(input,expect,63))
//  }
//
//  test("test initial variable index array element") {
//    val input = "boolean b[3]={true,false};"
//    val expect = "BOOLEAN,IDENTIFIERS,LSB,INTLIT,RSB,ASSIGN,LP,BOOLEAN_LITERAL,COMMA,BOOLEAN_LITERAL,RP,SEMI,EOF"
//    assert(checkLex(input,expect,64))
//  }
//
//  test("test assign int") {
//    val input = "i=3;"
//    val expect = "IDENTIFIERS,ASSIGN,INTLIT,SEMI,EOF"
//    assert(checkLex(input,expect,65))
//  }
//
//  test("test index function return type") {
//    val input = "int[] foo(int b[])";
//    val expect = "INT,LSB,RSB,IDENTIFIERS,LB,INT,IDENTIFIERS,LSB,RSB,RB,EOF"
//    assert(checkLex(input,expect,66))
//  }
//
//  test("test logic oprerators") {
//    val input = "a=b&&c||d";
//    val expect = "IDENTIFIERS,ASSIGN,IDENTIFIERS,AND,IDENTIFIERS,OR,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,67))
//  }
//
//  test("test return and operation") {
//    val input = "return b&&c||d;";
//    val expect = "RETURN,IDENTIFIERS,AND,IDENTIFIERS,OR,IDENTIFIERS,SEMI,EOF"
//    assert(checkLex(input,expect,68))
//  }
//
//  test("test return sub mix add expression") {
//    val input = "return b+--d;";
//    val expect = "RETURN,IDENTIFIERS,ADD,SUB,SUB,IDENTIFIERS,SEMI,EOF"
//    assert(checkLex(input,expect,69))
//  }
//
//  test("test for keyword and expression") {
//    val input = "() for d--;";
//    val expect = "LB,RB,FOR,IDENTIFIERS,SUB,SUB,SEMI,EOF"
//    assert(checkLex(input,expect,70))
//  }
//
//  test("test break statement") {
//    val input = "break;";
//    val expect = "BREAK,SEMI,EOF"
//    assert(checkLex(input,expect,71))
//  }
//
//  test("continue") {
//    val input = "continue;";
//    val expect = "CONTINUE,SEMI,EOF"
//    assert(checkLex(input,expect,72))
//  }
//
//  test("test multiple ") {
//    val input = "() for d--;";
//    val expect = "LB,RB,FOR,IDENTIFIERS,SUB,SUB,SEMI,EOF"
//    assert(checkLex(input,expect,73))
//  }
//
//  test("test declare error") {
//    val input = "static a,b,d: int;";
//    val expect = "IDENTIFIERS,IDENTIFIERS,COMMA,IDENTIFIERS,COMMA,IDENTIFIERS,COLON,INT,SEMI,EOF"
//    assert(checkLex(input,expect,74))
//  }
//
//  test("test void dunction") {
//    val input = "void foo(int a[]){}";
//    val expect = "VOID,IDENTIFIERS,LB,INT,IDENTIFIERS,LSB,RSB,RB,LP,RP,EOF"
//    assert(checkLex(input,expect,75))
//  }
//
//  test("test list declare variable") {
//    val input =
//      """int a[];
//        int b,c;
//        boolean d;
//      """
//    val expect = "INT,IDENTIFIERS,LSB,RSB,SEMI,INT,IDENTIFIERS,COMMA,IDENTIFIERS,SEMI,BOOLEAN,IDENTIFIERS,SEMI,EOF"
//    assert(checkLex(input,expect,76))
//  }
//
//  test("test multiple assign") {
//    val input = "a=b==2";
//    val expect = "IDENTIFIERS,ASSIGN,IDENTIFIERS,EQU,INTLIT,EOF"
//    assert(checkLex(input,expect,77))
//  }
//
//  test("test if return") {
//    val input = "if() return a;";
//    val expect = "IF,LB,RB,RETURN,IDENTIFIERS,SEMI,EOF"
//    assert(checkLex(input,expect,78))
//  }
//
//  test("test int return") {
//    val input = "0a;";
//    val expect = "INTLIT,IDENTIFIERS,SEMI,EOF"
//    assert(checkLex(input,expect,79))
//  }
//
//  test("test int operators") {
//    val input = "-45>=0a";
//    val expect = "SUB,INTLIT,GE,INTLIT,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,80))
//  }
//
//  test("test prefix underscore") {
//    val input = "_Ab";
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,81))
//  }
//
//  test("test suffix underscore") {
//    val input = "trr_";
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,82))
//  }
//
//  test("test mix underscore") {
//    val input = "_trr_";
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,83))
//  }
//
//  test("test identifiers number suffix") {
//    val input = "ty89";
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,84))
//  }
//
//  test("test identifiers nultiple underscore") {
//    val input = "ty89_8yy_";
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,85))
//  }
//
//  test("test capital letter") {
//    val input = "ADDES";
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,86))
//  }
//
//  test("test empty string") {
//    val input = "\"\"";
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,87))
//  }
//
//  test("test block comment with line") {
//    val input = "/*comment block with //line */";
//    val expect = "EOF"
//    assert(checkLex(input,expect,88))
//  }
//
//  test("test float mix identifiers") {
//    val input = "1.5fe";
//    val expect = "FLOAT_LITERAL,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,89))
//  }
//
//  test("test float identifiers") {
//    val input = "1.5e";
//    val expect = "FLOAT_LITERAL,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,90))
//  }
//
//  test("test float sub identifiers") {
//    val input = "1.5e-e";
//    val expect = "FLOAT_LITERAL,IDENTIFIERS,SUB,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,91))
//  }
//
//  test("test float add identifiers") {
//    val input = "1.5e+e";
//    val expect = "FLOAT_LITERAL,IDENTIFIERS,ADD,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,92))
//  }
//
//
//  test("test no digit before e") {
//    val input = "e3-5";
//    val expect = "IDENTIFIERS,SUB,INTLIT,EOF"
//    assert(checkLex(input,expect,93))
//  }
//
//  test("test float add identifiers with E") {
//    val input = "1.5E+e";
//    val expect = "FLOAT_LITERAL,IDENTIFIERS,ADD,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,94))
//  }
//
//  test("test float sub identifiers with E") {
//    val input = "1.5E-e";
//    val expect = "FLOAT_LITERAL,IDENTIFIERS,SUB,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,95))
//  }
//
//  test("test no digit before E") {
//    val input = "E3-5";
//    val expect = "IDENTIFIERS,SUB,INTLIT,EOF"
//    assert(checkLex(input,expect,96))
//  }
//
//  test("test no digit before dot sub") {
//    val input = "3.3e3-5";
//    val expect = "FLOAT_LITERAL,SUB,INTLIT,EOF"
//    assert(checkLex(input,expect,97))
//  }
//
//  test("test no digit before dot add") {
//    val input = "2.e34+5";
//    val expect = "FLOAT_LITERAL,ADD,INTLIT,EOF"
//    assert(checkLex(input,expect,98))
//  }
//
//  test("test no digit before dot sub with E") {
//    val input = ".E34-5";
//    val expect = "ErrorToken ."
//    assert(checkLex(input,expect,99))
//  }
//
//  test("test block comment in line comment with escape") {
//    val input = "//line comment and /*block comment*/ with escape //t ";
//    val expect = "EOF"
//    assert(checkLex(input,expect,100))
//  }
//}import org.scalatest.FunSuite
//
///**
//  * Created by nhphung on 4/28/17.
//  */
//class LexerSuite extends FunSuite with TestLexer {
//
//  test("a simple identifier") {
//    val input = "abc"
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,1))
//  }
//  test("half function declare") {
//    val input = "main int {"
//    val expect = """IDENTIFIERS,INT,LP,EOF"""
//    assert(checkLex(input,expect,2))
//  }
//  test("open and close parentheses"){
//    val input = "} int main {"
//    val expect = """RP,INT,IDENTIFIERS,LP,EOF"""
//    assert(checkLex(input,expect,3))
//  }
//
//  test("test block comment"){
//    val input = "/* this is comment */"
//    val expect = """EOF"""
//    assert(checkLex(input,expect,4))
//  }
//
//  test("test block and new line comment"){
//    val input = """/* this is
//      new line
//      comment*/"""
//    val expect = """EOF"""
//    assert(checkLex(input,expect,5))
//  }
//
//  test("test line comment"){
//    val input = "//this is comment"
//    val expect = """EOF"""
//    assert(checkLex(input,expect,6))
//  }
//
//  test("test block comment mix lexer"){
//    val input = """/* this is block comment */
//      int abc()"""
//    val expect = """INT,IDENTIFIERS,LB,RB,EOF"""
//    assert(checkLex(input,expect,7))
//  }
//
//  test("test line mix block comment"){
//    val input = "/* //this is comment */"
//    val expect = """EOF"""
//    assert(checkLex(input,expect,8))
//  }
//
//  test("test index array type"){
//    val input = "a[4]"
//    val expect = """IDENTIFIERS,LSB,INTLIT,RSB,EOF"""
//    assert(checkLex(input,expect,9))
//  }
//
//  test("test add op index array type"){
//    val input = "a[4]++b[3]+v[2]"
//    val expect = """IDENTIFIERS,LSB,INTLIT,RSB,ADD,ADD,IDENTIFIERS,LSB,INTLIT,RSB,ADD,IDENTIFIERS,LSB,INTLIT,RSB,EOF"""
//    assert(checkLex(input,expect,10))
//  }
//
//  test("test keyword mix string"){
//    val input = "abcfor"
//    val expect = """IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,11))
//  }
//
//  test("test int mix string"){
//    val input = "0x12ABaD"
//    val expect = """INTLIT,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,12))
//  }
//
//  test("test hexa number mix string"){
//    val input = "0x12ABaDvvyh"
//    val expect = """INTLIT,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,13))
//  }
//
//  test("test float number with dec part"){
//    val input = "1.3"
//    val expect = """FLOAT_LITERAL,EOF"""
//    assert(checkLex(input,expect,14))
//  }
//
//  test("test float with ex part"){
//    val input = "1.3e435"
//    val expect = """FLOAT_LITERAL,EOF"""
//    assert(checkLex(input,expect,15))
//  }
//
//  test("test float number full part"){
//    val input = "1.3e-12"
//    val expect = """FLOAT_LITERAL,EOF"""
//    assert(checkLex(input,expect,16))
//  }
//
//  test("test operator"){
//    val input = "a||b==c"
//    val expect = """IDENTIFIERS,OR,IDENTIFIERS,EQU,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,17))
//  }
//
//  test("test compare"){
//    val input = "a>=c"
//    val expect = """IDENTIFIERS,GE,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,18))
//  }
//
//  test("test bracket operator"){
//    val input = "a*(b+c/(d+c))"
//    val expect = """IDENTIFIERS,MUL,LB,IDENTIFIERS,ADD,IDENTIFIERS,FDIV,LB,IDENTIFIERS,ADD,IDENTIFIERS,RB,RB,EOF"""
//    assert(checkLex(input,expect,19))
//  }
//
//  test("test assignment express"){
//    val input = "foo(2)[3+x] = a[b[2]] +3"
//    val expect = """IDENTIFIERS,LB,INTLIT,RB,LSB,INTLIT,ADD,IDENTIFIERS,RSB,ASSIGN,IDENTIFIERS,LSB,IDENTIFIERS,LSB,INTLIT,RSB,RSB,ADD,INTLIT,EOF"""
//    assert(checkLex(input,expect,20))
//  }
//
//  test("test return express"){
//    val input = "return a[4]+3;"
//    val expect = """RETURN,IDENTIFIERS,LSB,INTLIT,RSB,ADD,INTLIT,SEMI,EOF"""
//    assert(checkLex(input,expect,21))
//  }
//
//  test("test if statement"){
//    val input = "if(true) a=b+c"
//    val expect = """IF,LB,BOOLEAN_LITERAL,RB,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,22))
//  }
//
//  test("test break"){
//    val input = "break;"
//    val expect = """BREAK,SEMI,EOF"""
//    assert(checkLex(input,expect,23))
//  }
//
//  test("test void main function"){
//    val input =
//      """void main() {
//        int a;
//        }"""
//    val expect = """VOID,IDENTIFIERS,LB,RB,LP,INT,IDENTIFIERS,SEMI,RP,EOF"""
//    assert(checkLex(input,expect,24))
//  }
//
//  test("test for statement"){
//    val input = "for(i;i<3;i=i+1) a=b+a;"
//    val expect =
//      """FOR,LB,IDENTIFIERS,SEMI,IDENTIFIERS,LT,INTLIT,SEMI,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,INTLIT,RB,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SEMI,EOF"""
//    assert(checkLex(input,expect,25))
//  }
//
//  test("test var declare"){
//    val input = "int a[];"
//    val expect =
//      """INT,IDENTIFIERS,LSB,RSB,SEMI,EOF"""
//    assert(checkLex(input,expect,26))
//  }
//
//  test("test array with size declare"){
//    val input = "int a[6];"
//    val expect =
//      """INT,IDENTIFIERS,LSB,INTLIT,RSB,SEMI,EOF"""
//    assert(checkLex(input,expect,27))
//  }
//
//  test("test many variables declare"){
//    val input = "int i,j,k[5]"
//    val expect =
//      """INT,IDENTIFIERS,COMMA,IDENTIFIERS,COMMA,IDENTIFIERS,LSB,INTLIT,RSB,EOF"""
//    assert(checkLex(input,expect,28))
//  }
//
//  test("test function declare"){
//    val input = "int abc(){}"
//    val expect =
//      """INT,IDENTIFIERS,LB,RB,LP,RP,EOF"""
//    assert(checkLex(input,expect,29))
//  }
//
//  test("test function with parameters declare"){
//    val input = "int abc(int a, float b, int c[]){}"
//    val expect =
//      """INT,IDENTIFIERS,LB,INT,IDENTIFIERS,COMMA,FLOAT,IDENTIFIERS,COMMA,INT,IDENTIFIERS,LSB,RSB,RB,LP,RP,EOF"""
//    assert(checkLex(input,expect,30))
//  }
//
//  test("test function with parameters declare not complete"){
//    val input = "int abc(int ,){}"
//    val expect =
//      """INT,IDENTIFIERS,LB,INT,COMMA,RB,LP,RP,EOF"""
//    assert(checkLex(input,expect,31))
//  }
//
//  test("test variable declare not complete"){
//    val input = "int [],"
//    val expect =
//      """INT,LSB,RSB,COMMA,EOF"""
//    assert(checkLex(input,expect,32))
//  }
//
//  test("test if statement expr statement"){
//    val input = "if(3==3) c++;"
//    val expect =
//      """IF,LB,INTLIT,EQU,INTLIT,RB,IDENTIFIERS,ADD,ADD,SEMI,EOF"""
//    assert(checkLex(input,expect,33))
//  }
//
//  test("test if statement intlit statement"){
//    val input = "if(3) c++;"
//    val expect =
//      """IF,LB,INTLIT,RB,IDENTIFIERS,ADD,ADD,SEMI,EOF"""
//    assert(checkLex(input,expect,34))
//  }
//
//  test("test if statement identifiers statement"){
//    val input = "if(c) c++;"
//    val expect =
//      """IF,LB,IDENTIFIERS,RB,IDENTIFIERS,ADD,ADD,SEMI,EOF"""
//    assert(checkLex(input,expect,35))
//  }
//
//  test("test signed int"){
//    val input = "-12453"
//    val expect =
//      """SUB,INTLIT,EOF"""
//    assert(checkLex(input,expect,36))
//  }
//
//  test("test not signed integer"){
//    val input = "!-34"
//    val expect =
//      """NOT,SUB,INTLIT,EOF"""
//    assert(checkLex(input,expect,37))
//  }
//
//  test("test assign not signed integer"){
//    val input = "a=!b"
//    val expect =
//      """IDENTIFIERS,ASSIGN,NOT,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,38))
//  }
//
//  test("test assign expression"){
//    val input = "a=b+c--d"
//    val expect =
//      """IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SUB,SUB,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,39))
//  }
//
//  test("test assign function call"){
//    val input = "a=function()"
//    val expect =
//      """IDENTIFIERS,ASSIGN,IDENTIFIERS,LB,RB,EOF"""
//    assert(checkLex(input,expect,40))
//  }
//
//  test("test assign function call with parameters list"){
//    val input = "a=function(b,c)"
//    val expect =
//      """IDENTIFIERS,ASSIGN,IDENTIFIERS,LB,IDENTIFIERS,COMMA,IDENTIFIERS,RB,EOF"""
//    assert(checkLex(input,expect,41))
//  }
//
//  test("test return function call"){
//    val input = "return function(b,c)"
//    val expect =
//      """RETURN,IDENTIFIERS,LB,IDENTIFIERS,COMMA,IDENTIFIERS,RB,EOF"""
//    assert(checkLex(input,expect,42))
//  }
//
//  test("test function call statement"){
//    val input = "function(b,c);"
//    val expect =
//      """IDENTIFIERS,LB,IDENTIFIERS,COMMA,IDENTIFIERS,RB,SEMI,EOF"""
//    assert(checkLex(input,expect,43))
//  }
//
//  test("test function expression statement"){
//    val input = "i++;"
//    val expect =
//      """IDENTIFIERS,ADD,ADD,SEMI,EOF"""
//    assert(checkLex(input,expect,44))
//  }
//
//  test("test function do while empty statement"){
//    val input = "do while(1);"
//    val expect =
//      """DO,WHILE,LB,INTLIT,RB,SEMI,EOF"""
//    assert(checkLex(input,expect,45))
//  }
//
//  test("test function do while one statement"){
//    val input = "do c++; while(1);"
//    val expect =
//      """DO,IDENTIFIERS,ADD,ADD,SEMI,WHILE,LB,INTLIT,RB,SEMI,EOF"""
//    assert(checkLex(input,expect,46))
//  }
//
//  test("test function do while block statement"){
//    val input = "do a=b+c; c=g-v; while(1);"
//    val expect =
//      """DO,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SEMI,IDENTIFIERS,ASSIGN,IDENTIFIERS,SUB,IDENTIFIERS,SEMI,WHILE,LB,INTLIT,RB,SEMI,EOF"""
//    assert(checkLex(input,expect,47))
//  }
//
//  test("test function do while expr call for block statement"){
//    val input = "do a=b+c; c=g-v; while(func(a,b));"
//    val expect =
//      """DO,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SEMI,IDENTIFIERS,ASSIGN,IDENTIFIERS,SUB,IDENTIFIERS,SEMI,WHILE,LB,IDENTIFIERS,LB,IDENTIFIERS,COMMA,IDENTIFIERS,RB,RB,SEMI,EOF"""
//    assert(checkLex(input,expect,48))
//  }
//
//  test("test if else statement"){
//    val input = "if(true==false) a=b+c; else c=g-v;"
//    val expect =
//      """IF,LB,BOOLEAN_LITERAL,EQU,BOOLEAN_LITERAL,RB,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SEMI,ELSE,IDENTIFIERS,ASSIGN,IDENTIFIERS,SUB,IDENTIFIERS,SEMI,EOF"""
//    assert(checkLex(input,expect,49))
//  }
//
//  test("test if nested else  statement"){
//    val input = "if(true==false) a=b+c; else if(3==3) c=g-v; else c=g+v;"
//    val expect =
//      """IF,LB,BOOLEAN_LITERAL,EQU,BOOLEAN_LITERAL,RB,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SEMI,ELSE,IF,LB,INTLIT,EQU,INTLIT,RB,IDENTIFIERS,ASSIGN,IDENTIFIERS,SUB,IDENTIFIERS,SEMI,ELSE,IDENTIFIERS,ASSIGN,IDENTIFIERS,ADD,IDENTIFIERS,SEMI,EOF"""
//    assert(checkLex(input,expect,50))
//  }
//
//  test("test float div statement"){
//    val input = "a/b"
//    val expect =
//      """IDENTIFIERS,FDIV,IDENTIFIERS,EOF"""
//    assert(checkLex(input,expect,51))
//  }
//
//  test("test nested block comment inside line comment"){
//    val input = """//this is a /*comment
//       and new line*/"""
//    val expect =
//      """IDENTIFIERS,IDENTIFIERS,IDENTIFIERS,MUL,FDIV,EOF"""
//    assert(checkLex(input,expect,52))
//  }
//
//  test("test string") {
//    val input = "\"this is a string \""
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,53))
//  }
//
//  test("test string with other escape") {
//    val input = "\"this is a string with other escape \b \' \' \""
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,54))
//  }
//
//  test("test string with tab") {
//    val input = "\"this is a string with other escape \t \""
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,55))
//  }
//
//  test("test string with nested string") {
//    val input = "\"this is a string with other escape \\\"hello world\\\" \""
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,56))
//  }
//
//  test("test string with back slash string") {
//    val input = "\"this is a string with other escape \\\\ \""
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,57))
//  }
//
//  test("test string with new line") {
//    val input = "\"this is a string with other escape \\n \""
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,58))
//  }
//
//  test("test float with empty zero") {
//    val input = ".1E2"
//    val expect = "FLOAT_LITERAL,EOF"
//    assert(checkLex(input,expect,59))
//  }
//
//  test("test float with non decimal") {
//    val input = "12e-2"
//    val expect = "FLOAT_LITERAL,EOF"
//    assert(checkLex(input,expect,60))
//  }
//
//  test("test int type with negative sign") {
//    val input = "-12"
//    val expect = "SUB,INTLIT,EOF"
//    assert(checkLex(input,expect,61))
//  }
//
//  test("test float type with negative sign") {
//    val input = "-12e-2"
//    val expect = "SUB,FLOAT_LITERAL,EOF"
//    assert(checkLex(input,expect,62))
//  }
//
//  test("test float type type with negative sign") {
//    val input = "!--12e-2"
//    val expect = "NOT,SUB,SUB,FLOAT_LITERAL,EOF"
//    assert(checkLex(input,expect,63))
//  }
//
//  test("test initial variable index array element") {
//    val input = "boolean b[3]={true,false};"
//    val expect = "BOOLEAN,IDENTIFIERS,LSB,INTLIT,RSB,ASSIGN,LP,BOOLEAN_LITERAL,COMMA,BOOLEAN_LITERAL,RP,SEMI,EOF"
//    assert(checkLex(input,expect,64))
//  }
//
//  test("test assign int") {
//    val input = "i=3;"
//    val expect = "IDENTIFIERS,ASSIGN,INTLIT,SEMI,EOF"
//    assert(checkLex(input,expect,65))
//  }
//
//  test("test index function return type") {
//    val input = "int[] foo(int b[])";
//    val expect = "INT,LSB,RSB,IDENTIFIERS,LB,INT,IDENTIFIERS,LSB,RSB,RB,EOF"
//    assert(checkLex(input,expect,66))
//  }
//
//  test("test logic oprerators") {
//    val input = "a=b&&c||d";
//    val expect = "IDENTIFIERS,ASSIGN,IDENTIFIERS,AND,IDENTIFIERS,OR,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,67))
//  }
//
//  test("test return and operation") {
//    val input = "return b&&c||d;";
//    val expect = "RETURN,IDENTIFIERS,AND,IDENTIFIERS,OR,IDENTIFIERS,SEMI,EOF"
//    assert(checkLex(input,expect,68))
//  }
//
//  test("test return sub mix add expression") {
//    val input = "return b+--d;";
//    val expect = "RETURN,IDENTIFIERS,ADD,SUB,SUB,IDENTIFIERS,SEMI,EOF"
//    assert(checkLex(input,expect,69))
//  }
//
//  test("test for keyword and expression") {
//    val input = "() for d--;";
//    val expect = "LB,RB,FOR,IDENTIFIERS,SUB,SUB,SEMI,EOF"
//    assert(checkLex(input,expect,70))
//  }
//
//  test("test break statement") {
//    val input = "break;";
//    val expect = "BREAK,SEMI,EOF"
//    assert(checkLex(input,expect,71))
//  }
//
//  test("continue") {
//    val input = "continue;";
//    val expect = "CONTINUE,SEMI,EOF"
//    assert(checkLex(input,expect,72))
//  }
//
//  test("test multiple ") {
//    val input = "() for d--;";
//    val expect = "LB,RB,FOR,IDENTIFIERS,SUB,SUB,SEMI,EOF"
//    assert(checkLex(input,expect,73))
//  }
//
//  test("test declare error") {
//    val input = "static a,b,d: int;";
//    val expect = "IDENTIFIERS,IDENTIFIERS,COMMA,IDENTIFIERS,COMMA,IDENTIFIERS,COLON,INT,SEMI,EOF"
//    assert(checkLex(input,expect,74))
//  }
//
//  test("test void dunction") {
//    val input = "void foo(int a[]){}";
//    val expect = "VOID,IDENTIFIERS,LB,INT,IDENTIFIERS,LSB,RSB,RB,LP,RP,EOF"
//    assert(checkLex(input,expect,75))
//  }
//
//  test("test list declare variable") {
//    val input =
//      """int a[];
//        int b,c;
//        boolean d;
//      """
//    val expect = "INT,IDENTIFIERS,LSB,RSB,SEMI,INT,IDENTIFIERS,COMMA,IDENTIFIERS,SEMI,BOOLEAN,IDENTIFIERS,SEMI,EOF"
//    assert(checkLex(input,expect,76))
//  }
//
//  test("test multiple assign") {
//    val input = "a=b==2";
//    val expect = "IDENTIFIERS,ASSIGN,IDENTIFIERS,EQU,INTLIT,EOF"
//    assert(checkLex(input,expect,77))
//  }
//
//  test("test if return") {
//    val input = "if() return a;";
//    val expect = "IF,LB,RB,RETURN,IDENTIFIERS,SEMI,EOF"
//    assert(checkLex(input,expect,78))
//  }
//
//  test("test int return") {
//    val input = "0a;";
//    val expect = "INTLIT,IDENTIFIERS,SEMI,EOF"
//    assert(checkLex(input,expect,79))
//  }
//
//  test("test int operators") {
//    val input = "-45>=0a";
//    val expect = "SUB,INTLIT,GE,INTLIT,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,80))
//  }
//
//  test("test prefix underscore") {
//    val input = "_Ab";
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,81))
//  }
//
//  test("test suffix underscore") {
//    val input = "trr_";
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,82))
//  }
//
//  test("test mix underscore") {
//    val input = "_trr_";
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,83))
//  }
//
//  test("test identifiers number suffix") {
//    val input = "ty89";
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,84))
//  }
//
//  test("test identifiers nultiple underscore") {
//    val input = "ty89_8yy_";
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,85))
//  }
//
//  test("test capital letter") {
//    val input = "ADDES";
//    val expect = "IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,86))
//  }
//
//  test("test empty string") {
//    val input = "\"\"";
//    val expect = "STRINGLIT,EOF"
//    assert(checkLex(input,expect,87))
//  }
//
//  test("test block comment with line") {
//    val input = "/*comment block with //line */";
//    val expect = "EOF"
//    assert(checkLex(input,expect,88))
//  }
//
//  test("test float mix identifiers") {
//    val input = "1.5fe";
//    val expect = "FLOAT_LITERAL,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,89))
//  }
//
//  test("test float identifiers") {
//    val input = "1.5e";
//    val expect = "FLOAT_LITERAL,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,90))
//  }
//
//  test("test float sub identifiers") {
//    val input = "1.5e-e";
//    val expect = "FLOAT_LITERAL,IDENTIFIERS,SUB,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,91))
//  }
//
//  test("test float add identifiers") {
//    val input = "1.5e+e";
//    val expect = "FLOAT_LITERAL,IDENTIFIERS,ADD,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,92))
//  }
//
//
//  test("test no digit before e") {
//    val input = "e3-5";
//    val expect = "IDENTIFIERS,SUB,INTLIT,EOF"
//    assert(checkLex(input,expect,93))
//  }
//
//  test("test float add identifiers with E") {
//    val input = "1.5E+e";
//    val expect = "FLOAT_LITERAL,IDENTIFIERS,ADD,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,94))
//  }
//
//  test("test float sub identifiers with E") {
//    val input = "1.5E-e";
//    val expect = "FLOAT_LITERAL,IDENTIFIERS,SUB,IDENTIFIERS,EOF"
//    assert(checkLex(input,expect,95))
//  }
//
//  test("test no digit before E") {
//    val input = "E3-5";
//    val expect = "IDENTIFIERS,SUB,INTLIT,EOF"
//    assert(checkLex(input,expect,96))
//  }
//
//  test("test no digit before dot sub") {
//    val input = "3.3e3-5";
//    val expect = "FLOAT_LITERAL,SUB,INTLIT,EOF"
//    assert(checkLex(input,expect,97))
//  }
//
//  test("test no digit before dot add") {
//    val input = "2.e34+5";
//    val expect = "FLOAT_LITERAL,ADD,INTLIT,EOF"
//    assert(checkLex(input,expect,98))
//  }
//
//  test("test no digit before dot sub with E") {
//    val input = ".E34-5";
//    val expect = "ErrorToken ."
//    assert(checkLex(input,expect,99))
//  }
//
//  test("test block comment in line comment with escape") {
//    val input = "//line comment and /*block comment*/ with escape //t ";
//    val expect = "EOF"
//    assert(checkLex(input,expect,100))
//  }
//}