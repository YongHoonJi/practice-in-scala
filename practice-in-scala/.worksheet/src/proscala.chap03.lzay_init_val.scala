package proscala.chap03

//page 162
// lazy키워드는 초기화 본문을 처음 참조하는 경우만 단 한번 평가한다. val만 사용가능하며 한번만 평가하므로 var사용이 안된다.
// 지연값이 guard로 구현되었음을 참조하라. http://daily-scala.blogspot.kr/2009/09/lazy-val.html
object lzay_init_val {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(249); 
	lazy val resource: Int = init();System.out.println("""resource: => Int""");$skip(46); 
	def init(): Int = {
		// 오래걸리는 작업을 위치
		0
	};System.out.println("""init: ()Int""")}
}
