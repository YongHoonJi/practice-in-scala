package proscala.chap05

object implicit_example {
  case class NameCard(name: String, age: Int);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(147); 

  implicit val tag: NameCard = NameCard("Ji", 38);System.out.println("""tag  : proscala.chap05.implicit_example.NameCard = """ + $show(tag ));$skip(98); 
  def getTag(predicate: String)(implicit tag: NameCard) = {
    println(tag.name + predicate)
  };System.out.println("""getTag: (predicate: String)(implicit tag: proscala.chap05.implicit_example.NameCard)Unit""");$skip(25); 

  getTag(" is my name")

  object test {
    implicit def dept(): String = {
      "Dev"
    }
  };$skip(248); val res$0 = 

  {
    import test.dept
		
		implicit val mydef = dept()
    def getDept(name: String)(implicit dept: String) = {
      name + " " + dept
    }
    getDept("I'm in ")
  }
  
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
	  };System.out.println("""res0: String = """ + $show(res$0));$skip(313); 
	  
	  val dollar = new Dollar(100);System.out.println("""dollar  : proscala.chap05.implicit_example.Dollar = """ + $show(dollar ));$skip(27); 
	  val euro: Euro = dollar;System.out.println("""euro  : proscala.chap05.implicit_example.Euro = """ + $show(euro ));$skip(18); 
	  euro.ammount()}

}
