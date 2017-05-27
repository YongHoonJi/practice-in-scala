package proscala.chap04

// p213
object match_fun_args {
	case class Address(street: String, city: String, country: String)
	case class Person(name: String, age: Int)
	
	val as = Seq(
		Address("1 scala Lane", "Anytown", "USA"),
		Address("2 Clojure Lane", "othertown", "USA")
	)                                         //> as  : Seq[proscala.chap04.match_fun_args.Address] = List(Address(1 scala Lan
                                                  //| e,Anytown,USA), Address(2 Clojure Lane,othertown,USA))
	
	val ps = Seq(
		Person("Buck trends", 29),
		Person("clo jure", 28)
	)                                         //> ps  : Seq[proscala.chap04.match_fun_args.Person] = List(Person(Buck trends,2
                                                  //| 9), Person(clo jure,28))
	
	val pas = ps zip as                       //> pas  : Seq[(proscala.chap04.match_fun_args.Person, proscala.chap04.match_fun
                                                  //| _args.Address)] = List((Person(Buck trends,29),Address(1 scala Lane,Anytown,
                                                  //| USA)), (Person(clo jure,28),Address(2 Clojure Lane,othertown,USA)))
	
	// bad case
	// 튜플을 인자로 받아서 패턴매치로 튜플값을 뽑아내는 일반적 함수
	pas map { tup =>
		val Person(name, age) = tup._1
		val Address(street, city, country) = tup._2
		s"$name(age: $age) lives at $street, $city, in $country"
                                                  //> res0: Seq[String] = List(Buck trends(age: 29) lives at 1 scala Lane, Anytown
                                                  //| , in USA, clo jure(age: 28) lives at 2 Clojure Lane, othertown, in USA)
	}
	
	// good case
	//부분함수로 더 간결하며 복잡한 데이터 처리시 더 유용하다.http://www.scala-lang.org/api/2.12.0/scala/PartialFunction.html
	pas map {
		case (Person(name, age), Address(street, city, country)) =>
			s"$name(age:$age) lives at $street, $city, in$country"
			
	}                                         //> res1: Seq[String] = List(Buck trends(age:29) lives at 1 scala Lane, Anytown,
                                                  //|  inUSA, clo jure(age:28) lives at 2 Clojure Lane, othertown, inUSA)
	// 위의 부분함수에 대해 풀어쓴 표현이다.
	val pf: PartialFunction[(Person,Address), String] = {
    case (Person(name, age), Address(street, city, country)) =>
			s"$name(age:$age) lives at $street, $city, in$country"
  }                                               //> pf  : PartialFunction[(proscala.chap04.match_fun_args.Person, proscala.chap
                                                  //| 04.match_fun_args.Address),String] = <function1>
  
  pas map( pf )                                   //> res2: Seq[String] = List(Buck trends(age:29) lives at 1 scala Lane, Anytown
                                                  //| , inUSA, clo jure(age:28) lives at 2 Clojure Lane, othertown, inUSA)
}