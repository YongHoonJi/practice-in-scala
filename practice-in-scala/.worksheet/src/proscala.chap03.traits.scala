package proscala.chap03


// 트레이트는 mixin이 가능한 인터페이스로 인스턴스 필드선언이 가능하고 함수를 정의할 수 있다.
object traits {
	class ServiceImportate(name: String) {
		def work(i: Int): Int = {
			println(s"service importante: doing work! $i")
			i+1
		}
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(275); 
	
	val service = new ServiceImportate("uno");System.out.println("""service  : proscala.chap03.traits.ServiceImportate = """ + $show(service ));$skip(63); 
	(1 to 3) foreach(i => println(s"Result: ${service.work(i)}"))
  //추상정의 트레이트:인터페이스와 같다. 바이트 코드조차 같다
	trait Logging{
		def info(m:String):Unit
		def warn(m:String):Unit
		def error(m:String):Unit
	}
	// 구현 트레이트
	trait StdoutLogging extends Logging{
		def info(m:String) = println(s"Info:$m")
		def warn(m:String) = println(s"Info:$m")
		def error(m:String) = println(s"Info:$m")
	};$skip(558); 
	
	// 미스인 코드를 보자
	val service2 = new ServiceImportate("dos") with StdoutLogging {
		override def work(i:Int):Int = {
			info(s"start work:i = $i")
			val result = super.work(i)
			info(s"end work:i = $i, result = $result")
			result
		}
	};System.out.println("""service2  : proscala.chap03.traits.ServiceImportate with proscala.chap03.traits.StdoutLogging = """ + $show(service2 ));$skip(65); 
	
	(1 to 3) foreach(i => println(s"result:${service2.work(i)}"))}
}
