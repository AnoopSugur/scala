package HigherOrderFun.Rationals

object InfixOperators {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 
  val x = new Rational(2, 3);System.out.println("""x  : HigherOrderFun.Rationals.Rational = """ + $show(x ));$skip(30); 

  val y = new Rational(5, 7);System.out.println("""y  : HigherOrderFun.Rationals.Rational = """ + $show(y ));$skip(9); val res$0 = 

  x + y;System.out.println("""res0: HigherOrderFun.Rationals.Rational = """ + $show(res$0));$skip(9); val res$1 = 

  y - x;System.out.println("""res1: HigherOrderFun.Rationals.Rational = """ + $show(res$1));$skip(30); 

  val z = new Rational(2, 3);System.out.println("""z  : HigherOrderFun.Rationals.Rational = """ + $show(z ));$skip(13); val res$2 = 

  x - y - z;System.out.println("""res2: HigherOrderFun.Rationals.Rational = """ + $show(res$2));$skip(9); val res$3 = 

  y + y;System.out.println("""res3: HigherOrderFun.Rationals.Rational = """ + $show(res$3));$skip(9); val res$4 = 

  x < y;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(11); val res$5 = 

  x max y;System.out.println("""res5: HigherOrderFun.Rationals.Rational = """ + $show(res$5));$skip(27); 

  val n = new Rational(5);System.out.println("""n  : HigherOrderFun.Rationals.Rational = """ + $show(n ))}

}

class Rational(x: Int, y: Int) {

  //adding another constructor
  def this(x: Int) = this(x, 1)

  //used to simplify the rationals, 70 / 28 will be 7/4
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)

  // Infix operators can be used to simplify
  def <(that: Rational) = numer * that.denom < denom * that.numer

  def max(that: Rational) =
    if (this < that) that else that

  def addRational(x: Rational, y: Rational): Rational =
    new Rational(x.numer * y.denom + y.numer * x.denom, x.denom + y.denom)

  def +(that: Rational) =
    new Rational(numer * that.denom + denom * that.numer, that.denom * denom)

  override def toString = numer + "/" + denom

  def unary_- : Rational = new Rational(-1 * numer, denom)

  def -(that: Rational) = this + -that

  //require is a pre-defined fucntion, if condition not met IllegalArgumentException is thrown
  require(y != 0, "denominator must be positive")

}
