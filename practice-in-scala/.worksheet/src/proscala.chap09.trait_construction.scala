package proscala.chap09
// p416
// 트레이트는 클래스와 트레이트를 확장할 수 있으나 부모 클래스의 생성자에 인자를 전달할 방법이 없다.
object trait_construction {
	trait T1 {
		println("creating T1")
		println(x)
		val x = 1
		println(x)
	}
	
	trait T2{
		println("creating T2")
		println(y)
		val y = "T2"
		println(y)
	}
	
	class Base12{
		println("creating Base12")
		println(b)
		val b = "Base12"
		println(b)
	}
	
	class C12 extends Base12 with T1 with T2{
		println("creating C12")
		println( c)
		val c = "C12"
		println(c)
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(516); 
	
	println("creating C12");$skip(9); val res$0 = 
	new C12;System.out.println("""res0: proscala.chap09.trait_construction.C12 = """ + $show(res$0));$skip(31); 
	println("after creating C12")}
	
}
