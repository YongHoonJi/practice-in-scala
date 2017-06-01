package proscala.chap06
// p277
object hofs_closure_example {
	var factor = 2                            //> factor  : Int = 2
	// 함수는 1급 객체이므로 함수도 일반값 처럼 정의할 수 있다.
	// muliplier가 factor 값을 참조하는 코드 블록임을 알자.
	// 여기서 muliplier의 인자 i는 함수의 형식인자(formal parameter)이고 호출시 새로운 값에 결부(bind)된다.
	// 하지만 factor는 형식 인자가 아닌 자유 변수 (free variable)이며 주위를 둘러싼 영역의 변수에 대한 참조이다.
	// 함수 외부의 변수를 참조하는 함수를 우리는 클로저라 부른다~
	// 함수안의 문맥과 외부의 지정되지 않은 변수를 참조하는 외부 문맥을 아울러 클로저라 부른다...
	//*함수 : 이름이 붙어 있거나 익명인 연산. 함수의 정의 안에 자유변수가 존재할 수 있다.
	//*람다 : 익명 함수. 내부에 자유 변수가 있을 수 있다.
	//*클로저 : 이름이 붙어 있거나 익명인 함수. 함수에서 사용하는 자유변수가 참조하는 모든 영역의 닫힌환경을 포함
	//*** 람다 : 익명함수 혹은 리터럴
	//*** 클로저는 일반함수와 별도 구분할 필요는 없다.
	val muliplier = (i: Int) => i * factor    //> muliplier  : Int => Int = <function1>
	(1 to 10) filter (_ % 2 == 0) map muliplier reduce(_ * _)
                                                  //> res0: Int = 122880
	
	factor = 3
	(1 to 10) filter (_ % 2 == 0) map muliplier reduce(_ * _)
                                                  //> res1: Int = 933120
                                                  
	// muliplier를 전달하면 그 시점의 factor도 전달됨을 보자
	def m1(multiplier: Int => Int) = {
		(1 to 10) filter (_ % 2 == 0) map multiplier reduce(_ * _)
	}                                         //> m1: (multiplier: Int => Int)Int
	// 반환한 함수는 factor에 대한 참조를 포함하는 클로저이다
	def m2: Int => Int = {
		val factor = 2
		val multiplier = (i: Int) => i * factor
		multiplier
	}                                         //> m2: => Int => Int
	
	m1(m2)                                    //> res2: Int = 122880
	
	object Mutliplier {
		var factor = 2
		def multiplier(i: Int) = i * factor
	}
	// 메서드 호출
	(1 to 10) filter (_ % 2 == 0) map Mutliplier.multiplier reduce(_ * _)
                                                  //> res3: Int = 122880
	Mutliplier.factor = 3
	(1 to 10) filter (_ % 2 == 0) map Mutliplier.multiplier reduce(_ * _)
                                                  //> res4: Int = 933120
	
}