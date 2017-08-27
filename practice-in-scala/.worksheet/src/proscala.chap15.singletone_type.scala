package proscala.chap15

//p566
//object 키워드 선언시 싱글톤 객체. 싱글턴 타입은 특정 인스턴스에 대한 고유의 타입 지정이다.
object singletone_type {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(158); 
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
  };$skip(380); 
    
  val s11 = new Service1;System.out.println("""s11  : proscala.chap15.singletone_type.Service1 = """ + $show(s11 ));$skip(25); 
  val s12 = new Service1;System.out.println("""s12  : proscala.chap15.singletone_type.Service1 = """ + $show(s12 ));$skip(33); 
  
  val l1: Logger = s11.logger;System.out.println("""l1  : proscala.chap15.singletone_type.Logger = """ + $show(l1 ));$skip(30); 
  val l2: Logger = s12.logger;System.out.println("""l2  : proscala.chap15.singletone_type.Logger = """ + $show(l2 ));$skip(55); 
  // 싱글톤 타입 지정
  val l11: s11.logger.type = s11.logger
  
  //val l12: s11.logger.type = s12.logger
  
  // 싱글톤 타입 지정 메소드
  case object Foo { override def toString = "Foo says Hello!" };System.out.println("""l11  : proscala.chap15.singletone_type.s11.logger.type = """ + $show(l11 ));$skip(176); 
  def printFoo(foo: Foo.type) = println(foo);System.out.println("""printFoo: (foo: proscala.chap15.singletone_type.Foo.type)Unit""");$skip(19); 
  
  printFoo(Foo)}
  
  
  
}
