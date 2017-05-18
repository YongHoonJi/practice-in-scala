package proscala.chap02

object rTest {
	val p1 = new Point(x = 3.3, y = 4.4)      //> p1  : proscala.chap02.Point = Point(3.3,4.4)
	val p2 = p1.copy(y=6.6)                   //> p2  : proscala.chap02.Point = Point(3.3,6.6)
	
	val s = Circle(Point(0.0, 0.0), 5.0)      //> s  : proscala.chap02.Circle = Circle(Point(0.0,0.0),5.0)
	
	
}