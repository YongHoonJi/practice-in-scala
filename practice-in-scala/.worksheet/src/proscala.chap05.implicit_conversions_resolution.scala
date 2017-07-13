package proscala.chap05

//p244
// 컴파일러는 현재 범위 안에 암시적 클래스와 메서드만 고려. 대상 타입의 동반 객체 안에 정의된 암시적 메서드도 포함시킨다.
object implicit_conversions_resolution {
// 암시를 사용하기 위한 임포트
	import scala.language.implicitConversions;
	
	case class Foo(s: String)
	object Foo{
		implicit def fromString(s: String): Foo = Foo(s)
	}
	
	class c{
		def m1(foo: Foo) = println(foo)
		def m(s: String) = m1(s)
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(405); 
	
	val f = new Foo("foo");System.out.println("""f  : proscala.chap05.implicit_conversions_resolution.Foo = """ + $show(f ));$skip(22); 
	val ctest = new c();System.out.println("""ctest  : proscala.chap05.implicit_conversions_resolution.c = """ + $show(ctest ));$skip(35); ;
 //bob에 대한 암시적 변환
	ctest.m("bob");}
	
}
