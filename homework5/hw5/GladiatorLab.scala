object GladiatorLab extends App {

  class Gladiator(val name: String)  {
    var health=100

    def damage(delta: Int): Unit = {
      health = health - delta
      if(health < 0){
        health = 0
      }
    }

    def attack(opponent: Gladiator) = {
      if(this.health > 0 && opponent.health>0){
        println("Attacker: " + this.name + " Victim: " + opponent.name)
        opponent.damage(scala.util.Random.nextInt(health))
      }
      else{
        println("Dead gladiators don't fight!")
      }
    }

  }

  trait Slasher {
    def slash(opponent: Gladiator) { println("Slashing"); opponent.damage(5) }
  }

  trait Masher {
    def mash(opponent: Gladiator) { println("Mashing!"); opponent.damage(5) }
  }

  trait Crusher {
    def crush(opponent: Gladiator) { println("Crushing"); opponent.damage(5) }
  }

  class CrusherMasher(name: String) extends Gladiator(name) with Masher with Crusher {
    override def attack(opponent: Gladiator): Unit = {
      super.attack(opponent)
      crush(opponent)
      mash(opponent)
    }


  }

  var optimusprime = new CrusherMasher("Optimus Prime")
  var bumblebee = new Gladiator("Bumble Bee") with Slasher with Masher {
    override def attack(opponent: Gladiator): Unit = {
      super.attack(opponent)
      slash(opponent)
      mash(opponent)
    }
  }

  for(i <- 0 to 5) {
    optimusprime.attack(bumblebee)
    bumblebee.attack(optimusprime)
  }

}

