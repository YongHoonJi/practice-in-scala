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
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(737); 
	
	val f1 = () => {println("callback1")};System.out.println("""f1  : () => Unit = """ + $show(f1 ));$skip(27); 
	val callbacks = List(f1);System.out.println("""callbacks  : List[() => Unit] = """ + $show(callbacks ));$skip(70); ;
	val buttonwithouttrait = new ButtonWithCallbacks("label", callbacks);System.out.println("""buttonwithouttrait  : proscala.chap09.button_callbacks.ButtonWithCallbacks = """ + $show(buttonwithouttrait ));$skip(28); 
	buttonwithouttrait.click()
	
	
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
	};$skip(944); 
	
	val button = new ObservableButton("Click me");System.out.println("""button  : proscala.chap09.button_callbacks.ObservableButton = """ + $show(button ));$skip(34); 
	val b1 = new ButtonCountObserver;System.out.println("""b1  : proscala.chap09.button_callbacks.ButtonCountObserver = """ + $show(b1 ));$skip(34); 
	val b2 = new ButtonCountObserver;System.out.println("""b2  : proscala.chap09.button_callbacks.ButtonCountObserver = """ + $show(b2 ));$skip(25); 
	
	button addObserver b1;$skip(23); 
	button addObserver b2;$skip(41); 
	
	(1 to 5) foreach(_ => button.click());$skip(21); 
	
	println(b1.count);$skip(19); 
	println(b2.count);$skip(272); 
	
	
	
	/***** 서브클래스 없이 익명 클래스를 인스턴스화 한 경우. 이는 자바에서 인터페이스 구현없이 익명 클래스를 인스턴스화하는 것과 유사 ****/
	// 상속 대신 트레이트를 구성하여 혼합할 방법이 없는지 살펴보자
	val button3 = new Button("click me!") with Subject[Button] {
		override def click(): Unit = {
			super.click()
			notifyObservers(this)
		}
	};System.out.println("""button3  : proscala.chap09.button_callbacks.Button with proscala.chap09.button_callbacks.Subject[proscala.chap09.button_callbacks.Button] = """ + $show(button3 ));$skip(38); 
	
	val bco1 = new ButtonCountObserver;System.out.println("""bco1  : proscala.chap09.button_callbacks.ButtonCountObserver = """ + $show(bco1 ));$skip(36); 
	val bco2 = new ButtonCountObserver;System.out.println("""bco2  : proscala.chap09.button_callbacks.ButtonCountObserver = """ + $show(bco2 ));$skip(28); 
	
	button3 addObserver bco1;$skip(26); 
	button3 addObserver bco2;$skip(43); 
	
	(1 to 5) foreach (_ => button3.click());$skip(27); 
	
	assert(bco1.count == 5);$skip(25); 
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
	};$skip(496); 
	
	val button4 = new Button4("click me!") with ObservableClicks
	
	class ClickCountObserver extends Observer[Clickable]{
		var count = 0
		def receiveUpdate(state: Clickable): Unit = count += 1
	};System.out.println("""button4  : proscala.chap09.button_callbacks.Button4 with proscala.chap09.button_callbacks.ObservableClicks = """ + $show(button4 ));$skip(172); 
	
	
	val bco3 = new ClickCountObserver;System.out.println("""bco3  : proscala.chap09.button_callbacks.ClickCountObserver = """ + $show(bco3 ));$skip(35); 
	val bco4 = new ClickCountObserver;System.out.println("""bco4  : proscala.chap09.button_callbacks.ClickCountObserver = """ + $show(bco4 ));$skip(26); 
	button4 addObserver bco3;$skip(26); 
	button4 addObserver bco4;$skip(17); 
	button4.click();$skip(14); val res$0 = 
	
	bco3.count;System.out.println("""res0: Int = """ + $show(res$0));$skip(12); val res$1 = 
	bco4.count
	
	
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
	};System.out.println("""res1: Int = """ + $show(res$1));$skip(498); 
	// 트레이트의 적용 순서는 오른쪽에서 왼쪽이다.
	val button5 = new Button4("Click me") with ObservableClicks with VetoableClicks {
		override val maxAllowed = 2 // VetoableClicks의 maxAllowed를오버라이딩
	};System.out.println("""button5  : proscala.chap09.button_callbacks.Button4 with proscala.chap09.button_callbacks.ObservableClicks with proscala.chap09.button_callbacks.VetoableClicks = """ + $show(button5 ));$skip(39); 
	
	
	val boc5 = new ClickCountObserver;System.out.println("""boc5  : proscala.chap09.button_callbacks.ClickCountObserver = """ + $show(boc5 ));$skip(35); 
	val boc6 = new ClickCountObserver;System.out.println("""boc6  : proscala.chap09.button_callbacks.ClickCountObserver = """ + $show(boc6 ));$skip(28); 
	
	button5 addObserver boc5;$skip(26); 
	button5 addObserver boc6;$skip(43); 
	
	(1 to 5) foreach (_ => button5.click());$skip(14); val res$2 = 
	
	boc5.count;System.out.println("""res2: Int = """ + $show(res$2));$skip(12); val res$3 = 
	boc6.count;System.out.println("""res3: Int = """ + $show(res$3))}
	
}
