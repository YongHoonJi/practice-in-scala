package proscala.chap11

//p479
/*
선형화 알고리즘 (http://www.scala-lang.org/docu/files/ScalaReference.pdf 5.1.2)
1. 인스턴스의 실제타입을 첫번째 원소로 넣는다.
2. 가장 오른쪽의 부모 타입으로부터 시작해서 왼쪽으로진행하면서 작업한다. 각 타입의 선형화를 계산해서 누적시킨 선형화의 뒤에 덧붙인다.
3. 2의 결과에 대해, 오른쪽부터 왼쪽으로 진행하면서 현재 위치보다 왼쪽에 나타나는 자기 자신을 모두 제거한다.
4. 맨 뒤에 AnyRef와 Any를 붙인다.
*/
object linearization4 {
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
	
	class C2A extends T2{
		override def m = { print("C2A "); super.m }
	}

	class C2 extends C2A with T1 with T3{
		override def m = { print("C2 "); super.m }
	}
	
	def calcLinearization(obj: C1, name:String) = {
		println(s"$name:")
		obj.m
		print("AnyRef ")
		println("Any")
	}                                         //> calcLinearization: (obj: proscala.chap11.linearization4.C1, name: String)Uni
                                                  //| t
	
	calcLinearization(new C2, "C2 ")          //> C2 :
                                                  //| C2 T3 T1 C2A T2 C1 AnyRef Any
	calcLinearization(new T3 {}, "T3 ")       //> T3 :
                                                  //| T3 C1 AnyRef Any
	calcLinearization(new T2 {}, "T2 ")       //> T2 :
                                                  //| T2 C1 AnyRef Any
	calcLinearization(new T1 {}, "T1 ")       //> T1 :
                                                  //| T1 C1 AnyRef Any
	calcLinearization(new C2A, "C2A ")        //> C2A :
                                                  //| C2A T2 C1 AnyRef Any
	calcLinearization(new C1, "C1 ")          //> C1 :
                                                  //| C1 AnyRef Any
	
}