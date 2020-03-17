package StackMachine
import scala.collection.mutable.ArrayBuffer
class sm {


  trait Command {
    def execute()
  }

  class Stack[T] ( val capacity: Int = 100) {
     val items: ArrayBuffer[T] = new ArrayBuffer[T](capacity)
     var count = 0
    def clear {
      count = 0
      items.clear
    }
    def push(elem: T) {
      if (items.size > count) {
        items(count) = elem
        count+=1
      }
      else {items += elem; count += 1}
    }
    def pop() {
      if (count > 0) {
        count -= 1
      }
      else println("Cannot pop")
    }
    def top: Option[T] = if (count > 0) Some(items(count - 1)) else None
  }


    object StackMachine {
    val stack = new Stack[Int]()
    var program = List[Command]()

    def run() = {
      stack.clear
      for (command <- program)
        command.execute()
    }
  }

  class Pop extends Command{
    def execute() {StackMachine.stack.pop()}
  }

  object Pop {
    def apply() = new Pop
  }

  class Push(val input: Int) extends Command {
    def execute() {StackMachine.stack.push(input)}
  }

  object Push {
    def apply(x: Int) = new Push(x)
  }

  class Top extends Command {
    def execute()  {
      val topFound = StackMachine.stack.top
      if(topFound == None) println("There is no top.")
      else println("Top = " + topFound.get)
    }
  }
  object Top {
    def apply() = new Top()
  }

}
