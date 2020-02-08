object sequencecontrol {

  //problem1
  def kingdom(n: Int): Int = {
    if (n % 2 == 0) (if (n > 10) (if (n % 100 == 0) 1 else 2) else 3) else 4
  }

  kingdom(100)
  kingdom(101)
  kingdom(104)
  kingdom(4)
  kingdom(5)
  kingdom(200)
  kingdom(208)
  kingdom(207)
  kingdom(10)

  //problem2
  def order(n: Int): Int = {

    (if (n % 3 == 0) 1 else 2) * (if (n == 50) 3 else 4) + (if (n % 7 == 0) 5 else 6)

  }

  order(7)
  order(49)
  order(50)
  order(6)

  //problem3 - since there are 2 if conditions, there needs to be 2 else conditions
  //the given code cannot evaluate negative numbers or 0
  def species(n: Int) =
    if (0 < n) if (n % 2 == 0) 1 else 2 else 2

  species(0)
  species(-3)
  species(-4)
  species(44)
  species(45)

  //problem 4
  def tax(x: Int) = {
    x match {
      case x if x < 20000 && x >= 0 => 0.0
      case x if x < 30000 && x >= 0 =>.05 * x
      case x if x < 40000 && x >= 0 =>.11 * x
      case x if x < 100000 && x >= 0 =>.32 * x
      case x if x >= 100000 && x >= 0 =>.50 * x
      case _ => throw new Exception("invalid income")
    }
  }

  tax(12300)
  tax(29000)
  tax(125000)
  tax(1000000)
  tax(0)
  tax(1)
  try {
    tax(-1)
  } catch {
    case e: Exception => println(e)
  }
  try {
    tax(-1000000)
  } catch {
    case e: Exception => println(e)
  }

  //problem 5
  def drawRectangle(x: Int, y: Int): Unit = {

    for (i <- Range(0, x)) {
      for (j <- Range(0, y)) {
        print("*")
      }
      println("")
    }
  }

  drawRectangle(3, 4)



//problem6 multiple generators until a value
  def printSums(n: Int, m: Int): Unit = {
    for(i<- 0 until n; j<- 0 until m){
      println(s"${i} + ${j} = ${i+j}")
    }
  }
  printSums(3, 4)



}

