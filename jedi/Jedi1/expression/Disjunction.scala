package expression
import value._
import context._

case class Disjunction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment): Value = {
    var answer = false
    for (e <- operands if answer != true) {
      e.execute(env) match{
        case Boole(value) => {

          if (value) answer = true

        }
      }
    }
    Boole(answer)
  }
}

