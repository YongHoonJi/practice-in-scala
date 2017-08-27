package proscala.chap16

object functor {
  println("")                                     //> 
  
  import scala.language.higherKinds
  
  trait Functor[F[_]] {
  	def map[A,B](fa: F[A])(f: A => B): F[B] // map인자는 F[A]라는 펑터로 A=>B로 변환하는 함수다.
  }
  
  object SeqF extends Functor[Seq] {
  	def map[A,B](seq: Seq[A])(f: A => B): Seq[B] = seq map f
  }
  
  object OptionF extends Functor[Option] {
  	def map[A,B](opt: Option[A])(f: A => B): Option[B] = opt map f
  }
  
  // 한 함수를 다른 함수로 매핑하는 구현 객체를 정의
  object FunctionF {
  	def map[A, A2, B](func: A => A2)(f: A2 => B): A => B = {
  		val functor = new Functor[({type l[m] = A => m}) #l] {
  			def map[A3,B](func: A => A3)(f: A3 => B): A => B = (a: A) => f(func(a))
  		}
  		functor.map(func)(f)
  	}
  }
  
  val fii: Int => Int = i => i * 2                //> fii  : Int => Int = <function1>
  val fid: Int => Double = i => 2.1 * 2           //> fid  : Int => Double = <function1>
  val fds: Double => String = d => d.toString     //> fds  : Double => String = <function1>
  
  SeqF.map(List(1,2,3,4))(fii)                    //> res0: Seq[Int] = List(2, 4, 6, 8)
  SeqF.map(List(1,2,3,4))(fid)                    //> res1: Seq[Double] = List(4.2, 4.2, 4.2, 4.2)
  SeqF.map(List.empty[Int])(fii)                  //> res2: Seq[Int] = List()
  
  OptionF.map(Some(2))(fii)                       //> res3: Option[Int] = Some(4)
  OptionF.map(Option.empty[Int])(fii)             //> res4: Option[Int] = None
  
  val fa = FunctionF.map(fid)(fds)                //> fa  : Int => String = <function1>
  fa(2)                                           //> res5: String = 4.2
  
  val fb = FunctionF.map(fid)(fds)                //> fb  : Int => String = <function1>
  fb(2)                                           //> res6: String = 4.2
  val fc = FunctionF.map[Int, Double, String](fid)(fds)
                                                  //> fc  : Int => String = <function1>
  
  val fd = fds compose fid                        //> fd  : Int => String = <function1>
  
  fd(2)                                           //> res7: String = 4.2
  
}