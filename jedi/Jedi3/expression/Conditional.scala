package expression
import value._
import context._

case class Conditional(condition: Expression, consequent: Expression, alternative: Expression = null) extends SpecialForm {
  override def execute(env: Environment): Value = {
    val value = condition.execute(env)
    if(!value.isInstanceOf[Boole]) throw new Exception("Check the type to be Bool") //not a boolean
    if(value.asInstanceOf[Boole].value) consequent.execute(env)
    else if (alternative != null) alternative.execute(env)
    else Notification.OK
  }
  override def toString = {
    var result = "if (" + condition + ") " + consequent
    if (alternative != null) result = result + " otherwise " + alternative
    result
  }
}