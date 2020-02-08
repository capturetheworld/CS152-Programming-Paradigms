
import scala.util._
import util.control.Breaks._

object BlackJack3 extends App {

  val gen = new Random(System.currentTimeMillis())

  val cards = new Array[Int](52)
  for(i <- 0 until 52) cards(i) = if (gen.nextBoolean()) gen.nextInt(11) else -1

  var total = 0


    for(i <- 0 until 52 if 21 > total) {
        if (cards(i) > 0)
          total += cards(i)
    }



  println("total = " + total)




}