package proscala.chap15

//p558
object type_path {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  class Service {
  	class Logger {
  		def log(message: String): Unit = println(s"log:&message")
  	}
  	
  	val logger: Logger = new Logger
  }
  
  val s1 = new Service                            //> s1  : proscala.chap15.type_path.Service = proscala.chap15.type_path$$anonfun
                                                  //| $main$1$Service$1@511baa65
  //val s2 = new Service { override val logger = s1.logger }
  
}