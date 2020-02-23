import DDS.controlLoop

def controlLoop[S](
    state: S,
    cycle: Int,
    halt: (S, Int)=> Boolean,
    update: (S, Int) => S): S = {
  if (halt(state, cycle)) {
    state
  }
  else {
    controlLoop(update(state, cycle), cycle + 1, halt, update)
  }
}
  //problem 2
  def popGrow(pondSize: Int) = {
    controlLoop(pondSize, 0, (x: Int, week: Int) => x > 100000, (x: Int, week: Int) => x*2)
  }

  println("amoebas(1) = " + popGrow(1))
  println("amoebas(5) = " + popGrow(5))



