package value

case class SomeValue(var content: Value) extends OptionValue {
  override def toString = "Some(" + content.toString() + ")"

}
