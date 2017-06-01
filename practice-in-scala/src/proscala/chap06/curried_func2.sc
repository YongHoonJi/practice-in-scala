package proscala.chap06

object curried_func2 {
	val f1: String => String => String =
		(s1: String) => (s2: String) => s1 + s2
                                                  //> f1  : String => (String => String) = <function1>
		
	val f2: String => (String => String) =
		(s1: String) => (s2: String) => s1 + s2
                                                  //> f2  : String => (String => String) = <function1>
	f1("hello ")("world")                     //> res0: String = hello world
	f2("hello ")("world")                     //> res1: String = hello world
	
	// uncurrying
	def cat3(s1: String, s2: String) = s1 + s2//> cat3: (s1: String, s2: String)String
	val cat3Curried = (cat3 _).curried        //> cat3Curried  : String => (String => String) = <function1>
	cat3Curried("hello")("world")             //> res2: String = helloworld
	val cat3Uncurried = Function.uncurried(cat3Curried)
                                                  //> cat3Uncurried  : (String, String) => String = <function2>
	cat3Uncurried("hello", "world")           //> res3: String = helloworld
	
	val ff1 = Function.uncurried(f1)          //> ff1  : (String, String) => String = <function2>
	
	ff1("hello","world")                      //> res4: String = helloworld
	
	
	// 커링의 실용적인 사용은 함수를 특정 데이터에 대해 특화시크는 것이다. 다음 예를 보자
	def multiplier(i: Int)(factor: Int) = i * factor
                                                  //> multiplier: (i: Int)(factor: Int)Int
	val byFive = multiplier(5) _              //> byFive  : Int => Int = <function1>
	val byTen = multiplier(10) _              //> byTen  : Int => Int = <function1>
	byFive(2)                                 //> res5: Int = 10
	byTen(2)                                  //> res6: Int = 20
	
	
	// 커링과 부분함수는 크게 구분없이 쓰인다. 중한 것은 어떻게 응용하는 것인가 이다.
	// 튜플에 대한 응용을 보자
	def mult(d1:Double, d2:Double,d3:Double) = d1*d2*d3
                                                  //> mult: (d1: Double, d2: Double, d3: Double)Double
	val d3 = (2.2,3.3,4.4)                    //> d3  : (Double, Double, Double) = (2.2,3.3,4.4)
	
	mult(d3._1, d3._2, d3._3)                 //> res7: Double = 31.944000000000003
	
	// 아래는 3원소 튜플을 단일인자로 받는 경우이다.
	val multTupled = Function.tupled(mult _)  //> multTupled  : ((Double, Double, Double)) => Double = <function1>
	multTupled(d3)                            //> res8: Double = 31.944000000000003
}