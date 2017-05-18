package proscala.chap01

object Upper extends App{
  
  class Upper{
  	def upper(strings: String*): Seq[String] = {
  	  // 함수 리터럴 (function literal = lamda = block, closer, proc
  		strings.map((s:String) => s.toUpperCase())
  	}
  }
  
  object Upper{
    def upper(strings: String*) = strings.map(_.toUpperCase())
  }
  
	val up = new Upper
	println(up.upper("Hello", "World"))
	println(Upper.upper("Hello", "World"))
	
}