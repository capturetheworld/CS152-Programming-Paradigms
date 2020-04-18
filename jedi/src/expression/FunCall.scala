package expression
import context._
import expression._
import value._

case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
  def execute(env: Environment) = alu.execute(operator, operands)
}
