package value

class Notification(val name: String) extends Value {
  override def toString = name

}


object Notification {
  val OK = new Notification("ok")
  val DONE = new Notification("done")
  val UNSPECIFIED = new Notification("unspecified")
  val BREAK = new Notification("break")
  def apply(printout: String) = new Notification(printout)

}
