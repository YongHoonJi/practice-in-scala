package proscala.chap06

//p314
// fold rigth의 함수 시그니쳐는 아래와 같다. z는 시작값이고 op는 적용될 함수이다.
// def foldRight[B](z: B)(op: (A, B) ⇒ B): B

object fold_map {
	val list = List(1,2,3,4,5,6)              //> list  : List[Int] = List(1, 2, 3, 4, 5, 6)
	list.foldRight(List.empty[String])((x, list) => ("["+x+"]") :: list)
                                                  //> res0: List[String] = List([1], [2], [3], [4], [5], [6])
	/*
		A1 >: A 상위 바운드 타입을 지정하는 것으로 리턴값이 A1 즉 A의 부모타입이다.
	*/
	// def fold[A1 >: A](z: A1)(op: (A1,A1) => A1): A1
	list.fold(0)((a,b) => (a+b))              //> res1: Int = 21
	
	// def foldLeft[B](z: B)(op: (B,A) => B):B
	list.foldLeft(1)((a,b) => (b/a))          //> res2: Int = 6
	list.foldRight(1)((a,b) => (b/a))         //> res3: Int = 0
	
	//def reduce[A1 >: A][op: (A1, A1) => A1]: A1
	list.reduce((a,b)=>a+b)                   //> res4: Int = 21
	
	//def reduceLeft[A1 >: A](op: (A1, A1) => A1): A1
	list.reduceLeft((a,b)=> b/a)              //> res5: Int = 6
	
	// def reduceRight[A1 >: A](op: (A1,A2) => A1):A1
	list.reduceRight((a,b)=> b/a)             //> res6: Int = 0
	
	// def optionReduce[A1 >: A](op: (A1, A1) => A1): Option[A1]
	list.reduceOption((a,b) => b/a)           //> res7: Option[Int] = Some(6)
	
	// aggredate
	// def aggregate[B](z: B)(seqop: (B,A) => B, chomop: (B,B) => B):B
	// seqop로 연산후 파티션을 하고 chomp를 통해 파티셔닝된 결과를 연산한다.
	//
	List(10, 20, 30).aggregate(0)({ (sum, ch) => sum + ch }, { (p1, p2) => p1 + p2 })
                                                  //> res8: Int = 60
	
	// scan : 컬랙션 접두사 스캔
	// def scan[B >: A](z: B)(op: (B,B) => B): TraversalbleOnce[B]
	val scanlist = List(1,2,3,4,5)            //> scanlist  : List[Int] = List(1, 2, 3, 4, 5)
	scanlist.scan(10)(_ + _)                  //> res9: List[Int] = List(10, 11, 13, 16, 20, 25)
	
	//product : 원소들의 곱
	// def producet:A
	//List(1,2,3).product(1)
	
	// mkString
	List(1,2,3).mkString                      //> res10: String = 123
	List(1,2,3).mkString("|")                 //> res11: String = 1|2|3
	List(1,2,3).mkString("[",",", "]")        //> res12: String = [1,2,3]
	
	
	//fold, reduce는 순회의 순서를 보장하지 않는다. 하지만 foldLeft, foldRight경우 원소를 특정방향으로 순회함을 보장한다.
	// 아래는 교환법칙이 성립되는 +,* 연산이기 때문에 순서와 상관없이 같은 값이 표시된다.
	List(1,2,3,4,5).fold(10)(_ * _)           //> res13: Int = 1200
	
	List(1,2,3,4,5).foldLeft(10)(_ * _)       //> res14: Int = 1200
	List(1,2,3,4,5).foldRight(10)(_ * _)      //> res15: Int = 1200
	
	val facLeft = (accum: Int, x: Int) => accum + x
                                                  //> facLeft  : (Int, Int) => Int = <function2>
	val facRight = (x:Int, accum: Int) => accum + x
                                                  //> facRight  : (Int, Int) => Int = <function2>
	
	val list1 = List(1,2,3,4,5)               //> list1  : List[Int] = List(1, 2, 3, 4, 5)
	
	// ((((1+2) + 3) + 4 ) + 5)
	list1.reduceLeft(facLeft)                 //> res16: Int = 15
	// (1 + (2 + (3 + (4+5))))
	list1.reduceRight(facRight)               //> res17: Int = 15
	
	// 교환의 법칙이 성립하지 않는다면?
	val fncLeft = (accum: Int, x: Int) => accum -x
                                                  //> fncLeft  : (Int, Int) => Int = <function2>
	val fncRight = (x: Int, accum: Int) => accum -x
                                                  //> fncRight  : (Int, Int) => Int = <function2>
  // ((((1-2) - 3) - 4) - 5)
	list1.reduceLeft(fncLeft)                 //> res18: Int = -13
	// (-1 + (-2 + (-3 + (-4 + 5))))
	list1.reduceRight(fncRight)               //> res19: Int = -5
	
	
}