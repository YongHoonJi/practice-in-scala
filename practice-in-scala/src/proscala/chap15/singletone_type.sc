package proscala.chap15

//p566
//object 키워드 선언시 싱글톤 객체. 싱글턴 타입은 특정 인스턴스에 대한 고유의 타입 지정이다.
object singletone_type {
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
    
  val s11 = new Service1                          //> s11  : proscala.chap15.singletone_type.Service1 = proscala.chap15.singletone
                                                  //| _type$$anonfun$main$1$Service1$1@30c7da1e
  val s12 = new Service1                          //> s12  : proscala.chap15.singletone_type.Service1 = proscala.chap15.singletone
                                                  //| _type$$anonfun$main$1$Service1$1@5b464ce8
  
  val l1: Logger = s11.logger                     //> l1  : proscala.chap15.singletone_type.Logger = proscala.chap15.singletone_ty
                                                  //| pe$$anonfun$main$1$ConsoleLogger$1@57829d67
  val l2: Logger = s12.logger                     //> l2  : proscala.chap15.singletone_type.Logger = proscala.chap15.singletone_ty
                                                  //| pe$$anonfun$main$1$ConsoleLogger$1@19dfb72a
  // 싱글톤 타입 지정
  val l11: s11.logger.type = s11.logger           //> l11  : proscala.chap15.singletone_type.s11.logger.type = proscala.chap15.sin
                                                  //| gletone_type$$anonfun$main$1$ConsoleLogger$1@57829d67
  
  //val l12: s11.logger.type = s12.logger
  
  // 싱글톤 타입 지정 메소드
  case object Foo { override def toString = "Foo says Hello!" }
  def printFoo(foo: Foo.type) = println(foo)      //> printFoo: (foo: proscala.chap15.singletone_type.Foo.type)Unit
  
  printFoo(Foo)                                   //> Foo says Hello!
  
  
  
}