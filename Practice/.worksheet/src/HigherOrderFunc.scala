object HigherOrderFunc {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(144); 

  /*add all numbers between a and b*/
  def sumInts(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInts(a + 1, b);System.out.println("""sumInts: (a: Int, b: Int)Int""");$skip(18); val res$0 = 

  sumInts(5, 10);System.out.println("""res0: Int = """ + $show(res$0));$skip(37); 

  def cube(a: Int): Int = a * a * a;System.out.println("""cube: (a: Int)Int""");$skip(90); 

  def cubeInts(a: Int, b: Int): Int =
    if (a > b) 0 else cube(a) + cubeInts(a + 1, b);System.out.println("""cubeInts: (a: Int, b: Int)Int""");$skip(18); val res$1 = 

  cubeInts(1, 3);System.out.println("""res1: Int = """ + $show(res$1));$skip(95); 

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b);System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(27); 

  def id(a: Int): Int = a;System.out.println("""id: (a: Int)Int""");$skip(61); 
  def fact(a: Int): Int = if (a == 0) 1 else a * fact(a - 1);System.out.println("""fact: (a: Int)Int""");$skip(50); 

  def newSumInts(a: Int, b: Int) = sum(id, a, b);System.out.println("""newSumInts: (a: Int, b: Int)Int""");$skip(51); 
  def newSumCube(a: Int, b: Int) = sum(cube, a, b);System.out.println("""newSumCube: (a: Int, b: Int)Int""");$skip(54); 
  def newFactorials(a: Int, b: Int) = sum(fact, a, b);System.out.println("""newFactorials: (a: Int, b: Int)Int""");$skip(18); val res$2 = 

  sumInts(5, 10);System.out.println("""res2: Int = """ + $show(res$2));$skip(17); val res$3 = 
  cubeInts(1, 3);System.out.println("""res3: Int = """ + $show(res$3));$skip(22); val res$4 = 
  newFactorials(1, 5);System.out.println("""res4: Int = """ + $show(res$4));$skip(11); val res$5 = 

  fact(3);System.out.println("""res5: Int = """ + $show(res$5));$skip(92); 

  /**
   * Anonymous Functions
   */
  def newSumInts1(a: Int, b: Int) = sum(x => x, a, b);System.out.println("""newSumInts1: (a: Int, b: Int)Int""");$skip(62); 
  def newSumCube1(a: Int, b: Int) = sum(x => x * x * x, a, b);System.out.println("""newSumCube1: (a: Int, b: Int)Int""");$skip(22); val res$6 = 

  newSumInts1(4, 10);System.out.println("""res6: Int = """ + $show(res$6));$skip(21); val res$7 = 
  newSumCube1(4, 10);System.out.println("""res7: Int = """ + $show(res$7));$skip(170); 

  def tailRecurSum(f: Int => Int, a: Int, b: Int) = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  };System.out.println("""tailRecurSum: (f: Int => Int, a: Int, b: Int)Int""");$skip(34); val res$8 = 

  tailRecurSum(x => x * x, 3, 5);System.out.println("""res8: Int = """ + $show(res$8));$skip(208); 

  /**
   * Currying, Functions returning function
   */

  def sum1(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  };System.out.println("""sum1: (f: Int => Int)(Int, Int) => Int""");$skip(31); 

  def sumInts2 = sum1(x => x);System.out.println("""sumInts2: => (Int, Int) => Int""");$skip(38); 
  def sumCube2 = sum1(x => x * x * x);System.out.println("""sumCube2: => (Int, Int) => Int""");$skip(33); 
  def sumFactorials = sum1(fact);System.out.println("""sumFactorials: => (Int, Int) => Int""");$skip(19); val res$9 = 

  sumInts2(5, 10);System.out.println("""res9: Int = """ + $show(res$9));$skip(17); val res$10 = 
  sumCube2(1, 3);System.out.println("""res10: Int = """ + $show(res$10));$skip(22); val res$11 = 
  sumFactorials(1, 5);System.out.println("""res11: Int = """ + $show(res$11));$skip(21); val res$12 = 

  sum1(cube)(1, 10);System.out.println("""res12: Int = """ + $show(res$12));$skip(18); val res$13 = 
  sum1(id)(1, 10);System.out.println("""res13: Int = """ + $show(res$13));$skip(127); 

/**
Making it even shorter
*/
  def sum2(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum2(f)(a + 1, b);System.out.println("""sum2: (f: Int => Int)(a: Int, b: Int)Int""")}

}
