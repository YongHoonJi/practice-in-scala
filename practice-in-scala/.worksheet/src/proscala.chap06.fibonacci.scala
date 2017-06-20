package proscala.chap06

import scala.math.BigInt;

//p326
object fibonacci {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(103); 
	val list = List(1,2,3,4);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(11); val res$0 = 
	list.head;System.out.println("""res0: Int = """ + $show(res$0));$skip(21); val res$1 = 
	list.zip(list.tail);System.out.println("""res1: List[(Int, Int)] = """ + $show(res$1));$skip(237); 
	// res1: List[(Int, Int)] = List((1,2), (2,3), (3,4))
	
	// http://www.scala-lang.org/api/current/scala/collection/immutable/Stream.html
	val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map (n => n._1 + n._2);System.out.println("""fibs  : Stream[scala.math.BigInt] = """ + $show(fibs ));$skip(47); 
	
	fibs take 10 foreach( i => println(s"$i "))}
}
