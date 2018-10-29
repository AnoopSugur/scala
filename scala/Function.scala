def simple() : Unit = {
  println ("Simple Print")
}

simple()


def adder(num1:Int, num2:Int): Int = {
  return num1 + num2
}

println(adder(4,2))


def greetName(str:String): String = {
  return(s"Hello $str")
}

println(greetName("Anoop"))


def isPrime(numcheck:Int): Boolean = {
  for(n <- Range(2,numcheck)) {
    if(numcheck % n == 0) {
      return false
    }
  }
  return true
}

println(isPrime(45))
println(isPrime(19))

val numbers = List(1,2,4,5,9)

def nums(num: List[Int]) : List[Int] = {
  return num
}

println(numbers)
