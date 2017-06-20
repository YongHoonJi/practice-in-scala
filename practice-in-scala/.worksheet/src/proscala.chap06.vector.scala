package proscala.chap06

//p297
// list, vector, linked list : http://seeit.kr/36
// vector는 연산에서 O(1)시간을 제공한다. 중간 원소에 대한 직접 접근이 가능하다. (리스트는 특정 원소 검색에 O(n)의 시간이 필요하다.)

import util.TicToc;

object vector {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(249); 
	val vect1 = Vector("programming", "scala");System.out.println("""vect1  : scala.collection.immutable.Vector[String] = """ + $show(vect1 ));$skip(53); 
	val vect2 = "people" +: "should" +: "read" +: vect1;System.out.println("""vect2  : scala.collection.immutable.Vector[String] = """ + $show(vect2 ));$skip(56); 
	
	val vect3 = "programming" +: "scala" +: Vector.empty;System.out.println("""vect3  : scala.collection.immutable.Vector[String] = """ + $show(vect3 ));$skip(62); 
	
	val vect4 = "people" +: "should" +: "read" +: Vector.empty;System.out.println("""vect4  : scala.collection.immutable.Vector[String] = """ + $show(vect4 ));$skip(32); 
	
	
	val vect5 = vect4 ++ vect3;System.out.println("""vect5  : scala.collection.immutable.Vector[String] = """ + $show(vect5 ));$skip(62); 
                
	val list3 = "programming" :: "scala" :: Nil;System.out.println("""list3  : List[String] = """ + $show(list3 ));$skip(51); 
	val list4 = "people" :: "should" :: "read" :: Nil;System.out.println("""list4  : List[String] = """ + $show(list4 ));$skip(30); 
	
	val list5 = list4 ++ list3;System.out.println("""list5  : List[String] = """ + $show(list5 ));$skip(79); val res$0 = 
	
	// 상수 시간에 첨자를 기반으로 원소에 접근. 아래 리스트와의 접근 실행시간을 비교해보아라.
	TicToc.time(vect5(3));System.out.println("""res0: String = """ + $show(res$0));$skip(25); val res$1 = 
	
	TicToc.time(list5(3));System.out.println("""res1: String = """ + $show(res$1))}
}
