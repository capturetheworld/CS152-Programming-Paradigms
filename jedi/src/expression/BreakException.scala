package expression
import context._
import value._

class BreakException() extends JediException

case class Break() extends SpecialForm {
  def execute(env: Environment) = {
    throw new BreakException
    Notification.BREAK
  }
}
