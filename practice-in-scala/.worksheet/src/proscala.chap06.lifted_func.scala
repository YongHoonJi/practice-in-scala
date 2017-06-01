package proscala.chap06
//p292
// 부분함수와 옵션을 반환하는 함수 lift
object lifted_func {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(159); 
	val finicky: PartialFunction[String,String] = {
		case "finicky" => "Finicky"
	};System.out.println("""finicky  : PartialFunction[String,String] = """ + $show(finicky ));$skip(22); val res$0 = 
	
	finicky("finicky");System.out.println("""res0: String = """ + $show(res$0));$skip(184); 
	//finicky("other")    // scala.MatchError: other (of class java.lang.String)
	// lift는 함수를 끌어올리는 개념으로 부분함수에 더 이상 적용할 파라미터가 없는 경우에도 Option을 반환하도록 한다.
	val finickyOption = finicky.lift;System.out.println("""finickyOption  : String => Option[String] = """ + $show(finickyOption ));$skip(29); val res$1 = 
		
	finickyOption("finicky");System.out.println("""res1: Option[String] = """ + $show(res$1));$skip(24); val res$2 = 
	finickyOption("other");System.out.println("""res2: Option[String] = """ + $show(res$2));$skip(49); 
	
	val finicky2 = Function.unlift(finickyOption);System.out.println("""finicky2  : PartialFunction[String,String] = """ + $show(finicky2 ));$skip(23); val res$3 = 
	
	finicky2("finicky");System.out.println("""res3: String = """ + $show(res$3));$skip(19); val res$4 = 
	finicky2("other");System.out.println("""res4: String = """ + $show(res$4))}
	
}
