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
	}
	
	println("creating C12")                   //> creating C12
	new C12                                   //> creating Base12
                                                  //| null
                                                  //| Base12
                                                  //| creating T1
                                                  //| 0
                                                  //| 1
                                                  //| creating T2
                                                  //| null
                                                  //| T2
                                                  //| creating C12
                                                  //| null
                                                  //| C12
                                                  //| res0: proscala.chap09.trait_construction.C12 = proscala.chap09.trait_constru
                                                  //| ction$C12@511baa65
	println("after creating C12")             //> after creating C12
	
}