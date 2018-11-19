import scala.annotation.tailrec
object TailRecursive {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(125); 

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b);System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(15); val res$0 = 

  gcd(28, 49);System.out.println("""res0: Int = """ + $show(res$0));$skip(79); 
  

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1);System.out.println("""factorial: (n: Int)Int""");$skip(16); val res$1 = 

  factorial(7);System.out.println("""res1: Int = """ + $show(res$1));$skip(142); 
  
  def fact(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, n)
  };System.out.println("""fact: (n: Int)Int""");$skip(13); val res$2 = 
  
  fact(7);System.out.println("""res2: Int = """ + $show(res$2))}
}
