class Adder {
  def add(x: Int,y: Int): Int = {
    x + y
  }
}

class APrinter() {
  def print(): Unit = {
    println("A")
  }
}

class BPrinter() extends APrinter {
  override def print(): Unit = {
    println("B")
  }
}

class Point3D(val x: Int, val y: Int, val z: Int) {
}

object Main {
  def main(args:Array[String]): Unit = {
    val adder = new Adder()
    val fun: Int => Int = adder.add(3, _)
    println(fun(3))

    val aPrinter = new APrinter()
    val bPrinter = new BPrinter()
    aPrinter.print()
    bPrinter.print()

    val point3D = new Point3D(10, 20, 30)
    println(point3D.x)
    println(point3D.y)
    println(point3D.z)
  }
}

