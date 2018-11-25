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

object Rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(1582); 
  val x = new Rational(2, 3);System.out.println("""x  : Rationals.Rational = """ + $show(x ));$skip(30); 

  val y = new Rational(5, 7);System.out.println("""y  : Rationals.Rational = """ + $show(y ));$skip(12); val res$0 = 

  x.add(y);System.out.println("""res0: Rationals.Rational = """ + $show(res$0));$skip(12); val res$1 = 

  y.sub(x);System.out.println("""res1: Rationals.Rational = """ + $show(res$1));$skip(30); 

  val z = new Rational(2, 3);System.out.println("""z  : Rationals.Rational = """ + $show(z ));$skip(19); val res$2 = 

  x.sub(y).sub(z);System.out.println("""res2: Rationals.Rational = """ + $show(res$2));$skip(12); val res$3 = 

  y.add(y);System.out.println("""res3: Rationals.Rational = """ + $show(res$3));$skip(13); val res$4 = 

  x.less(y);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(12); val res$5 = 

  x.max(y);System.out.println("""res5: Rationals.Rational = """ + $show(res$5));$skip(27); 

  val n = new Rational(5);System.out.println("""n  : Rationals.Rational = """ + $show(n ))}
  
}
