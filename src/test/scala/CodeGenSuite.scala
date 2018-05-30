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
//
//  test("508") {
//    val input = "void main () {putStringLn(\"abcd\");}"
//    val expected = "abcd"
//    assert(checkCode(input,expected,508))
//  }
//
//  test("509") {
//    val input = "void main () {putIntLn(1+3);}"
//    val expected = "4"
//    assert(checkCode(input,expected,509))
//  }
//
//  test("510") {
//    val input = "void main () {putIntLn(1-3);}"
//    val expected = "-2"
//    assert(checkCode(input,expected,510))
//  }
//
//  test("511") {
//    val input = "void main () {putIntLn(1*3);}"
//    val expected = "3"
//    assert(checkCode(input,expected,511))
//  }
//
//  test("512") {
//    val input = "void main () {putIntLn(3/1);}"
//    val expected = "3"
//    assert(checkCode(input,expected,512))
//  }
//
//  test("513") {
//    val input = "void main () {putFloatLn(3.0-1.0);}"
//    val expected = "2.0"
//    assert(checkCode(input,expected,513))
//  }
//
//  test("514") {
//    val input = "void main () {putFloatLn(3.0+1.0);}"
//    val expected = "4.0"
//    assert(checkCode(input,expected,514))
//  }
//
//  test("515") {
//    val input = "void main () {putFloatLn(3.0*1.0);}"
//    val expected = "3.0"
//    assert(checkCode(input,expected,515))
//  }
//
//  test("516") {
//    val input = "void main () {putFloatLn(3.0/1.0);}"
//    val expected = "3.0"
//    assert(checkCode(input,expected,516))
//  }
//
//  test("517") {
//    val input = "void main () {putFloatLn(2.0+1);}"
//    val expected = "3.0"
//    assert(checkCode(input,expected,517))
//  }
//
//  test("518") {
//    val input = "void main () {putFloatLn(2+1.0);}"
//    val expected = "3.0"
//    assert(checkCode(input,expected,518))
//  }
//
//  test("519") {
//    val input = "void main () {putFloatLn(2-1.0);}"
//    val expected = "1.0"
//    assert(checkCode(input,expected,519))
//  }
//
//  test("520") {
//    val input = "void main () {putFloatLn(2.0-1);}"
//    val expected = "1.0"
//    assert(checkCode(input,expected,520))
//  }
//
//  test("521") {
//    val input = "void main () {putFloatLn(2.0*1);}"
//    val expected = "2.0"
//    assert(checkCode(input,expected,521))
//  }
//
//  test("522") {
//    val input = "void main () {putFloatLn(2*1.0);}"
//    val expected = "2.0"
//    assert(checkCode(input,expected,522))
//  }
//
//  test("523") {
//    val input = "void main () {putFloatLn(2.0/1);}"
//    val expected = "2.0"
//    assert(checkCode(input,expected,523))
//  }
//
//  test("524") {
//    val input = "void main () {putFloatLn(2/1.0);}"
//    val expected = "2.0"
//    assert(checkCode(input,expected,524))
//  }
//
//  test(" string parameters ")
//  {
//    val input = """void main () {putStringLn("I am Student !");}"""
//    val expected = "I am Student !"
//    assert(checkCode(input,expected,555))
//  }
//
//  test(" string parameters 525")
//  {
//    val input = """void main () {putBoolLn(3 > 4);}"""
//    val expected = "false"
//    assert(checkCode(input,expected,525))
//  }
//
//  test(" string parameters 526")
//  {
//    val input = """void main () {putBoolLn(3 >= 4);}"""
//    val expected = "false"
//    assert(checkCode(input,expected,526))
//  }
//
//  test(" string parameters 527")
//  {
//    val input = """void main () {putBoolLn(3 < 4);}"""
//    val expected = "true"
//    assert(checkCode(input,expected,527))
//  }
//
//  test(" string parameters 528")
//  {
//    val input = """void main () {putBoolLn(3 <= 4);}"""
//    val expected = "true"
//    assert(checkCode(input,expected,528))
//  }
//
//  test(" string parameters 529")
//  {
//    val input = """void main () {putBoolLn(3 == 4);}"""
//    val expected = "false"
//    assert(checkCode(input,expected,529))
//  }
//
//  test(" string parameters 530")
//  {
//    val input = """void main () {putBoolLn(3 != 4);}"""
//    val expected = "true"
//    assert(checkCode(input,expected,530))
//  }
//
//  test(" string parameters 531")
//  {
//    val input = """void main () {putBoolLn(true && true);}"""
//    val expected = "true"
//    assert(checkCode(input,expected,531))
//  }
//
//  test(" string parameters 532")
//  {
//    val input = """void main () {putBoolLn(true && false);}"""
//    val expected = "false"
//    assert(checkCode(input,expected,532))
//  }
//
//  test(" string parameters 533")
//  {
//    val input = """void main () {putBoolLn(false && false);}"""
//    val expected = "false"
//    assert(checkCode(input,expected,533))
//  }
//
//  test(" string parameters 534")
//  {
//    val input = """void main () {putBoolLn(false && true);}"""
//    val expected = "false"
//    assert(checkCode(input,expected,534))
//  }
//
//  test(" string parameters 535")
//  {
//    val input = """void main () {putBoolLn(true || true);}"""
//    val expected = "true"
//    assert(checkCode(input,expected,535))
//  }
//
//  test(" string parameters 536")
//  {
//    val input = """void main () {putBoolLn(false || true);}"""
//    val expected = "true"
//    assert(checkCode(input,expected,536))
//  }
//
//  test(" string parameters 537")
//  {
//    val input = """void main () {putBoolLn(true || false);}"""
//    val expected = "true"
//    assert(checkCode(input,expected,537))
//  }
//
//  test(" string parameters 538")
//  {
//    val input = """void main () {putBoolLn(false || false);}"""
//    val expected = "false"
//    assert(checkCode(input,expected,538))
//  }
//
//  test(" string parameters 539")
//  {
//    val input = """void main () {putIntLn(4%3);}"""
//    val expected = "1"
//    assert(checkCode(input,expected,539))
//  }
//
//  test(" string parameters 540")
//  {
//    val input = """void main () {putBoolLn(!true);}"""
//    val expected = "false"
//    assert(checkCode(input,expected,540))
//  }
//
//  test(" string parameters 541")
//  {
//    val input = """void main () {putBoolLn(!true&&false);}"""
//    val expected = "false"
//    assert(checkCode(input,expected,541))
//  }
//
//  test(" string parameters 542")
//  {
//    val input = """void main () {putBoolLn(!false||false);}"""
//    val expected = "true"
//    assert(checkCode(input,expected,542))
//  }
//
//  test(" string parameters 543")
//  {
//    val input = """void main () {putIntLn(-3);}"""
//    val expected = "-3"
//    assert(checkCode(input,expected,543))
//  }
//
//  test(" string parameters 544")
//  {
//    val input = """void main () {putIntLn(--3);}"""
//    val expected = "3"
//    assert(checkCode(input,expected,544))
//  }
//
//  test(" string parameters 545")
//  {
//    val input = """void main () {putIntLn(---3);}"""
//    val expected = "-3"
//    assert(checkCode(input,expected,545))
//  }
//
//  test(" string parameters 546")
//  {
//    val input = """void main () {putIntLn(4+---3);}"""
//    val expected = "1"
//    assert(checkCode(input,expected,546))
//  }
//
//  /**
//    * failed this tc
//    */
//  test(" string parameters 547")
//  {
//    val input = """void main () {putBoolLn((4+---3>5)||!true);}"""
//    val expected = "false"
//    assert(checkCode(input,expected,547))
//  }
//
//  test(" string parameters xxx")
//  {
//    val input = """void main () {putBoolLn(4+---3>5||6+5<10&&false&&!true);}"""
//    val expected = "false"
//    assert(checkCode(input,expected,566))
//  }
//
//  test(" string parameters 548")
//  {
//    val input = """void main () {putBoolLn(!true||false);}"""
//    val expected = "false"
//    assert(checkCode(input,expected,548))
//  }
//
//  test(" string parameters 549")
//  {
//    val input = """void main () {putBoolLn(4>5||(8+8>=9));}"""
//    val expected = "true"
//    assert(checkCode(input,expected,549))
//  }
//
//  test(" string parameters 777")
//  {
//    val input = """void main () {putBoolLn(4>5);}"""
//    val expected = "true"
//    assert(checkCode(input,expected,777))
//  }

//  test("simple5 ")  {
//    val input = "void main () {getInt();}"
//    val expected = "0"
//    assert(checkCode(input,expected,666))
//  }

  test(" 550")  {
    val input = "void main () {int a; int b; a= 3; b = 5; putBoolLn(a>b);}"
    val expected = "0"
    assert(checkCode(input,expected,550))
  }


//  test("special program => print 0") {
//    val input = "void abc(int a){} void main () {putIntLn(004);}"
//    val expected = "4"
//    assert(checkCode(input,expected,504))
//  }
}
