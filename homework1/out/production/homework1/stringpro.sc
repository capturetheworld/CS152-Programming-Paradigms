object stringpro {
//problem1
  def isPal(n: String): Boolean = {


    var rev = n.reverse
    if (rev.trim() == n.trim()){
      true

    }
    else {
      false
    }


  }

  isPal("rotator")                                //> res0: Boolean = true
  isPal("cat")                                    //> res1: Boolean = false
  isPal("Civic")                                  //> res2: Boolean = false
  isPal("Toyota")                                 //> res3: Boolean = false
  isPal("$3.1441.3$")
  isPal("      rotator ")


  //problem2

  def isPal2(n: String): Boolean = {
    var rev = n.reverse
    var revModified = rev.trim.toLowerCase.replaceAll(
      "[,.!?:;]", "").replaceAll("\\s", "")
    var nModified = n.trim.toLowerCase.replaceAll(
      "[,.!?:;]", "").replaceAll("\\s", "")
    println(revModified)
    println(nModified)

    if (revModified==nModified){
      true
    }
    else {
      false
    }


  }

  isPal2("A man, a plan, a canal, Panama!")


  //problem3
  import scala.util.Random


  def mkWord(size: Int = 5): String = {
    var gen = ""
    val rand = new Random

    for(i<- 0 until size){
      val myRandomNumber = rand.nextInt(0x1A) + 0x61
      gen += myRandomNumber.toChar

    }
    gen

  }
  mkWord(4)
  mkWord()

  //problem4

  def mkSentence(size: Int = 10): String =
  {
    var gen = ""+mkWord(1).toUpperCase()

    val rand = scala.util.Random
    for (i <- 0 until size) {
      val randomnum = rand.nextInt(8) + 2
      val string = mkWord(randomnum)
      gen = gen.concat(string + " ")

    }

    gen = gen.trim()+"."
    gen

  }

  mkSentence()
  mkSentence(4)
}

//PROBLEM 7 in Peano


