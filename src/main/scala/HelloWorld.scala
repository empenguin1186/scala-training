object HelloWorld {
  def main(args:Array[String]): Unit = {
    answer()
  }

  def isYouji(age: Int, isSchoolStarted: Boolean): Unit = {
    if (isSchoolStarted && age < 7) {
      println("幼児です")
    } else {
      println("幼児ではありません")
    }
  }

  def loopFrom0To9(): Unit = {
    var i: Int = 0
    do {
      println(i)
      i = i+1
    } while(i < 10)
  }

  def pitagoras(): Unit ={
    for(a <- 1 to 1000; b <- 1 to 1000; c <- 1 to 1000 if a*a + b*b == c*c){
      println("a = " + a + " b = " + b + " c = " + c)
    }
  }

  def headEqualsTail(): Unit = {
    var i: Int = 0;
    while(i < 1000) {
      var str: List[Char] = new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList
      if(str.head.equals(str.last)) {
        println(i+1 + ":" + str)
        i = i+1;
      }
    }
  }

  def answer(): Unit = {
    for(i <- 1 to 1000){
      var s = new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList match{
        case a::b::c::d::_ => List(a,b,c,d,a).mkString
      }
      println(s)
    }
  }
}