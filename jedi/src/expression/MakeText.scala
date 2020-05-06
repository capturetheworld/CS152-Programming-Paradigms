package expression
import context.Environment
import value.{Text, Value}

case class MakeText(body: Expression) extends SpecialForm{
  override def execute(env: Environment): Value = new Text(body)
}
