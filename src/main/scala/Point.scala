import scala.io.Source

case class Point(val x: Int, val y: Int) {

  def +(p: Point): Point = {
    new Point(x+p.x, y+p.y)
  }

  override def toString(): String = "(" + x + ", " + y + ")"
}

object Point {
  def main(args:Array[String]): Unit = {
    var isSame = Point(1,2).equals(Point(1,2))
    if(Point(1,2).equals(Point(1,2)))
      println(Point.apply(1,2))
  }
}

class Person(name: String, age: Int, private val weight: Int)

object Person {
  def printweight(): Unit = {
    val taro = new Person("Taro", 20 , 70)
    println(taro.weight)
  }
}

trait TraitA {
  def greet(): Unit = println("Hello!")
}

trait TraitB extends TraitA {
  override def greet(): Unit = {
    super.greet()
    println("My name is Terebi-chan.")
  }
}

trait TraitC extends TraitA {
  override def greet(): Unit = {
    super.greet()
    println("I like niconico.")
  }
}

class ClassA extends TraitB with TraitC
class ClassB extends TraitC with TraitB

class A {
  def foo() = "A"
}

trait B extends A {
  override def foo() = "B" + super.foo()
}

trait C extends B {
  override def foo() = "C" + super.foo()
}

trait D extends A {
  override def foo() = "D" + super.foo()
}


object ClassA {
  def main(args:Array[String]): Unit = {
    def printfile(filename: String): Unit = withFile(filename)(file => file.getLines.foreach(println))

  }

  def withFile[A](filename: String)(f: Source => A): A = {
    val s = Source.fromFile(filename)
    try {
      f(s)
    } finally {
      s.close()
    }
  }
}

