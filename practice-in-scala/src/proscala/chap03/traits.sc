package proscala.chap03


// 트레이트는 mixin이 가능한 인터페이스로 인스턴스 필드선언이 가능하고 함수를 정의할 수 있다.
object traits {
	class ServiceImportate(name: String) {
		def work(i: Int): Int = {
			println(s"service importante: doing work! $i")
			i+1
		}
	}
	
	val service = new ServiceImportate("uno") //> service  : proscala.chap03.traits.ServiceImportate = proscala.chap03.traits$
                                                  //| ServiceImportate@3581c5f3
	(1 to 3) foreach(i => println(s"Result: ${service.work(i)}"))
                                                  //> service importante: doing work! 1
                                                  //| Result: 2
                                                  //| service importante: doing work! 2
                                                  //| Result: 3
                                                  //| service importante: doing work! 3
                                                  //| Result: 4
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
	}
	
	// 미스인 코드를 보자
	val service2 = new ServiceImportate("dos") with StdoutLogging {
		override def work(i:Int):Int = {
			info(s"start work:i = $i")
			val result = super.work(i)
			info(s"end work:i = $i, result = $result")
			result
		}
	}                                         //> service2  : proscala.chap03.traits.ServiceImportate with proscala.chap03.tra
                                                  //| its.StdoutLogging = proscala.chap03.traits$$anonfun$main$1$$anon$1@506e6d5e
	
	(1 to 3) foreach(i => println(s"result:${service2.work(i)}"))
                                                  //> Info:start work:i = 1
                                                  //| service importante: doing work! 1
                                                  //| Info:end work:i = 1, result = 2
                                                  //| result:2
                                                  //| Info:start work:i = 2
                                                  //| service importante: doing work! 2
                                                  //| Info:end work:i = 2, result = 3
                                                  //| result:3
                                                  //| Info:start work:i = 3
                                                  //| service importante: doing work! 3
                                                  //| Info:end work:i = 3, result = 4
                                                  //| result:4
}