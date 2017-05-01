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

    // 3.3 List의 첫 요소를 다른 값으로 대체하는 함수 setHead를 구현하라.
    /*
    *If a function body consists solely of a match expression, we'll often put the match on the same line as the function signature, 
    * rather than introducing another level of nesting.
    */
    def setHead[A](o: A, xs: List[A]): List[A] = xs match {
      case Nil => sys.error("setHead on empty list");
      case Cons(x, xs) => Cons(o, xs);
    }

    //3.4 tail을 일반화해서, 목록에서 처음 n개의 요소를 제거하는 함수 drop을 구현하라. 이 함수의 실행시간은 제거되는 원소의 개수에만 비례함을 주의할 것. List 전체의 복사본을 만들 필요는 없다. 
    def drop[A](l: List[A], n: Int): List[A] = {
      if (n <= 0) l
      else l match {
        case Nil => Nil;
        case Cons(_, t) => drop(t, n - 1);
      }
    }

    // 3.5 주어진 술어(predicate)와 부합하는 List의 앞 요소들(prefix)을 제거하는 함수 dropwhile을 구현하라.
    def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
      case Cons(h, t) if f(h) => dropWhile(t, f)
      case _ => l
    }

    // 3.6 한 List의 마지막 요쇼를 제외한 모든 요소로 이루어진 List를 돌려주는 함수 Init을 구현하라. 예를 들어 List(1,2,3,4)에 대해 init은 List(1,2,3)을 돌려주어야 한다. 
    // 이 함수를 tail처럼 상수시간으로 구현할 수 없는 이유는 무엇인가?
    def init[A](l: List[A]): List[A] = l match {
      case Nil => sys.error("empty list");
      case Cons(_, Nil) => Nil;
      case Cons(h, t) => Cons(h, init(t));
    }

    // 3.9 foldRight를 이용해서 목록의 길이를 계산하라
    def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
      case Nil => z;
      case Cons(x, xs) => f(x, foldRight(xs, z)(f));
    }
    /*
    foldRight(Cons(1,Cons(2, Cons(3, Nil))), 0) ((x,y) => x + y)
    1 + foldRight(Cons(2, Cons(3, Nil)), 0) ((x,y) => x + y)
    1 + (2, foldRight(Cons(3, Nil), 0) ((x,y) => x + y))
    1 + (2 + (3, foldRight(Nil), 0) ((x,y) => x + y))
    1 (2 + (3 + (0)))
    */
    		    
    def sum2(ns: List[Int]) =
      foldRight(ns, 0)((x, y) => x + y)

    def product2(ns: List[Double]) =
      foldRight(ns, 1.0)(_ * _)

    def length[A](as: List[A]): Int = {
      foldRight(as, 0)((x, acc) => acc + 1)
    }

    // 3.10
    @annotation.tailrec
    def foldLeft[A, B](l: List[A], z: B)(f: (B, A) => B): B = l match {
      case Nil => z
      case Cons(h, t) => foldLeft(t, f(z, h))(f)
    }
    
    // 3.11
    def sum3(ns: List[Int]) = foldLeft(ns, 0)( (x,y) => x + y );
    
    def product3(ns: List[Double]) = foldLeft(ns, 1.0)( (x,y) => x * y );
    
    // *3.12 목록의 역을 돌려주는 함수를 작성하라. 접기 함수를 이용해 볼 것
    def reverse[A](l: List[A]): List[A] = foldLeft(l, List[A]())((acc, h) => Cons(h, acc))

  }

  val n = List(1, 2);
}