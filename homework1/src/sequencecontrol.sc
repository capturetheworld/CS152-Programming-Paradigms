object sequencecontrol{

  //problem1
  def kingdom(n: Int): Int = {                                                   //kingdom: kingdom[](val n: Int) => Int
    if(n%2==0) (if(n>10) (if(n%100==0) 1 else 2) else 3) else 4
  }

  kingdom(100)                                                                   //res0: Int = 1
  kingdom(101)                                                                   //res1: Int = 4
  kingdom(104)                                                                   //res2: Int = 2
  kingdom(4)                                                                     //res3: Int = 3
  kingdom(5)                                                                     //res4: Int = 4
  kingdom(200)                                                                   //res5: Int = 1
  kingdom(208)                                                                   //res6: Int = 2
  kingdom(207)                                                                   //res7: Int = 4
  kingdom(10)                                                                    //res8: Int = 3

  //problem2
}                                                                                //
