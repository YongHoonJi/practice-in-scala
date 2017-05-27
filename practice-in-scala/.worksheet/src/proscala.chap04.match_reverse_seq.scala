package proscala.chap04

// p197
// leftfold
object match_reverse_seq {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(112); 
  val nonEmptyList = List(1, 2, 3, 4, 5);System.out.println("""nonEmptyList  : List[Int] = """ + $show(nonEmptyList ));$skip(45); 
  val nonEmptyVector = Vector(1, 2, 3, 4, 5);System.out.println("""nonEmptyVector  : scala.collection.immutable.Vector[Int] = """ + $show(nonEmptyVector ));$skip(62); 
  val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" -> 3);System.out.println("""nonEmptyMap  : scala.collection.immutable.Map[String,Int] = """ + $show(nonEmptyMap ));$skip(147); 

	def reverseSeqToString[T](l: Seq[T]): String = l match {
		case prefix :+ end => reverseSeqToString(prefix) + s" :+ $end"
		case Nil => "Nil"
	};System.out.println("""reverseSeqToString: [T](l: Seq[T])String""");$skip(105); 
	
	for(seq <- Seq(nonEmptyList, nonEmptyVector, nonEmptyMap.toSeq)) {
		println(reverseSeqToString(seq))}
	}
}
