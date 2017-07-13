package proscala.chap11

object linearization2 {
//p475
/*
생성자의 호출 순서를 보자
*/

	class C1 {
		print("C1 ")
	}
	
	trait T1 extends C1{
		print("T1 ")
	}
	
	trait T2 extends C1{
		print("T2 ")
	}
	
	trait T3 extends C1{
		print("T3 ")
	}
	
	class C2 extends T1 with T2 with T3 {
		println("C2 ")
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(356); 
	
	// 생성자 생성 순서는 당연하게도 부모 부터 생성되는 것을 볼 수 있다.
	val c2 = new C2;System.out.println("""c2  : proscala.chap11.linearization2.C2 = """ + $show(c2 ))}
}
