package proscala.chap02

object method_broad_inference_return {
	def makeList(strings: String*) = {
		if(strings.length == 0)
			List(0)
		else
			strings.toList
	}
	// 너무 광범위한 추론을 필요로함. 컴파일 오류
	val list: List[String] = makeList()

}