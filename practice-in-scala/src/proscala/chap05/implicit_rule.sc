package proscala.chap05
// p239
// 암시적 인자 처리 규칙
/*
	1. 마지막 인자목록에만 암시작 인자가 들어갈 수 있다.
	2. 암시적 파라미터만 존재할 수 없다.
	3. 암시적 인자는 첫 파라미터만 될 수 있다. 또 두번 나타날 수 없다.
	4. 인자목록이 implicit으로 시작하면 그 이후 파라미터도 모두 암시적 인자이다.
*/
object implicit_rule {
	class Bad1{ // 유일한 인자 목록의 두번 째 인자에 implicit 지정
		//def m(i: Int, implicit s: String) = "boo"
	}
	
	class Bad2{ // implicit 인자 목록을 두번 사용
		def m(i:Int)(implicit s: String)(implicit d: Double) = "boo"
	}
	
	class Good1{ // 두번 째 인자목록 s, d는 모두 암시적 파라미터
		def m(i: Int)(implicit s: String, d: Double) = "boo"
	}
	
	class Good2{ // 유일한 인자 목록의 세인자 i, s, d는 모두 암시적 파라미터
		def m(implicit i: Int, s: String, d: Double) = "boo"
	}
}