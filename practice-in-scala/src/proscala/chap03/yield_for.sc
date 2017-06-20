package proscala.chap03

object yieldFor {
	val alpha = List("abc", "bcd", "efg")     //> alpha  : List[String] = List(abc, bcd, efg)
	// for의 결과를 모아서 담아두는 yield
	val filtered = for{
		a <- alpha
		if a.contains("a")
	} yield a                                 //> filtered  : List[String] = List(abc)

	for( e <- filtered ) println(e)           //> abc
	
	for{
		a <- alpha
		upcased = a.toUpperCase()
	} println(upcased)                        //> ABC
                                                  //| BCD
                                                  //| EFG
	val optionalAlpha = List(Some("abc"), None, Some("bcd"), Some("cde"))
                                                  //> optionalAlpha  : List[Option[String]] = List(Some(abc), None, Some(bcd), Som
                                                  //| e(cde))
	// None에 대한 검사를 for에서 내부적으로 처
	println("first pass:")                    //> first pass:
	for {
		aOptional <- optionalAlpha
		a <- aOptional
	} println(a)                              //> abc
                                                  //| bcd
                                                  //| cde
                                                  
	
	
	
}