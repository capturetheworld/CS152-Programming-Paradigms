package test

import value._

object BooleTest1 extends App {
  val t = Boole(true)
  val f = Boole(false)
  println("t && f = " + (t && f))
  println("t || f = " + (t || f))
  println("!t = " + (!t))
}