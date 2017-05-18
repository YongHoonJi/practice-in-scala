package proscala.chap02

import scala.annotation.tailrec

object factorial {

	def factorial(i: Int): Long = {
		// nested function
		@tailrec
		def fact(i: Int, acc: Long):Long = {
			if(i <= 1) acc
			else fact(i-1, i*acc)
		}
		fact(i, 1)
	}                                         //> factorial: (i: Int)Long
	
	(0 to 10) foreach ( i => println(factorial(i)) )
                                                  //> 1
                                                  //| 1
                                                  //| 2
                                                  //| 6
                                                  //| 24
                                                  //| 120
                                                  //| 720
                                                  //| 5040
                                                  //| 40320
                                                  //| 362880
                                                  //| 3628800
	
	//꼬리 재귀가 아닌 경우 (꼬리 재귀는 표현식의 반환값은 마지막 호출이 반환하는 값이어야 한다)
	def fibonacci(i: Int): Long = {
		if(i <= 1) 1L
		else fibonacci(i -2) +fibonacci(i -1)
	}                                         //> fibonacci: (i: Int)Long

	//nested function은 자신의 함수 밖의 변수를 참조한다. 즉 클로저이다.
	def countTo(n: Int): Unit = {
		def count(i: Int): Unit = {
			if(i <= n) { println(i); count(i + 1) }
		}
		count(3)
	}                                         //> countTo: (n: Int)Unit
	
	countTo(10)                               //> 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
	
}