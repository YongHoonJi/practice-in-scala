package chap05

class Practice extends App{
  
  sealed trait Option[+A]
  case class Some[+A](get: A) extends Option[A]
  case object None extends Option[Nothing]
  
  // 완전함수
  def mean(xs: Seq[Double]): Option[Double] = {
    if(xs.isEmpty) None
    else Some(xs.sum / xs.length)
  }
  
  
  trait Optaion[+A] {
    def map[B](f: A => B): Option[B]
    def flaMap[B](f: A => Option[B]): Option[B]
    def getOrElse[B >: A](default: => B): B
    def orElse[B >: A](obj: => Option[B]): Option[B]
    def filter(f: A => Boolean): Option[A]
  }
}