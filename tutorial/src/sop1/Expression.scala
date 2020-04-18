package sop1

trait Expression {
  def execute: Double
}

case class Sum(val operand1: Expression, val operands: List[Expression]) extends Expression {
  def execute =
    operand1.execute + operands.map(_.execute).reduce(_+_)
}

case class Product(val operand1: Expression, val operands: List[Expression]) extends Expression {
  def execute =
    operand1.execute * operands.map(_.execute).reduce(_*_)
}

case class Number(val value: Double) extends Expression {
  def execute = value
}