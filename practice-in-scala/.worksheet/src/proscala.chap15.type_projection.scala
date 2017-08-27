package proscala.chap15

//p564
object type_projection {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(100); 
  println("Welcome to the Scala worksheet")
  
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
  };$skip(569); 
  
  //val l1: Serivce.Log = new ConsoleLogger
  
  //val l2: Service1.Log = new ConsoleLogger
  
  //val l3: Service#Log = new ConsoleLogger
  // 클래스에 대한 투영을 사용하여 정적 타입 검사를 통과
  val l4: Service1#Log = new ConsoleLogger;System.out.println("""l4  : proscala.chap15.type_projection.ConsoleLogger = """ + $show(l4 ));$skip(79); val res$0 = 
  
  // 타입 지정자(type designator)는 타입투영(type projection)을 짧게 쓴 것이다. 아래를 보자
 	Int;System.out.println("""res0: Int.type = """ + $show(res$0));$skip(12); val res$1 = 
 	scala.Int;System.out.println("""res1: Int.type = """ + $show(res$1))}
  
}
