case class Note(
                 val amplitude: Double, val frequency: Double, val duration: Double = 1.0)

// a sample score for testing purposes:
val symphony1 =
  List(Note(3, 30), Note(3.1, 40, .25), Note(3.2, 10, .5),
    Note(5.1, 5, -.75), Note(3.9, 2),  Note(3.9, -20, 2))

def noise(note: Note) = note.frequency < 0

def filterNoise(score: List[Note]): List[Note] = {
   var result: List[Note] = Nil
   for (note <- score) if (!noise(note)) result = result :+ note
  result
}

def filterNoiseRecursive(score: List[Note]): List[Note] = {
  if(score == Nil) Nil
  else if(noise(score.head)) filterNoiseRecursive(score.tail)
  else score.head::filterNoiseRecursive(score.tail)
}

def filterNoiseTail(score: List[Note]): List[Note] = {
  score.filter((n:Note) => !noise(n))
}

filterNoise(symphony1)
filterNoiseRecursive(symphony1)
filterNoiseTail(symphony1)