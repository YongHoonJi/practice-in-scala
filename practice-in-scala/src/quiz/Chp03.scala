package quiz

class Chp03 extends App {

  // 3.1 다음 패턴 부합 표현식의 결과는?
  sealed trait List[+A] // `List` data type, parameterized on a type, `A`
  case object Nil extends List[Nothing] // A `List` data constructor representing the empty list
  /* Another data constructor, representing nonempty lists. Note that `tail` is another `List[A]`, 
   * which may be `Nil` or another `Cons`.
  */
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List { // `List` companion object. Contains functions for creating and working with lists.
    def sum(ints: List[Int]): Int = ints match { // A function that uses pattern matching to add up a list of integers
      case Nil => 0 // The sum of the empty list is 0.
      case Cons(x, xs) => x + sum(xs) // The sum of a list starting with `x` is `x` plus the sum of the rest of the list.
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }

    def apply[A](as: A*): List[A] = { // Variadic function syntax
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))
    }
    
    // 3.2 List의 첫 요소를 제거하는 함수 tail을 구현하라. 이 함수가 상수 시간으로 실행됨을 주의할 것. Nil인 List도 지원하도록 독자의 구현을 수정하는 여러 가지 방법들도 고려해 보라.
    def removeTail[A](xs: List[A]): List[A] = xs match {
      case Nil => sys.error("tail of empty list");
      case Cons(x, xs) => xs;
    }
  }
  
  val n = List(1,2);
}