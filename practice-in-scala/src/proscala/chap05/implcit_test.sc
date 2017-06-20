package proscala.chap05

object implcit_test  {
	implicit val name: String = "ji"          //> name  : String = ji
	def whatisyourname(predicate: String)(implicit name: String) = {
		println(name + predicate)
	}                                         //> whatisyourname: (predicate: String)(implicit name: String)Unit
	
}