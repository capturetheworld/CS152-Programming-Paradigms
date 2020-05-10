
package expression

import value.Value
import context.Environment

//questions where values are answers
//all things inside expression are case classes

trait Expression {
  def execute(env: Environment): Value
}