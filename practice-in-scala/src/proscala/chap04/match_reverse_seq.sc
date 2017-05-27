package proscala.chap04

// p197
// leftfold
object match_reverse_seq {
  val nonEmptyList = List(1, 2, 3, 4, 5)          //> nonEmptyList  : List[Int] = List(1, 2, 3, 4, 5)
  val nonEmptyVector = Vector(1, 2, 3, 4, 5)      //> nonEmptyVector  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4
                                                  //| , 5)
  val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" -> 3)
                                                  //> nonEmptyMap  : scala.collection.immutable.Map[String,Int] = Map(one -> 1, tw
                                                  //| o -> 2, three -> 3)

	def reverseSeqToString[T](l: Seq[T]): String = l match {
		case prefix :+ end => reverseSeqToString(prefix) + s" :+ $end"
		case Nil => "Nil"
	}                                         //> reverseSeqToString: [T](l: Seq[T])String
	
	for(seq <- Seq(nonEmptyList, nonEmptyVector, nonEmptyMap.toSeq)) {
		println(reverseSeqToString(seq))  //> Nil :+ 1 :+ 2 :+ 3 :+ 4 :+ 5
                                                  //| Nil :+ 1 :+ 2 :+ 3 :+ 4 :+ 5
                                                  //| Nil :+ (one,1) :+ (two,2) :+ (three,3)
	}
}