sealed abstract class DayOfWeek
case object Sunday extends DayOfWeek
case object Monday extends DayOfWeek
case object Tuesday extends DayOfWeek
case object Wednesday extends DayOfWeek
case object Thursday extends DayOfWeek
case object Friday extends DayOfWeek
case object Saturday extends DayOfWeek

sealed abstract class Exp
case class Add(lhs: Exp, rhs: Exp) extends Exp
case class Sub(lhs: Exp, rhs: Exp) extends Exp
case class Mul(lhs: Exp, rhs: Exp) extends Exp
case class Div(lhs: Exp, rhs: Exp) extends Exp
case class Lit(value: Int) extends Exp

sealed abstract class Tree
case class Branch(value: Int, left: Tree, right: Tree) extends Tree
case object Empty extends Tree

object CaseClass {
  def max(tree: Tree): Int = tree match {
    case Branch(self: Int, left: Tree, right: Tree) => List(self, max(left), max(left)).max
    case Branch(self: Int, Empty, Empty) => self
  }

  def depth(tree: Tree): Int = tree match {
    case Branch(self: Int, left: Tree, right: Tree) => 1 + List(depth(left), depth(right)).max
    case Branch(self: Int, Empty, Empty) => 1
  }

  def sort(tree: Tree): Tree = tree match {
    case Branch(self: Int, Branch(leftSelf: Int, Empty, Empty), Branch(rightSelf: Int, Empty, Empty))
    => {
      val sorted = List(self, leftSelf, rightSelf).sorted
      return Branch(sorted(1), Branch(sorted(0), Empty, Empty), Branch(sorted(2), Empty, Empty))
    }
    case Branch(self: Int, Empty, Empty) => Branch(self: Int, Empty, Empty)
  }

  val x: DayOfWeek = Sunday
  x match {
    case Sunday => 1
    case Monday => 2
    case Tuesday => 3
    case Wednesday => 4
    case Thursday => 5
    case Friday => 6
    case Saturday => 7
  }

  def nextDayOfWeek(dayOfWeek: DayOfWeek): DayOfWeek = dayOfWeek match {
    case Sunday => Monday
    case Monday => Tuesday
    case Tuesday => Wednesday
    case Wednesday => Thursday
    case Thursday => Friday
    case Friday => Saturday
    case Saturday => Sunday
  }

  val example: Exp = Add(Lit(1),Div(Mul(Lit(2),Lit(3)),Lit(2)))

  def eval(exp: Exp): Int = exp match {
    case Add(l,r) => eval(l) + eval(r)
    case Sub(l,r) => eval(l) - eval(r)
    case Mul(l,r) => eval(l) * eval(r)
    case Div(l,r) => eval(l) / eval(r)
    case Lit(v) => v
  }

  def main(args: Array[String]): Unit = {
    println(nextDayOfWeek(x))
  }
}
