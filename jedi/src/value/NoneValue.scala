package value
import expression.Literal

//class NoneValue() extends OptionValue with Literal {
//  override def toString = "None"
//}

//object NoneValue {
//  def apply() = new NoneValue()
//}
object NoneValue extends Literal with OptionValue{
  override def toString = "None"


}
