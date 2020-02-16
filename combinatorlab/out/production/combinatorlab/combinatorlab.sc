

  class combinatorlab {
    def makeIter(init: Int, f: (Int, Int) => Int): Int => Int = {
      def r(n: Int) = {
        var result = init
        for (count <- 1 to n) result = f(result, count)

        result
      }

      r _

    }

    val tri = makeIter(0,  _ _)

    tri(5)

  }

