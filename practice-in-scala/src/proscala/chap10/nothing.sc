package proscala.chap10

// p434
// Nothing은 모든 AnyRef, AnyVal의 서브 타입이다.
object nothing {

	//https://github.com/scala/scala/blob/v2.12.2/src/library/scala/Predef.scala#L1
	// def ??? : Nothing = throw new NotImplementedError
	// 아래는 예외가 발생하나 Nothing이 모든 타입의 하위이기 때문에 타입 검사를 통과한다.
	def m(l: List[Int]): List[Int] = l map(i => ???)
                                                  //> m: (l: List[Int])List[Int]
	
	m(List(1,2,3))                            //> scala.NotImplementedError: an implementation is missing
                                                  //| 	at scala.Predef$.$qmark$qmark$qmark(Predef.scala:230)
                                                  //| 	at proscala.chap10.nothing$$anonfun$main$1$$anonfun$m$1$1.apply(proscala
                                                  //| .chap10.nothing.scala:10)
                                                  //| 	at proscala.chap10.nothing$$anonfun$main$1$$anonfun$m$1$1.apply(proscala
                                                  //| .chap10.nothing.scala:10)
                                                  //| 	at scala.collection.immutable.List.map(List.scala:273)
                                                  //| 	at proscala.chap10.nothing$$anonfun$main$1.m$1(proscala.chap10.nothing.s
                                                  //| cala:10)
                                                  //| 	at proscala.chap10.nothing$$anonfun$main$1.apply$mcV$sp(proscala.chap10.
                                                  //| nothing.scala:12)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at proscala.chap10.nothing$.main(proscala.chap10.nothing.scala:5)
  //아래와 같이 정의없는 메서드 지정을 위해 사용도 가능
  def mean_stdDev(data: Seq[Double]): (Double, Double) = ???
  /*
  아래와 같이 프로그램 exit 경우 최하위인 Nothing을 리턴하므로 타입 세이프하다.
  def exit(status: Int): Nothing = {
    java.lang.System.exit(status)
    throw new Throwable()
  }
  
  */
}