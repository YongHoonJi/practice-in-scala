package proscala.chap06

import scala.annotation.tailrec
//p282
// 아래함수는 꼬리재귀가 아니다. 자기자시을 호출 후 곱하기 연산을 하므로 루프로 변환이 될 수 없는 일반 재귀이다.
// for의 범위가 넒어지면 특정 시점에 스택오버플로우가 발생할 것이다.
object factorial_recur1 {
	//	@tailrec
	def factorial(i: BigInt): BigInt = {
		if( i == 1) i
		else i* factorial(i - 1)
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