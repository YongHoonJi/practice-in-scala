package proscala.chap10

//p438
// scala.Product를 케이스 클래스에 혼합할 수 있다.
object product {
	case class Person(name: String, age: Int);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(552); 
	// http://www.scala-lang.org/api/current/scala/Product.html
	// 케이스 클래스를 product를 구현한다.
	// trait Product2[+T1, +T2] extends Product  => 필드의 실제 타입을 반환한다. 타입매개변수가 공변적이다.
	// Product2 is a Cartesian product of 2 components.
	// Product2는 2 요소의 곱집합이다.
	//** 곱집합(cartesian product or product set : 임의의 두 집합 X,Y에 대하여 각 원소 X의 원소 x,Y의 원소 Y의 모든 순서쌍의 집합을 말한다.
	// http://hanmaths.tistory.com/49
	val p: Product = Person("Dean", 20);System.out.println("""p  : Product = """ + $show(p ));$skip(16); val res$0 = 
	p.productArity;System.out.println("""res0: Int = """ + $show(res$0));$skip(23); val res$1 = 
	
	p.productElement(0);System.out.println("""res1: Any = """ + $show(res$1));$skip(37); 
	
	p.productIterator foreach println;$skip(197); 
	// case 클래스의 원소수는 제한이 없으나 튜플이나 프로덕트 경우 원소제한이 여전히 22개이다.
	// final case class Tuple1[+T1](_1: T1) extends Product1[T1] with Product with Serializable
	// Product 트레이트를 상속한다.
	val t2 = ("Dean", 29);System.out.println("""t2  : (String, Int) = """ + $show(t2 ));$skip(7); val res$2 = 
	t2._1;System.out.println("""res2: String = """ + $show(res$2));$skip(7); val res$3 = 
	t2._2;System.out.println("""res3: Int = """ + $show(res$3))}
	//t2._3
}
