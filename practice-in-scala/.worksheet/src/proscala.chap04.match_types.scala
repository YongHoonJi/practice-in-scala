package proscala.chap04

// p 206
object match_types {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(495); 
	/*
	for{
		x <- Seq(List(5.5,5.6,5.7), List("a","b"))
		} yield (x match {
			case seqd: Seq[Double] => ("seq double", seqd)
			case seqs: Seq[String] => ("seq string", seqs)
			case _ 								 => ("unknown",x)
		})
	}
	*/
	def doSeqMatch[T](seq: Seq[T]): String = seq match {
		case Nil => "nothing"
		case head +: _ => head match {
			case _ : Double => "Double"
			case _ : String => "String"
			case _ => "Unmatched seq element"
		}
	};System.out.println("""doSeqMatch: [T](seq: Seq[T])String""");$skip(189); val res$0 = 
	
	
	for {
		x <- Seq(List(5.5, 5.6, 5.7), List("a", "b"), Nil)
		} yield {
			x match {
				case seq: Seq[_] => (s"seq ${doSeqMatch(seq)}", seq)
				case _ 								 => ("unknown",x)
				};System.out.println("""res0: Seq[(String, List[Any])] = """ + $show(res$0))}
			}
}
