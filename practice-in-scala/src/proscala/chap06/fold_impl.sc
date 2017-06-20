package proscala.chap06

//p322
// reduceLeft, foldRight는 꼬리 재귀이다. 즉 성능향상의 이점이 있다. right는 꼬리 재귀가 아니므로 큰 리스트를 적용시 stack overflow가
// 발생한다. right는 특성상 모든 재귀함수가 끝까지 미칠때까지 연산을 미뤄둔다.
// 왼쪽 재귀는 꼬리 재귀이므로 루프로 변환이 가능하며 지연 연산을 적용할 수 없으나 오른쪽 재귀는 뒷부분에 대한 평가를 유보하여 무한 지연 스트림 처리가 가능해진다.
object fold_impl {
	def reduceLeft[A,B](s: Seq[A])(f: A => B): Seq[B] = {
		@annotation.tailrec
		def rl(accum: Seq[B], s2: Seq[A]): Seq[B] = s2 match {
			case head +: tail => rl(f(head) +: accum, tail)
			case _ => accum
		}
		rl(Seq.empty[B], s)
	}                                         //> reduceLeft: [A, B](s: Seq[A])(f: A => B)Seq[B]
	
	def reduceRight[A,B](s: Seq[A])(f: A => B): Seq[B] = s match {
		case head +: tail => f(head) +: reduceRight(tail)(f)
		case _ => Seq.empty[B]
	}                                         //> reduceRight: [A, B](s: Seq[A])(f: A => B)Seq[B]
	
	val list = List(1,2,3,4)                  //> list  : List[Int] = List(1, 2, 3, 4)
	reduceLeft(list)(i => 2*i)                //> res0: Seq[Int] = List(8, 6, 4, 2)
	
	reduceRight(list)(i => 2*i)               //> res1: Seq[Int] = List(2, 4, 6, 8)
}