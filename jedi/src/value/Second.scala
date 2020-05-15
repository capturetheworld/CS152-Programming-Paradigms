package value

class Second (var content: Value) extends Value {
  override def toString = content.toString
}

object Second {
  def apply(content: Value) = new Second(content)
}