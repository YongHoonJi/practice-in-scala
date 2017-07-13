package proscala.chap09

//p402
object button_callbacks {
	// before trait
 	abstract class Widget
 	// 아래 클래스는 버튼으로 UI를 업데이트함 과 동시에 콜백함수 처리도 한다.
 	// 단일 책임의 원칙(Single Responsibility Principle)을 위반하므로  관심사 분리(Seperation of Concern) 대상이 된다.
	class ButtonWithCallbacks(val label: String,
		val callbacks: List[() => Unit] = Nil) extends Widget {
		
		def click(): Unit = {
			updateUI()
			callbacks.foreach(f => f())
		}
		
		protected def updateUI(): Unit = {
			println("update")
		}
		
		object ButtonWithCallbacks {
			def apply(label: String, callback: () => Unit) =
				new ButtonWithCallbacks(label, List(callback))
		}
		
		def apply(label: String) = new ButtonWithCallbacks(label, Nil)
	}
	
	val f1 = () => {println("callback1")}     //> f1  : () => Unit = <function0>
	val callbacks = List(f1);                 //> callbacks  : List[() => Unit] = List(<function0>)
	val buttonwithouttrait = new ButtonWithCallbacks("label", callbacks)
                                                  //> buttonwithouttrait  : proscala.chap09.button_callbacks.ButtonWithCallbacks =
                                                  //|  proscala.chap09.button_callbacks$ButtonWithCallbacks@21bcffb5
	buttonwithouttrait.click()                //> update
                                                  //| callback1
	
	
	//  trait
	trait Observer[-T] {
		def receiveUpdate(state: T): Unit
	}
	
	trait Subject[T] {
		// 통지를 받을 목록 (not thread safe)
		var observers: List[Observer[T]] = Nil
		// 관찰자를 추가, A ::= List[A] 뜻 : A를 List[A] 앞에 붙이고 그 결과를 List[A]에 대입
		def addObserver(observer: Observer[T]): Unit = observers ::= observer
		// 상태변경을 관찰자에게 통지
		def notifyObservers(state: T): Unit = observers foreach (_.receiveUpdate(state))
	}
	
	class Button(val label: String) extends Widget {
		def click(): Unit = updateUI()
		
		def updateUI(): Unit = {
			println("update UI")
		}
	}
	
	//  mixed in class
	class ObservableButton(name: String) extends Button(name) with Subject[Button] {
		override def click(): Unit = {
			super.click()
			notifyObservers(this)
		}
	}
	
	// observer 객체
	class ButtonCountObserver extends Observer[Button] {
		var count = 0
		def receiveUpdate(state: Button): Unit = count += 1
	}
	
	val button = new ObservableButton("Click me")
                                                  //> button  : proscala.chap09.button_callbacks.ObservableButton = proscala.chap
                                                  //| 09.button_callbacks$$anonfun$main$1$ObservableButton$1@380fb434
	val b1 = new ButtonCountObserver          //> b1  : proscala.chap09.button_callbacks.ButtonCountObserver = proscala.chap0
                                                  //| 9.button_callbacks$$anonfun$main$1$ButtonCountObserver$1@668bc3d5
	val b2 = new ButtonCountObserver          //> b2  : proscala.chap09.button_callbacks.ButtonCountObserver = proscala.chap0
                                                  //| 9.button_callbacks$$anonfun$main$1$ButtonCountObserver$1@3cda1055
	
	button addObserver b1
	button addObserver b2
	
	(1 to 5) foreach(_ => button.click())     //> update UI
                                                  //| update UI
                                                  //| update UI
                                                  //| update UI
                                                  //| update UI
	
	println(b1.count)                         //> 5
	println(b2.count)                         //> 5
	
	
	
	/***** 서브클래스 없이 익명 클래스를 인스턴스화 한 경우. 이는 자바에서 인터페이스 구현없이 익명 클래스를 인스턴스화하는 것과 유사 ****/
	// 상속 대신 트레이트를 구성하여 혼합할 방법이 없는지 살펴보자
	val button3 = new Button("click me!") with Subject[Button] {
		override def click(): Unit = {
			super.click()
			notifyObservers(this)
		}
	}                                         //> button3  : proscala.chap09.button_callbacks.Button with proscala.chap09.but
                                                  //| ton_callbacks.Subject[proscala.chap09.button_callbacks.Button] = proscala.c
                                                  //| hap09.button_callbacks$$anonfun$main$1$$anon$3@7a5d012c
	
	val bco1 = new ButtonCountObserver        //> bco1  : proscala.chap09.button_callbacks.ButtonCountObserver = proscala.cha
                                                  //| p09.button_callbacks$$anonfun$main$1$ButtonCountObserver$1@3fb6a447
	val bco2 = new ButtonCountObserver        //> bco2  : proscala.chap09.button_callbacks.ButtonCountObserver = proscala.cha
                                                  //| p09.button_callbacks$$anonfun$main$1$ButtonCountObserver$1@79b4d0f
	
	button3 addObserver bco1
	button3 addObserver bco2
	
	(1 to 5) foreach (_ => button3.click())   //> update UI
                                                  //| update UI
                                                  //| update UI
                                                  //| update UI
                                                  //| update UI
	
	assert(bco1.count == 5)
	assert(bco2.count == 5)
	
	// clickable 추가. 실제로 옵저버의 관찰대상은 버튼이 아니라 클릭했는지 여부다.
	trait Clickable{
		def click(): Unit = updateUI()
		protected def updateUI(): Unit
	}
	
	trait ObservableClicks extends Clickable with Subject[Clickable]{
		abstract override def click(): Unit = {
			super.click()
			notifyObservers(this)
		}
	}
	
	class Button4(val label: String) extends Widget with Clickable {
		protected def updateUI(): Unit = { println("update ui") }
	}
	
	val button4 = new Button4("click me!") with ObservableClicks
                                                  //> button4  : proscala.chap09.button_callbacks.Button4 with proscala.chap09.bu
                                                  //| tton_callbacks.ObservableClicks = proscala.chap09.button_callbacks$$anonfun
                                                  //| $main$1$$anon$2@6b2fad11
	
	class ClickCountObserver extends Observer[Clickable]{
		var count = 0
		def receiveUpdate(state: Clickable): Unit = count += 1
	}
	
	
	val bco3 = new ClickCountObserver         //> bco3  : proscala.chap09.button_callbacks.ClickCountObserver = proscala.chap
                                                  //| 09.button_callbacks$$anonfun$main$1$ClickCountObserver$1@79698539
	val bco4 = new ClickCountObserver         //> bco4  : proscala.chap09.button_callbacks.ClickCountObserver = proscala.chap
                                                  //| 09.button_callbacks$$anonfun$main$1$ClickCountObserver$1@73f792cf
	button4 addObserver bco3
	button4 addObserver bco4
	button4.click()                           //> update ui
	
	bco3.count                                //> res0: Int = 1
	bco4.count                                //> res1: Int = 1
	
	
	// 트레이트가 너무 많으면 컴파일 시간이 오래 걸림. 라이브러리 사용자가 당황할 수도 있다.
	
	// 버튼을 중복 클릭 못하도록 하는 트레이트를 추가해보자
	trait VetoableClicks extends Clickable {
		// 허용하는 최대 눌림 횟수의 기본값
		val maxAllowed = 1
		private var count = 0
		
		abstract override def click() = {
			if(count < maxAllowed) {
				count += 1
				super.click()
			}
		}
	}
	// 트레이트의 적용 순서는 오른쪽에서 왼쪽이다.
	val button5 = new Button4("Click me") with ObservableClicks with VetoableClicks {
		override val maxAllowed = 2 // VetoableClicks의 maxAllowed를오버라이딩
	}                                         //> button5  : proscala.chap09.button_callbacks.Button4 with proscala.chap09.bu
                                                  //| tton_callbacks.ObservableClicks with proscala.chap09.button_callbacks.Vetoa
                                                  //| bleClicks = proscala.chap09.button_callbacks$$anonfun$main$1$$anon$1@2ed94a
                                                  //| 8b
	
	
	val boc5 = new ClickCountObserver         //> boc5  : proscala.chap09.button_callbacks.ClickCountObserver = proscala.chap
                                                  //| 09.button_callbacks$$anonfun$main$1$ClickCountObserver$1@38082d64
	val boc6 = new ClickCountObserver         //> boc6  : proscala.chap09.button_callbacks.ClickCountObserver = proscala.chap
                                                  //| 09.button_callbacks$$anonfun$main$1$ClickCountObserver$1@dfd3711
	
	button5 addObserver boc5
	button5 addObserver boc6
	
	(1 to 5) foreach (_ => button5.click())   //> update ui
                                                  //| update ui
	
	boc5.count                                //> res2: Int = 2
	boc6.count                                //> res3: Int = 2
	
}