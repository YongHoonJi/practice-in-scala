package proscala.chap10

//p421
object func {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(129); 
	val f: Int => Int = new Function1[Int, Int] {
		def apply(i: Int): Int = i + 3;
	};System.out.println("""f  : Int => Int = """ + $show(f ));$skip(24); val res$0 = 
	
	List(1,2,3,4) map(f)

	class GrandPapa { def msuper() = println("GrandPapa") }
	class Papa extends GrandPapa { def m() = println("Papa") }
	class Son extends Papa { def msub() = println("Son") };System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(462); 
	
  // trait Function1[-T1, +R] extends AnyRef
  // ex) http://www.scala-lang.org/api/current/scala/Function1.html
 	// 아래 예제에서 하나의 파라미터가 역변성임을 확인하자. 또 리턴값은 변성인 것도 보일 것이다.
 	
 	// papa를 받아서 papa를 리턴하는 함수를 정의했다.
 	// Function1[-Papa, +Papa]
	var test: Papa => Papa = (c: Papa) => new Papa;System.out.println("""test  : proscala.chap10.func.Papa => proscala.chap10.func.Papa = """ + $show(test ));$skip(67); 
  // 아래 세개의 수정함수는 역변, 가변성을 만족한다.
	test = (c: GrandPapa) => new Son;$skip(37); 
	
	test = (c: GrandPapa) => new Papa;$skip(29); 
	test = (c: Papa) => new Son}
	// 아래 함수는 역변일 경우 Papa의 상위타입으로 역변성을 위반하였고 GrandPapa를 리턴함으로써 가변성을 위반하였다.
	// 입력값의 타입은 적어도 papa와 같거나 상위타입(GrandPapa)이어야 하고 리턴타입은 Papa, Son이어야 한다.
	//test = (c: Son) => new GrandPapa
	
	//****반공변적 인자와 공변적 반환타입이 안전한 이유 (사용이유?)
	// Papa 입력타입 : 역변이기 때문에 Papa의 상위타입을 받지 않아서 약속 범위를 넘지 않는다.
	// Papa 반환타입 : 또 반환타입이 Papa의 하위타입이기 때문에 함수를 호출한 쪽에서는 Papa의 하위 타입을 처리할 수 있다.
	
	
}
