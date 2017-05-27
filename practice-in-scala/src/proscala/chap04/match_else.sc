package proscala.chap04

// 값에 대해 매칭을 사용할 수 있다.
object match_else {
	 val head +: tail = List(1,2,3)           //> head  : Int = 1
                                                  //| tail  : List[Int] = List(2, 3)
	 
	 val head1 +: head2 +: tail2 = Vector(1,2,3)
                                                  //> head1  : Int = 1
                                                  //| head2  : Int = 2
                                                  //| tail2  : scala.collection.immutable.Vector[Int] = Vector(3)
	val Seq(a,b,c) = List(1,2,3)              //> a  : Int = 1
                                                  //| b  : Int = 2
                                                  //| c  : Int = 3
	val Seq(a1,b1,c1) = List(1,2,3,4)         //> scala.MatchError: List(1, 2, 3, 4) (of class scala.collection.immutable.$col
                                                  //| on$colon)
                                                  //| 	at proscala.chap04.match_else$$anonfun$main$1.apply$mcV$sp(proscala.chap
                                                  //| 04.match_else.scala:9)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at proscala.chap04.match_else$.main(proscala.chap04.match_else.scala:4)
                                                  //| 	at proscala.chap04.match_else.main(proscala.chap04.match_else.scala)
                                                  
	case class Address(street: String, city: String, country: String)
  case class Person(name: String, age: Int, address: Address)

  val alice = Person("Alice", 25, Address("1 scala lane", "chicago", "USA"))
  
 if(alice == Person("Alice", 25, Address("1 scala lane", "chicago", "USA"))) "yes" else "no"
	 
	 
}