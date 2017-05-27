package proscala.chap04

object apply_unapply {
  /*
	Firstly, apply and unapply are not necessarily opposites of each other. Indeed, if you define one on a class/object, you don't have to define the other.

apply:
apply is probably the easier to explain. Essentially, when you treat your object like a function, apply is the method that is called, so, Scala turns:

obj(a, b, c) to obj.apply(a, b, c).

unapply :
unapply is a bit more complicated. It is used in Scala's pattern matching mechanism and its most common use I've seen is in Extractor Objects.

케이스 클래스의 특징 중 하나는 컴파일러가 모든 케이스 클래스에 대해 각 클래스의 이름이 같은 싱글턴 객체인 동반객체를 자동으로 만들어낸다.
동반 객체에 자동으로 추가되는 메서드가 있는데 그 중 하나가 apply 메서드다. 이 메서드는 동반 클래스의 생성자와 같은 인자를 받는다.
*/
  // case class http://docs.scala-lang.org/ko/tutorials/tour/case-classes
  // apply는 사실상 Point객체를 만드는 팩토리다.
  // 물론 subtype에서 apply를 구현하여 만들 수 있다.
  case class Point(x: Int, y: Int);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(929); 
  val p1 = Point.apply(1, 2);System.out.println("""p1  : proscala.chap04.apply_unapply.Point = """ + $show(p1 ));$skip(23); 
  val p2 = Point(1, 2);System.out.println("""p2  : proscala.chap04.apply_unapply.Point = """ + $show(p2 ));$skip(186); val res$0 = 

  // 대칭성의 논리에 의해 case class에는 unapply가 존재한다. 생성의 반대인 추출, 해제의 unapply이다.
  //unapply가 튜플2로 객체를 분해하는 것을 볼 수 있다.
  // 이는 패턴 매칭시 unapply를 통해 각 인자를 분해하여 비교하는 것으로 볼 수 있다.
  Point.unapply(p1)

  case class Address(street: String, city: String, country: String)
  case class Person(name: String, age: Int, address: Address);System.out.println("""res0: Option[(Int, Int)] = """ + $show(res$0));$skip(209); 

  val alice = Person("Alice", 25, Address("1 scala lane", "chicago", "USA"));System.out.println("""alice  : proscala.chap04.apply_unapply.Person = """ + $show(alice ));$skip(25); val res$1 = 
  Person.unapply(alice);System.out.println("""res1: Option[(String, Int, proscala.chap04.apply_unapply.Address)] = """ + $show(res$1));$skip(296); ;
  
  // +: 는 시퀀스 추출기로 싱글톤 객체인 것을 아래와 같이 확인할 수 있다. 반환값이 Option[(T, Coll)]인 unapply 함수를 참고해라
  // http://www.scala-lang.org/api/2.12.0/scala/collection/$plus$colon$.html
  // https://github.com/scala/scala/blob/v2.12.0/src/library/scala/collection/SeqExtractors.scala#L1
  val list = List(1,2,3,4);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(42); val res$2 = 
	  // 원래 표기법이 아래와 같으나
	  +:.unapply(list);System.out.println("""res2: Option[(Int, List[Int])] = """ + $show(res$2));$skip(67); 
	  // 아래와 같이 중위 표기법을 적용할 수 있다. 스칼라에서는 중위표기법을 지원한다.
	  val head = 1;System.out.println("""head  : Int = """ + $show(head ));$skip(26); 
	  val tail = List(2,3,4);System.out.println("""tail  : List[Int] = """ + $show(tail ));$skip(16); val res$3 = 
	  head +: tail;System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(219); 
	  
	  // 패턴매칭에서 중위표기법을 사용하지 않은 경우를 보자
	  def processSeq[T](l: Seq[T]): Unit = l match {
	  	case +:(head,tail) =>
	  												printf("%s +: ", head)
	  												processSeq(tail)
	  	case Nil => print("Nil")
	  };System.out.println("""processSeq: [T](l: Seq[T])Unit""");$skip(33); 
	  
	  processSeq(List(1,2,3,4))}
  
}
