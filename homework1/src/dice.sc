object dice {
  import scala.util.Random

  def rollDice(): (Int, Int)= {
    val seed = new scala.util.Random(scala.util.Random.nextInt)
    (seed.nextInt(6) + 1, seed.nextInt(6) + 1)


  }

  rollDice()
  rollDice()
  rollDice()
  rollDice()


}