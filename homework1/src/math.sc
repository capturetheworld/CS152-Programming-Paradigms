import scala.None

//problems 1-2 math
object poly {

  def roots(p: (Double, Double, Double)): Option[(Double, Double)] = {
    // = None if p has no real roots
    // = Some((r1, r2)) where p(r1) == p(r2) == 0
    var rootQuadForumula = scala.math.sqrt(scala.math.pow(p._2,2)- 4*p._1*p._3)
    var r1, r2 = Double.NaN;
    r1 = (-p._2+rootQuadForumula)/(2*p._1)
    r2 = (-p._2-rootQuadForumula)/(2*p._1)
    Option(r1,r2)

  }

  def deriv(p: (Double, Double, Double)): (Double, Double, Double) =
  // = derivative of p (which should be degree 1
    (0, p._1 * 2, p._2)

  def eval(a: Double, p: (Double, Double, Double)): Double =
  // = p(a)
    p._1 * (a * a) + p._2 * a + p._3
}

object PolyTest extends App {
  val p = (3.0, 9.0, -30.0) // = (3x - 6) * (x + 5)

  println("eval(6, p) = " + poly.eval(6, p))
  println("eval(2, p) = " + poly.eval(2, p))
  println("eval(-5, p) = " + poly.eval(-5, p))

  println("roots(p) = " + poly.roots(p))

  println("deriv(p) = " + poly.deriv(p))
  println("deriv2(p) = " + poly.deriv(poly.deriv(p)))

}

object vector {

  def sum(v1: (Double, Double, Double), v2: (Double, Double, Double)): (Double, Double, Double) =
  // v1 + v2
    (v1._1 + v2._1, v1._2 + v2._2, v1._3 + v2._3)

  def mul(a: Double, v: (Double, Double, Double)): (Double, Double, Double) =
  // = a * v
    (a * v._1, a * v._2, a * v._3)

  def dot(v1: (Double, Double, Double), v2: (Double, Double, Double)): Double =
  // v1 * v2
    (v1._1 * v2._1 + v1._2 * v2._2 + v1._3 * v2._3)

  def length(v: (Double, Double, Double)): Double = {
    scala.math.sqrt(v._1 * v._1 + v._2 * v._2 + v._3 * v._3)
 }



  def theta(v1: (Double, Double, Double), v2: (Double, Double, Double)): Double = {
    val product = dot(v1, v2) / (length(v1) * length(v2))
    scala.math.acos(product)
  }

}

