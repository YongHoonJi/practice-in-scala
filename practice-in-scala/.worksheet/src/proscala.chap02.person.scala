package proscala.chap02

object person {
  class Person(val name: String, var age: Int);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(122); 
  val p = new Person("Justin", 29);System.out.println("""p  : proscala.chap02.person.Person = """ + $show(p ));$skip(9); val res$0 = 
  p.name;System.out.println("""res0: String = """ + $show(res$0));$skip(8); val res$1 = 
  p.age;System.out.println("""res1: Int = """ + $show(res$1));$skip(33); 
  //p.name = "Nick"
  p.age = 30;$skip(8); val res$2 = 
  p.age;System.out.println("""res2: Int = """ + $show(res$2));$skip(40); 

  val p1 = new Point(x = 3.3, y = 4.4);System.out.println("""p1  : proscala.chap02.Point = """ + $show(p1 ));$skip(28); 
  val p2 = p1.copy(y = 6.6);System.out.println("""p2  : proscala.chap02.Point = """ + $show(p2 ));$skip(40); 

  val s = Circle(Point(0.0, 0.0), 5.0);System.out.println("""s  : proscala.chap02.Circle = """ + $show(s ));$skip(65); 
  
  s.draw(Point(0.0, 0.0))(s => println(s"shapes of myheart"))}

}
