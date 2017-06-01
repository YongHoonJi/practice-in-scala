package proscala.chap06

//p284
// 꼬리 호출 트램펄린 : 트랜폴린은 여러 함수가 하나씩 서로를 순서대로 호출하면서 이루어지는 루프를 말한다.
// 어떤 함수 A가 B를 호출하고 B가 A를 호출하고 A가 다시 B를 호출하는 이런식의 재귀를 트램펄린이라 한다.

import scala.util.control.TailCalls._
 
object trampoline {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(327); 
	def isEven(xs: List[Int]): TailRec[Boolean] =
		if(xs.isEmpty) done(true)
		else tailcall(isOdd(xs.tail));System.out.println("""isEven: (xs: List[Int])util.control.TailCalls.TailRec[Boolean]""");$skip(109); 
		
	def isOdd(xs: List[Int]): TailRec[Boolean] =
		if(xs.isEmpty) done(false) else tailcall(isEven(xs.tail));System.out.println("""isOdd: (xs: List[Int])util.control.TailCalls.TailRec[Boolean]""");$skip(102); 
		
	for(i <- 1 to 5) {
		val even = isEven((1 to i).toList).result
		println(s"$i is even? $even")
	}}
}
