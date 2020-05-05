package context

import scala.collection.mutable._
import value._
import expression._

class Environment(var extension: Environment = null) //recursive data structure, chain env extensions
  extends HashMap[Identifier, Value] with Value { //associates identifiers def pi = 3.14 with values

  // used by closures to bind parameters to arguments
  def bulkPut(params: List[Identifier], args: List[Value]) {
    if (params.length != args.length) throw new TypeException("# arguments != #parameters")
    for(i <- 0 until params.length) this.put(params(i), args(i))
  }

  override def contains(name: Identifier): Boolean = {
    super.contains(name) || (extension != null && extension.contains(name))
    //looks inside hashmap and sees if that name is in there, look in extensions
  }

  override def apply(name: Identifier): Value = { //searching environment, look up identifier
    if (super.contains(name)) super.apply(name) //if hashmap contains name, search hashmap
    else if (extension != null) extension.apply(name) //recursively call name
    else throw new UndefinedException(name) //can't find the identifier, so we're in global env throw err
  }
}