package proscala.chap06

import scala.annotation.tailrec
//p283
// 꼬리 재귀 : 자기자신의 호출이며 그 호출이 해당 함수의 마지막 연산인 경우를 꼬리 재귀라고 한다. 루프로 쉽게 변환될 수 있는 재귀유형
object factorial_recur2 {
	def factorial(i: BigInt): BigInt = {
		@tailrec
		def fact(i: BigInt, acc: BigInt): BigInt = {
			if(i == 1) acc
			else fact(i -1, i * acc)
		}
		
		fact(i, 1)
	}                                         //> factorial: (i: BigInt)BigInt
	
	for( i <- 1 to 10)
		println(s"$i: \t${factorial(i)}") //> 1: 	1
                                                  //| 2: 	2
                                                  //| 3: 	6
                                                  //| 4: 	24
                                                  //| 5: 	120
                                                  //| 6: 	720
                                                  //| 7: 	5040
                                                  //| 8: 	40320
                                                  //| 9: 	362880
                                                  //| 10: 	3628800
}