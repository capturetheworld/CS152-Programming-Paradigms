package expression
import value._
import expression._
import context._
//while (condition) body
//iteration ::= "while" ~@ "(" ~ expression ~ ")" ~ expression

case class Iteration(val condition: Expression, val body: Expression) extends Expression {

  def execute(env: Environment) = {
    val c1 = condition.execute(env)
    if (!c1.isInstanceOf[Boole]) throw new TypeException("While condition must be Boole")
    var c2 = c1.asInstanceOf[Boole]
    var break = false
    while(c2.value  && !break) {
      try {
        body.execute(env)
      } catch {
        case e: BreakException => break = true
        //case e: ContinueException => {}
      }
      c2 = condition.execute(env).asInstanceOf[Boole]
    }
    Notification.DONE
  }
}