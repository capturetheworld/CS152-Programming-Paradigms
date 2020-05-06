package context

import scala.util.parsing.combinator._
import expression._
import value._

class Jedi3Parsers extends Jedi2Parsers {

  // assignment ::= identifier ~ "=" ~ expression
  def assignment: Parser[List[Assignment]] = identifier ~ "=" ~ expression ^^ {
    case "(" ~ Some(id ~ more) ~ ")" => id :: more
    case "(" ~ None ~ ")" => Nil
  }

  // iteration ::= "while" ~ "(" ~ expression ~ ")" ~ expression
  def iteration: Parser[List[Iteration]] = "while" ~ "(" ~ expression ~ ")" ~ expression^^ {
    case "(" ~ Some(id ~ more) ~ ")" => id :: more
    case "(" ~ None ~ ")" => Nil
  }

  // dereference ::= "[" ~ expression ~ "]"
  def dereference: Parser[List[dereference]] = "(" ~ opt(identifier ~ rep("," ~> identifier)) ~ ")" ^^ {
    case "(" ~ Some(id ~ more) ~ ")" => id :: more
    case "(" ~ None ~ ")" => Nil
  }


  override def expression: Parser[Expression] = declaration | conditional | iteration | disjunction | failure("Invalid expression")
  override def term: Parser[Expression]  = lambda | freeze | delay | funCall | block |  assignment | dereference | literal | "("~>expression<~")"

}