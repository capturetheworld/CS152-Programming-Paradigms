package expression
import context.Environment
import value._


//Identifiers are names of values. To execute an identifier we simply look it up in the environment.
//things like add, sub, mul, div
case class Identifier(val name: String) extends Expression {
  override def toString = name

  def head = this

  override def equals(other: Any) =
    if(!other.isInstanceOf[Identifier]) false
    else this.name==other.asInstanceOf[Identifier].name

  override def hashCode = this.toString.hashCode

  def execute(env: Environment) = env(this) match {
    case thunk: Thunk => thunk()
    case text: Text => text(env)
    case value: Value => value

  }

}