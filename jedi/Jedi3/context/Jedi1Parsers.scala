package context

import scala.util.parsing.combinator._
import context._
import expression._
import value._
/*
 * Notes:
 * disjunction reduces to conjunction reduces to equality ... reduces to term
 * if A reduces to B, then B will have higher precedence than A
 * Example: sum reduces to product, so a + b * c = a + (b * c)
 * Had to make some big corrections to numeral regex
 * This could probably have been a singleton
 */

class Jedi1Parsers extends RegexParsers {

  def expression: Parser[Expression] = declaration | conditional | disjunction | failure("Invalid expression")
  //def expression: Parser[Expression] = declaration | equality | failure("Invalid expression")

  def declaration: Parser[Declaration] = "def" ~ identifier ~ "=" ~ expression ^^ {
    case "def"~id~"="~exp => Declaration(id, exp)
  }


  def conditional: Parser[Conditional] = "if" ~ "(" ~ expression ~ ")" ~ expression ~ opt("else" ~ expression) ^^ {
    case "if"~"("~cond~")"~cons~None => Conditional(cond, cons)
    case "if"~"("~cond~")"~cons~Some("else"~alt) => Conditional(cond, cons, alt)
  }

  def disjunction: Parser[Expression] = conjunction ~ rep("||" ~> conjunction) ^^ {
    case con ~ Nil => con
    case con ~ more => Disjunction(con::more)
  }

  // conjunction ::= equality ~ ("&&" ~ equality)*
  def conjunction: Parser[Expression] = equality ~ rep("&&" ~> equality) ^^ {
    case e ~ Nil => e
    case e ~ list => Conjunction(e :: list)
  }

  // equality ::= inequality ~ ("==" ~ inequality)*
  def equality: Parser[Expression] = inequality ~ rep("==" ~> inequality) ^^ {
    case e ~ Nil => e
    case e ~ list => FunCall(Identifier("equals"), e :: list)
  }

  // inequality ::= sum ~ (("<" | ">" | "!=") ~ sum)?

  def inequality: Parser[Expression] = sum ~ opt(("<" | ">" | "!=") ~ sum) ^^ {
    case thisExp ~ None => thisExp
    case thisExp ~ Some("<" ~ that) => FunCall(Identifier("less"), List[Expression](thisExp, that))
    case thisExp ~ Some(">" ~ that) => FunCall(Identifier("more"), List[Expression](thisExp, that))
    case thisExp ~ Some("!=" ~ that) => FunCall(Identifier("unequals"), List[Expression](thisExp, that))
  }

  //


  // negate(exp) = 0 - exp
  private def negate(exp: Expression): Expression = {
    val sub = Identifier("sub")
    val zero = Integer(0)
    FunCall(sub, List(zero, exp))
  }

  // sum ::= product ~ ("+" | "-") ~ product)*
  def sum: Parser[Expression] = product ~ rep(("+"|"-") ~ product ^^ {
    case "+"~s=>s
    case "-"~s=> negate(s)
  })^^{
    case p~Nil=> p
    case p~rest=>FunCall(Identifier("add"), p::rest)
  }

  // product ::= term ~ (("*" | "/") ~ term)*
  def product: Parser[Expression] = term ~ rep(("*"|"/") ~ term) ^^ {
    case (t ~ blah) => parseProduct(t, blah)
  }

  // generates left-to-right calls to mul and div:
  private  def parseProduct(t: Expression, terms: List[~[String, Expression]]): Expression = {
    terms match {
      case Nil => t
      case ~("*", t1)::more => parseProduct(FunCall(Identifier("mul"), List(t, t1)), more)
      case ~("/", t1)::more => parseProduct(FunCall(Identifier("div"), List(t, t1)), more)
    }
  }

  def term: Parser[Expression]  = funCall | literal | "("~>expression<~")"

  def literal = boole | real | integer | chars | identifier


  // chars ::= any characters bracketed by quotes
  def chars: Parser[Chars] = """\"[^"]+\"""".r ^^ {
    case characters => Chars(characters.substring(1, characters.length - 1))
  }

  // integer ::= 0|(\+|-)?[1-9][0-9]*
  def integer: Parser[Integer] = """0|(\+|-)?[1-9][0-9]*""".r ^^ {
    case integers => Integer(integers.toInt)
  }

  // real ::= (\+|-)?[0-9]+\.[0-9]+
  def real: Parser[Real] = """(\+|-)?[0-9]+\.[0-9]+""".r ^^ {
    case doubles => Real(doubles.toDouble)
  }

  // boole ::= true|false

  def boole: Parser[Boole] = """true|false""".r ^^ {
    case booleans => Boole(booleans.toBoolean)
  }

  // identifier ::= [a-zA-Z][a-zA-Z0-9]*
  def identifier: Parser[Identifier] = """[a-zA-Z][a-zA-Z0-9]*""".r ^^ {
    case identifiers => Identifier(identifiers)
  }

  // funCall ::= identifier ~ operands
  def funCall: Parser[FunCall] = identifier ~ operands ^^ {
    case (op ~ ops) => FunCall(op, ops)
  }

  // operands ::= "(" ~ (expression ~ ("," ~ expression)*)? ~ ")"
  def operands: Parser[List[Expression]] = "(" ~ opt(expression ~ rep("," ~> expression)) ~ ")" ^^ {
    case "(" ~ Some(expression ~ more) ~ ")" => expression :: more
    case "(" ~ None ~ ")" => Nil

  }

}
