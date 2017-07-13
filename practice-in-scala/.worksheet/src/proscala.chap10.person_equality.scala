package proscala.chap10
//p 451
object person_equality {
	case class Person(firstName: String, lastName: String, age: Int);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(163); 
	val p1a = Person("Dean", "Wampler", 29);System.out.println("""p1a  : proscala.chap10.person_equality.Person = """ + $show(p1a ));$skip(41); 
	val p1b = Person("Dean", "Wampler", 29);System.out.println("""p1b  : proscala.chap10.person_equality.Person = """ + $show(p1b ));$skip(39); 
	val p2 = Person("Buck", "Trends", 30);System.out.println("""p2  : proscala.chap10.person_equality.Person = """ + $show(p2 ));$skip(18); val res$0 = 
	
	p1a equals p1a;System.out.println("""res0: Boolean = """ + $show(res$0));$skip(16); val res$1 = 
	p1a equals p1b;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(15); val res$2 = 
	p1a equals p2;System.out.println("""res2: Boolean = """ + $show(res$2));$skip(17); val res$3 = 
	p1a equals null;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(42); val res$4 = 
	
	// eq : 참조동등성 검사, ne 는 neq
	p1a eq p1a;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(12); val res$5 = 
	p1a eq p1b;System.out.println("""res5: Boolean = """ + $show(res$5));$skip(11); val res$6 = 
	p1a eq p2;System.out.println("""res6: Boolean = """ + $show(res$6));$skip(13); val res$7 = 
	p1a eq null;System.out.println("""res7: Boolean = """ + $show(res$7));$skip(14); val res$8 = 
	
	p1a ne p1a;System.out.println("""res8: Boolean = """ + $show(res$8));$skip(12); val res$9 = 
	p1a ne p1b;System.out.println("""res9: Boolean = """ + $show(res$9));$skip(11); val res$10 = 
	p1a ne p2;System.out.println("""res10: Boolean = """ + $show(res$10));$skip(41); val res$11 = 
	
	// array 비교
	Array(1,2) == Array(1,2);System.out.println("""res11: Boolean = """ + $show(res$11));$skip(36); val res$12 = 
	Array(1,2) sameElements Array(1,2);System.out.println("""res12: Boolean = """ + $show(res$12));$skip(38); val res$13 = 
	
	// list 비교
	List(1,2) == List(1,2);System.out.println("""res13: Boolean = """ + $show(res$13));$skip(35); val res$14 = 
	List(1,2).sameElements(List(1,2));System.out.println("""res14: Boolean = """ + $show(res$14))}
	
	
}
