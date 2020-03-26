package value

class Notification(val name: String) extends Value {

}

object Notification {
  val OK = new Notification("ok")
  val DONE = new Notification("done")
  val SPECIFIED = new Notification("unspecified")

}
