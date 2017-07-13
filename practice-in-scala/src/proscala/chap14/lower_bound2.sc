package proscala.chap14

//p530
// 공변 표현을 무공변으로 변환
object lower_bound2 {
	case class Opt[A](value: A = null) {
		def getOrEls(default: A) = if(value != null) value else default
	}
	
	
}