import scala.collection.mutable._
//problem 1


def countRoots[T](f: T=>Double, inputs: List[T]) = {
  (inputs.map(f).filter(_ == 0.0)).length

}

def poly(x: Double):Double = (x + 1) * (x - 1)
println(countRoots(poly _, List(-1.0, 0.0, 1.0, 2.0)))   // = 2


//problem 2

def double(n: Int): Int = 2 + double(n - 1)
def exp(n: Int): Int = double(exp(n - 1))
def hyperExp(n: Int): Int = exp(hyperExp(n - 1))
def hyper2Exp(n: Int): Int =  exp(hyperExp(n - 1))

def recur(edgecase: Int, recurFunc: Int=>Int): Int => Int = {
  def r(n: Int) = {
    if (n == 0) edgecase else {

      recurFunc(n)
    }

  }
  r _
}

def recurDouble = recur(0,double)
recurDouble(3)

def double2(n: Int): Int = if (n == 0) 0 else 2 + double2(n - 1)
double2(3)




//problem3

class Flight(val flightNo: Int,val eta: Int,val ata: Int,val cancelled: Boolean = false) extends{
  if (flightNo < 0) throw new IllegalArgumentException
  if (eta < 0) throw new IllegalArgumentException
  if (ata < 0) throw new IllegalArgumentException
  override def hashCode = this.toString.##

  override def equals(that: Any): Boolean =
    that match {
      case p: Flight =>
        this.## == p.## &&
          (p.flightNo == this.flightNo) &&
          (p.eta == this.eta)&&
          (p.ata == this.ata) &&
          (p.cancelled == this.cancelled)
      case _ => false
    }


}
val flightsMarch3 = List(new Flight(123, 0, 30),
  new Flight(234, 60, 65),
  new Flight(345, 200, 200, true),
  new Flight(456, 420, 510))

def avg(nums: List[Double]): Double = {
  if (nums.length == 0) throw new Exception("length is 0")
  var sum = 0.0
  for(i <- nums) sum += i
  sum / nums.length
}

def flightDelay(aFlight: Flight):Double = {
  if(!aFlight.cancelled) {
    aFlight.ata - aFlight.eta
  }
  0.0

}

def avgDelay(flights: List[Flight]): Double = {
  flights.map(flightDelay).reduce(avg _)
}


