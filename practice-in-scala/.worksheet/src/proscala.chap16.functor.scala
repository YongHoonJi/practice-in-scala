package proscala.chap16

object functor {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(55); 
  println("")
  
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
  };$skip(701); 
  
  val fii: Int => Int = i => i * 2;System.out.println("""fii  : Int => Int = """ + $show(fii ));$skip(40); 
  val fid: Int => Double = i => 2.1 * 2;System.out.println("""fid  : Int => Double = """ + $show(fid ));$skip(46); 
  val fds: Double => String = d => d.toString;System.out.println("""fds  : Double => String = """ + $show(fds ));$skip(34); val res$0 = 
  
  SeqF.map(List(1,2,3,4))(fii);System.out.println("""res0: Seq[Int] = """ + $show(res$0));$skip(31); val res$1 = 
  SeqF.map(List(1,2,3,4))(fid);System.out.println("""res1: Seq[Double] = """ + $show(res$1));$skip(33); val res$2 = 
  SeqF.map(List.empty[Int])(fii);System.out.println("""res2: Seq[Int] = """ + $show(res$2));$skip(31); val res$3 = 
  
  OptionF.map(Some(2))(fii);System.out.println("""res3: Option[Int] = """ + $show(res$3));$skip(38); val res$4 = 
  OptionF.map(Option.empty[Int])(fii);System.out.println("""res4: Option[Int] = """ + $show(res$4));$skip(38); 
  
  val fa = FunctionF.map(fid)(fds);System.out.println("""fa  : Int => String = """ + $show(fa ));$skip(8); val res$5 = 
  fa(2);System.out.println("""res5: String = """ + $show(res$5));$skip(38); 
  
  val fb = FunctionF.map(fid)(fds);System.out.println("""fb  : Int => String = """ + $show(fb ));$skip(8); val res$6 = 
  fb(2);System.out.println("""res6: String = """ + $show(res$6));$skip(56); 
  val fc = FunctionF.map[Int, Double, String](fid)(fds);System.out.println("""fc  : Int => String = """ + $show(fc ));$skip(30); 
  
  val fd = fds compose fid;System.out.println("""fd  : Int => String = """ + $show(fd ));$skip(11); val res$7 = 
  
  fd(2);System.out.println("""res7: String = """ + $show(res$7))}
  
}
