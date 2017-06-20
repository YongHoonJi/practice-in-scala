package proscala.chap07
//p338
//for 내장
object RemoveBlanks {
	def apply(path: String, compressWhiteSpace: Boolean = false): Seq[String] =
		for {
			line <- scala.io.Source.fromFile(path).getLines.toSeq
			if line.matches("""^\s*$""") == false
			line2 = if(compressWhiteSpace) line replaceAll ("\\s+", " ")
							else line
		} yield line2
		
	}
}