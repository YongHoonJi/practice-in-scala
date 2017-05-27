package proscala.chap04

// 값에 대해 매칭을 사용할 수 있다.
object match_else {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(100); 
	 val head +: tail = List(1,2,3);System.out.println("""head  : Int = """ + $show(head ));System.out.println("""tail  : List[Int] = """ + $show(tail ));$skip(49); 
	 
	 val head1 +: head2 +: tail2 = Vector(1,2,3);System.out.println("""head1  : Int = """ + $show(head1 ));System.out.println("""head2  : Int = """ + $show(head2 ));System.out.println("""tail2  : scala.collection.immutable.Vector[Int] = """ + $show(tail2 ));$skip(30); 
	val Seq(a,b,c) = List(1,2,3);System.out.println("""a  : Int = """ + $show(a ));System.out.println("""b  : Int = """ + $show(b ));System.out.println("""c  : Int = """ + $show(c ));$skip(35); 
	val Seq(a1,b1,c1) = List(1,2,3,4)
                                                  
	case class Address(street: String, city: String, country: String)
  case class Person(name: String, age: Int, address: Address);System.out.println("""a1  : Int = """ + $show(a1 ));System.out.println("""b1  : Int = """ + $show(b1 ));System.out.println("""c1  : Int = """ + $show(c1 ));$skip(258); 

  val alice = Person("Alice", 25, Address("1 scala lane", "chicago", "USA"));System.out.println("""alice  : proscala.chap04.match_else.Person = """ + $show(alice ));$skip(96); val res$0 = 
  
 if(alice == Person("Alice", 25, Address("1 scala lane", "chicago", "USA"))) "yes" else "no";System.out.println("""res0: String = """ + $show(res$0))}
	 
	 
}
