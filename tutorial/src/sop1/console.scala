package sop1

import scala.io._

object console {

  val parsers = new Parsers1

  def execute(cmmd: String): String = {
    val result = parsers.parseAll(parsers.expression, cmmd)
    result match {
      case result: parsers.Failure => throw new Exception("syntax error")
      case _ => {
        val exp = result.get  // get the expression from the tree
        println("tree: " + exp.toString)
        val value = exp.execute  // execute the expression
        value.toString  // return string representation of result
      }
    }
  }

  def repl() {
    var more = true
    while(more) {
      try {
        print("-> ")
        val cmmd = StdIn.readLine
        if (cmmd == "quit") more = false
        else println("value: " + execute(cmmd))
      } catch {
        case e: Exception => println(e)
      }
    }
    println("bye")
  }

  def main(args: Array[String]): Unit = { repl() }

}