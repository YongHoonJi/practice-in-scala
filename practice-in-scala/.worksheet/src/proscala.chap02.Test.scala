package proscala.chap02

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(187); 
  def sleep(millis: Long) = {
    Thread.sleep(millis)
  };System.out.println("""sleep: (millis: Long)Unit""");$skip(81); 
  
  def dowork(index: Int) = {
  	sleep((math.random*1000).toLong)
  	index
  };System.out.println("""dowork: (index: Int)Int""");$skip(259); 
  
  (1 to 5) foreach { index =>
  	val future = Future {
  		dowork(index)
  	}
  	future onSuccess {
  		case answer: Int => println(s"Success! returned: $answer")
  	}
  	future onFailure {
  		case th: Throwable => println(s"Failure! returned: $th")
  	}
  };$skip(21); 
  
  sleep(1000);$skip(20); 
  println("Finish")}
}
