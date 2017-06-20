package proscala.chap10

// p434
// Nothing은 모든 AnyRef, AnyVal의 서브 타입이다.
object nothing {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(330); 

	//https://github.com/scala/scala/blob/v2.12.2/src/library/scala/Predef.scala#L1
	// def ??? : Nothing = throw new NotImplementedError
	// 아래는 예외가 발생하나 Nothing이 모든 타입의 하위이기 때문에 타입 검사를 통과한다.
	def m(l: List[Int]): List[Int] = l map(i => ???);System.out.println("""m: (l: List[Int])List[Int]""");$skip(18); val res$0 = 
	
	m(List(1,2,3));System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(95); 
  //아래와 같이 정의없는 메서드 지정을 위해 사용도 가능
  def mean_stdDev(data: Seq[Double]): (Double, Double) = ???;System.out.println("""mean_stdDev: (data: Seq[Double])(Double, Double)""")}
  /*
  아래와 같이 프로그램 exit 경우 최하위인 Nothing을 리턴하므로 타입 세이프하다.
  def exit(status: Int): Nothing = {
    java.lang.System.exit(status)
    throw new Throwable()
  }
  
  */
}
