package proscala.chap06
//p303 순회
// foreach는 대표적인 순회 메서드이다. scala.collection.IterableLike를 참조하자.
// foreach는 부수효과를 수행하는 함수이므로 순수함수가 아니다. (리턴값이 없는 unit 함수)
object foreach {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(228); 
	List(1,2,3,4,5) foreach { i => println("Int: " + i ) };$skip(81); 
 val stateCapitals = Map(
 	"albama" -> "montgomery",
 	"alaska" -> "juneau"
 	);System.out.println("""stateCapitals  : scala.collection.immutable.Map[String,String] = """ + $show(stateCapitals ));$skip(86); 
 	// 키와 값을 분리하는 케이스문을 사용
 	stateCapitals foreach { case(k,v) => println(k + ":" +v) }
                                                  
	// 연관시키기 - map은 scala.collection.TraversableLike에 정의가 들어있다.
	// map[B](f: (A) ⇒ B): Traversable[B] { ... def map[B](f: (A) => B:Traverable[B] ... }
	
	object Combinators {
		def map[A,B](f: (A) => B)(list: List[A]): List[B] = list map f
	};$skip(333); 
	
	val intToString = (i: Int) => s"N=&i";System.out.println("""intToString  : Int => String = """ + $show(intToString ));$skip(186); 
	// int => string 함수를 List[Int] => List[String]으로 끌어올린다
	// map은 특정 함수를 사용하여 A타입을 B타입으로 변환하는 함수라고 생각하지만 이 케이스와 같이 특정 자료형으로 끌어올리는 도구로도 볼 수 있다.
	val flist = Combinators.map(intToString) _;System.out.println("""flist  : List[Int] => List[String] = """ + $show(flist ));$skip(33); 
	val list = flist(List(1,2,3,4));System.out.println("""list  : List[String] = """ + $show(list ));$skip(185); 

	// 펼치면서 연관시키기 - flatmap
	// def flatMap[B](f: A => GenTraversableOnce[B]): Traverable[B]
	// 함수의 리턴 값이 최소 한번은 순회할 수 있는 컬랙션이다.
	val tobeFlatList = List("now", "is", "", "the", "time");System.out.println("""tobeFlatList  : List[String] = """ + $show(tobeFlatList ));$skip(38); val res$0 = 
	tobeFlatList flatMap( s => s.toList);System.out.println("""res0: List[Char] = """ + $show(res$0));$skip(203); 

	// 아래는 동일한 표현이다. map을 호출후 flatten한 것은 flatmap과 같다.
	// 하지만 map + flatten은 중간 결과물인 List[List[char], List[char]...]를 만들어 낸다.
	val toBeFlatList2 = List("now", "is", "", "the", "time") map (s => s.toList);System.out.println("""toBeFlatList2  : List[List[Char]] = """ + $show(toBeFlatList2 ));$skip(23); val res$1 = 
	toBeFlatList2.flatten;System.out.println("""res1: List[Char] = """ + $show(res$1))}
	
}
