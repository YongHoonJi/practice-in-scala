package pis.chap19

object funtional_queue {
	println("")                               //> 

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
	}
	
	val l1 = List(1,2)                        //> l1  : List[Int] = List(1, 2)
	val l2 = List(3,4)                        //> l2  : List[Int] = List(3, 4)
	
	val q = Queue(l1, l2)                     //> q  : pis.chap19.funtional_queue.Queue[List[Int]] = pis.chap19.funtional_queu
                                                  //| e$$anonfun$main$1$Queue$3$QueueImpl@668bc3d5
	q.enqueue(List(6))                        //> res0: pis.chap19.funtional_queue.Queue[List[Int]] = pis.chap19.funtional_que
                                                  //| ue$$anonfun$main$1$Queue$3$QueueImpl@3cda1055
	q.head                                    //> res1: List[Int] = List(1, 2)
	println(q.tail)                           //> pis.chap19.funtional_queue$$anonfun$main$1$Queue$3$QueueImpl@7a5d012c
	
	val q2 = Queue(List(), l2)                //> q2  : pis.chap19.funtional_queue.Queue[List[Int]] = pis.chap19.funtional_que
                                                  //| ue$$anonfun$main$1$Queue$3$QueueImpl@3fb6a447
	q2.head                                   //> res2: List[Int] = List()
	q2.tail                                   //> res3: pis.chap19.funtional_queue.Queue[List[Int]] = pis.chap19.funtional_que
                                                  //| ue$$anonfun$main$1$Queue$3$QueueImpl@79b4d0f
}