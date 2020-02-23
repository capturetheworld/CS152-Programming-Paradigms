
def controlLoop[S](state: S, cycle: Int, halt: (S, Int)=> Boolean, update: (S, Int) => S): S = {
  if (halt(state, cycle)) {
    state
  }
  else {
    controlLoop(update(state, cycle), cycle + 1, halt, update)
  }
}
  //problem 2
  def popGrow(pondSize: Int) = {
    controlLoop(pondSize, //state
      0, //cycle
      (x: Int, week: Int) => x > 100000, //halt
      (x: Int, week: Int) => x*2)//update
  }

  println("amoebas(1) = " + popGrow(5000))
  println("amoebas(5) = " + popGrow(5))


//problem3
def solve(f: Double=>Double): Double = {
  val delta = 0.000000000001 //approaches 0
  def prime(x: Double) = (f(x + delta) - f(x)) / delta
  def toHalt(guess: Double, time: Int) = math.abs(f(guess)) <= delta
  def refine(guess: Double, time: Int) = guess - f(guess) / prime(guess)

  controlLoop(
    1.0, //state
    0, //cycle
    toHalt, //halt
    refine)//update

}

//problem4
def squareRoot(x: Double): Double = solve((y: Double) => math.pow(y,2) - x)
//problem5
def cubeRoot(x: Double): Double = solve((y: Double) => math.pow(y,3) - x)
//problem6
def nthRoot(x: Double, power: Double): Double = solve((y: Double) => math.pow(y,power) - x)


squareRoot(16)
cubeRoot(27)

//problem6

def getValue(init: Int) = {


  def monthly(a: Double, time: Int) = a*(a + (1.0 / init))
  def finalValue(a: Double, time: Int) = init <= time

  controlLoop(1.0, 0, finalValue, monthly)
}




