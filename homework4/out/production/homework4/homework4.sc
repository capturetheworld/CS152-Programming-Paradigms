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


///////////////problem6////////////////////////


///////////////problem7////////////////////////

