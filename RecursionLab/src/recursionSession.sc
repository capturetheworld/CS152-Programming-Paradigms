import scala.annotation.tailrec

object recursionSession{
  def inc(n: Int) = n + 1
  def dec(n: Int) = n - 1
  def isZero(n: Int) = n == 0
 //problem 1
  def add(n: Int, m: Int):Int = {
    if(isZero(m)){
      n
    }
    else {

      add(inc(n), dec(m))
    }


  }

  add(4,3)
  add(0,1)
  add(0,1)
  add(5,33)
  add(1000000000,1000000000)


  //problem2

  def mul(n: Int, m: Int):Int = {
    //println(n)
    if(isZero(m)){
      0
    }
    else{
      add(n,mul(n,dec(m)))
    }


  }
  mul(7,3)
  mul(3,7)
  mul(1,4)
  mul(1,1)
//  mul(1000000000,1000000000)

  //problem3

  def exp(m: Int):Int = {
    //println(n)
    if(isZero(m)){
      1
    }
    else{
      mul(2,exp(dec(m)))
    }


  }

  exp(2)
  exp(3)
  exp(4)

  //problem4

  def hyperExp(n: Int):Int = {
    //println(n)
    if(isZero(n)){
      0
    }
    else{
      exp(hyperExp(dec(n)))
    }


  }
  hyperExp(0)
  hyperExp(1)
  hyperExp(2)
  hyperExp(3)
  hyperExp(4)


  //problem 5.1

  def tailAdd(n: Int, m:Int):Int = {
    @tailrec
    def helper(total: Int, counter: Int):Int =
    {
      if (isZero(counter)) {
        total
      }
      else {

        helper(inc(total), dec(counter))
      }
    }

    helper(n,m)

  }

  //problem 5.2

  def tailMult(n: Int, m:Int):Int = {
    def helper(counter: Int, total: Int): Int = {
      if (isZero(counter)) {
        total
      } else {

        helper(dec(counter), tailAdd(total, m))
      }
    }
    helper(n,0)





  }

  tailMult(3,4)

  //problem 5.3

  def tailExp(m:Int):Int = {
    def helper(counter: Int, total: Int): Int = {
      if (isZero(counter)) {
        total
      } else {

        helper(dec(counter), tailMult(total, 2))
      }
    }
    helper(m,1)





  }

  tailExp(2)
  tailExp(3)
  tailExp(4)


  //problem 5.4

  def tailHyper(m:Int):Int = {
    def helper(counter: Int, total: Int): Int = {
      if (isZero(counter)) {
        total
      } else {

        helper(dec(counter), tailExp(total))
      }
    }
    helper(m,0)
  }

//problem 9
  def fib(n:Int):Int={
    if(n<=1){
      n
    }
    else{
      fib(n-1) + fib(n-2)
    }
  }
  fib(3)
  fib(5)
  fib(6)
  fib(7)

  def tailFib(n:Int): Int = {
    def helper(n: Int, a: Int, b: Int):Int  = {
//      println("  n is " + n)
      if(n==0) {
//        println("  a is " + a)
        a
      }
      else if (n==1) {
//        println("  b is " + b)
        b
      }

      else{
        helper(n-1, b, a+b)
      }


    }
    helper(n,0,1)
  }


  tailFib(5)
  tailFib(6)
  tailFib(7)







}