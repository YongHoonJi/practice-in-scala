package proscala.chap03

// 시퀀스는 모든 컬랙션의 부모 타입이다.
// map은 seq의 서브타입이 아님

object math_seq {
  // 연산자 +: 는 시퀀스의 'Cons'연산자이다. 3.3절의 우선순위 규칙에서 List:: 와 유사.오른쪽 접기(+:)
  //왼쪽에서 오른쪽 순서로 묶이는 연산
  val foldRight = 1 +: 2+: 3+: 4+: Nil            //> foldRight  : List[Int] = List(1, 2, 3, 4)
  
  val nonEmptySeq = Seq(1, 2, 3, 4, 5)            //> nonEmptySeq  : Seq[Int] = List(1, 2, 3, 4, 5)
  val emptySeq = Seq.empty[Int]                   //> emptySeq  : Seq[Int] = List()
  val nonEmptyList = List(1, 2, 3, 4, 5)          //> nonEmptyList  : List[Int] = List(1, 2, 3, 4, 5)
  val emptyList = Nil                             //> emptyList  : scala.collection.immutable.Nil.type = List()
  val nonEmptyVector = Vector(1, 2, 3, 4, 5)      //> nonEmptyVector  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4
                                                  //| , 5)
  val emptyVector = Vector.empty[Int]             //> emptyVector  : scala.collection.immutable.Vector[Int] = Vector()
  val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" -> 3)
                                                  //> nonEmptyMap  : scala.collection.immutable.Map[String,Int] = Map(one -> 1, tw
                                                  //| o -> 2, three -> 3)
  val emptyMap = Map.empty[String, Int]           //> emptyMap  : scala.collection.immutable.Map[String,Int] = Map()

  def seqToString[T](seq: Seq[T]): String = seq match {
    case head +: tail => s"$head + " + seqToString(tail)
    case Nil => "Nil"
  }                                               //> seqToString: [T](seq: Seq[T])String

  seqToString(nonEmptySeq)                        //> res0: String = 1 + 2 + 3 + 4 + 5 + Nil

  for (
    seq <- Seq(
      nonEmptySeq, emptySeq, nonEmptyList, emptyList, nonEmptyVector, emptyVector, nonEmptyMap.toSeq, emptyMap.toSeq)
  ) {
    println(seqToString(seq))                     //> 1 + 2 + 3 + 4 + 5 + Nil
                                                  //| Nil
                                                  //| 1 + 2 + 3 + 4 + 5 + Nil
                                                  //| Nil
                                                  //| 1 + 2 + 3 + 4 + 5 + Nil
                                                  //| Nil
                                                  //| (one,1) + (two,2) + (three,3) + Nil
                                                  //| Nil
  }

  def seqToString2[T](seq: Seq[T]): String = seq match {
    case head +: tail => s"($head +: ${seqToString2(tail)})"
    case Nil => "(Nil)"
  }                                               //> seqToString2: [T](seq: Seq[T])String

  for (seq <- Seq(nonEmptySeq, emptySeq, nonEmptyList)) {
    println(seqToString2(seq))                    //> (1 +: (2 +: (3 +: (4 +: (5 +: (Nil))))))
                                                  //| (Nil)
                                                  //| (1 +: (2 +: (3 +: (4 +: (5 +: (Nil))))))
  }
	
  // 리스트의 head, tail 표현
  // +: 는 unapply[T,Coll](collection:Coll):Option[(Coll, T)] 함수를 유일하게 가지며
  // 이 함수는 머리와 꼬리가 들어있는 튜플 Option을 반환한다
  val unappliedList = 1 +: 2 +: 3 +: 4 +: 5 +: Nil//> unappliedList  : List[Int] = List(1, 2, 3, 4, 5)
  val hd :: tail = List(1, 2, 3, 4, 5)            //> hd  : Int = 1
                                                  //| tail  : List[Int] = List(2, 3, 4, 5)
  val head +: tails = List(1, 2, 3, 4, 5)         //> head  : Int = 1
                                                  //| tails  : List[Int] = List(2, 3, 4, 5)
  def listToString[T](list: List[T]): String = list match {
    case head :: tail => s"($head :: ${listToString(tail)})"
    case Nil => "(Nil)"
  }                                               //> listToString: [T](list: List[T])String

  for (l <- List(nonEmptyList, emptyList)) { println(listToString(l)) }
                                                  //> (1 :: (2 :: (3 :: (4 :: (5 :: (Nil))))))
                                                  //| (Nil)

}