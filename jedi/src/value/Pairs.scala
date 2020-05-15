package value

import context._
import collection.mutable._

class Pair(val first: First, val second: Second) extends Value {
  override def toString = "(" + first.toString + " , " + second.toString + ")"

  def getFirst(): Value = first

  def getSecond(): Second = second
}

object Pair {
  def apply(first: First, second: Second) = new Pair(first, second)
}