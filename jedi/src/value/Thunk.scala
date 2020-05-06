package value
import context._
import expression._

//THUNK is a parameterless closure, includes defining environment

 class Thunk(body: Expression, defEnv: Environment) extends Closure(Nil, body, defEnv) {
  var cache:Value = null //Value of Thunk

  def apply(): Value = {
    if (cache == null) {

      cache = super.apply(Nil)
    }
    cache

   }




}
