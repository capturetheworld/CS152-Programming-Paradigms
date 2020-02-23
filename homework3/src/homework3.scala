
object homework3 extends App {
  //question1
  def compose[T](f: T => T, g: T => T): T => T = { //returns the inner function
    (x: T) => f(g(x))
  }

  //question2
  def selfIter[T](f: T => T, n: Int): T => T = { //returns a function
    if (n == 1) {
//      println("n is now 1")
//      println("x is now " + x)
      f
    }
    else if (n==0){
      (x: T) => x
    }
//    else if (n==1) f
    else {
      compose(f,selfIter(f , n - 1))
    }
  }

  def inc(x: Double):Double = {
    x + 1;
  }

  def double(x: Double):Double = 2 * x


  println(selfIter(inc, 0)(2))

  //question3

  def countPass[T](inputArray: Array[T]): Int ={
    var counter = 0
    for(i <- inputArray){
      if(i.isInstanceOf[Boolean]) counter+=1
    }
    counter
  }

  println("There are this many booleans in your array: " + countPass(Array(true, false,true,5,6,2,7)))
//  val testArray = Array(true,4.55, 3.620, true, true, "string it", 3)
//
//  println("There are this many booleans in your array: " + countPass(testArray))


  ///////////////////
  //question4
  ///////////////////

  def recur(baseVal: Int, combiner: (Int, Int)=>Int): Int=>Int = {

    def r(n: Int): Int = {
      var result = baseVal
      println(baseVal)
      for (count <- 1 to n) result = {
//        println(result + " result")
//        println(count + " count")
        combiner(result, count)

      }
//      println(result + " result 2")
      result
    }

    r _


  }

  val factorial = recur(1, _ * _)

  println(factorial(4))

  ///////////////////
  //question5
  ///////////////////

  def deOptionize[I,O](f: I => Option[O]):I => O = {
    def g(x: I): O = {
      if(f(x) == None) throw new Exception("The error was None")
      else f(x).get
      }

    g
  }
  def parseDigits(digits: String): Option[Int] =
    if (digits.matches("[0-9]*")) Some(digits.toInt) else None
  val optionDisable = deOptionize[String, Int](parseDigits)
//  optionDisable("H1029")
  ///////////////////
  //question6
  ///////////////////

  def combinator(combiner: (Double, Double) => Double ): (Double, Int) => Double = { //returns the inner function
    def h(init: Double, n: Int) : Double = {
      var result = init
      for(i <- 1 to n) result = combiner(result,result)

      result
    }
    h
  }

  val square = combinator(_ * _)

  println(square(2,2))

  ///////////////////
  //question7
  ///////////////////
  def cube(n: Int) = n * n * n

  def unitTest[T,S](f: T => S, inputList: Array[(T,S)]): Int = {

    var fails = 0
    for((input, toCheck) <- inputList ){
      if(f(input) != toCheck)
        fails+=1
    }
    fails
  }

  println(unitTest(cube, Array((1, 1), (2, 8), (3, 9), (4, 64), (5, 124))))



}