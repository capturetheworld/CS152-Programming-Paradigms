package context
object flags {
  var staticScope = true
  var paramPassing = BY_VALUE
  val BY_VALUE = 0
  val BY_NAME = 1 //thunk
  val BY_TEXT = 2 //text - global

}

