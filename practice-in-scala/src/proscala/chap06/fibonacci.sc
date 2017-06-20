package proscala.chap06

import scala.math.BigInt;

//p326
object fibonacci {
	val list = List(1,2,3,4)
	list.head
	list.zip(list.tail)
	// res1: List[(Int, Int)] = List((1,2), (2,3), (3,4))
	
	// http://www.scala-lang.org/api/current/scala/collection/immutable/Stream.html
	val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map (n => n._1 + n._2)
	
	fibs take 10 foreach( i => println(s"$i "))
}