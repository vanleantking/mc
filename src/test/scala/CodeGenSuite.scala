import org.scalatest.FunSuite

/**
  * Created by nhphung on 4/30/17.
  */
class CodeGenSuite extends FunSuite with TestCodeGen {
//  test("simple program => print 5") {
//    val input = "void main () {putIntLn(5);}"
//    val expected = "5"
//    assert(checkCode(input,expected,501))
//  }
//  test("another simple program => print 125") {
//    val input = "void main () {putIntLn(125);}"
//    val expected = "125"
//    assert(checkCode(input,expected,502))
//  }
//  test("special program => print 0") {
//    val input = "void main () {putIntLn(004);}"
//    val expected = "4"
//    assert(checkCode(input,expected,503))
//  }
//
//  test("504") {
//    val input = "void main () {putFloatLn(1.2);}"
//    val expected = "1.2"
//    assert(checkCode(input,expected,504))
//  }
//
//  test("505") {
//    val input = "void main () {putFloatLn(1000.2);}"
//    val expected = "1000.2"
//    assert(checkCode(input,expected,505))
//  }
//
//  test("506") {
//    val input = "void main () {putBool(true);}"
//    val expected = "true"
//    assert(checkCode(input,expected,506))
//  }
//
//  test("507") {
//    val input = "void main () {putBool(false);}"
//    val expected = "false"
//    assert(checkCode(input,expected,507))
//  }

  test("508") {
    val input = "void main () {putStringLn(\"abcd\");}"
    val expected = "false"
    assert(checkCode(input,expected,508))
  }


//  test("special program => print 0") {
//    val input = "void abc(int a){} void main () {putIntLn(004);}"
//    val expected = "4"
//    assert(checkCode(input,expected,504))
//  }
}
