package proscala.chap03

//page 160
object call_by_name{
	//@annotation.tailrec
	def countinue(conditional: => Boolean)(body: => Unit){
		if(conditional) {
			body
			countinue(conditional)(body)
		}
	}                                         //> countinue: (conditional: => Boolean)(body: => Unit)Unit
	
	def c( i:Int): Boolean = {
		println("condition")
		return i < 5
	}                                         //> c: (i: Int)Boolean
	
	
	var count = 0;                            //> count  : Int = 0
	countinue(count < 3){
		println(count);
		count += 1
	}                                         //> 0
                                                  //| 1
                                                  //| 2
}