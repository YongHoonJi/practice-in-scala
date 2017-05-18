package proscala.chap02

object methooverloadReturnv1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(118); 

	def joiner(strings: String*): String = strings.mkString("-");System.out.println("""joiner: (strings#2027548: String#1947588*)String#1947588""");$skip(113); 
	// _* : 리스트를 가변인자 목록(*)로 다루되, 타입을 추론한 타입을 사용하라는
	def joiner(strings: List[String]): String = joiner(strings:_*);System.out.println("""joiner: (strings#2027601: List#3053[String#1947588])String#1947588""");$skip(49); 
	
	println(joiner(List("Programming", "Scala")))}
	
}
