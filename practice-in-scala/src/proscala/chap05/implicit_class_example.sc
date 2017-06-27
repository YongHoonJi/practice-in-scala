package proscala.chap05

object implicit_class_example {

	case class Rectangle(width: Int, height: Int){
		def draw(): Unit = {
			println(width + "-" + height)
		}
	}
	
	implicit class RectangleMaker(width: Int){
		def x(height: Int) = Rectangle(width, height)
	}
	
	val rec = 3 x 4                           //> rec  : proscala.chap05.implicit_class_example.Rectangle = Rectangle(3,4)
	
	rec.draw                                  //> 3-4
}