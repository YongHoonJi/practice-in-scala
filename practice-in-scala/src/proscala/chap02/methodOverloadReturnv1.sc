package proscala.chap02

object methooverloadReturnv1 {

	def joiner(strings: String*): String = strings.mkString("-")
	// _* : 리스트를 가변인자 목록(*)로 다루되, 타입을 추론한 타입을 사용하라는
	def joiner(strings: List[String]): String = joiner(strings:_*)
	
	println(joiner(List("Programming", "Scala")))
	
}