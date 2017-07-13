package proscala.chap11


//p471
/*
  단일 접근 원칙(Uniform Access Principle) : 속성의 직관성과 메소드에 의한 캡슐화
  내부 설계 결정에 무관하게 객체의 특징(feature)에 접근할 수 있도록 단일 표기법을 제공
  단일 접근 원칙을 적용하면 account.balance와 같은 직관적인 표기법을 사용해서 balance의 값을 참조할 수 있다.
  클라이언트 입장에서는 balance가 속성인지(즉, 저장된 값인지), 질의(QUERY)인지(단순하게 저장된 값을 반환하는 함수인지 아니면
  런타임에 값을 계산해서 반환하는 함수인지) 여부를 구분할 필요가 없다.
  속성에 대해 getter, setter와 같은 인터페이스를 하나만 제공하고 그 인터페이스로만 클라이언트에서 접근하도록 유도
  
  http://egloos.zum.com/aeternum/v/3028192
*/
object vetoable_clicks_uap {
	
	abstract class Widget
	
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
	
	trait Clickable{
		def click(): Unit = updateUI()
		protected def updateUI(): Unit
	}
	// 버튼을 중복 클릭 못하도록 하는 트레이트를 추가해보자
	trait VetoableClicksUAP extends Clickable {
		def maxAllowed: Int = 1 // 기본값이 1인 반환메서드, 트레이트에서는 필드값 대신 인자가 없는 메서드를 사용하는 것이 관습
		private var count = 0
		
		abstract override def click() = {
			if(count < maxAllowed) {
				count += 1
				super.click()
			}
		}
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
	
		class ClickCountObserver extends Observer[Clickable]{
		var count = 0
		def receiveUpdate(state: Clickable): Unit = count += 1
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(1863); 
	
	val obsbutton =
		new Button4("OKay") with ObservableClicks with VetoableClicksUAP {
			override val maxAllowed: Int = 2
		};System.out.println("""obsbutton  : proscala.chap11.vetoable_clicks_uap.Button4 with proscala.chap11.vetoable_clicks_uap.ObservableClicks with proscala.chap11.vetoable_clicks_uap.VetoableClicksUAP{val maxAllowed: Int} = """ + $show(obsbutton ));$skip(40); 
		
	
	val bco3 = new ClickCountObserver;System.out.println("""bco3  : proscala.chap11.vetoable_clicks_uap.ClickCountObserver = """ + $show(bco3 ));$skip(35); 
	val bco4 = new ClickCountObserver;System.out.println("""bco4  : proscala.chap11.vetoable_clicks_uap.ClickCountObserver = """ + $show(bco4 ));$skip(28); 
	obsbutton addObserver bco3;$skip(28); 
	obsbutton addObserver bco4;$skip(19); 
	obsbutton.click();$skip(14); val res$0 = 
	
	bco3.count;System.out.println("""res0: Int = """ + $show(res$0))}
	
}
