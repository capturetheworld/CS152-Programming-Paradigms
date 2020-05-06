package value

import context.Environment
import expression.{Expression, Identifier}

class Text(body: Expression) extends Value {
  private var cache: Value = null
  def apply(callEnv:Environment) = {
    if(cache == null){
      cache = body.execute(callEnv)
    }
    cache
  }
}