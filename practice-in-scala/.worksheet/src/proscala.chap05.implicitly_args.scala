package proscala.chap05

object implicitly_args {
 	// Ordering은 java comparable과 유사
 	// sortBy : https://www.scala-lang.org/api/current/scala/collection/immutable/List.html
 	// trait Ordering : https://www.scala-lang.org/api/current/scala/math/Ordering.html
	import math.Ordering
	
	case class MyList[A](list: List[A]) {
	
		def sortBy1[B](f: A => B)(implicit ord: Ordering[B]): List[A] = list.sortBy(f)(ord)
		// implicitly : Ordering[B]의 인스턴스를 취하는 암시적 2번째 인자 목록이 있음. context bound
		def sortBy2[B: Ordering](f: A => B): List[A] = list.sortBy(f)(implicitly[Ordering[B]])
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(615); 
	
	val list = MyList(List(1,3,5,2,4));System.out.println("""list  : proscala.chap05.implicitly_args.MyList[Int] = """ + $show(list ));$skip(25); val res$0 = 
	
	list sortBy1(i => -i);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(22); val res$1 = 
	list.sortBy1(i => i);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(23); val res$2 = 
	list sortBy2(i => -i);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(303); val res$3 = 
	
	
	// sortby example
	// def sortBy[B](f: (A) ⇒ B)(implicit ord: math.Ordering[B]): List[A]
	{
	val words = "The quick brown fox jumped over the lazy dog".split(' ')
	// this works because scala.Ordering will implicitly provide an Ordering[Tuple2[Int, Char]]
	words.sortBy(x => (x.length, x.head))
	};System.out.println("""res3: Array[String] = """ + $show(res$3));$skip(321); 
	// ordering example
	{
	import scala.util.Sorting
	val pairs = Array(("a", 5, 2), ("c", 3, 1), ("b", 1, 3))
	
	// sort by 2nd element
	Sorting.quickSort(pairs)(Ordering.by[(String, Int, Int), Int](_._2))
	
	// sort by the 3rd element, then 1st
	Sorting.quickSort(pairs)(Ordering[(Int, String)].on(x => (x._3, x._1)))
	}}
}
