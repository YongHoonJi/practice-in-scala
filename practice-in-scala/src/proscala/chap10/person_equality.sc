package proscala.chap10
//p 451
object person_equality {
	case class Person(firstName: String, lastName: String, age: Int)
	val p1a = Person("Dean", "Wampler", 29)   //> p1a  : proscala.chap10.person_equality.Person = Person(Dean,Wampler,29)
	val p1b = Person("Dean", "Wampler", 29)   //> p1b  : proscala.chap10.person_equality.Person = Person(Dean,Wampler,29)
	val p2 = Person("Buck", "Trends", 30)     //> p2  : proscala.chap10.person_equality.Person = Person(Buck,Trends,30)
	
	p1a equals p1a                            //> res0: Boolean = true
	p1a equals p1b                            //> res1: Boolean = true
	p1a equals p2                             //> res2: Boolean = false
	p1a equals null                           //> res3: Boolean = false
	
	// eq : 참조동등성 검사, ne 는 neq
	p1a eq p1a                                //> res4: Boolean = true
	p1a eq p1b                                //> res5: Boolean = false
	p1a eq p2                                 //> res6: Boolean = false
	p1a eq null                               //> res7: Boolean = false
	
	p1a ne p1a                                //> res8: Boolean = false
	p1a ne p1b                                //> res9: Boolean = true
	p1a ne p2                                 //> res10: Boolean = true
	
	// array 비교
	Array(1,2) == Array(1,2)                  //> res11: Boolean = false
	Array(1,2) sameElements Array(1,2)        //> res12: Boolean = true
	
	// list 비교
	List(1,2) == List(1,2)                    //> res13: Boolean = true
	List(1,2).sameElements(List(1,2))         //> res14: Boolean = true
	
	
}