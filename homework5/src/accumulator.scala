class accumulator {

  trait Instruction {
    var register = 0; var halt = false; var IP = 0
    def execute()
  }

  object Accumulator extends App {
    var register = 0
    var program  = List[Instruction]()
    var IP = 0
    var halt = false


    def run() {
      register = 0; IP = 0; halt = false
      while (IP < program.size && !halt) {
        program(IP).execute()
        IP = IP + 1
      }
    }
  }


  class Add(val x: Int) extends Instruction {
    def execute {register = register + x}
  }

  object Add {
    def apply(x: Int) = new Add(x)
  }

  class Mul(val x: Int) extends Instruction {
    def execute {register = register * x}
  }

  object Mul {
    def apply(x: Int) = new Mul(x)
  }

  class Halt extends Instruction{
    def execute {halt = true}
  }

  object Halt {
    def apply() = new Halt
  }

  class Goto(val arg: Int) extends Instruction {
    def execute {IP = arg}
  }

  object Goto {
    def apply(arg: Int) = new Goto(arg)
  }


  // computing ((3 * 5) + 1) * 2
  Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2))
  Accumulator.run()
  Accumulator.register                           //> res6: Int = 32
  // computing (((10 * 2) + 3) * 5)
  Accumulator.register = 0
  Accumulator.program = List(Add(10), Mul(2), Add(3), Mul(5))
  Accumulator.run()
  Accumulator.register                           //> res7: Int = 115

}
