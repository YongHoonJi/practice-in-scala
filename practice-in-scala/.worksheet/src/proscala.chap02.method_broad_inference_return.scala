package proscala.chap02

object method_broad_inference_return {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(164); 
	def makeList(strings: String*) = {
		if(strings.length == 0)
			List(0)
		else
			strings.toList
	};System.out.println("""makeList: (strings#577604: String#367995*)List#8641[Any#719]""");$skip(66); 
	// 너무 광범위한 추론을 필요로함. 컴파일 오류
	val list: List[String] = makeList();System.out.println("""list  : List#3053[String#367995] = """ + $show(list ))}

}
