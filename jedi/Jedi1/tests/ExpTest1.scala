package test

import context._
import expression._
import value._

object ExpTest1 extends App {
  val globalEnv = new Environment
  val pi = Identifier("pi")
  val num = Real(3.14)
  globalEnv.put(pi, num)
  println(pi.execute(globalEnv))
  println(num.execute(globalEnv))
}