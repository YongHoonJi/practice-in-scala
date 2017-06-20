package proscala.chap05

object implcit_test  {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(81); 
	implicit val name: String = "ji";System.out.println("""name  : String = """ + $show(name ));$skip(97); 
	def whatisyourname(predicate: String)(implicit name: String) = {
		println(name + predicate)
	};System.out.println("""whatisyourname: (predicate: String)(implicit name: String)Unit""")}
	
}
