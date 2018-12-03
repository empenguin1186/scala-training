object ArrayTraining {
  def main(args: Array[String]): Unit = {
    var arr = Array[Int](1,2,3,4,5)
//    arr.foreach(e => print(e))
//    println("")
//    swapArray(arr)(1,2)
//    arr.foreach(e => print(e))

//    var list = List(1, 2).++(List(3, 4))
//    list.foreach(el => print(el))
    println(List(1,2,3).foldLeft(0)((x,y) => x+y))
  }

  def swapArray[T](arr: Array[T])(i: Int, j: Int): Unit = {
    val tmp = arr(i)
    arr(i) = arr(j)
    arr(j) = tmp
  }

  def joinByComma(start: Int, end: Int): String = {
    val listStr = (start to end).toList.mkString(",")
    return listStr
  }

  def reverse[T](list: List[T]): List[T] = {
    list.foldLeft(Nil: List[T])((x,y) => y::x)
  }

  def sum(list: List[Int]): Int = list.foldRight(0)((x,y) => x+y)

  def mul(list: List[Int]): Int = list.foldRight(1)((y,x) => y*x)

  def mkString[T](list: List[T])(sep: String): String = list.foldLeft("")((x,y) => x.toString()+","+y.toString)
}

