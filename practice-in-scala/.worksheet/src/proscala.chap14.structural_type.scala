package proscala.chap14


// p547
// 구조적 타입, 일명 덕타입(duck typing:어떤 것이 오리처럼 걷는다면 오리로 간주)의 한 버전으로 어떤 객체가 특정 구조를 준수하도록 지정할 수 있다.
// 즉, 어떤 객체가 특정 맴버 (타입, 필드,메서드)를 포함해야 한다는 사실을 타입 이름을 지정하지 않고 타입 지정이 가능
// 일반적인 타입인 이름에 의한 타입 지정과 달리 구조적 타입 지정에서는 타입의 구조에만 관심이 있다.
object structural_type {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(293); 
	println("")
	
	// 이름에 의한 타입 지정. Observe트레이트를 구현한 객체만 인자로 사용이 가능
	/*
	trait Obserer[-State] {
		def receiveUpdate(s: State): Unit
	}
	
	trait Subject[State] {
		private var observers: List[Obserser[State]] = Nil
	}
	*/
	
	trait Subject {
		import scala.language.reflectiveCalls
		
		type State
		// 구조적 타입. 단 구조적 타입이 추상 타입이나 타입 매개변수를 참조할 수 없다. state 타입이 Any인 것을 확인
		// 리플렉션을 이용해 해당 타입이 원하는 메서드를 구현하는지 검증하기 때문에 컴파일러에 부가비용이 든다.
		// 이런 단점에도 불구하고 특정 메서드를 구현하는 광범위한 결합으로 클래스간의 결합도를 낮춰준다.
		type Observer = { def receiveUpdate(state: Any): Unit }
		
		private var observers: List[Observer] = Nil
		
		def addObserver(observer: Observer): Unit =
			 observers ::= observer
		
		def notifyObservers(state: State): Unit =
			observers foreach (_.receiveUpdate(state))
	}
	
	// 리플렉션 호출 없이 사용하는 케이스
	trait SubjectFunc {
		type State
		// 익명함수를 타입으로 지정
		type Observer = State => Unit
		
		private var observers: List[Observer] = Nil
		
		def addObserver(observer: Observer): Unit =
			observers ::= observer
			
		def notifyObservers(state: State): Unit =
			observers foreach (o => o(state)) // 관찰자의 apply 메소드를 호출
	};$skip(1172); 
	
	val observer: Int => Unit = (state: Int) => println("got one! " + state);System.out.println("""observer  : Int => Unit = """ + $show(observer ));$skip(57); 
	
	val subject = new SubjectFunc {
		type State = Int
	};System.out.println("""subject  : proscala.chap14.structural_type.SubjectFunc{type State = Int} = """ + $show(subject ));$skip(31); 
	subject.addObserver(observer);$skip(29); 
	subject.notifyObservers(10)}
}
