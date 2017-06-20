package proscala.chap06


object filter_collection {
 val stateCapitals = Map(
 	"albama" -> "montgomery",
 	"alaska" -> "juneau"
 	)                                         //> stateCapitals  : scala.collection.immutable.Map[String,String] = Map(albama 
                                                  //| -> montgomery, alaska -> juneau)
	//p310 걸러내기 - filter
	// 컬랙션을 순회하면서 특정 선택 기준을 만족하는 원소를 뽑아내서 새 컬랙션을 만드는 것.
	val filterMap2 = stateCapitals filter { kv => kv._1 startsWith "a"}
                                                  //> filterMap2  : scala.collection.immutable.Map[String,String] = Map(albama -> 
                                                  //| montgomery, alaska -> juneau)
                                                  
	val strList = List("apple", "banna", "citrus", "danny", "effle", "google", "hipo")
                                                  //> strList  : List[String] = List(apple, banna, citrus, danny, effle, google, h
                                                  //| ipo)
	// def drop(n:Int) : TraversableLike.Repr
	//3번째 이후 리스트를 드롭
	strList.drop(3)                           //> res0: List[String] = List(danny, effle, google, hipo)
	val numberList = List(1,2,3,4,5,6,7,8,9)  //> numberList  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
	
	// def dropWhile(p:(a) => Boolean): TraversableLike.Repr
	// 술어를 만족하지 않는 경우를 만나면 그 이후는 모두 반환
	numberList.dropWhile(_ % 2 != 0)          //> res1: List[Int] = List(2, 3, 4, 5, 6, 7, 8, 9)
	
	// exists(p:A => Boolean): Boolean
	// 원소 중 하나라도 만족하면 true
	strList.exists(_ == "apple" )             //> res2: Boolean = true
	
	// def filter(p: (A) => Boolean): TraverableLike.Repr
	// 술어를 만족하지 않는 모든 원소를 선택
	numberList.filterNot(_ > 5)               //> res3: List[Int] = List(1, 2, 3, 4, 5)
	
	// def filterNot(p:(A) => Boolean): TraversableLike.Repr
	
	// find(p:(A) => Boolean):TraversableLike.Repr
	// 술어를 만족하는 첫번째 원소를 반환
	numberList.find(_ > 5)                    //> res4: Option[Int] = Some(6)
	
	// def forall(p: (A) => Boolean): Boolean
	// 술어를 모두 만족하면 true
	numberList.forall(_ > 0)                  //> res5: Boolean = true

	// def partition(p: (A) => Boolean):(TraversableLike.Repr, TraversableLike.Repr)
	// 술어를 만족하는 컬렉션과 만족하지 않는 컬랙션을 분리
	numberList.partition( _ % 2 == 0)         //> res6: (List[Int], List[Int]) = (List(2, 4, 6, 8),List(1, 3, 5, 7, 9))
	
	// def take(n: Int): TraverableLike.Repr
	// 맨앞 n개의 원소를 반환
	numberList.take(4)                        //> res7: List[Int] = List(1, 2, 3, 4)
	
	// def takeWhile(p: (A) => Boolean): TraversableLike.Repr
	numberList.takeWhile(_ > 5)               //> res8: List[Int] = List()
}