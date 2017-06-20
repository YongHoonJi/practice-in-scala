package proscala.chap14
//p527
object lower_bound {
	class Parent(val value: Int) {
		override def toString = s"${this.getClass.getName}${value}"
	}
	
	class Child(value: Int) extends Parent(value)
	
	val op1: Option[Parent] = Option(new Child(1))
                                                  //> op1  : Option[proscala.chap14.lower_bound.Parent] = Some(proscala.chap14.low
                                                  //| er_bound$Child1)
	val p1: Parent = op1.getOrElse(new Parent(10))
                                                  //> p1  : proscala.chap14.lower_bound.Parent = proscala.chap14.lower_bound$Child
                                                  //| 1
	
	val op2: Option[Parent] = Option[Parent](null)
                                                  //> op2  : Option[proscala.chap14.lower_bound.Parent] = None
	val p2a: Parent = op2.getOrElse(new Parent(10))
                                                  //> p2a  : proscala.chap14.lower_bound.Parent = proscala.chap14.lower_bound$Pare
                                                  //| nt10
	val p2b: Parent = op2.getOrElse(new Child(100))
                                                  //> p2b  : proscala.chap14.lower_bound.Parent = proscala.chap14.lower_bound$Chil
                                                  //| d100
	
	val op3: Option[Parent] = Option[Child](null)
                                                  //> op3  : Option[proscala.chap14.lower_bound.Parent] = None
	val	p3a: Parent = op3.getOrElse(new Parent(20))
                                                  //> p3a  : proscala.chap14.lower_bound.Parent = proscala.chap14.lower_bound$Pare
                                                  //| nt20
	// 리턴값이 Child가 아닌 무조건 Parent임을 보자
	val p3b: Parent = op3.getOrElse(new Child(200))
                                                  //> p3b  : proscala.chap14.lower_bound.Parent = proscala.chap14.lower_bound$Chil
                                                  //| d200
	// 아래의 경우는 상위 바운드 타입을  Child로 지정했다.
	val op4: Option[Child] = Option[Child](null)
                                                  //> op4  : Option[proscala.chap14.lower_bound.Child] = None
	
	val	p4a: Parent = op4.getOrElse(new Parent(20))
                                                  //> p4a  : proscala.chap14.lower_bound.Parent = proscala.chap14.lower_bound$Pare
                                                  //| nt20
	// 상위 바운드 타입이 Child이기 때문에 Parent 상위 타입인 child도 받을 수 있다.
  val	p4c: Child = op4.getOrElse(new Child(20)) //> p4c  : proscala.chap14.lower_bound.Child = proscala.chap14.lower_bound$Child
                                                  //| 20
	// 리턴값이 Child가 아닌 무조건 Parent임을 보자
	val p4b: Parent = op4.getOrElse(new Child(200))
                                                  //> p4b  : proscala.chap14.lower_bound.Parent = proscala.chap14.lower_bound$Chil
                                                  //| d200
	// 상위 바운드 타입이 함수파라미터가 반공변이어야 하는 이유가 쓰임이 같다. 연구해보자
 
}