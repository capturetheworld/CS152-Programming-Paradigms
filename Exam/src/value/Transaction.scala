import scala.collection.mutable.ListBuffer

class Transaction(val sourceID: Int, val destID: Int, val amount: Double)  {


}


object Transaction {
  def apply(first: Int, second: Int, dollar: Double) = new Transaction(first, second, dollar)



}

var block = List(
  Transaction(4, 5, 200), // transfer $200 from account 4 to account 5
  Transaction(4, 6, 100), // transfer $100 from account 4 to account 6
  Transaction(5, 6, 30),  // transfer $30 from account 5 to account 6
  Transaction(6, 4, 50))  // transfer $50 from account 6 to account 4

getBalance(4, block)                            //> res0: Double = -250.0
getBalance(5, block)                            //> res1: Double = 170.0
getBalance(6, block)                            //> res2: Double = 80.0

def getBalance(acct: Int, block: List[Transaction]): Double ={
  var credits = block.filter(isCredits(_,acct):Boolean).map(getAmmount _).reduce(_ + _)
  var debits = block.filter(isDebits(_,acct):Boolean).map(getAmmount _).reduce(_ + _)
  credits-debits

}
// balance of acct after all transactions in block have been executed assuming initial balance was $0.00.
def isCredits(toTest: Transaction, account: Int) =  {
  if (toTest.destID == account) true else false
}
def isDebits(toTest: Transaction, account: Int) =  {
  if (toTest.sourceID == account) true else false
}
def getAmmount(toTest: Transaction) =  {
  toTest.amount
}



