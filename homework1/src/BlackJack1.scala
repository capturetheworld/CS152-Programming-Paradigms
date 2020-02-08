
import scala.util._
import util.control.Breaks._

object BlackJack1 extends App {

  val gen = new Random(System.currentTimeMillis())

  val cards = new Array[Int](52)
  for(i <- 0 until 52) cards(i) = if (gen.nextBoolean()) gen.nextInt(11) else -1

  var total = 0

  breakable {
    for(i <- 0 until 52) {
      breakable {
        if (cards(i) <= 0) break
        total += cards(i)
      }
      if(21 <= total) break

    }
  }

  println("total = " + total)




}