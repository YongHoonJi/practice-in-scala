package proscala.chap11

//p474
/*
트레이트가 다른 트레이트나 클래스를 상속할 수 있다. 그래서 상속 계층은 비순환적 방향성 그래프(directed acyclic graph)다.
트레이트가 쌓이면 선언순서 기준으로 오른쪽에서 왼쪽으로 결합된다.
*/


object linearization1 {
	class C1 {
		def m = print("C1 ")
	}
	
	trait T1 extends C1{
		override def m = { print("T1 "); super.m }
	}
	
	trait T2 extends C1{
		override def m = { print("T2 "); super.m }
	}
	
	trait T3 extends C1{
		override def m = { print("T3 "); super.m }
	}
	
	class C2 extends T1 with T2 with T3 {
		override def m = { print("C2 "); super.m }
	}
	
	// m을 호출시 트레이트의 선언이 오른쪽에서 왼쪽으로 선언됨을 볼 수 있다.
	val c2 = new C2                           //> c2  : proscala.chap11.linearization1.C2 = proscala.chap11.linearization1$C2@
                                                  //| 3581c5f3
	c2.m                                      //> C2 T3 T2 T1 C1 
	println("")                               //> 
}