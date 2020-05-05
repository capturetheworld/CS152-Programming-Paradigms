package value
import context._
import expression._

//like flash freezing an expression > closure/lambda execute when you call function
//extraction principle
case class Closure(params: List[Identifier], body: Expression, defEnv: Environment ) extends Value {
  def apply(args: List[Value]) = {
    
    var tempEnv = new Environment(defEnv)
    tempEnv.bulkPut(params, args)
    //bind using bulkput
    body.execute(tempEnv)

  }

}