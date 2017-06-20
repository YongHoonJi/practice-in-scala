package proscala.chap14
//p527
object lower_bound {
	class Parent(val value: Int) {
		override def toString = s"${this.getClass.getName}${value}"
	}
	
	class Child(value: Int) extends Parent(value);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(247); 
	
	val op1: Option[Parent] = Option(new Child(1));System.out.println("""op1  : Option[proscala.chap14.lower_bound.Parent] = """ + $show(op1 ));$skip(48); 
	val p1: Parent = op1.getOrElse(new Parent(10));System.out.println("""p1  : proscala.chap14.lower_bound.Parent = """ + $show(p1 ));$skip(50); 
	
	val op2: Option[Parent] = Option[Parent](null);System.out.println("""op2  : Option[proscala.chap14.lower_bound.Parent] = """ + $show(op2 ));$skip(49); 
	val p2a: Parent = op2.getOrElse(new Parent(10));System.out.println("""p2a  : proscala.chap14.lower_bound.Parent = """ + $show(p2a ));$skip(49); 
	val p2b: Parent = op2.getOrElse(new Child(100));System.out.println("""p2b  : proscala.chap14.lower_bound.Parent = """ + $show(p2b ));$skip(49); 
	
	val op3: Option[Parent] = Option[Child](null);System.out.println("""op3  : Option[proscala.chap14.lower_bound.Parent] = """ + $show(op3 ));$skip(49); 
	val	p3a: Parent = op3.getOrElse(new Parent(20));System.out.println("""p3a  : proscala.chap14.lower_bound.Parent = """ + $show(p3a ));$skip(84); 
	// 리턴값이 Child가 아닌 무조건 Parent임을 보자
	val p3b: Parent = op3.getOrElse(new Child(200));System.out.println("""p3b  : proscala.chap14.lower_bound.Parent = """ + $show(p3b ));$skip(83); 
	// 아래의 경우는 상위 바운드 타입을  Child로 지정했다.
	val op4: Option[Child] = Option[Child](null);System.out.println("""op4  : Option[proscala.chap14.lower_bound.Child] = """ + $show(op4 ));$skip(51); 
	
	val	p4a: Parent = op4.getOrElse(new Parent(20));System.out.println("""p4a  : proscala.chap14.lower_bound.Parent = """ + $show(p4a ));$skip(105); 
	// 상위 바운드 타입이 Child이기 때문에 Parent 상위 타입인 child도 받을 수 있다.
  val	p4c: Child = op4.getOrElse(new Child(20));System.out.println("""p4c  : proscala.chap14.lower_bound.Child = """ + $show(p4c ));$skip(84); 
	// 리턴값이 Child가 아닌 무조건 Parent임을 보자
	val p4b: Parent = op4.getOrElse(new Child(200));System.out.println("""p4b  : proscala.chap14.lower_bound.Parent = """ + $show(p4b ))}
	// 상위 바운드 타입이 함수파라미터가 반공변이어야 하는 이유가 쓰임이 같다. 연구해보자
 
}
