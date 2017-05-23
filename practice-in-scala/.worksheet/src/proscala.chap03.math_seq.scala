package proscala.chap03

// 시퀀스는 모든 컬랙션의 부모 타입이다.
// map은 seq의 서브타입이 아님
object math_seq {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(128); 
  val nonEmptySeq = Seq(1, 2, 3, 4, 5);System.out.println("""nonEmptySeq  : Seq[Int] = """ + $show(nonEmptySeq ));$skip(32); 
  val emptySeq = Seq.empty[Int];System.out.println("""emptySeq  : Seq[Int] = """ + $show(emptySeq ));$skip(41); 
  val nonEmptyList = List(1, 2, 3, 4, 5);System.out.println("""nonEmptyList  : List[Int] = """ + $show(nonEmptyList ));$skip(22); 
  val emptyList = Nil;System.out.println("""emptyList  : scala.collection.immutable.Nil.type = """ + $show(emptyList ));$skip(45); 
  val nonEmptyVector = Vector(1, 2, 3, 4, 5);System.out.println("""nonEmptyVector  : scala.collection.immutable.Vector[Int] = """ + $show(nonEmptyVector ));$skip(38); 
  val emptyVector = Vector.empty[Int];System.out.println("""emptyVector  : scala.collection.immutable.Vector[Int] = """ + $show(emptyVector ));$skip(62); 
  val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" -> 3);System.out.println("""nonEmptyMap  : scala.collection.immutable.Map[String,Int] = """ + $show(nonEmptyMap ));$skip(40); 
  val emptyMap = Map.empty[String, Int];System.out.println("""emptyMap  : scala.collection.immutable.Map[String,Int] = """ + $show(emptyMap ));$skip(227); 

  def seqToString[T](seq: Seq[T]): String = seq match {
    // 연산자 +: 는 시퀀스의 '콘즈'연산자이다. 3.3절의 우선순위 규칙에서 List:: 와 유사.
    //왼쪽에서 오른쪽 순서로 묶이는 연산
    case head +: tail => s"$head + " + seqToString(tail)
    case Nil => "Nil"
  };System.out.println("""seqToString: [T](seq: Seq[T])String""");$skip(28); val res$0 = 

  seqToString(nonEmptySeq);System.out.println("""res0: String = """ + $show(res$0));$skip(179); 

  for (
    seq <- Seq(
      nonEmptySeq, emptySeq, nonEmptyList, emptyList, nonEmptyVector, emptyVector, nonEmptyMap.toSeq, emptyMap.toSeq)
  ) {
    println(seqToString(seq))
  };$skip(152); 


  def seqToString2[T](seq: Seq[T]): String = seq match {
    case head +: tail => s"($head +: ${seqToString2(tail)})"
    case Nil => "(Nil)"
  };System.out.println("""seqToString2: [T](seq: Seq[T])String""");$skip(89); 
  
  for(seq <- Seq(nonEmptySeq, emptySeq, nonEmptyList)){
  	println(seqToString2(seq))}
  }

}
