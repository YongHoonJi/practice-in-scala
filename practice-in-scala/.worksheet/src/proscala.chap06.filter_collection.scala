package proscala.chap06


object filter_collection {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(133); 
 val stateCapitals = Map(
 	"albama" -> "montgomery",
 	"alaska" -> "juneau"
 	);System.out.println("""stateCapitals  : scala.collection.immutable.Map[String,String] = """ + $show(stateCapitals ));$skip(144); 
	//p310 걸러내기 - filter
	// 컬랙션을 순회하면서 특정 선택 기준을 만족하는 원소를 뽑아내서 새 컬랙션을 만드는 것.
	val filterMap2 = stateCapitals filter { kv => kv._1 startsWith "a"};System.out.println("""filterMap2  : scala.collection.immutable.Map[String,String] = """ + $show(filterMap2 ));$skip(135); 
                                                  
	val strList = List("apple", "banna", "citrus", "danny", "effle", "google", "hipo");System.out.println("""strList  : List[String] = """ + $show(strList ));$skip(78); val res$0 = 
	// def drop(n:Int) : TraversableLike.Repr
	//3번째 이후 리스트를 드롭
	strList.drop(3);System.out.println("""res0: List[String] = """ + $show(res$0));$skip(42); 
	val numberList = List(1,2,3,4,5,6,7,8,9);System.out.println("""numberList  : List[Int] = """ + $show(numberList ));$skip(130); val res$1 = 
	
	// def dropWhile(p:(a) => Boolean): TraversableLike.Repr
	// 술어를 만족하지 않는 경우를 만나면 그 이후는 모두 반환
	numberList.dropWhile(_ % 2 != 0);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(93); val res$2 = 
	
	// exists(p:A => Boolean): Boolean
	// 원소 중 하나라도 만족하면 true
	strList.exists(_ == "apple" );System.out.println("""res2: Boolean = """ + $show(res$2));$skip(112); val res$3 = 
	
	// def filter(p: (A) => Boolean): TraverableLike.Repr
	// 술어를 만족하지 않는 모든 원소를 선택
	numberList.filterNot(_ > 5);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(158); val res$4 = 
	
	// def filterNot(p:(A) => Boolean): TraversableLike.Repr
	
	// find(p:(A) => Boolean):TraversableLike.Repr
	// 술어를 만족하는 첫번째 원소를 반환
	numberList.find(_ > 5);System.out.println("""res4: Option[Int] = """ + $show(res$4));$skip(92); val res$5 = 
	
	// def forall(p: (A) => Boolean): Boolean
	// 술어를 모두 만족하면 true
	numberList.forall(_ > 0);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(152); val res$6 = 

	// def partition(p: (A) => Boolean):(TraversableLike.Repr, TraversableLike.Repr)
	// 술어를 만족하는 컬렉션과 만족하지 않는 컬랙션을 분리
	numberList.partition( _ % 2 == 0);System.out.println("""res6: (List[Int], List[Int]) = """ + $show(res$6));$skip(82); val res$7 = 
	
	// def take(n: Int): TraverableLike.Repr
	// 맨앞 n개의 원소를 반환
	numberList.take(4);System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(90); val res$8 = 
	
	// def takeWhile(p: (A) => Boolean): TraversableLike.Repr
	numberList.takeWhile(_ > 5);System.out.println("""res8: List[Int] = """ + $show(res$8))}
}
