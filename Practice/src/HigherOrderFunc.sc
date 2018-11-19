object HigherOrderFunc {

  /*add all numbers between a and b*/
  def sumInts(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInts(a + 1, b)       //> sumInts: (a: Int, b: Int)Int

  sumInts(5, 10)                                  //> res0: Int = 45

  def cube(a: Int): Int = a * a * a               //> cube: (a: Int)Int

  def cubeInts(a: Int, b: Int): Int =
    if (a > b) 0 else cube(a) + cubeInts(a + 1, b)//> cubeInts: (a: Int, b: Int)Int

  cubeInts(1, 3)                                  //> res1: Int = 36

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)     //> sum: (f: Int => Int, a: Int, b: Int)Int

  def id(a: Int): Int = a                         //> id: (a: Int)Int
  def fact(a: Int): Int = if (a == 0) 1 else a * fact(a - 1)
                                                  //> fact: (a: Int)Int

  def newSumInts(a: Int, b: Int) = sum(id, a, b)  //> newSumInts: (a: Int, b: Int)Int
  def newSumCube(a: Int, b: Int) = sum(cube, a, b)//> newSumCube: (a: Int, b: Int)Int
  def newFactorials(a: Int, b: Int) = sum(fact, a, b)
                                                  //> newFactorials: (a: Int, b: Int)Int

  sumInts(5, 10)                                  //> res2: Int = 45
  cubeInts(1, 3)                                  //> res3: Int = 36
  newFactorials(1, 5)                             //> res4: Int = 153

  fact(3)                                         //> res5: Int = 6

  /**
   * Anonymous Functions
   */
  def newSumInts1(a: Int, b: Int) = sum(x => x, a, b)
                                                  //> newSumInts1: (a: Int, b: Int)Int
  def newSumCube1(a: Int, b: Int) = sum(x => x * x * x, a, b)
                                                  //> newSumCube1: (a: Int, b: Int)Int

  newSumInts1(4, 10)                              //> res6: Int = 49
  newSumCube1(4, 10)                              //> res7: Int = 2989

  def tailRecurSum(f: Int => Int, a: Int, b: Int) = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }                                               //> tailRecurSum: (f: Int => Int, a: Int, b: Int)Int

  tailRecurSum(x => x * x, 3, 5)                  //> res8: Int = 50

  /**
   * Currying, Functions returning function
   */

  def sum1(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sum1: (f: Int => Int)(Int, Int) => Int

  def sumInts2 = sum1(x => x)                     //> sumInts2: => (Int, Int) => Int
  def sumCube2 = sum1(x => x * x * x)             //> sumCube2: => (Int, Int) => Int
  def sumFactorials = sum1(fact)                  //> sumFactorials: => (Int, Int) => Int

  sumInts2(5, 10)                                 //> res9: Int = 45
  sumCube2(1, 3)                                  //> res10: Int = 36
  sumFactorials(1, 5)                             //> res11: Int = 153

  sum1(cube)(1, 10)                               //> res12: Int = 3025
  sum1(id)(1, 10)                                 //> res13: Int = 55

/**
Making it even shorter
*/
  def sum2(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum2(f)(a + 1, b)    //> sum2: (f: Int => Int)(a: Int, b: Int)Int

}