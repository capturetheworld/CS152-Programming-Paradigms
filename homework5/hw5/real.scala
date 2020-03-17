class Real(val scalaValue: Double) extends Ordered[Real] with Equals {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Real]

  def compare(that: Real): Int = {
    if (scalaValue - that.scalaValue < 0) -1
    else if (scalaValue - that.scalaValue == 0) 0
    else 1
  }

  def *(that: Real) = this.scalaValue * that.scalaValue

}

object Real {
  def apply(x: Double) = new Real(x)
}

object RealTest extends App {
  var r1 = Real(3.14)
  var r2 = Real(2.71)
  println("r1 * r2 = " + (r1 * r2))
  println("r1 == r2 = " + (r1 == r2))
  println("r1 < r2 = " + (r1 < r2))
}
