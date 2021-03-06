package HigherOrderFun

import Math.abs

object FixedPoints {

  def tolerance = 0.0001                          //> tolerance: => Double

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance              //> isCloseEnough: (x: Double, y: Double)Boolean

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) guess
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double

  fixedPoint(x => 1 + x / 2)(1)                   //> res0: Double = 1.99951171875


  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2) (1)
                                                  //> sqrt: (x: Double)Double
  
  sqrt(2)                                         //> res1: Double = 1.4142156862745097
}