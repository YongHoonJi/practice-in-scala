package proscala.chap05

	case class NameCard(name: String, age:Int)
object implcit_test {
	
	
	{
		implicit val nc = NameCard("Ji", 38)
		implicit def printer(implicit nc: NameCard): String = {
			"my name is "+nc.name
		}
		
	}
	
}
