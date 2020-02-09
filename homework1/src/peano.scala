
import scala.io._
import util.control.Breaks._

class SyntaxException(gripe: String = "ERROR") extends Exception(gripe)
class MissingOperator extends SyntaxException("Missing operator!")
class NumberFormat extends SyntaxException("Illegal operand!")


object peano {


  def execute(cmmd: String): String = {
    var operand1 = 0.0
    var operand2 = 0.0
    var operatorlocation=0

    if (cmmd.contains('+')) {
      operatorlocation = cmmd.indexOf('+')

      try {
        operand1 = cmmd.take(operatorlocation).trim.toDouble //removespaces convert to double
        operand2 = cmmd.substring(operatorlocation + 1).trim.toDouble //removespaces convert to double
      }
      catch{
        case e: NumberFormatException => throw new NumberFormat
      }
      (operand1 + operand2).toString

    }
    else if(cmmd.contains('*')){
      operatorlocation = cmmd.indexOf('*')
      try {
        operand1 = cmmd.take(operatorlocation).trim.toDouble //removespaces convert to double
        operand2 = cmmd.substring(operatorlocation + 1).trim.toDouble //removespaces convert to double
      }
      catch{
        case e: NumberFormatException => throw new NumberFormat
      }
      (operand1 * operand2).toString
    }
    else throw new MissingOperator

    }
    // if cmmd is a valid expression, compute its value and return it as a string





  // read-execute-print loop
  def repl {
    // repeatedly:
    //   1. prompt user for a string
    //   2. quit if cmmd == "quit"
    //   3. ignore if cmmd == ""
    //   4. print execute(cmmd) otherwise
    //   5. handle all exceptions
    println("Welcome to Peano 1.0")
    var on = true
    while(on) {
      try {
        print("-> ")
        val exp = StdIn.readLine
        if (exp == "quit") on = false//   2. quit if cmmd == "quit"
        else if(exp!="") {     //   3. ignore if cmmd == ""
          val result = execute(exp);
          println(result)  //   4. print execute(cmmd) otherwise
        }
      }
      catch { //   5. handle all exceptions
        case m: SyntaxException => println(m.getMessage)
        case m: NumberFormat => println(m.getMessage)
        case m: MissingOperator => println(m.getMessage)
        case m: Throwable => {
          on = false
          println(m.getMessage)


        }
          on = false
      }
    }
    println("bye")
  }

  def main(args: Array[String]): Unit = {
    repl
  }


}

///Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=50634:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Users/ian/Documents/GitHub/CS152/homework1/out/production/homework1:/Users/ian/.sdkman/candidates/scala/2.13.1/lib/scala-library.jar:/Users/ian/.sdkman/candidates/scala/2.13.1/lib/scala-reflect.jar peano
//Welcome to Peano 1.0
//-> 2+3
//5.0
//-> 2*3
//6.0
//-> 4/5
//Missing operator!
//->
//-> quit
//bye
//
//Process finished with exit code 0