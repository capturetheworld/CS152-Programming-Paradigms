object lab1 {
  //problem 1

  def perfectSquare(n: Int): Boolean = {
    var result = false
    for (x <- Range(0, n) if !result) {
      if (x * x == n)
        result = true
    }
    result

  }


  perfectSquare(36)
  perfectSquare(37)

}
