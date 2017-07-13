package proscala.chap14

// p543
object selftype_cake_pattern {
	trait Persistence { def startPersistence(): Unit }
	trait Midtier { def startMidtier(): Unit }
	trait UI { def startUI(): Unit }
	
	trait Database extends Persistence{
		def startPersistence(): Unit = println("starting Database")
	}
	
	trait BizLogic extends Midtier {
		def startMidtier(): Unit = println("starting BizLogic")
	}
	
	trait WebUI extends UI {
		def startUI(): Unit = println("starting WebUI")
	}
	
	// 아래 뼈대 트레이트는 어떤 구체적 트레이트도 사용하지 않았다는 것에 주목하자.
	trait App { self: Persistence with Midtier with UI =>
		def run() = {
			startPersistence()
			startMidtier()
			startUI()
		}
	}
	
	trait AppInheritance extends Persistence with Midtier with UI{
			def run() = {
			startPersistence()
			startMidtier()
			startUI()
		}
	}
	
	// 자기 참조 구현 :  혼합을 통해 동작을 조합한다.
	object MyApp extends App with Database with BizLogic with WebUI
	
	MyApp.run                                 //> starting Database
                                                  //| starting BizLogic
                                                  //| starting WebUI
  // 상속기반 구현 : 아래와 같이 자기 참조 타입 대신 상속을 사용할 수 있다.
	object Myapp2 extends AppInheritance with Database with BizLogic with WebUI
	Myapp2.run()                              //> starting Database
                                                  //| starting BizLogic
                                                  //| starting WebUI
}