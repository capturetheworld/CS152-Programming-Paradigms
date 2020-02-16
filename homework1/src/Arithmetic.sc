object Arithmetic {

  def sqrt(n: Int): Option[Int] = {
    // = None if n < 0
    if (n<0) {
      None
    }
    // = largest int m such that m * m <= n
    else{
      var m = 0
      while((scala.math.pow(m+1,2) <= n)) {
        m+=1
      }
      Option(m)

    }
  }

  def log(n: Int): Option[Int] = {
    // = None if N <= 0
    if (n <= 0) None
    // = largest m such that 2^m <= n
    else {
      var m = 0
      while ((scala.math.pow(2, m+1) <= n)) {
        m += 1
      }
      Option(m)
    }
  }
  log(64)

    def isPrime(n: Int): Option[Boolean] = {
      if (n < 0) None
      else {
        var isPrime = true
        for (divisor <- 2 to n/2) if (n % divisor == 0) {
          isPrime = false
        }
        Option(isPrime)
      }
    }


    def gcd(n: Int, m: Int): Option[Int] = {
      if(n<0 || m<0) None
      // = None if n or m < 0
      // = gcd(m, n) if n < m
      // = largest k dividing both n and m
      var k = 0
      k+=1
      val minimum = scala.math.min(n, m)
      for (i <-  minimum until 1 by -1 if k == 1){
        if (n % i == 0 && m % i == 0){
          k = i
        }
      }
      Option(k)

    }

    def lcm(n: Int, m: Int): Option[Int] = {
      // = None if n < 0 or m < 0
      // = smallest k such that n a,d m divide k
      if (n < 0 || m<0) None
      else {
        var k = n * m
        for (i <- 1 until n * m if k == n * m) {
          if (i % m == 0 && i % n == 0) {
            k = i
          }
        }
        Option(k)
      }
    }

    def phi(n: Int): Option[Int] = {
      // = None if n < 0
      // = # of k <= n such that gcd(k, n) = 1
    if (n < 0) None
    else {
      var k = 0
      for (i <- 1 until n) {
        if (gcd(i, n).contains(1)) {
          k = k + 1
        }
      }
      Option(k)
  }
    }

}



