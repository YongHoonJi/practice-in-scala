package proscala.chap11

//p462
object trait_invalid_init_val {
	trait AbstractT2{
		println("In AbstractT2:")
		val value: Int
		val inverse = 1.0 / value // inverse값이 평가되기전에 계산됨.
		println("AbstractT2: value = "+value+", inverse = "+inverse)
	}
	
	val obj = new AbstractT2{
		println("In obj:")
		val value = 10
	}                                         //> In AbstractT2:
                                                  //| AbstractT2: value = 0, inverse = Infinity
                                                  //| In obj:
                                                  //| obj  : proscala.chap11.trait_invalid_init_val.AbstractT2 = proscala.chap11.t
                                                  //| rait_invalid_init_val$$anonfun$main$1$$anon$1@511baa65
	
	
	println("obj.value = "+obj.value+", inverse = "+obj.inverse)
                                                  //> obj.value = 10, inverse = Infinity
                                                  
	/* 초기화 값에 대한 지연평가 */
	trait AbstractT3{
		println("In AbstractT3:")
		val value: Int
		lazy val inverse = 1.0 / value // 지연 평가로 인해 평가시 초기화가 이루어짐.
	}
	
	val obj2 = new AbstractT3{
		println("In obj:")
		val value = 10
	}                                         //> In AbstractT3:
                                                  //| In obj:
                                                  //| obj2  : proscala.chap11.trait_invalid_init_val.AbstractT3 = proscala.chap11.
                                                  //| trait_invalid_init_val$$anonfun$main$1$$anon$2@340f438e
	println("obj.value = "+obj2.value+", inverse = "+ obj2.inverse)
                                                  //> obj.value = 10, inverse = 0.1
                                                  
	/* 초기화 필드를 활용 */
	val obj3 = new {
		val value = 10
	} with AbstractT2                         //> In AbstractT2:
                                                  //| AbstractT2: value = 10, inverse = 0.1
                                                  //| obj3  : proscala.chap11.trait_invalid_init_val.AbstractT2 = proscala.chap11.
                                                  //| trait_invalid_init_val$$anonfun$main$1$$anon$3@30c7da1e
	
	println("obj.value = "+obj3.value+", inverse = "+ obj3.inverse)
                                                  //> obj.value = 10, inverse = 0.1
}