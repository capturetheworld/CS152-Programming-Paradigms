
package expression

import value.Value
import context.Environment

//questions where values are answers

trait Expression {
  def execute(env: Environment): Value
}