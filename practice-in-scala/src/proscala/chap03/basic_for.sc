package proscala.chap03

object basic_for {
	val alpha = List("a", "b", "C")           //> alpha  : List[String] = List(a, b, C)
	for(a <- alpha)
		println(a)                        //> a
                                                  //| b
                                                  //| C
 	for( a <- alpha)
 		if(a.contains("a") && a.startsWith("a"))
 		println(a)                        //> a
 		
	for(i <- 1 to 10) println(i)              //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
}