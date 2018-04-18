//import org.scalatest.FunSuite
////
/////**
////  * Created by nhphung on 4/28/17.
////  */
//class ParserSuite  extends FunSuite with TestParser {
//
//  test("a simple program") {
//    val input = "int a () {}"
//    val expect = "sucessful"
//    assert(checkRec(input,expect,101))
//  }
//  test("more complex program") {
//    val input ="""int main () {
//	putIntLn(4);
//}"""
//    val expect ="sucessful"
//    assert(checkRec(input,expect,102))
//  }
//  test("wrong program"){
//    val input = "} int main {"
//    val expect = "Error on line 1 col 1: }"
//    assert(checkRec(input,expect,103))
//  }
//
//  test("test missing ) declare function ") {
//    val input = "int a( {}"
//    val expect = "Error on line 1 col 8: {"
//    assert(checkRec(input,expect,104))
//  }
//
//  test("test missing } function") {
//    val input = "int a() }"
//    val expect = "Error on line 1 col 9: }"
//    assert(checkRec(input,expect,105))
//  }
//
//  test("test missing function type") {
//    val input = "ss a() }"
//    val expect = "Error on line 1 col 1: ss"
//    assert(checkRec(input,expect,106))
//  }
//
//  test("test multiple function type") {
//    val input = "int a(){} int main(){}"
//    val expect = "sucessful"
//    assert(checkRec(input,expect,107))
//  }
//
//  test("test array pointer type") {
//    val input = "int[] a(){}"
//    val expect = "sucessful"
//    assert(checkRec(input,expect,108))
//  }
//
//  test("test array type function") {
//    val input = "int[5] a(){}"
//    val expect = "Error on line 1 col 5: 5"
//    assert(checkRec(input,expect,109))
//  }
//
//  test("test float type function") {
//    val input = "float a(){}"
//    val expect = "sucessful"
//    assert(checkRec(input,expect,110))
//  }
//
//  test("test boolean type function") {
//    val input = "boolean a(){}"
//    val expect = "sucessful"
//    assert(checkRec(input,expect,111))
//  }
//
//  test("test void type function") {
//    val input = "void a(){}"
//    val expect = "sucessful"
//    assert(checkRec(input,expect,112))
//  }
//
//  test("test void function error") {
//    val input = "void int(){}"
//    val expect = "Error on line 1 col 6: int"
//    assert(checkRec(input,expect,113))
//  }
//
//  test("test parameter with function error") {
//    val input = "void a(int a,){}"
//    val expect = "Error on line 1 col 14: )"
//    assert(checkRec(input,expect,114))
//  }
//
//  test("test list parameter function") {
//    val input = "void a(int a, float b){}"
//    val expect = "sucessful"
//    assert(checkRec(input,expect,115))
//  }
//
//  test("test list parameter function error") {
//    val input = "void a(int a,c, float b){}"
//    val expect = "Error on line 1 col 14: c"
//    assert(checkRec(input,expect,116))
//  }
//
//  test("test parameter array type function") {
//    val input = "void a(int a[]){}"
//    val expect = "sucessful"
//    assert(checkRec(input,expect,117))
//  }
//
//  test("test assignment") {
//    val input =
//      """void a(){
//         a=b;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,118))
//  }
//
//  test("test assignment failed") {
//    val input =
//      """void a(){
//         a=b
//        }"""
//    val expect = "Error on line 3 col 9: }"
//    assert(checkRec(input,expect,119))
//  }
//
//  test("test assignment with AND logic") {
//    val input =
//      """void a(){
//         a=b&&c;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,120))
//  }
//
//  test("test assignment with AND logic mix OR") {
//    val input =
//      """void a(){
//         a=b&&c||d;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,121))
//  }
//
//  test("test multi statement") {
//    val input =
//      """void a(){
//         a=b&&c||d;
//         b = v+d;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,122))
//  }
//
//  test("test statement unary sub") {
//    val input =
//      """void a(){
//         b = v--d;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,123))
//  }
//
//  test("test statement unary add") {
//    val input =
//      """void a(){
//         b = v++d;
//        }"""
//    val expect = "Error on line 2 col 16: +"
//    assert(checkRec(input,expect,124))
//  }
//
//  test("test function call with agrument") {
//    val input =
//      """void a(){
//         b = fun(a,g);
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,125))
//  }
//
//  test("test function call with intlit") {
//    val input =
//      """void a(){
//         b = fun(a,g) + 5;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,126))
//  }
//
//  test("test function call with expresion") {
//    val input =
//      """void a(){
//         b = fun(a,g) + g[6];
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,127))
//  }
//
//  test("test function call with complicated expresion") {
//    val input =
//      """void a(){
//         b = (fun(a,g) +- g[6])*fun2();
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,128))
//  }
//
//  test("test function call with complicated expresion array pointer") {
//    val input =
//      """void a(){
//         b = function(2)[3+x] + goo[3];
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,129))
//  }
//
//  test("test function call with complicated expresion div operator") {
//    val input =
//      """void a(){
//         b = function(2)[3+x] / goo[3];
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,130))
//  }
//
//  test("test function call with complicated expresion equal operator") {
//    val input =
//      """void a(){
//         b = function(2)[3+x] == goo[3];
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,131))
//  }
//
//  test("test function call with complicated expresion and operator") {
//    val input =
//      """void a(){
//         b = function(2)[3+x] && goo[3];
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,132))
//  }
//
//  test("test function call with complicated expresion equal and not operator") {
//    val input =
//      """void a(){
//         b = function(2)[3+x] && !goo[3];
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,133))
//  }
//
//  test("test if statement null condition") {
//    val input =
//      """void a(){
//        if() d;
//        }"""
//    val expect = "Error on line 2 col 12: )"
//    assert(checkRec(input,expect,134))
//  }
//
//  test("test if statement with int lit condition") {
//    val input =
//      """void a(){
//        if(3) d = d+5;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,135))
//  }
//
//  test("test if statement equal condition") {
//    val input =
//      """void a(){
//        if(s==f) d = d+5;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,136))
//  }
//
//  test("test if statement less condition") {
//    val input =
//      """void a(){
//        if(s<f) d = d+5;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,137))
//  }
//
//  test("test if statement greater condition") {
//    val input =
//      """void a(){
//        if(s>f) d = d+5;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,138))
//  }
//
//  test("test if statement ge condition") {
//    val input =
//      """void a(){
//        if(s>=f) d = d+5;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,139))
//  }
//
//  test("test if statement le condition") {
//    val input =
//      """void a(){
//        if(s<=f) d = d+5;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,140))
//  }
//
//  test("test if statement true condition") {
//    val input =
//      """void a(){
//        if(true) d = d+5;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,141))
//  }
//
//  test("test if statement else statement true condition") {
//    val input =
//      """void a(){
//        if(false) d = d+5; else d=d-5;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,142))
//  }
//
//  test("test if statement else nested if else statement true condition") {
//    val input =
//      """void a(){
//        if(d>5) d = d+5; else
//          if(d=5) d=d-5;
//          else d=0;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,143))
//  }
//
//  test("test for statement with null") {
//    val input =
//      """void a(){
//        for() --f;
//        }"""
//    val expect = "Error on line 2 col 13: )"
//    assert(checkRec(input,expect,144))
//  }
//
//  test("test for statement with expression") {
//    val input =
//      """void a(){
//        for(i=0;i<n;i=i+1) --f;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,145))
//  }
//
//  test("test for statement with nested if statement") {
//    val input =
//      """void a(){
//        for(i=0;i<n;i=i+1)
//          if(i==3) i=i+7;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,146))
//  }
//
//  test("test for statement with return statement") {
//    val input =
//      """void a(){
//        for(i=0;i<n;i=i+1)
//          if(i==3) return i;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,147))
//  }
//
//  test("test for statement with break statement") {
//    val input =
//      """void a(){
//        for(i=0;i<n;i=i+1)
//          if(i==3) break;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,148))
//  }
//
//  test("test for statement with continue statement") {
//    val input =
//      """void a(){
//        for(i=0;i<n;i=i+1)
//          if(i==3) continue;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,149))
//  }
//
//  test("test return null expression statement") {
//    val input =
//      """void a(){
//        return ;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,150))
//  }
//
//  test("test return intlit statement") {
//    val input =
//      """int a(){
//        return 5;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,151))
//  }
//
//  test("test return function call") {
//    val input =
//      """int a(){
//        return g(2);
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,152))
//  }
//
//  test("test return expression") {
//    val input =
//      """int a(){
//        return g(2) + foo(2)[4+f];
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,153))
//  }
//
//  test("test do while") {
//    val input =
//      """int a(){
//        do while(true);
//        }"""
//    val expect = "Error on line 2 col 12: while"
//    assert(checkRec(input,expect,154))
//  }
//
//  test("test do while one statement") {
//    val input =
//      """int a(){
//        do a = a+1; while(true);
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,155))
//  }
//
//  test("test do while multiple statement") {
//    val input =
//      """int a(){
//        do a = a+1; v=v-a; while(true);
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,156))
//  }
//
//  test("test do while block statement") {
//    val input =
//      """int a(){
//        do {a = a+1; v=v-a;} while(true);
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,157))
//  }
//
//  test("test do while empty block statement") {
//    val input =
//      """int a(){
//        do {} while(true);
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,158))
//  }
//
//  test("test do while empty block statement and line comment") {
//    val input =
//      """int a(){
//        do {
//        //comment
//        } while(true);
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,159))
//  }
//
//  test("test do while equal condition") {
//    val input =
//      """int a(){
//        do a = a+1; v=v-a; while r==3;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,160))
//  }
//
//  test("test do while great condition") {
//    val input =
//      """int a(){
//        do a = a+1; v=v-a; while r>3;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,161))
//  }
//
//  test("test do while less condition") {
//    val input =
//      """int a(){
//        do a = a+1; v=v-a; while r>3;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,162))
//  }
//
//  test("test do while ge condition") {
//    val input =
//      """int a(){
//        do a = a+1; v=v-a; while r>=3;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,163))
//  }
//
//  test("test do while le condition") {
//    val input =
//      """int a(){
//        do a = a+1; v=v-a; while r<=3;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,164))
//  }
//
//  test("test do while logical condition") {
//    val input =
//      """int a(){
//        do a = a+1; v=v-a; while a==b||c;
//        }"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,165))
//  }
//
//  test("test do while null condition") {
//    val input =
//      """int a(){
//        do a = a+1; v=v-a; while ;
//        }"""
//    val expect = "Error on line 2 col 34: ;"
//    assert(checkRec(input,expect,166))
//  }
//
//  test("test do while null statement") {
//    val input =
//      """int a(){
//        do ; while(1) ;
//        }"""
//    val expect = "Error on line 2 col 12: ;"
//    assert(checkRec(input,expect,167))
//  }
//
//  test("test declare parameters") {
//    val input =
//      """int a;"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,168))
//  }
//
//  test("test multiple declare parameters errors") {
//    val input =
//      """int a; float b"""
//    val expect = "Error on line 1 col 15: <EOF>"
//    assert(checkRec(input,expect,169))
//  }
//
//  test("test multiple variables") {
//    val input =
//      """int a[4],b,c; float b;"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,170))
//  }
//
//  test("test declare int error") {
//    val input =
//      """Int a; float b;"""
//    val expect = "Error on line 1 col 1: Int"
//    assert(checkRec(input,expect,171))
//  }
//
//  test("test declare string error") {
//    val input =
//      """StRing a; float b;"""
//    val expect = "Error on line 1 col 1: StRing"
//    assert(checkRec(input,expect,172))
//  }
//
//  test("test declare float error") {
//    val input =
//      """int a; Float b;"""
//    val expect = "Error on line 1 col 8: Float"
//    assert(checkRec(input,expect,173))
//  }
//
//  test("test init int") {
//    val input =
//      """int a=3; float b;"""
//    val expect = "Error on line 1 col 6: ="
//    assert(checkRec(input,expect,174))
//  }
//
//  test("test declare boolean error") {
//    val input =
//      """Boolean a; float b;"""
//    val expect = "Error on line 1 col 1: Boolean"
//    assert(checkRec(input,expect,175))
//  }
//
//  test("test declare boolean init error") {
//    val input =
//      """boolean a=true; float b;"""
//    val expect = "Error on line 1 col 10: ="
//    assert(checkRec(input,expect,176))
//  }
//
//  test("test declare boolean") {
//    val input =
//      """boolean a; float b;"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,177))
//  }
//
//  test("test declare variable mix function") {
//    val input =
//      """boolean a; float b() {};"""
//    val expect = "Error on line 1 col 24: ;"
//    assert(checkRec(input,expect,178))
//  }
//
//  test("test capital void function error") {
//    val input =
//      """boolean a; VOID b() {};"""
//    val expect = "Error on line 1 col 12: VOID"
//    assert(checkRec(input,expect,179))
//  }
//
//  test("test boolean function error") {
//    val input =
//      """BoOlean b() {};"""
//    val expect = "Error on line 1 col 1: BoOlean"
//    assert(checkRec(input,expect,180))
//  }
//
//  test("test expression condition if") {
//    val input =
//      """void func () {
//         if ((a + b) <  (c * d)) {} else {}}"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,181))
//  }
//
//  test("test multiple block statement do while") {
//    val input =
//      """void func () {
//         do {} {} while(1);"""
//    val expect = "Error on line 2 col 28: <EOF>"
//    assert(checkRec(input,expect,182))
//  }
//
//
//
//  test("test multiple block statement do while 3") {
//    val input =
//      """void func () {
//         do {{}{}} while(1);}"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,183))
//  }
//
//  test("test for statement null expressions") {
//    val input =
//      """void func () {
//         for(;;)"""
//    val expect = "Error on line 2 col 14: ;"
//    assert(checkRec(input,expect,184))
//  }
//
//  test("test multiple function") {
//    val input =
//      """float a() {a=b+c; int a; float a, b,j[6];}
//         void main(){z=z+1;u=(m+n)*g;return (b+c);}
//        """
//    val expect = "sucessful"
//    assert(checkRec(input,expect,185))
//  }
//
//  test("test declare in do while") {
//    val input =
//      """void func () {
//         do int a; while(1)"""
//    val expect = "Error on line 2 col 13: int"
//    assert(checkRec(input,expect,186))
//  }
//
//  test("test continue with expression") {
//    val input =
//      """void func () {
//         continue 5;"""
//    val expect = "Error on line 2 col 19: 5"
//    assert(checkRec(input,expect,187))
//  }
//
//  test("test break with expression") {
//    val input =
//      """void func () {
//         continue 5;"""
//    val expect = "Error on line 2 col 19: 5"
//    assert(checkRec(input,expect,188))
//  }
//
//  test("test null declare") {
//    val input =
//      """"""
//    val expect = "Error on line 1 col 1: <EOF>"
//    assert(checkRec(input,expect,189))
//  }
//
//  test("test multiple block statement do while gg") {
//    val input =
//      """void func () {
//         do {} {} while(1);}"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,190))
//  }
//
//  test("test multiple block statement do while return express") {
//    val input =
//      """void func () {
//         do {{return r;}} while(1);}"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,191))
//  }
//
//  test("test multiple block statement do while return null express") {
//    val input =
//      """void func () {
//         do {{return ;}} while(1);}"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,192))
//  }
//
//  test("test multiple block statement do while break") {
//    val input =
//      """void func () {
//         do {{break ;}} while(1);}"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,193))
//  }
//
//  test("test multiple block statement do while break success") {
//    val input =
//      """void func () {
//         do {{break ;}} while(1);}"""
//    val expect = "sucessful"
//    assert(checkRec(input,expect,194))
//  }
//
//  test("test multiple block statement do while break error") {
//    val input =
//      """void func () {
//         do {{break}{} while(1);}"""
//    val expect = "Error on line 2 col 20: }"
//    assert(checkRec(input,expect,195))
//  }
//
//  test("test multiple block statement do while break continue") {
//    val input =
//      """void func () {
//         do {{break ;}{continue;} while(1);}"""
//    val expect = "Error on line 2 col 35: while"
//    assert(checkRec(input,expect,196))
//  }
//
//  test("test for decrease i") {
//    val input =
//      """void func () {
//         for(;;-i)"""
//    val expect = "Error on line 2 col 14: ;"
//    assert(checkRec(input,expect,197))
//  }
//
//  test("test for declare i") {
//    val input =
//      """void func () {
//         for(;int i;)"""
//    val expect = "Error on line 2 col 14: ;"
//    assert(checkRec(input,expect,198))
//  }
//
//  test("test return statement with ()") {
//    val input =
//      """void func () {
//         return (b+c)-a"""
//    val expect = "Error on line 2 col 24: <EOF>"
//    assert(checkRec(input,expect,199))
//  }
//
//  test("test return statement logic") {
//    val input =
//      """boolean func () {
//         return a||b&&!c"""
//    val expect = "Error on line 2 col 25: <EOF>"
//    assert(checkRec(input,expect,200))
//  }
//
//}