package proscala.chap04

//p191
// 클래스의 인스턴스에 들어간 내용을 매치
// 매턴 매칭은 케이스 클래스의 unapply를 사용하여 객체를 분해하여 각 항목을 필요하다면 비교하여 매칭한다!
object match_deeper {
  case class Address(street: String, city: String, country: String)
  case class Person(name: String, age: Int, address: Address)

  val alice = Person("Alice", 25, Address("1 scala lane", "chicago", "USA"))
                                                  //> alice  : proscala.chap04.match_deeper.Person = Person(Alice,25,Address(1 sca
                                                  //| la lane,chicago,USA))
  val bob = Person("Bob", 29, Address("2 java ave.", "miami", "USA"))
                                                  //> bob  : proscala.chap04.match_deeper.Person = Person(Bob,29,Address(2 java av
                                                  //| e.,miami,USA))
  val charlie = Person("Charlie", 32, Address("pthon ct.", "boston", "USA"))
                                                  //> charlie  : proscala.chap04.match_deeper.Person = Person(Charlie,32,Address(p
                                                  //| thon ct.,boston,USA))

  for (person <- Seq(alice, bob, charlie)) {
    person match {
      case Person("Alice", 25, Address(_, "chicago", _)) => println("hi alice")
      case Person(name, age, _) => println("the others")
  }
	// @는 뒷 인자를 후인자에 대입한다. p @ Person이면 Person의 값을 p로 alias처리한다고 보면 된다.
	for (person <- Seq(alice, bob, charlie)) {
	  person match {
	    case p @ Person("Alice", 25, address) => println(s"hi alice! $p")
	    case p @ Person("Bob", 29, a @ Address(street, city, country)) =>
	      println(s"hi ${p.name}! age ${p.age}, in ${a.city}")
	    case p @ Person(name, age, _) =>
	      println(s"who are you, $age year-old person named $name? $p")
	  }
	}

  }                                               //> hi alice
                                                  //| hi alice! Person(Alice,25,Address(1 scala lane,chicago,USA))
                                                  //| hi Bob! age 29, in miami
                                                  //| who are you, 32 year-old person named Charlie? Person(Charlie,32,Address(pt
                                                  //| hon ct.,boston,USA))
                                                  //| the others
                                                  //| hi alice! Person(Alice,25,Address(1 scala lane,chicago,USA))
                                                  //| hi Bob! age 29, in miami
                                                  //| who are you, 32 year-old person named Charlie? Person(Charlie,32,Address(pt
                                                  //| hon ct.,boston,USA))
                                                  //| the others
                                                  //| hi alice! Person(Alice,25,Address(1 scala lane,chicago,USA))
                                                  //| hi Bob! age 29, in miami
                                                  //| who are you, 32 year-old person named Charlie? Person(Charlie,32,Address(pt
                                                  //| hon ct.,boston,USA))

}