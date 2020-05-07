
package expression

import value._
import context.Environment

//creates and returns a closure params is a list of identifiers - names of values like pi, x, y, z
//body is whatever's inside
case class Lambda(params: List[Identifier],body: Expression) extends SpecialForm{
  override def execute(env: Environment): Value = {
    Closure(params, body, env)

  }
}

