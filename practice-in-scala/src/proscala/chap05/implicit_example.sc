package proscala.chap05

object implicit_example {
  case class NameCard(name: String, age: Int)

  implicit val tag: NameCard = NameCard("Ji", 38) //> tag  : proscala.chap05.implicit_example.NameCard = NameCard(Ji,38)
  def getTag(predicate: String)(implicit tag: NameCard) = {
    println(tag.name + predicate)
  }                                               //> getTag: (predicate: String)(implicit tag: proscala.chap05.implicit_example.N
                                                  //| ameCard)Unit

  getTag(" is my name")                           //> Ji is my name

  object test {
    implicit def dept(): String = {
      "Dev"
    }
  }

  {
    import test.dept
		
		implicit val mydef = dept()
    def getDept(name: String)(implicit dept: String) = {
      name + " " + dept
    }
    getDept("I'm in ")
  }                                               //> res0: String = I'm in  Dev
  
  object Dollar {
  	// 달러를 유로로 변환
  	implicit def dollarToEuro(x: Dollar): Euro = {
  		new Euro(x.amount())
  	}
  }
  
  class Dollar(n: Int){
  	def amount(): Int={
  		n
  	}
  }
  
	  class Euro(n: Int) {
	  	def ammount(): Unit={
	  		println("euro :"+ n)
	  	}
	  }
	  
	  val dollar = new Dollar(100)            //> dollar  : proscala.chap05.implicit_example.Dollar = proscala.chap05.implicit
                                                  //| _example$$anonfun$main$1$Dollar$3@2d6e8792
	  val euro: Euro = dollar                 //> euro  : proscala.chap05.implicit_example.Euro = proscala.chap05.implicit_exa
                                                  //| mple$$anonfun$main$1$Euro$1@2812cbfa
	  euro.ammount()                          //> euro :100

}