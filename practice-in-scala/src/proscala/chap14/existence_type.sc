package proscala.chap14

//p554

// 존재타입은 타입 추상화 중 하나의 방법으로 타입이름을 지정하지 않고 해당 타입을 지정하는 것이다.
// 존재타입은 자바의 타입 시스템과 연동시 특히 세경우에 중요하다.
// 1. JVM에서의 타입소거
// 2. java5이전의 원시 타입을 마주치는 경우
// 3. 자바에서 제네릭 타입을 사용하는 곳에서 공변성을 표현하기 위해 와일드카드를 사용하는 경우.
object existence_type {
	println("")                               //> 
	
	// 아래의 경우는 타입 소거에 의해 컴파일 에러가 발생한다.
	/*
	object Doubler {
		def double(seq: Seq[String]): Seq[Int] = double(seq map (_.toInt))
		def double(seq: Seq[Int]): Seq[Int] = seq map (_*2)
	}
	*/
	
	// 버거운 해결 방법
	object Doubler{
		def double(seq: Seq[_]): Seq[Int] = seq match { //Seq[_]는 실제 Seq[T]라는 존재타입을 줄인 것이다.
			case Nil => Nil
			case head +: tail => (toInt(head) * 2) +: double(tail)
		}
		
		private def toInt(x: Any): Int = x match {
			case i: Int => i
			case s: String => s.toInt
			case x => throw new RuntimeException(s"Unexpected list element $x")
		}
		// Seq[_] : Seq[T] forSome {type T}
		// Seq[_ <: A] : Seq[T] forSome {type T <: A}
		// Seq[_ >: Z <: A] Seq[T] forSome {type T >: Z <: A}
	}
}