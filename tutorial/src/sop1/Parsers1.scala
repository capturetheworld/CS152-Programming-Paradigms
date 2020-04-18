package sop1

import scala.util.parsing.combinator._

/*
 * expression ::= sum
 * sum ::= product ~ ("+" ~ product)*
 * product ::= term ~ ("*" ~ term)*
 * term ::= number | "(" ~ expression ~ ")"
 * number ::= """(\+|\-)?[0-9]+(\.[0-9]+)?""".r
 */
class Parsers1 extends RegexParsers {

  def expression: Parser[Expression] = sum

  def sum: Parser[Expression] = product ~ rep("+" ~> product) ^^ {
    case p ~ Nil => p
    case p ~ prods => Sum(p, prods)
  }

  def product: Parser[Expression] = term ~ rep("*" ~> term) ^^ {
    case t ~ Nil => t
    case t ~ terms => Product(t, terms)
  }

  def term: Parser[Expression] = number | "(" ~> expression <~ ")"

  def number: Parser[Number] = """(\+|\-)?[0-9]+(\.[0-9]+)?""".r ^^ {
    case num => Number(num.toDouble)
  }
}