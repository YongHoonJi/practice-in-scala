package proscala.chap04

// p198
// 유연하게 시퀀스 원소를 반환하기 위한 방법으로 Seq에 내장된 unapplySeq를 사용해 보자
// 아래 A*는 elems가 가변 인자 목록임을 알려준다.
object match_seq_unapplySeq {
  val emptyList = Nil                             //> emptyList  : scala.collection.immutable.Nil.type = List()
  val nonEmptyVector = Vector(1, 2, 3, 4, 5)      //> nonEmptyVector  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4
                                                  //| , 5)
  val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" -> 3)
                                                  //> nonEmptyMap  : scala.collection.immutable.Map[String,Int] = Map(one -> 1, tw
                                                  //| o -> 2, three -> 3)
  
 	// 한쌍씩 처리함
 	def windows[T](seq: Seq[T]): String = seq match {
 		case Seq(head1, head2, _*) => s"($head1, $head2), "+ windows(seq.tail)
 		case Seq(head,_*) => s"($head,_), "+windows(seq.tail)
 		case Nil => "Nil"
 	}                                         //> windows: [T](seq: Seq[T])String
 	
 	for(seq <- Seq(emptyList, nonEmptyVector, nonEmptyMap.toSeq)) {
 		println(windows(seq))             //> Nil
                                                  //| (1, 2), (2, 3), (3, 4), (4, 5), (5,_), Nil
                                                  //| ((one,1), (two,2)), ((two,2), (three,3)), ((three,3),_), Nil
 	}
 	
 	def windows2[T](seq: Seq[T]): String = seq match {
 		case head1 +: head2 +: tail => s"($head1,$head2), "+ windows2(seq.tail)
 		case head +: tail => s"($head,_), " + windows2(seq.tail)
 		case Nil => "Nil"
 	}                                         //> windows2: [T](seq: Seq[T])String
 	
 	for(seq <- Seq(emptyList, nonEmptyVector, nonEmptyMap.toSeq)) {
 		println(windows2(seq))            //> Nil
                                                  //| (1,2), (2,3), (3,4), (4,5), (5,_), Nil
                                                  //| ((one,1),(two,2)), ((two,2),(three,3)), ((three,3),_), Nil
 	}
 	
 	//Seq에 내장된 슬라이더이다
 	val seq = Seq(1,2,3,4,5)                  //> seq  : Seq[Int] = List(1, 2, 3, 4, 5)
 	val slide2 = seq.sliding(2)               //> slide2  : Iterator[Seq[Int]] = non-empty iterator
 	slide2.toSeq                              //> res0: Seq[Seq[Int]] = Stream(List(1, 2), ?)
 	slide2.toList                             //> res1: List[Seq[Int]] = List(List(2, 3), List(3, 4), List(4, 5))
 	seq.sliding(3,2).toList                   //> res2: List[Seq[Int]] = List(List(1, 2, 3), List(3, 4, 5))

}