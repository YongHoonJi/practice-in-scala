package proscala.chap06

//p296
// 반환이나 파라미터를 list, vector를 사용하지 말고 트레이트인 seq를 사용하자
object seq {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(136); 
	val seq1 = Seq("programming", "scala");System.out.println("""seq1  : Seq[String] = """ + $show(seq1 ));$skip(53); 
	
	val seq2 = "People" +: "should" +: "read" +: seq1;System.out.println("""seq2  : Seq[String] = """ + $show(seq2 ));$skip(52); 


	val seq3 = "programming" +: "scala" +: Seq.empty;System.out.println("""seq3  : Seq[String] = """ + $show(seq3 ));$skip(58); 
	
	val seq4 = "people" +: "should" +: "read" +: Seq.empty;System.out.println("""seq4  : Seq[String] = """ + $show(seq4 ));$skip(27); 
	
	val seq5 = seq4 ++ seq3;System.out.println("""seq5  : Seq[String] = """ + $show(seq5 ));$skip(29); 
	
	val seq6 = seq1 :+ "rear";System.out.println("""seq6  : Seq[String] = """ + $show(seq6 ));$skip(88); 
	// +: 는 컬랙션 앞에 요소를 추가 :+는 컬랙션 뒤에 추가
	val seq7 = "People" +: "should" +: "read" +: seq1;System.out.println("""seq7  : Seq[String] = """ + $show(seq7 ));$skip(79); 
                                                  
	val seq8 = "front" +: seq1;System.out.println("""seq8  : Seq[String] = """ + $show(seq8 ))}
	
}
