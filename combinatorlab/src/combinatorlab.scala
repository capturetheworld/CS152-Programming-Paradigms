class combinatorlab {
  def makeIter(init: Int, f: (Int, Int) => Int): Int => Int = {
    def r(n: Int) = {
      var result = init
      for (count <- 1 to n) result = f(result, count)

      result
    }

    r _

  }

  def add( x: Int, y:Int) = { x+y }
  val tri = makeIter(0, add _)


  tri(5)

}

