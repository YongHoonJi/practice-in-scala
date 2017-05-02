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
    def sum3(ns: List[Int]) = foldLeft(ns, 0)((x, y) => x + y);

    def product3(ns: List[Double]) = foldLeft(ns, 1.0)((x, y) => x * y);

    // ***3.12 목록의 역을 돌려주는 함수를 작성하라. 접기 함수를 이용해 볼 것
    def reverse[A](l: List[A]): List[A] = foldLeft(l, List[A]())((acc, h) => Cons(h, acc))

    // **3.14 append를 foldLeft나 foldRight를 이용해서 구현하라.
    def appendViaFoldRight[A](l: List[A], r: List[A]): List[A] = foldRight(l, r)(Cons(_, _))

    // ***3.15 목록들의 목록을 하나의 목록으로 연결하는 함수를 작성하라. 실행시간은 반드시 모든 목록의 전체 길이에 선형으로 비례해야 한다. 이미 정의한 함수들을 활용하도록 노력할 것.
    /*
    Since `append` takes time proportional to its first argument, and this first argument never grows because of the right-associativity of `foldRight`, 
    this function is linear in the total length of all lists. 
    You may want to try tracing the execution of the implementation on paper to convince yourself that this works. 
    Note that we're simply referencing the `append` function, without writing something like `(x,y) => append(x,y)` or `append(_,_)`. 
    In Scala there is a rather arbitrary distinction between functions defined as _methods_, which are introduced with the `def` keyword, 
    and function values, which are the first-class objects we can pass to other functions, put in collections, and so on. 
    This is a case where Scala lets us pretend the distinction doesn't exist. 
    In other cases, you'll be forced to write `append _` (to convert a `def` to a function value) or even `(x: List[A], y: List[A]) => append(x,y)` 
    if the function is polymorphic and the type arguments aren't known. 
    */
    //def concat[A](l: List[List[A]]): List[A] = foldRight(l, append);

    // 3.16 정수 목록의 각 요소에 1을 더해서 목록을 변환하는 함수를 작성하라. 새 List를 돌려주는 순수함수여야 한다.
    def add1(l: List[Int]): List[Int] = foldRight(l, Nil: List[Int])((h, t) => Cons(h + 1, t))

    // ***3.24 부분 순차열을 담고 있는지 점검하는 hasSubsequence 함수를 구현
    @annotation.tailrec
    def startsWith[A](l: List[A], prefix: List[A]): Boolean = (l, prefix) match {
      case (_, Nil) => true
      case (Cons(h, t), Cons(h2, t2)) if h == h2 => startsWith(t, t2)
      case _ => false
    }

    @annotation.tailrec
    def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = sup match {
      case Nil => sub == Nil
      case _ if startsWith(sup, sub) => true
      case Cons(_, t) => hasSubsequence(t, sub)
    }
  }

  /* fold에 대한 생각 */
  //val num = List[Int](1,2,3,4,5)
  //println(num.foldRight(0)((x,y) => x-y)); // 방향은 <=, 계산시 오른쪽으로 가면서 하나씩 unfold 된다고 생각, result = 3
  // 1 - (foldRight(2) - (foldRight(3) - (foldRight(4) - (foldRight(5) - (0)))))
  //println(num.foldLeft(0)((x,y) => x-y));  // 방향은 =>, 계산시 왼쪽으로 가면서 하나씩 unfold 된다고 생각 , result = -15
  // (((((0 - foldLeft(1)) - foldLeft(2)) - foldLeft(3)) - foldLeft(4)) - foldLeft(5))

  // 3.16 정수 목록의 각 요소에 1을 더해서 목록을 변환하는 함수를 작성하라. 새 List를 돌려주는 순수함수여야 한다.
  /*
  val numbers = List(1,2,3,4,5,6,7,8,9,10)
  val sumLeft = numbers.foldLeft(0) { (m: Int, n: Int) => println("m: " + m + " n: " + n); m - n }
  println("sumLeft:"+sumLeft);
  val sumRight = numbers.foldRight(0) { (m: Int, n: Int) => println("m: " + m + " n: " + n); m - n }
  println("sumRight:"+sumRight);
  * */

  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  // 3.25 트리의 노드, 입과 가지의 개수를 세는 size 함수를 작성하라.
  def size[A](t: Tree[A]): Int = t match {
    case Leaf(t) => 1
    case Branch(l, r) => 1 + size(l) + size(r)
  }

  // 3.26 Tree[Int]에서 가장 큰 요소를 돌려주는 함수 maximum을 작성하라.
  def maximum[A](t: Tree[Int]): Int = t match {
    case Leaf(n) => n;
    case Branch(l, r) => maximum(l).max(maximum(r))
  }

  // 3.27 트리의 뿌리에서 임의의 잎으로 가장 긴 경로의 길이를 돌려주는 depth를 작성하라.
  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 0
    case Branch(l, r) => 1 + (depth(l) max depth(r))
  }
  
  // 3.28 `

}