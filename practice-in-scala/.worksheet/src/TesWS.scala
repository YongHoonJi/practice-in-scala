object TesWS {
  class Upper{
  	def upper(strings: String*): Seq[String] = {
  	  // 함수 리터럴 (function literal = lamda = block, closer, proc
  		strings.map((s:String) => s.toUpperCase())
  	}
  }
  
  object Upper{
    def upper(strings: String*) = strings.map(_.toUpperCase())
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(305); 
  
	val up = new Upper;System.out.println("""up  : TesWS.Upper = """ + $show(up ));$skip(37); 
	println(up.upper("Hello", "World"));$skip(40); 
	println(Upper.upper("Hello", "World"))}
}
