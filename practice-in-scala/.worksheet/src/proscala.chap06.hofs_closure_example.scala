package proscala.chap06
// p277
object hofs_closure_example {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
	var factor = 2;System.out.println("""factor  : Int = """ + $show(factor ));$skip(580); 
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
	val muliplier = (i: Int) => i * factor;System.out.println("""muliplier  : Int => Int = """ + $show(muliplier ));$skip(59); val res$0 = 
	(1 to 10) filter (_ % 2 == 0) map muliplier reduce(_ * _);System.out.println("""res0: Int = """ + $show(res$0));$skip(14); 
	
	factor = 3;$skip(59); val res$1 = 
	(1 to 10) filter (_ % 2 == 0) map muliplier reduce(_ * _);System.out.println("""res1: Int = """ + $show(res$1));$skip(193); 
                                                  
	// muliplier를 전달하면 그 시점의 factor도 전달됨을 보자
	def m1(multiplier: Int => Int) = {
		(1 to 10) filter (_ % 2 == 0) map multiplier reduce(_ * _)
	};System.out.println("""m1: (multiplier: Int => Int)Int""");$skip(137); 
	// 반환한 함수는 factor에 대한 참조를 포함하는 클로저이다
	def m2: Int => Int = {
		val factor = 2
		val multiplier = (i: Int) => i * factor
		multiplier
	};System.out.println("""m2: => Int => Int""");$skip(10); val res$2 = 
	
	m1(m2)
	
	object Mutliplier {
		var factor = 2
		def multiplier(i: Int) = i * factor
	};System.out.println("""res2: Int = """ + $show(res$2));$skip(163); val res$3 = 
	// 메서드 호출
	(1 to 10) filter (_ % 2 == 0) map Mutliplier.multiplier reduce(_ * _);System.out.println("""res3: Int = """ + $show(res$3));$skip(23); 
	Mutliplier.factor = 3;$skip(71); val res$4 = 
	(1 to 10) filter (_ % 2 == 0) map Mutliplier.multiplier reduce(_ * _);System.out.println("""res4: Int = """ + $show(res$4))}
	
}
