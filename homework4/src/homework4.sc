//1, 2, 6, 7, 13, 15, 16
//problem1
import scala.math.pow

///////////////problem1////////////////////////
def cubeIter(input: List[Int]):Int = {
  var sum = 0
  for(number <- input) {
    if(number % 2 == 1){
      sum = sum + (number*number*number)
    }
  }
  sum
}

def cubeRecur(input: List[Int]):Double = {
  if (input == Nil) 0
  else if (input.head % 2 == 1) pow(input.head,3) + cubeRecur(input.tail)
  else cubeRecur(input.tail)
}

def cubeTail(input: List[Int]):Double = {
  def helper(iterList: List[Int], sum: Double): Double = {
    if (iterList == Nil) sum
    else if (input.head % 2 == 1) + helper(iterList.tail, pow(iterList.head, 3) +sum)
    else cubeTail(iterList.tail)
  }
  helper(input,0.0)
}

def cubeIt(x: Int): Int = x*x*x
def cubePipe(input: List[Int]): Int = input.filter(_ % 2 == 1).map(cubeIt).reduce(_ + _)

///////////////problem2////////////////////////
def sosIter(input: List[List[Int]]) = {
  var sum = 0
  for(containerList <- input){
    for(num <- containerList){
      sum+=num
    }
  }
  sum
}


def sosRecur(input: List[List[Int]]):Int = {
  if(input == Nil) 0
  else input.head.sum + sosRecur(input.tail)

}

def sosTail(input: List[List[Int]]):Int = {
  def helper(result: Int, containerList: List[List[Int]]): Int = {
    if (containerList == Nil) result
    else helper(result + containerList.head.sum, containerList.tail)
  }
  helper(0, input)

}

def sosPipe (input: List[List[Int]]):Int = {
  input.map(_.reduce(_ + _)).reduce(_ + _)
}

///////////////problem6////////////////////////

def preIter[T](input: List[T], predicate: (T) => Boolean): Int = {
  var count = 0
  for(element <- input) {
    if (predicate(element)){
      count += 1
    }
  }
  count
}

def preRecur[T](input: List[T], predicate: (T) => Boolean): Int = {
  if(input == Nil) 0
  else if(predicate(input.head)) (1 + preRecur(input.tail,predicate)) else preRecur(input.tail,predicate)

}

def preTail[T](input: List[T], predicate: (T) => Boolean): Int = {
  def helper(result: Int, containerList: List[T]):Int ={
    if(containerList==Nil) result
    else if(predicate(containerList.head)) helper(result+1,containerList.tail)
    else  helper(result,containerList.tail)
  }
  helper(0,input)
}

def prePipe[T](input: List[T], predicate: (T) => Boolean): Int = {
  input.filter(predicate(_)).size
}


///////////////problem7////////////////////////


def checkIter[T](input: List[T], predicate: (T) => Boolean): Boolean = {
  var flag = true
  for(element <- input) {
    if (!predicate(element)){
      flag = false
    }
  }
  flag
}

def checkRecur[T](input: List[T], predicate: (T) => Boolean): Boolean = {
  if(input == Nil) true
  else if(predicate(input.head)) checkRecur((input.tail),predicate)
  else false
}

def checkTail[T](input: List[T], predicate: (T) => Boolean): Boolean = {
  def helper(status: Boolean,containerList: List[T] ):Boolean = {
    if(containerList == Nil) status
    else if(!predicate(containerList.head)) false
    else(helper(true, containerList.tail))

  }
  helper(true,input)
}

def checkPipe[T](input: List[T], predicate: (T) => Boolean): Boolean = {
  input.filter(predicate(_)).length == input.length
}



///////////////////QUESTION13/////////////////

def makeOnes(): LazyList[Int] = 1 #:: makeOnes
val ones = makeOnes.tail.tail.tail.tail
ones.tail.tail.tail.tail
ones


def makePos(iter: Int = 0): LazyList[Int] = iter #:: makePos(iter+1)
val nonneg = makePos().tail.tail.tail.tail
nonneg.tail.tail.tail.tail
nonneg

def makeEven(iter: Int = 0): LazyList[Int] = iter #:: makeEven(iter+2)

val evennonneg = makeEven().tail.tail.tail.tail
evennonneg.tail.tail.tail.tail
evennonneg

def makeSquares (iter: Int = 0 ): LazyList[Int]=  (math.pow(iter, 2).toInt) #:: makeSquares(iter + 1)
val squared = makeSquares()
squared.tail.tail.tail.tail
squared




///////////////////QUESTION15/////////////////

def spellCheck(doc: List[String], dictionary: List[String]): List[String] = {
  doc.filter(!dictionary.contains((_)))
}



///////////////////QUESTION16/////////////////

def evalMono(mono: (Double, Double), x: Double): Double = {
  mono._1 * math.pow(x, mono._2)
}

def evalPoly(poly: List[(Double, Double)], x: Double): Double ={
  poly.map(evalMono(_, x)).reduce(_ + _)
}
