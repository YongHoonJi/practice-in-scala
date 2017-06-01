package proscala.chap05

object implicitly {

	import math.Ordering
	
	case class MyList[A](list: List[A]) {
	
		def sortBy1[B](f: A => B)(implicit ord: Ordering[B]): List[A] = list.sortBy(f)(ord)
			
		def sortBy2[B: Ordering](f: A => B): List[A] = list.sortBy(f)(implicitly[Ordering[B]])
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(330); 
	
	val list = MyList(List(1,3,5,2,4));System.out.println("""list  : proscala.chap05.implicitly.MyList[Int] = """ + $show(list ));$skip(25); val res$0 = 
	
	list sortBy1(i => -i);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(23); val res$1 = 
	list sortBy2(i => -i);System.out.println("""res1: List[Int] = """ + $show(res$1))}
}
