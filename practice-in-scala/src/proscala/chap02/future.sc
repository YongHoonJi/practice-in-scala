package proscala.chap02

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Test {
  def sleep(millis: Long) = {
    Thread.sleep(millis)
  }                                               //> sleep: (millis: Long)Unit
  
  def dowork(index: Int) = {
  	sleep((math.random*1000).toLong)
  	index
  }                                               //> dowork: (index: Int)Int
  
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
  }
  
  sleep(1000)                                     //> Success! returned: 4
                                                  //| Success! returned: 5
                                                  //| Success! returned: 1
                                                  //| Success! returned: 3
                                                  //| Success! returned: 2
  println("Finish")                               //> Finish
}