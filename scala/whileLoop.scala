import util.control.Breaks._

var x = 10

while (x < 15) {

  println(s"get lost $x")
  x=x+1
}

x = 10

while (x < 15) {

  println(s"get lost $x")
  x = x +1
if(x ==12) break
  }
