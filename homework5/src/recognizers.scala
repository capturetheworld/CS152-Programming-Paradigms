trait Recognizers {
  // matches(s) = s
  def matches(s: String): String => Boolean = {
    def r(s1: String) = s1.trim.equalsIgnoreCase(s)
    r _
  }

  // opt(r) = r?
  def opt(r: String => Boolean): String => Boolean = {
    def inner(s: String) = r(s) || s.isEmpty
    inner _
  }

  // pipe(r1, r2) = r1 | r2
  def pipe(r1: String => Boolean, r2: String => Boolean) : String => Boolean = {
    def piper(s: String) = r1(s) || r2(s)
    piper _
  }

  // follows(r1, r2) = r1 ~ r2
  def follows(r1: String => Boolean, r2: String => Boolean) : String => Boolean = {
    def r(followString: String) = {
      var foundString = false
      for (i <- 0 to followString.length if (!foundString))
        foundString = r1(followString.take(i)) && r2(followString.drop(i))

      foundString
    }
    r _
  }


  // rep(r) = r*
  def rep(r: String => Boolean): String => Boolean = {
    //r1 uses recursion and iteration!
    def r1(s: String): Boolean = {
      var result = false
      if (s == "") result = true
      else {
        for(i <- 0 to s.length if !result)
          result = r(s.take(i)) && r1(s.drop(i))
      }
      result
    }
    r1 _
  }
}


object RecognizerTests extends App with Recognizers {

  // exp1 ::= 00 ~ 11 | 111
  def exp1 = pipe(follows(matches("00"), matches("11")), matches("111"))

  println(exp1("0011")) // = true
  println(exp1("111"))  // = true
  println(exp1("000011")) // = false, too many 0's

  // exp2 ::= (00)* ~ (111) ~ (00)?
  var exp2 = follows(follows(rep(matches("00")), matches("111")), opt(matches("00")))
  println(exp2("0000111")) // = true
  println(exp2("00000011100")) // = true
  println(exp2("00011100")) // = false, #leading zeroes must be even
  println(exp2("11100")) // = true
}