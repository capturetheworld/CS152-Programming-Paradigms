package expression
import context.Environment
import value._

case class MakeThunk(body: Expression) extends SpecialForm{
  override def execute(env: Environment): Value = new Thunk(body, env)
}
