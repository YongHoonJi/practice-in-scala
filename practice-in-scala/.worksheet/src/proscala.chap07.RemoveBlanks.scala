package proscala.chap07
//p338
//for 내장
object RemoveBlanks {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(341); 
	def apply(path: String, compressWhiteSpace: Boolean = false): Seq[String] =
		for {
			line <- scala.io.Source.fromFile(path).getLines.toSeq
			if line.matches("""^\s*$""") == false
			line2 = if(compressWhiteSpace) line replaceAll ("\\s+", " ")
							else line
		} yield line2;System.out.println("""apply: (path: String, compressWhiteSpace: Boolean)Seq[String]""")}
		
	}
}
