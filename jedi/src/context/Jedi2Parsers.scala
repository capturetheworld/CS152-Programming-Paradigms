package context

import scala.util.parsing.combinator._
import expression._
import expression.MakeText
import expression.MakeThunk
import value._

class Jedi2Parsers extends Jedi1Parsers {

  // params parser
  // a parameter list is zero or more comma-separated identifiers bracketed by parentheses:
  // params ::= "(" ~ (identifier ~ ("," ~ identifier)*)? ~ ")"

  def params: Parser[List[Identifier]] = "(" ~ opt(identifier ~ rep("," ~> identifier)) ~ ")" ^^ {
    case "(" ~ Some(id ~ more) ~ ")" => id :: more
    case "(" ~ None ~ ")" => Nil
  }

  // lambda parser
  // lambda ::= "lambda" ~ params ~ expression
  def lambda: Parser[Lambda] = "lambda" ~ params ~ expression ^^ {
    case "lambda" ~ param ~ expression => Lambda(param, expression)
  }

  // block parser
  // a block is one or more semi-colon separated expressions bracketed by curly braces:
  // block ::= "{" ~ expression ~ (";" ~ expression)* ~ "}"

  def block: Parser[Block] = "{" ~ expression ~ rep(";" ~> expression) ~ "}" ^^ {
    case "{" ~ expression ~ more ~ "}"=> Block(expression :: more)
    case "{" ~ expression ~ Nil ~ "}" => Block(List[Expression](expression))

  }
  // freeze parser
  // freeze ::= "freeze" ~ "(" ~ expression ~ ")" // makes a thunk
  def freeze: Parser[MakeThunk] = "freeze" ~ "(" ~ expression ~ ")" ^^ {
    case freeze ~ "(" ~ expression ~ ")" => MakeThunk(expression)

  }

  // delay parser
  // delay ::= "delay" ~ "(" ~ expression ~ ")" // makes a text
  def delay: Parser[MakeText] ="delay" ~ "(" ~ expression ~ ")"^^ {
    case delay ~ "(" ~ expression ~ ")" => MakeText(expression)

  }


  override def term: Parser[Expression]  = lambda | freeze | delay | funCall | block | literal | "("~>expression<~")"
}
