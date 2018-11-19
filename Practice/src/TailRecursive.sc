import scala.annotation.tailrec
object TailRecursive {

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)              //> gcd: (a: Int, b: Int)Int

  gcd(28, 49)                                     //> res0: Int = 7
  

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)       //> factorial: (n: Int)Int

  factorial(7)                                    //> res1: Int = 5040
  
  def fact(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, n)
  }                                               //> fact: (n: Int)Int
  
  fact(7)                                         //> res2: Int = 5040
}