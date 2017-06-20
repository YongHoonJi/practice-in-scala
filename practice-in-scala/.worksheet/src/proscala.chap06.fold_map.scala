package proscala.chap06

//p314
// fold rigth의 함수 시그니쳐는 아래와 같다. z는 시작값이고 op는 적용될 함수이다.
// def foldRight[B](z: B)(op: (A, B) ⇒ B): B

object fold_map {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(180); 
	val list = List(1,2,3,4,5,6);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(70); val res$0 = 
	list.foldRight(List.empty[String])((x, list) => ("["+x+"]") :: list);System.out.println("""res0: List[String] = """ + $show(res$0));$skip(141); val res$1 = 
	/*
		A1 >: A 상위 바운드 타입을 지정하는 것으로 리턴값이 A1 즉 A의 부모타입이다.
	*/
	// def fold[A1 >: A](z: A1)(op: (A1,A1) => A1): A1
	list.fold(0)((a,b) => (a+b));System.out.println("""res1: Int = """ + $show(res$1));$skip(80); val res$2 = 
	
	// def foldLeft[B](z: B)(op: (B,A) => B):B
	list.foldLeft(1)((a,b) => (b/a));System.out.println("""res2: Int = """ + $show(res$2));$skip(35); val res$3 = 
	list.foldRight(1)((a,b) => (b/a));System.out.println("""res3: Int = """ + $show(res$3));$skip(74); val res$4 = 
	
	//def reduce[A1 >: A][op: (A1, A1) => A1]: A1
	list.reduce((a,b)=>a+b);System.out.println("""res4: Int = """ + $show(res$4));$skip(83); val res$5 = 
	
	//def reduceLeft[A1 >: A](op: (A1, A1) => A1): A1
	list.reduceLeft((a,b)=> b/a);System.out.println("""res5: Int = """ + $show(res$5));$skip(84); val res$6 = 
	
	// def reduceRight[A1 >: A](op: (A1,A2) => A1):A1
	list.reduceRight((a,b)=> b/a);System.out.println("""res6: Int = """ + $show(res$6));$skip(97); val res$7 = 
	
	// def optionReduce[A1 >: A](op: (A1, A1) => A1): Option[A1]
	list.reduceOption((a,b) => b/a);System.out.println("""res7: Option[Int] = """ + $show(res$7));$skip(220); val res$8 = 
	
	// aggredate
	// def aggregate[B](z: B)(seqop: (B,A) => B, chomop: (B,B) => B):B
	// seqop로 연산후 파티션을 하고 chomp를 통해 파티셔닝된 결과를 연산한다.
	//
	List(10, 20, 30).aggregate(0)({ (sum, ch) => sum + ch }, { (p1, p2) => p1 + p2 });System.out.println("""res8: Int = """ + $show(res$8));$skip(120); 
	
	// scan : 컬랙션 접두사 스캔
	// def scan[B >: A](z: B)(op: (B,B) => B): TraversalbleOnce[B]
	val scanlist = List(1,2,3,4,5);System.out.println("""scanlist  : List[Int] = """ + $show(scanlist ));$skip(26); val res$9 = 
	scanlist.scan(10)(_ + _);System.out.println("""res9: List[Int] = """ + $show(res$9));$skip(104); val res$10 = 
	
	//product : 원소들의 곱
	// def producet:A
	//List(1,2,3).product(1)
	
	// mkString
	List(1,2,3).mkString;System.out.println("""res10: String = """ + $show(res$10));$skip(27); val res$11 = 
	List(1,2,3).mkString("|");System.out.println("""res11: String = """ + $show(res$11));$skip(36); val res$12 = 
	List(1,2,3).mkString("[",",", "]");System.out.println("""res12: String = """ + $show(res$12));$skip(173); val res$13 = 
	
	
	//fold, reduce는 순회의 순서를 보장하지 않는다. 하지만 foldLeft, foldRight경우 원소를 특정방향으로 순회함을 보장한다.
	// 아래는 교환법칙이 성립되는 +,* 연산이기 때문에 순서와 상관없이 같은 값이 표시된다.
	List(1,2,3,4,5).fold(10)(_ * _);System.out.println("""res13: Int = """ + $show(res$13));$skip(39); val res$14 = 
	
	List(1,2,3,4,5).foldLeft(10)(_ * _);System.out.println("""res14: Int = """ + $show(res$14));$skip(38); val res$15 = 
	List(1,2,3,4,5).foldRight(10)(_ * _);System.out.println("""res15: Int = """ + $show(res$15));$skip(51); 
	
	val facLeft = (accum: Int, x: Int) => accum + x;System.out.println("""facLeft  : (Int, Int) => Int = """ + $show(facLeft ));$skip(49); 
	val facRight = (x:Int, accum: Int) => accum + x;System.out.println("""facRight  : (Int, Int) => Int = """ + $show(facRight ));$skip(31); 
	
	val list1 = List(1,2,3,4,5);System.out.println("""list1  : List[Int] = """ + $show(list1 ));$skip(58); val res$16 = 
	
	// ((((1+2) + 3) + 4 ) + 5)
	list1.reduceLeft(facLeft);System.out.println("""res16: Int = """ + $show(res$16));$skip(57); val res$17 = 
	// (1 + (2 + (3 + (4+5))))
	list1.reduceRight(facRight);System.out.println("""res17: Int = """ + $show(res$17));$skip(73); 
	
	// 교환의 법칙이 성립하지 않는다면?
	val fncLeft = (accum: Int, x: Int) => accum -x;System.out.println("""fncLeft  : (Int, Int) => Int = """ + $show(fncLeft ));$skip(49); 
	val fncRight = (x: Int, accum: Int) => accum -x;System.out.println("""fncRight  : (Int, Int) => Int = """ + $show(fncRight ));$skip(56); val res$18 = 
  // ((((1-2) - 3) - 4) - 5)
	list1.reduceLeft(fncLeft);System.out.println("""res18: Int = """ + $show(res$18));$skip(63); val res$19 = 
	// (-1 + (-2 + (-3 + (-4 + 5))))
	list1.reduceRight(fncRight);System.out.println("""res19: Int = """ + $show(res$19))}
	
	
}
