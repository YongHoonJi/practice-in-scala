package proscala.chap02

object literal {
	// function literal. a, b는 Int, String에 대한 추
	val f1:(Int, String) => String = (a, b) => a+b
                                                  //> f1  : (Int#1131, String#1947588) => String#1947588 = <function2>
	
	val f2:Function2[Int, String, String] = (i, s) => s+i
                                                  //> f2  : (Int#1131, String#1947588) => String#1947588 = <function2>
                                                  
	//tuple literal. 튜플은 1급 계층값으로 immutable 하다.
	//tuple의 인덱스는 1부터 시
	val t = ("hello", 1, 2.3)                 //> t  : (String#254, Int#1131, Double#1647) = (hello,1,2.3)
	println(t)                                //> (hello,1,2.3)
	println(t._1)                             //> hello
	println(t._2)                             //> 1
	println(t._3)                             //> 2.3
	
	val (t1, t2, t3) = ("world", '!', 0x22)   //> t1  : String#254 = world
                                                  //| t2  : Char#1791 = !
                                                  //| t3  : Int#1131 = 34

	val (t4, t5, t6) = Tuple3("world", '!', 0x22)
                                                  //> t4  : String#254 = world
                                                  //| t5  : Char#1791 = !
                                                  //| t6  : Int#1131 = 34
                                                  
	//option, some, null
	// Map(key -> val, key -> val)
	val stateCapitals = Map("Korea" -> "seoul", "Italia" -> "Roma", "Spain" -> "Madrid")
                                                  //> stateCapitals  : scala#27.collection#2782.immutable#5867.Map#7906[String#254
                                                  //| ,String#254] = Map(Korea -> seoul, Italia -> Roma, Spain -> Madrid)
	println("Korea:"+stateCapitals.get("Seoul"))
                                                  //> Korea:None
	println("Italia:"+stateCapitals.get("Italia"))
                                                  //> Italia:Some(Roma)
	println("Unknown:"+stateCapitals.get("Unknown"))
                                                  //> Unknown:None
	println("Unknown:"+stateCapitals.get("Unknown").getOrElse("Not Country"))
                                                  //> Unknown:Not Country
                                                  
}