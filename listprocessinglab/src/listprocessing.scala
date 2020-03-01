class listprocessing {

  // this is how one declares a class with three fields in Scala:
  case class Note(
                   val amplitude: Double, val frequency: Double, val duration: Double = 1.0)

  // a sample score for testing purposes:
  val symphony1 =
    List(Note(3, 30), Note(3.1, 40, .25), Note(3.2, 10, .5),
      Note(5.1, 5, -.75), Note(3.9, 2))
  def maxAmpIterative(score: List[Note]): Unit ={
    var result = 0.0
    for(note <- score if 0 < note.duration)
        result = result + note.amplitude
    result
  }


  def noise(note: Note) = note.frequency < 0

   // def filterNoise(score: List[Note]): List[Note] = a new score with noisy notes eliminated



  def filterNoise(score: List[Note]): List[Note] = {
    var result: List[Note] = Nil
    for(note <- score) if (!noise(note)) result = result :+ note
    result
  }

  def amplifyNote(note: Note, amt: Double = 2.0): Note =
    Note(amt * note.amplitude, note.frequency, note.duration)

  def amplifyIterative(score: List[Note]): List[Note] = {
    var result: List[Note] = Nil
    for(note <- score) result = result :+ amplifyNote(note)
    result
  }

  def amplifyRecursive(score: List[Note]): List[Note] =
    if (score == Nil) Nil
    else amplifyNote(score.head):: amplifyRecursive(score.tail)




}
