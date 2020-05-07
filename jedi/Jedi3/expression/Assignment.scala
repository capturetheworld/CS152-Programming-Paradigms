package expression

import context.{Environment, TypeException}
import value._

case class Assignment(var vbl: Identifier, update: Expression) extends SpecialForm {
  override def execute(env: Environment): Value = {
    val identifierValue = vbl.execute(env)
    if(!identifierValue.isInstanceOf[Variable] || !env.contains(vbl) ) {throw new TypeException("Not a variable")}
    identifierValue.asInstanceOf[Variable].content = update.execute(env)
    Notification.DONE
  }



}
