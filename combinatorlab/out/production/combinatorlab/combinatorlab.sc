object combinatorlab{
  def makeIter(init: Int, combiner: (Int, Int) => Int): Int => Int = {
    def r(n: Int) = {
      var result = init
      for (count <- 1 to n) result = combiner(result, count)

      result
    }

    r _

  }

//  def add( x: Int, y:Int) = { x+y }
  val tri = makeIter(0, _ + _)

//  def mult( x: Int, y:Int) = { x*y }
  val fact = makeIter(1, _ * _)


  tri(5)
  fact(3)

}

