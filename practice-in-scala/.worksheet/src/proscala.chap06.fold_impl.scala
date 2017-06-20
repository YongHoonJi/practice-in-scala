package proscala.chap06

//p322
// reduceLeft, foldRight는 꼬리 재귀이다. 즉 성능향상의 이점이 있다. right는 꼬리 재귀가 아니므로 큰 리스트를 적용시 stack overflow가
// 발생한다. right는 특성상 모든 재귀함수가 끝까지 미칠때까지 연산을 미뤄둔다.
// 왼쪽 재귀는 꼬리 재귀이므로 루프로 변환이 가능하며 지연 연산을 적용할 수 없으나 오른쪽 재귀는 뒷부분에 대한 평가를 유보하여 무한 지연 스트림 처리가 가능해진다.
object fold_impl {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(524); 
	def reduceLeft[A,B](s: Seq[A])(f: A => B): Seq[B] = {
		@annotation.tailrec
		def rl(accum: Seq[B], s2: Seq[A]): Seq[B] = s2 match {
			case head +: tail => rl(f(head) +: accum, tail)
			case _ => accum
		}
		rl(Seq.empty[B], s)
	};System.out.println("""reduceLeft: [A, B](s: Seq[A])(f: A => B)Seq[B]""");$skip(149); 
	
	def reduceRight[A,B](s: Seq[A])(f: A => B): Seq[B] = s match {
		case head +: tail => f(head) +: reduceRight(tail)(f)
		case _ => Seq.empty[B]
	};System.out.println("""reduceRight: [A, B](s: Seq[A])(f: A => B)Seq[B]""");$skip(28); 
	
	val list = List(1,2,3,4);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(28); val res$0 = 
	reduceLeft(list)(i => 2*i);System.out.println("""res0: Seq[Int] = """ + $show(res$0));$skip(31); val res$1 = 
	
	reduceRight(list)(i => 2*i);System.out.println("""res1: Seq[Int] = """ + $show(res$1))}
}
