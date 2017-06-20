package proscala.chap06

//p296
// 반환이나 파라미터를 list, vector를 사용하지 말고 트레이트인 seq를 사용하자
object seq {
	val seq1 = Seq("programming", "scala")    //> seq1  : Seq[String] = List(programming, scala)
	
	val seq2 = "People" +: "should" +: "read" +: seq1
                                                  //> seq2  : Seq[String] = List(People, should, read, programming, scala)


	val seq3 = "programming" +: "scala" +: Seq.empty
                                                  //> seq3  : Seq[String] = List(programming, scala)
	
	val seq4 = "people" +: "should" +: "read" +: Seq.empty
                                                  //> seq4  : Seq[String] = List(people, should, read)
	
	val seq5 = seq4 ++ seq3                   //> seq5  : Seq[String] = List(people, should, read, programming, scala)
	
	val seq6 = seq1 :+ "rear"                 //> seq6  : Seq[String] = List(programming, scala, rear)
	// +: 는 컬랙션 앞에 요소를 추가 :+는 컬랙션 뒤에 추가
	val seq7 = "People" +: "should" +: "read" +: seq1
                                                  //> seq7  : Seq[String] = List(People, should, read, programming, scala)
                                                  
	val seq8 = "front" +: seq1                //> seq8  : Seq[String] = List(front, programming, scala)
	
}