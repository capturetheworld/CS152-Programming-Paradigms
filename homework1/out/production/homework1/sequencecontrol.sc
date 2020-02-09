object sequencecontrol {
//PROBLEMS 1-6
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

  //problem 7 in BlackJackX.scala files

//  //problem 8 NOT WORKING!
//  class Realm1Exception extends Exception {}
//  class Realm2Exception extends Exception {}
//  class Realm3Exception extends Exception {}
//  import util.control.Breaks._
//
//  def realm1(n: Int): Int = { // = 1 if n belongs to realm 1, throws an exception otherwise
//    if(n%2==1) 1 else throw new Realm1Exception()
//  }
//  def realm2(n: Int): Int = { // = 2 if n belongs to realm 2, throws an exception otherwise
//    if(n%2==0 && n%3!=0 ) 2 else throw new Realm2Exception()
//  }
//  def realm3(n: Int): Int = { // = 3 if n belongs to realm 3, throws an exception otherwise
//    if(n%6==0 || n%7==0) 3 else throw new Realm3Exception()
//
//
//  }
//  def realm(n: Int): Int = {  // = the realm of n
//    var realm = 0
//    breakable {
//      try {
//        realm1(n)
//        realm = 1
//      }
//      catch {
//        case e: Realm1Exception => println("Not in 1")
//          break
//      }
//    }
//    breakable {
//      try {
//        realm1(n)
//        realm = 2
//      }
//      catch {
//        case e: Realm2Exception => println("Not in 2")
//          break
//      }
//    }
//    breakable {
//      try {
//        realm1(n)
//        realm = 3
//      }
//      catch {
//        case e: Realm3Exception => println("Not in 3")
//          break
//      }
//    }
//    if(realm>0) realm else 0
//
//
//    }
//
//
//
//
//  realm(-5)
//  realm(3)
//  realm(8)
//  realm(12)
//  realm(14)


  //problem 9

  import scala.math._

  def sqrt(x: Double) = {
    if (x < 0) None else Some(math.sqrt(x))
  }

  def log(x: Double) = {
    if (x <= 0) None else Some(math.log(x))
  }

  def sqrtLog(x: Int) = {
    x match {
      case x if x >= 0 =>  sqrt(log(x).get);
      case _ => None
    }
  }


}

