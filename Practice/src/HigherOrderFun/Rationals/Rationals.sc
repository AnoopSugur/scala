package Rationals

/*
class Rational(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def numer = x / gcd(x,y)
  def denom = y / gcd(x,y)

  def addRational(x: Rational, y: Rational): Rational =
    new Rational(x.numer * y.denom + y.numer * x.denom, x.denom + y.denom)

  def add(that: Rational) =
    new Rational(numer * that.denom + denom * that.numer, that.denom * denom)

  override def toString = numer + "/" + denom

  def neg: Rational = new Rational(-1 * numer, denom)

  def sub(that: Rational) = add(that.neg)

}
*/

class Rational(x: Int, y: Int) {

  //adding another constructor
  def this(x: Int) = this(x, 1)
  
  //used to simplify the rationals, 70 / 28 will be 7/4
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)

  def less(that: Rational) = numer * that.denom < denom * that.numer

  def max(that: Rational) =
    if (this.less(that)) that else that

  def addRational(x: Rational, y: Rational): Rational =
    new Rational(x.numer * y.denom + y.numer * x.denom, x.denom + y.denom)

  def add(that: Rational) =
    new Rational(numer * that.denom + denom * that.numer, that.denom * denom)

  override def toString = numer + "/" + denom

  def neg: Rational = new Rational(-1 * numer, denom)

  def sub(that: Rational) = add(that.neg)

  //require is a pre-defined fucntion, if condition not met IllegalArgumentException is thrown
  require(y != 0, "denominator must be positive")

}

object Rationals {
  val x = new Rational(2, 3)                      //> x  : Rationals.Rational = 2/3

  val y = new Rational(5, 7)                      //> y  : Rationals.Rational = 5/7

  x.add(y)                                        //> res0: Rationals.Rational = 29/21

  y.sub(x)                                        //> res1: Rationals.Rational = 1/21

  val z = new Rational(2, 3)                      //> z  : Rationals.Rational = 2/3

  x.sub(y).sub(z)                                 //> res2: Rationals.Rational = 5/-7

  y.add(y)                                        //> res3: Rationals.Rational = 10/7

  x.less(y)                                       //> res4: Boolean = true

  x.max(y)                                        //> res5: Rationals.Rational = 5/7

  val n = new Rational(5)                         //> n  : Rationals.Rational = 5/1
  
}