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
val flightsMarch3 = List(new Flight(123, 0, 30), new Flight(234, 60, 65), new Flight(345, 200, 200, true), new Flight(456, 420, 510))