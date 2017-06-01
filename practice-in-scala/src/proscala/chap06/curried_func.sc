package proscala.chap06

//p286
object curried_func {
	// 커링은 여러 인자를 취하는 함수를 단하나의 인자를 취하는 여러함수의 연쇄로 바꿔준다.
  def cat1(s1: String)(s2: String) = s1 + s2      //> cat1: (s1: String)(s2: String)String
  // 커링의 다른 표현
 	def cat2(s1: String) = (s2: String) => s1 + s2
                                                  //> cat2: (s1: String)String => String
  
  val hello = cat1("Hello ") _                    //> hello  : String => String = <function1>
  hello("world")                                  //> res0: String = Hello world

  cat1("Hello")("world")                          //> res1: String = Helloworld
  
  val cat2Hello = cat2("Hello ")                  //> cat2Hello  : String => String = <function1>
  cat2Hello("world!")                             //> res2: String = Hello world!

	def cat3(s1: String, s2: String) = s1 + s2//> cat3: (s1: String, s2: String)String
	cat3("hello", "world")                    //> res3: String = helloworld
	
	// cat3 함수를 커링 처리
	val cat3Curried = (cat3 _).curried        //> cat3Curried  : String => (String => String) = <function1>
	cat3Curried("hello")("world")             //> res4: String = helloworld

	//부분함수는 함수의 인자 목록을 일부 적용하지만, 전부 적용하지 않은 식을 말함.
  val inverse: PartialFunction[Double, Double] = {
    case d if d != 0.0 => 1.0 / d
  }                                               //> inverse  : PartialFunction[Double,Double] = <function1>

  inverse(1.0)                                    //> res5: Double = 1.0
  inverse(2.0)                                    //> res6: Double = 0.5
  //inverse(0.0)

}