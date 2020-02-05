object lab1 {
  //problem 1

  def perfectSquare(n: Int): Boolean = {                                         //perfectSquare: perfectSquare[](val n: Int) => Boolean
    var result = false
    for (x <- Range(0, n/2) if !result) {
      if (x * x == n)
        result = true
    }
    result

  }


  perfectSquare(36)                                                              //res0: Boolean = true
  perfectSquare(37)                                                              //res1: Boolean = false

  //problem 2
  def aura(n: Int) =
//    var random = new scala.util.Random
//    val start = 0
//    val end = 100
//
    n match{
      case n if (n%2==0) && (n%3!=0) => 1
      case n if (n%2==0) && (n%3==0)=> 2
      case n if (n%2!=0) && (n%3==0)=> 3
      case _=> 0
    }

  aura(6)
  aura(7)
}                                                                                //
