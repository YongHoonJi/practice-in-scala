package proscala.chap15

//p558
object type_path {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(94); 
  println("Welcome to the Scala worksheet")
  
  class Service {
  	class Logger {
  		def log(message: String): Unit = println(s"log:&message")
  	}
  	
  	val logger: Logger = new Logger
  };$skip(175); 
  
  val s1 = new Service;System.out.println("""s1  : proscala.chap15.type_path.Service = """ + $show(s1 ))}
  //val s2 = new Service { override val logger = s1.logger }
  
}
