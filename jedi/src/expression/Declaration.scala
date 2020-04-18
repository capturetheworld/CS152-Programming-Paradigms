package expression
import  value.Notification
import value.Value
import context.Environment

case class Declaration(val id: Identifier, val exp: Expression) extends SpecialForm {
  override def toString = "Declaration id" + id + "expression = " + exp
  def execute(env: Environment): Value = {
    env.put(id, exp.execute(env))
    value.Notification.OK
  }
}