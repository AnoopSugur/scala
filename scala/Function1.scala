def isEven (num: Int) : Boolean = {
  return num %2==0
}

println(isEven(4))

def isEven1(num: Int) = num %2==0

println(isEven1(5))

def checkEvens (nums: List[Int]) : List[Int] = {
  var list = scala.collection.mutable.ListBuffer[Int]()
  for (n <- nums) {
    if (n % 2 ==0 )
    list += n
  }
  return list.toList
}

def returnEvens (nums: List[Int]) : List[Int] = {
  var list = nums.filter (_ % 2 ==0)
  return list
}

println(checkEvens(List(2,5,1,3,6)))
println(returnEvens(List(2,5,1,3,6)))

def sumSevens (nums: List[Int]) : Int = {
  var sum = 0
    for (n <- nums) {
      sum += n
      if (n == 7)
        sum += n
     }
  return sum
}


def sumImpSevens (nums: List[Int]) : Int = {
  var sum = 0
     nums.foreach(sum += _)
  return sum
}
println(sumSevens(List(2,5,1,3,6,7)))
println(sumImpSevens(List(2,5,1,3,6,7)))

//Return the index where sum of 1st half of list matches the 2nd half of the list
// If it doesn't occur return -1
def balanceCheck (nums :List[Int]) : Int = {
  var firstHalf  = 0
  var secondHalf = 0

  secondHalf = nums.sum

  for(i <- Range(0, nums.length)) {
    firstHalf = firstHalf + nums(i)
    secondHalf = secondHalf - nums(i)
    if(firstHalf == secondHalf) {
      return i
    }
  }
    return -1
}

println(balanceCheck(List(3,4,1,22,5,5,3)))
println(balanceCheck(List(1,2,3,4,10)))


def isPalindrome(str:String): Boolean ={
    return (str == str.reverse)
}

println(isPalindrome("abccba"))
println(isPalindrome("abcca"))
