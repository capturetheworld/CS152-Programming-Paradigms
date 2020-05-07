package value
import context._
import expression._

//THUNK is a parameterless closure, includes defining environment

//like flash freezing an expression > closure/lambda execute when you call function
//extraction principle
case class Closure( params: List[Identifier],  body: Expression, defEnv: Environment) extends Value {
  override def toString="closure"

  def apply(args: List[Value], callEnv: Environment = null) = {

    val tempEnv = if (flags.staticScope) new Environment(defEnv) else new Environment(callEnv)
    tempEnv.bulkPut(params, args)
    //bind using bulkput
    body.execute(tempEnv)

  }

}
