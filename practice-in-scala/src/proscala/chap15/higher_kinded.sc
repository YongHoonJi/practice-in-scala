package proscala.chap15
// p570

object higher_kinded {

	trait Add[T]{
		def add(t1: T, T2: T): T
	}
	
	object Add {
		implicit val ddInt = new Add[Int] {
			def add(i1: Int, i2: Int): Int = i1 + i2
		}
		
		implicit val addIntPair = new Add[(Int, Int)] {
			def add(p1:(Int, Int), p2: (Int, Int)): (Int, Int) =
				(p1._1 + p2._1, p1._2 + p2._2)
		}
	}
	
	
	def sumSeq[T : Add](seq: Seq[T]): T =
		seq reduce (implicitly[Add[T]].add(_,_))
                                                  //> sumSeq: [T](seq: Seq[T])(implicit evidence$1: proscala.chap15.higher_kinded.
                                                  //| Add[T])T
		
	
	sumSeq(Vector(1 -> 10, 2 -> 20))          //> res0: (Int, Int) = (3,30)
	sumSeq(1 to 10)                           //> res1: Int = 55
	
	// 암시를 사용한 Seq의 덧셈을 만들지만 Option과 같은 타입은 지원하지않는다.
	//sumSeq(Option(2))
	
	// 아래와 같은 고계타입 (highter-kinded type)을 사용하면 매개변수화한 타입을 또 추상화 할 수 있다.
	import scala.language.higherKinds // 고계타입을 위한 임포트
	// 고계타입을 사용한 트레이트. 관례상 고계타입은 M을 사용한다.
	trait Reduce[T, -M[T]] { // 매서드 인자이므로 반공변
		def reduce(m: M[T])(f: (T, T) => T): T
	}
	
	object Reduce {
		implicit def seqReduce[T] = new Reduce[T, Seq] {
			def reduce(seq: Seq[T])(f: (T, T) => T): T = seq reduce f
		}
		
		implicit def optionReduce[T] = new Reduce[T, Option] {
			def reduce(opt: Option[T])(f: (T, T) => T): T = opt reduce f
		}
	}
	
	def sum[T : Add, M[T]](container: M[T]) (implicit red: Reduce[T,M]): T =
		red.reduce(container)(implicitly[Add[T]].add(_,_))
                                                  //> sum: [T, M[T]](container: M[T])(implicit evidence$2: proscala.chap15.higher
                                                  //| _kinded.Add[T], implicit red: proscala.chap15.higher_kinded.Reduce[T,M])T
	// 암시 적용이 3단계네...
	sum(Vector(1 -> 10, 2 -> 20, 3 -> 30))    //> res2: (Int, Int) = (6,60)
	sum(Option(2))                            //> res3: Int = 2
	
	// 더 축약한 버전
	trait Reduce1[-M[_]] {
		def reduce[T](m: M[T])(f: (T, T) => T): T
	}
	
	object Reduce1 {
		implicit val seqReduce = new Reduce1[Seq] {
			def reduce[T](seq: Seq[T])(f: (T,T) => T): T = seq reduce f
		}
		
		implicit val optionReduce = new Reduce1[Option] {
			def reduce[T](opt: Option[T])(f: (T,T) => T): T = opt reduce f
		}
	}
	
	def sum1[T:Add, M[_] : Reduce1](container: M[T]): T =
		implicitly[Reduce1[M]].reduce(container)(implicitly[Add[T]].add(_,_))
                                                  //> sum1: [T, M[_]](container: M[T])(implicit evidence$3: proscala.chap15.highe
                                                  //| r_kinded.Add[T], implicit evidence$4: proscala.chap15.higher_kinded.Reduce1
                                                  //| [M])T
		
	sum(Vector(1 -> 10, 2 -> 20, 3 -> 30))    //> res4: (Int, Int) = (6,60)
	sum1(Option(2))                           //> res5: Int = 2
	
}