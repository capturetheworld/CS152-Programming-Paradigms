package expression
import value._
import expression._
import context._

case class Iteration(condition: Expression, body:Expression) extends SpecialForm{
  override def execute(env: Environment): Value = {
    if (!condition.execute(env).isInstanceOf[Boole]) throw new TypeException("Condition needs to be a boolean. That is a true/false condition to iterate")
    var exit = condition.execute(env).asInstanceOf[Boole].value
    while (exit) {
      body.execute(env)
      exit = condition.execute(env).asInstanceOf[Boole].value
    }
    Notification.DONE
  }
}
