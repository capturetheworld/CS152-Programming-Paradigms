package time1

class Time(val hours: Int, val minutes: Int = 0) {


  if( 0 > hours) throw new Exception("Hours must be non-negative")
  if( 0 > minutes) throw new Exception("Minutes must be non-negative")
  if( 23 > hours) throw new Exception("Hours must be <24")
  if( 59 > minutes) throw new Exception("Minutes must be < 60>")


  def minutesSinceMidNight = hours_ * 60 + minutes_

  def before(other: Time) = this.minutesSinceMidnight < other.minutesSinceMidnight
  override def toString = hours.toString + ":" + if(minutes < 10) "0" else minutes.toString



}


object Time{
  def apply(hours: Int, minutes: Int = 0) = new Time(hours,minutes)
}