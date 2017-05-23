package proscala.chap02

import java.io._
// 추상화 타
object abstractType {
  abstract class BulkReader {
    type In // 추상맴버
    val source: In // 추상맴버
    def read: String // 추상맴버
  }

  class StringBulkReader(val source: String) extends BulkReader {
    type In = String // 추상 맴버In을source를 String형으로 지정
    def read: String = source
  }

  class FileBulkReader(val source: File) extends BulkReader {
    type In = File // 추상 맴버In을source를File형으로 지정
    def read: String = {
      val in = new BufferedInputStream(new FileInputStream(source))
      val numBytes = in.available()
      val bytes = new Array[Byte](numBytes)
      in.read(bytes, 0, numBytes)
      new String(bytes)
    }
  }
  
  println(new StringBulkReader("Hello").read)     //> Hello
  println(new FileBulkReader(
  	new File("/Users/Justin/git/practice-in-scala/practice-in-scala/src/proscala/chap02/factorial.sc")).read)
                                                  //> package proscala.chap02
                                                  //| 
                                                  //| import scala.annotation.tailrec
                                                  //| 
                                                  //| object factorial {
                                                  //| 
                                                  //| 	def factorial(i: Int): Long = {
                                                  //| 		// nested function
                                                  //| 		@tailrec
                                                  //| 		def fact(i: Int, acc: Long):Long = {
                                                  //| 			if(i <= 1) acc
                                                  //| 			else fact(i-1, i*acc)
                                                  //| 		}
                                                  //| 		fact(i, 1)
                                                  //| 	}                                         //> factorial: (i: Int)Long
                                                  //| 	
                                                  //| 	(0 to 10) foreach ( i => println(factorial(i)) )
                                                  //|                                                   //> 1
                                                  //|                                                   //| 1
                                                  //|                                                   //| 2
                                                  //|                                                   //| 6
                                                  //|                                                   //| 24
                                                  //|                                                   //| 120
                                                  //|                                                   //| 720
                                                  //|                                                   //| 5040
                                                  //|                                                   //| 40320
                                                  //|            
                                                  //| Output exceeds cutoff limit.
}