package proscala.chap05

object implicit_class_example {

	case class Rectangle(width: Int, height: Int){
		def draw(): Unit = {
			println(width + "-" + height)
		}
	}
	
	implicit class RectangleMaker(width: Int){
		def x(height: Int) = Rectangle(width, height)
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(284); 
	
	val rec = 3 x 4;System.out.println("""rec  : proscala.chap05.implicit_class_example.Rectangle = """ + $show(rec ));$skip(12); 
	
	rec.draw}
}
