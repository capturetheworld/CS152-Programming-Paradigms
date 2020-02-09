
object poly {

  def roots(p: (Double, Double, Double)): Option[(Double, Double)] = {
    // = None if p has no real roots
    // = Some((r1, r2)) where p(r1) == p(r2) == 0

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

  def mul(a: Double,v: (Double, Double, Double)): (Double, Double, Double) =
  // = a * v
    (a * v._1, a * v._2, a * v._3)
  def dot(v1: (Double, Double, Double), v2: (Double, Double, Double)): Double =
  // v1 * v2
    (v1._1 * v2._1 + v1._2 * v2._2 + v1._3 * v2._3)
  def length(v: (Double, Double, Double)): Double =
    scala.math.sqrt(v._1 * v._1 + v._2 * v._2 + v._3 * v._3)
  // = |v|

  def theta(v1: (Double, Double, Double), v2: (Double, Double, Double)): Double =
  val product = dot(v1, v2) / (length(v1) * length(v2))
  scala.math.acos(product)

}

object arithmetic {

  def sqrt(n: Int): Option[Int] = {
    // = None if n < 0
    // = largest int m such that m * m <= n
  }

  def log(n: Int): Option[Int] = {
    // = None if N <= 0
    // = largest m such that 2^m <= n
  }

  def isPrime(n: Int): Option[Boolean] = {
    // = true if n has no divisors > 1
  }

  def gcd(n: Int, m: Int): Option[Int] = {
    // = None if n or m < 0
    // = gcd(m, n) if n < m
    // = largest k dividing both n and m
  }

  def lcm(n: Int, m: Int): Option[Int] = {
    // = None if n < 0 or m < 0
    // = smallest k such that n a,d m divide k
  }

  def phi(n: Int): Option[Int] = {
    // = None if n < 0
    // = # of k <= n such that gcd(k, n) = 1
  }

}