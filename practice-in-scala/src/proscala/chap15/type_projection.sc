package proscala.chap15

//p564
object type_projection {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  trait Logger {
  	def log(message: String): Unit
  }
  
  class ConsoleLogger extends Logger {
  	def log(message: String): Unit = println(s"log:$message")
  }
  
  trait Service {
  	type Log <: Logger
  	val logger: Log
  }
  
  class Service1 extends Service{
  	type Log = ConsoleLogger
  	val logger: ConsoleLogger = new ConsoleLogger
  }
  
  //val l1: Serivce.Log = new ConsoleLogger
  
  //val l2: Service1.Log = new ConsoleLogger
  
  //val l3: Service#Log = new ConsoleLogger
  // 클래스에 대한 투영을 사용하여 정적 타입 검사를 통과
  val l4: Service1#Log = new ConsoleLogger        //> l4  : proscala.chap15.type_projection.ConsoleLogger = proscala.chap15.type_p
                                                  //| rojection$$anonfun$main$1$ConsoleLogger$1@511baa65
  
  // 타입 지정자(type designator)는 타입투영(type projection)을 짧게 쓴 것이다. 아래를 보자
 	Int                                       //> res0: Int.type = object scala.Int
 	scala.Int                                 //> res1: Int.type = object scala.Int
  
}