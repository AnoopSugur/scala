object practice {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

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
  }                                               //> sqrt: (x: Double)Double
  

  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(9)                                         //> res1: Double = 3.00009155413138
  sqrt(1e-6)                                      //> res2: Double = 0.0010000001533016628
  sqrt(1.0e50)                                    //> res3: Double = 1.0000003807575104E25
}