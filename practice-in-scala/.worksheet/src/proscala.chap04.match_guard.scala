package proscala.chap04

object match_guard {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(169); 
	for(i <- Seq(1,2,3,4)) {
		i match {
			case _ if i%2 == 0 => println(s"event : $i")
			case _ => println(s"odd : $i")
		}}
	}
	
}
