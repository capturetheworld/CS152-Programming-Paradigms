package context

import expression._
import value._

/*
 * Notes:
 * alu implements all low-level arithmetic, logic, and I/O functions
 * alu does lots of type checking
 * alu is a singleton
 */
object alu {
  // dispatcher
  def execute(opcode: Identifier, args: List[Value]): Value = {
    opcode.name match {
      case "add" => add(args)
      case "mul" => mul(args)
      case "sub" => sub(args)
      case "div" => div(args)
      case "less" => less(args)
      case "more" => more(args)
      case "equals" => equals(args)
      case "unequals" => unequals(args)
      case "not" => not(args)
      // variables
      case "dereference" => dereference(args)
      case "var" => makeVar(args)
      // primitive I/O ops:
      case "write" => write(args)
      case "prompt" => prompt(args)
      case "read" => read(args)
      // store ops
      /*
      case "store" => store(args)
      case "put" => put(args)
      case "rem" => rem(args)
      case "contains" => contains(args)
      case "map" => map(args)
      case "filter" => filter(args)
      case "get" => get(args)
      case "addLast" => addLast(args)
      case "size" => size(args)
      */
      case _ => throw new UndefinedException(opcode)
    }
  }
  
   // variable ops
   
   // returns the content of args(0)
   private def dereference(args: List[Value]) = {???}
   
   // creates a new variable cobtaining args(0)
   private def makeVar(args: List[Value]) = {???}
   
   /*
   // store ops
   
   // returns a new store containing args
   private def store(args: List[Value]) = {???}
   
   // put(v: Value, p: Integer, s: Store) calls s.put(v, p)
   private def put(args: List[Value]) = {
     if (args.size != 3)
        throw new TypeException("expected signature: put(v: Value, p: Integer, s: Store)")
     if(!args(1).isInstanceOf[Integer] || !args(2).isInstanceOf[Store]) 
        throw new TypeException("expected signature: put(v: Value, p: Integer, s: Store)")
     args(2).asInstanceOf[Store].put(args(0), args(1).asInstanceOf[Integer])
     Notification.DONE
   } 
   
   // rem(p: Integer, s: Store) calls s.rem(p)
   private def rem(args: List[Value]) = {???}
   
   // get(p: Integer, s: Store) calls s.get(p)
   private def get(args: List[Value]) = {???}
   
   // map(f: Closure, s: Store) calls s.map(f)
   private def map(args: List[Value]) = {???} 
   
   // filter(f: Closure, s: Store) calls s.filter(f)
   private def filter(args: List[Value]) = {???} 
   
   // contains(v: Value, s: Store) calls s.contains(v)
   private def contains(args: List[Value]) = {???}
   
   // addLast(v: Value, s: Store) calls s.add(v)
   private def addLast(args: List[Value]) = {???}
   
   // size(s: Store) calls s.size
   private def size(args: List[Value]) = {???}
   */
   
  // etc.
}