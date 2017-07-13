package proscala.chap05

// 여러변환을 사용하는 경우 더 구체적인 암시를 찾아간다. (since 2.8)
// 전자의 인자타입이 후자의 서브타입인 경우, 두 변환 모두 메소드라면 전자를 둘러싼 클래스가 후자를 둘러썬 클래스를 확장한다.
object implicit_overload {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(224); 
	def printLength(seq: Seq[Int]) = println(seq.length);System.out.println("""printLength: (seq: Seq[Int])Unit""");$skip(42); 
	implicit def intToRange(i: Int) = i to i;System.out.println("""intToRange: (i: Int)scala.collection.immutable.Range.Inclusive""");$skip(69); 
	
	implicit def inToDigits(i: Int) = i.toString.toList.map(_.length);System.out.println("""inToDigits: (i: Int)List[Int]""");$skip(24); 
	
	printLength(Seq(12))}
	
}
