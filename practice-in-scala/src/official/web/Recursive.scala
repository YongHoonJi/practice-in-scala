package practice

object Recursive {
  def factorinal(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n - 1, n * acc)
    }
    go(n, 1)
  }

  def fibonacci(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, prev: Int, cur: Int): Int = {
      if (n == 0) prev
      else loop(n - 1, cur, prev + cur)
    }
    loop(n, 0, 1);
  }

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d."
    println(msg.format(name, n, f(n)))
  }

  //monomorphic function
  def findFirst(ss: Array[String], key: String): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)
    }
    loop(0);
  }

  // polymorphic function with higher-order function
  def findFirst[A](ss: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= ss.length) -1
      else if (p(ss(n))) n
      else loop(n + 1)
    }
    loop(0)
  }

  def getIndexFromString(s: String): Boolean = {
    if ("e" == s) true
    else false
  }

  def isSorted[A](ss: Array[A], p: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int): Boolean = {
      if (n >= ss.length - 1) true
      else if (p(ss(n), ss(n + 1))) false
      else loop(n + 1)
    }

    loop(0);
  }
  // answer
  def isSortedAnswer[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(n: Int): Boolean =
      if (n >= as.length - 1) true
      else if (gt(as(n), as(n + 1))) false
      else go(n + 1)

    go(0)
  }

  def main(args: Array[String]): Unit = {
    formatResult("factorial", 5, factorinal)
    formatResult("fibonacci", 8, fibonacci)

    println(findFirst(Array(1, 2, 3, 4, 5, 6), (x: Int) => x == 6))
    println(findFirst(Array("Jane", "Jack", "Min", "Mark"), (x: String) => x == "Jack"))
    println(isSorted(Array(1, 2, 3, 4, 5, 6), (x: Int, y: Int) => x > y))

    // curring(원 파라미터의 분해함수들)
    def line(a: Int, b: Int, x: Int): Int = a * x + b
    def curriedLine(a: Int)(b: Int)(x: Int): Int = line(a, b, x)
    def defaultLine(x: Int): Int = curriedLine(1)(0)(x)
    println("decomposed to curring : " + defaultLine(5)) //returns`5`

    def curriedByKeyword = (line _).curried
    println("curried : " + curriedByKeyword(1)(0)(5))

    // curring ex2
    // Note that `=>` associates to the right, so we could
    // write the return type as `A => B => C`
    def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => b => f(a, b)

    // partially applied function(부분 적용함수)
    def normline(a: Int, b: Int, x: Int): Int = a * x + b
    def partialLine = (b: Int, x: Int) => normline(2, b, x)
    println("partially applied function:" + partialLine(0, 1)) // returns `2`  
    def partialLine2 = line(2, _: Int, _: Int)

    // Exercise 4: Implement `uncurry`
    def uncurry[A, B, C](f: A => B => C): (A, B) => C =
      (a, b) => f(a)(b)

    /*
  NB: There is a method on the `Function` object in the standard library,
  `Function.uncurried` that you can use for uncurrying.
  Note that we can go back and forth between the two forms. We can curry
  and uncurry and the two forms are in some sense "the same". In FP jargon,
  we say that they are _isomorphic_ ("iso" = same; "morphe" = shape, form),
  a term we inherit from category theory.
  */

    // Exercise 5: Implement `compose`

    def compose[A, B, C](f: B => C, g: A => B): A => C =
      a => f(g(a))
  }

}