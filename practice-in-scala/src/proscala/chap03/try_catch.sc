package proscala.chap03

// 자바와 달리 스칼라에서는 검증에외가 없다. 검증 예외는 성공적인 설계가 아니기 때문이다. 자바를 위해 존재하는 검증 예외라고 보면 되겠다.
// 스칼라에서 자동 자원 관리를 위해 예외사용보다는 scala-arm 라이브러리(http://jsuereth.com/scala-arm/index.html)를 사용하자.
object try_catch {
	import scala.io.Source;
	import scala.util.control.NonFatal
	
	def countLines(fileName: String) = {
		println()
		var source: Option[Source] = None
		try{
			source = Some(Source.fromFile(fileName))
			val size = source.get.getLines.size
		} catch {
			case NonFatal(ex) => println(s"Non fatal exception! $ex") // 패턴매칭으로 치명적이지 않은 오류를 잡아낸다.
		} finally {
			for(s <- source) {
				println(s"closing $fileName...")
				s.close
			}
		}
	}                                         //> countLines: (fileName: String)Unit
	
	
	val fileName = "";                        //> fileName  : String = ""
	countLines(fileName);                     //> 
                                                  //| Non fatal exception! java.io.FileNotFoundException:  (No such file or direct
                                                  //| ory)
}