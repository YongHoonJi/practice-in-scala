package proscala.chap05

//p231 JVM은 컴파일 시 타입을 지워버린다. 오버로딩 함수 경우 인자수가 같다면 컴파일 오류가 일어나며 이는 두 메소드의 바이트 코드가 동일하기 때문이다.
// 타입 소거로 인해 바이트 코드가 같은 두 메서드를 암시를 통해 모호성을 제거할 수 있다.
object implicit_erasure {
	object m{
	 	def a(seq: Seq[Int]): Unit = println(s"Seq[Int]: $seq")
	 	//def a(seq[String]):Unit = println(s"Seq[String]: $seq") JVM 타입 소거로 인한 컴파일 오류
	}
	
	object m2{
		implicit object IntMaker
		implicit object StringMaker
		
		def a2(seq: Seq[Int])(implicit i: IntMaker.type): Unit =  println(s"Seq[Int]: $seq")
		def a2(seq: Seq[String])(implicit i: StringMaker.type): Unit =  println(s"Seq[String]: $seq")
	}
	
	import m2._
	a2(List(1,2,3))                           //> Seq[Int]: List(1, 2, 3)
	a2(List("one", "two", "three"))           //> Seq[String]: List(one, two, three)
}