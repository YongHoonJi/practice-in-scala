package proscala.chap02

object rTest {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
	val p1 = new Point(x = 3.3, y = 4.4);System.out.println("""p1  : proscala.chap02.Point = """ + $show(p1 ));$skip(25); 
	val p2 = p1.copy(y=6.6);System.out.println("""p2  : proscala.chap02.Point = """ + $show(p2 ));$skip(40); 
	
	val s = Circle(Point(0.0, 0.0), 5.0);System.out.println("""s  : proscala.chap02.Circle = """ + $show(s ))}
	
	
}
