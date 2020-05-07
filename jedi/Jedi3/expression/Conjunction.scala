package expression
import value._
import context._

case class Conjunction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment): Value = {
    var answer = true
    for (e <- operands if answer) {
      e.execute(env)
      match{
        case Boole(value) => {if (!value) answer = false}
        case _ => throw new TypeException("inputs to Conjunction must be Booles")
      }
    }
    Boole(answer)
  }
}



