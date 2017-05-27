package proscala.chap04

// p213
object match_fun_args {
	case class Address(street: String, city: String, country: String)
	case class Person(name: String, age: Int);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(279); 
	
	val as = Seq(
		Address("1 scala Lane", "Anytown", "USA"),
		Address("2 Clojure Lane", "othertown", "USA")
	);System.out.println("""as  : Seq[proscala.chap04.match_fun_args.Address] = """ + $show(as ));$skip(74); 
	
	val ps = Seq(
		Person("Buck trends", 29),
		Person("clo jure", 28)
	);System.out.println("""ps  : Seq[proscala.chap04.match_fun_args.Person] = """ + $show(ps ));$skip(23); 
	
	val pas = ps zip as;System.out.println("""pas  : Seq[(proscala.chap04.match_fun_args.Person, proscala.chap04.match_fun_args.Address)] = """ + $show(pas ));$skip(210); val res$0 = 
	
	// bad case
	// 튜플을 인자로 받아서 패턴매치로 튜플값을 뽑아내는 일반적 함수
	pas map { tup =>
		val Person(name, age) = tup._1
		val Address(street, city, country) = tup._2
		s"$name(age: $age) lives at $street, $city, in $country"
	};System.out.println("""res0: Seq[String] = """ + $show(res$0));$skip(256); val res$1 = 
	
	// good case
	//부분함수로 더 간결하며 복잡한 데이터 처리시 더 유용하다.http://www.scala-lang.org/api/2.12.0/scala/PartialFunction.html
	pas map {
		case (Person(name, age), Address(street, city, country)) =>
			s"$name(age:$age) lives at $street, $city, in$country"
			
	};System.out.println("""res1: Seq[String] = """ + $show(res$1));$skip(207); 
	// 위의 부분함수에 대해 풀어쓴 표현이다.
	val pf: PartialFunction[(Person,Address), String] = {
    case (Person(name, age), Address(street, city, country)) =>
			s"$name(age:$age) lives at $street, $city, in$country"
  };System.out.println("""pf  : PartialFunction[(proscala.chap04.match_fun_args.Person, proscala.chap04.match_fun_args.Address),String] = """ + $show(pf ));$skip(19); val res$2 = 
  
  pas map( pf );System.out.println("""res2: Seq[String] = """ + $show(res$2))}
}
