object practice {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  println("Welcome to the Scala worksheet");$skip(379); 

  def sqrt(x: Double): Double = {

    def abs(x: Double) = if (x < 0) -x else x

    def sqrtItr(guess: Double): Double =
      if (isGoodEnough(guess: Double)) guess
      else sqrtItr(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.0001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    sqrtItr(1.0)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(14); val res$0 = 
  

  sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(9);System.out.println("""res1: Double = """ + $show(res$1));$skip(13); val res$2 = 
  sqrt(1e-6);System.out.println("""res2: Double = """ + $show(res$2));$skip(15); val res$3 = 
  sqrt(1.0e50);System.out.println("""res3: Double = """ + $show(res$3))}
}
