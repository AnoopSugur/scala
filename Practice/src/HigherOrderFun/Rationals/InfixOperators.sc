package HigherOrderFun.Rationals

object InfixOperators {
  val x = new Rational(2, 3)                      //> x  : HigherOrderFun.Rationals.Rational = 2/3

  val y = new Rational(5, 7)                      //> y  : HigherOrderFun.Rationals.Rational = 5/7

  x + y                                           //> res0: HigherOrderFun.Rationals.Rational = 29/21

  y - x                                           //> res1: HigherOrderFun.Rationals.Rational = 1/21

  val z = new Rational(2, 3)                      //> z  : HigherOrderFun.Rationals.Rational = 2/3

  x - y - z                                       //> res2: HigherOrderFun.Rationals.Rational = 5/-7

  y + y                                           //> res3: HigherOrderFun.Rationals.Rational = 10/7

  x < y                                           //> res4: Boolean = true

  x max y                                         //> res5: HigherOrderFun.Rationals.Rational = 5/7

  val n = new Rational(5)                         //> n  : HigherOrderFun.Rationals.Rational = 5/1

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