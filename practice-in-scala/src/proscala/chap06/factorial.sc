package proscala.chap06
// p271
object factorial {
	def factorial(i: Int): Long = {
		def fact(i: Int, accumulator: Int): Long = {
			if(i <= 1) accumulator
			else fact(i -1, i * accumulator)
		}
		
		fact(i, 1)
	}                                         //> factorial: (i: Int)Long
	
	(0 to 5) foreach( i => println(factorial(i)))
                                                  //> 1
                                                  //| 1
                                                  //| 2
                                                  //| 6
                                                  //| 24
                                                  //| 120
}