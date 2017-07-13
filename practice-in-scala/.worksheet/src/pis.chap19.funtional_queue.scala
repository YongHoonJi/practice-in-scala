package pis.chap19

object funtional_queue {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
	println("")

	trait Queue[T] {
		def head: T
		def tail: Queue[T]
		def enqueue(x: T): Queue[T]
	}
	
	object Queue {
		def apply[T](xs: T*): Queue[T] =
			new QueueImpl[T](xs.toList, Nil)

		private class QueueImpl[T](
			private val leading: List[T],
			private val tailing: List[T]
		) extends Queue[T] {
			
			def mirror =
				if(leading.isEmpty){
					println("reverse:"+tailing.reverse)
					new QueueImpl(tailing.reverse, Nil)
				} else {
					this
				}
					
			def head: T = mirror.leading.head
			
			def tail: QueueImpl[T] = {
				val q = mirror
				new QueueImpl(q.leading.tail, q.tailing)
			}
			
			def enqueue(x: T) =
				new QueueImpl(leading, x :: tailing)
		}
	};$skip(694); 
	
	val l1 = List(1,2);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(20); 
	val l2 = List(3,4);System.out.println("""l2  : List[Int] = """ + $show(l2 ));$skip(25); 
	
	val q = Queue(l1, l2);System.out.println("""q  : pis.chap19.funtional_queue.Queue[List[Int]] = """ + $show(q ));$skip(20); val res$0 = 
	q.enqueue(List(6));System.out.println("""res0: pis.chap19.funtional_queue.Queue[List[Int]] = """ + $show(res$0));$skip(8); val res$1 = 
	q.head;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(17); 
	println(q.tail);$skip(30); 
	
	val q2 = Queue(List(), l2);System.out.println("""q2  : pis.chap19.funtional_queue.Queue[List[Int]] = """ + $show(q2 ));$skip(9); val res$2 = 
	q2.head;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(9); val res$3 = 
	q2.tail;System.out.println("""res3: pis.chap19.funtional_queue.Queue[List[Int]] = """ + $show(res$3))}
}
