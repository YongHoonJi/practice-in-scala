object TesWS {
  class Upper{
  	def upper(strings: String*): Seq[String] = {
  	  // 함수 리터럴 (function literal = lamda = block, closer, proc
  		strings.map((s:String) => s.toUpperCase())
  	}
  }
  
  object Upper{
    def upper(strings: String*) = strings.map(_.toUpperCase())
  }
  
	val up = new Upper                        //> up  : TesWS.Upper = TesWS$Upper@3581c5f3
	println(up.upper("Hello", "World"))       //> ArrayBuffer(HELLO, WORLD)
	println(Upper.upper("Hello", "World"))    //> ArrayBuffer(HELLO, WORLD)
}