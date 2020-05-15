package expression
import context._
import expression._
import value._
import scala.collection.mutable._

//Identifiers are names of values things like add, sub, mul, div
//operands are things like variable or numbers or LAMBDA
//a funcall is add(3,4) can be thunks, texts, or regular expressions

case class FunCall(val operator: Identifier, val operands: List[Expression] = Nil) extends Expression {

  def execute(env: Environment) = {

    val args : List[Value] = flags.paramPassing match{
      case flags.BY_NAME => operands.map(new Thunk(_, env))
      case flags.BY_TEXT => operands.map(new Text(_))
      case flags.BY_VALUE => operands.map((e: Expression) => e.execute(env))
    }


//    val args: List[Value] = operands.map((e: Expression) => e.execute(env))
    //execute arguments to values

    //check if the operator identifier is already defined (for example f was defined)
    if(env.contains(operator)) {
//      val v = operator.execute(env) //identifier execute simply runs env.apply on itself
//      if (!v.isInstanceOf[Closure]) throw new TypeException("Not a closure") {
//        v.asInstanceOf[Closure].apply(args, env)
//      }
      operator.execute(env) match{
        case f: Thunk=> f.apply()
        case f: Text=> f.apply(env)
        case f: Closure => f.apply(args,env)
        case _=> throw new TypeException("Functions only")
      }


    }else{

      if(flags.paramPassing != flags.BY_VALUE)
        //
        alu.execute(operator,operands.map(_.execute(env)))
      else
        //above returns values for example executing x to the env hashmap, will return "3"
        //these values or answers to questions are stored in args and the alu executes them
        //add(x,y) becomes add(3,4) for example (3,4) are the arguments (which of of type value)
        alu.execute(operator, args)

    }



  }


}
