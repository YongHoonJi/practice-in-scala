package proscala.chap05

// 여러변환을 사용하는 경우 더 구체적인 암시를 찾아간다. (since 2.8)
// 전자의 인자타입이 후자의 서브타입인 경우, 두 변환 모두 메소드라면 전자를 둘러싼 클래스가 후자를 둘러썬 클래스를 확장한다.
object implicit_overload {
	def printLength(seq: Seq[Int]) = println(seq.length)
                                                  //> printLength: (seq: Seq[Int])Unit
	implicit def intToRange(i: Int) = i to i  //> intToRange: (i: Int)scala.collection.immutable.Range.Inclusive
	
	implicit def inToDigits(i: Int) = i.toString.toList.map(_.length)
                                                  //> inToDigits: (i: Int)List[Int]
	
	printLength(Seq(12))                      //> 1
	
}