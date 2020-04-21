package expression
import context._
import expression._
import value._
import scala.collection.mutable._

case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
  def execute(env: Environment) = {
    val args : List[Value] = operands.map(_.execute(env))
    alu.execute(operator, args)

  }
}
