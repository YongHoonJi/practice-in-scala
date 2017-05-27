package proscala.chap04

// p198
// 유연하게 시퀀스 원소를 반환하기 위한 방법으로 Seq에 내장된 unapplySeq를 사용해 보자
// 아래 A*는 elems가 가변 인자 목록임을 알려준다.
object match_seq_unapplySeq {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(175); 
  val emptyList = Nil;System.out.println("""emptyList  : scala.collection.immutable.Nil.type = """ + $show(emptyList ));$skip(45); 
  val nonEmptyVector = Vector(1, 2, 3, 4, 5);System.out.println("""nonEmptyVector  : scala.collection.immutable.Vector[Int] = """ + $show(nonEmptyVector ));$skip(62); 
  val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" -> 3);System.out.println("""nonEmptyMap  : scala.collection.immutable.Map[String,Int] = """ + $show(nonEmptyMap ));$skip(224); 
  
 	// 한쌍씩 처리함
 	def windows[T](seq: Seq[T]): String = seq match {
 		case Seq(head1, head2, _*) => s"($head1, $head2), "+ windows(seq.tail)
 		case Seq(head,_*) => s"($head,_), "+windows(seq.tail)
 		case Nil => "Nil"
 	};System.out.println("""windows: [T](seq: Seq[T])String""");$skip(94); 
 	
 	for(seq <- Seq(emptyList, nonEmptyVector, nonEmptyMap.toSeq)) {
 		println(windows(seq))
 	};$skip(220); 
 	
 	def windows2[T](seq: Seq[T]): String = seq match {
 		case head1 +: head2 +: tail => s"($head1,$head2), "+ windows2(seq.tail)
 		case head +: tail => s"($head,_), " + windows2(seq.tail)
 		case Nil => "Nil"
 	};System.out.println("""windows2: [T](seq: Seq[T])String""");$skip(95); 
 	
 	for(seq <- Seq(emptyList, nonEmptyVector, nonEmptyMap.toSeq)) {
 		println(windows2(seq))
 	};$skip(54); 
 	
 	//Seq에 내장된 슬라이더이다
 	val seq = Seq(1,2,3,4,5);System.out.println("""seq  : Seq[Int] = """ + $show(seq ));$skip(30); 
 	val slide2 = seq.sliding(2);System.out.println("""slide2  : Iterator[Seq[Int]] = """ + $show(slide2 ));$skip(15); val res$0 = 
 	slide2.toSeq;System.out.println("""res0: Seq[Seq[Int]] = """ + $show(res$0));$skip(16); val res$1 = 
 	slide2.toList;System.out.println("""res1: List[Seq[Int]] = """ + $show(res$1));$skip(26); val res$2 = 
 	seq.sliding(3,2).toList;System.out.println("""res2: List[Seq[Int]] = """ + $show(res$2))}

}
