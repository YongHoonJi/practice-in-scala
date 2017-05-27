package proscala.chap04

object match_guard {
	for(i <- Seq(1,2,3,4)) {
		i match {
			case _ if i%2 == 0 => println(s"event : $i")
			case _ => println(s"odd : $i")
		}                                 //> odd : 1
                                                  //| event : 2
                                                  //| odd : 3
                                                  //| event : 4
	}
	
}