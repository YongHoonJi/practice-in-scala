package proscala.chap14
//p546
// 실제로 self는 키워드가 아니다 단지 현재 객체의 참조 위치를 지정하는것이다.
object this_alias {
	class C1 { c1_self =>
		def talk(message: String) = println("c1.talk:"+message)
		
		class C2 {
			def send(message: String) = println("show your name:"+message)
			class C3{
				// 자기 참조 표기를 사용하지 상위 타입의 함수에 접근
				def talk(message: String) = c1_self.talk("c3.talk:"+message)
			}
			val c3 = new C3
		}
		val c2 = new C2
	}
	
	val c1 = new C1                           //> c1  : proscala.chap14.this_alias.C1 = proscala.chap14.this_alias$C1@3581c5f3
                                                  //| 
	c1.talk("hello")                          //> c1.talk:hello
	c1.c2.c3.talk("world")                    //> c1.talk:c3.talk:world
	c1.c2.send("Ji")                          //> show your name:Ji
}