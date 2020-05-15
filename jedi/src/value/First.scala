package value

class First (var content: Value) extends Value {
  override def toString = content.toString
}

object First {
  def apply(content: Value) = new First(content)
}
