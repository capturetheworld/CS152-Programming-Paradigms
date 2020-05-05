package expression
import context.Environment
import value.Value

//extends SpecialForm JEDI 2.0 which extends Expression
//contains expressions
case class Block(val operands: List[Expression]) extends SpecialForm {
  override def execute(env: Environment): Value = {
    def tempEnv = new Environment(env)

    var value = new Value {}
    for(operand <- operands){
      value = operand.execute(tempEnv)
    }
    value

    }

}
