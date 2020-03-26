package value

import expression._

case class Chars(val value: String) extends Literal  with Equals {

  def <(other: Chars) = this.value<other.value
  def ==(other: Chars) = this.value.equals(other.value)
  def +(other: Chars) = Chars(this.value + other.value)

  def substring(start: Integer) = Chars(this.value.substring(start.value))
  def substring(start: Integer, end:Integer) = Chars(this.value.substring(start.value,end.value))

  // *, -, /


}
