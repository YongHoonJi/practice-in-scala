package proscala.chap05

object implicit_parameters {
  class PreferredPrompt(val pre: String)
  class PreferredDrink(val pre: String)

  object Greeter {
    def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) = {
      println("Welcome, " + name + ". The system is ready.")
      println("drink : " + drink.pre)
      println("prompt : " + prompt.pre)
    }
  }

  object JoesPrefs {
    implicit val propmt = new PreferredPrompt("Yes master >")
    implicit val drink = new PreferredDrink("tea")
  }

  import JoesPrefs._
  Greeter.greet("Justin")                         //> Welcome, Justin. The system is ready.
                                                  //| drink : tea
                                                  //| prompt : Yes master >
  // sorting
  import scala.util.Sorting
  val pairs = Array(("a", 5, 2), ("c", 3, 1), ("b", 1, 3))
                                                  //> pairs  : Array[(String, Int, Int)] = Array((a,5,2), (c,3,1), (b,1,3))

  // sort by 2nd element
  Sorting.quickSort(pairs)(Ordering.by[(String, Int, Int), Int](_._2))
  pairs                                           //> res0: Array[(String, Int, Int)] = Array((b,1,3), (c,3,1), (a,5,2))
  // sort by the 3rd element, then 1st
  Sorting.quickSort(pairs)(Ordering[(Int, String)].on(x => (x._3, x._1)))
  pairs                                           //> res1: Array[(String, Int, Int)] = Array((c,3,1), (a,5,2), (b,1,3))

  // not using implicit
  def maxListOrdering[T](elements: List[T])(ordering: Ordering[T]): T =
    elements match {
      case List() => throw new IllegalArgumentException("empty list:")
      case List(x) => x
      case x :: rest =>
        println("x " + x)
        println("rest : " + rest)
        val maxRest = maxListOrdering(rest)(ordering)
        println(x + ", " + maxRest)
        if (ordering.gt(x, maxRest)) {
          println("com x:" + x)
          x // gt - x is greater than maxRest
        } else {
          println("maxRest:" + maxRest)
          maxRest
        }
    }                                             //> maxListOrdering: [T](elements: List[T])(ordering: Ordering[T])T

  val list = List(2, 3, 4, 2, 1)                  //> list  : List[Int] = List(2, 3, 4, 2, 1)
  maxListOrdering(list)(Ordering[Int])            //> x 2
                                                  //| rest : List(3, 4, 2, 1)
                                                  //| x 3
                                                  //| rest : List(4, 2, 1)
                                                  //| x 4
                                                  //| rest : List(2, 1)
                                                  //| x 2
                                                  //| rest : List(1)
                                                  //| 2, 1
                                                  //| com x:2
                                                  //| 4, 2
                                                  //| com x:4
                                                  //| 3, 4
                                                  //| maxRest:4
                                                  //| 2, 4
                                                  //| maxRest:4
                                                  //| res2: Int = 4

  // using implicit
  def maxListImpParam[T](elements: List[T])(implicit ordering: Ordering[T]): T =
    elements match {
      case List() => throw new IllegalArgumentException("empty list:")
      case List(x) => x
      case x :: rest =>
        println("x " + x)
        println("rest : " + rest)
        val maxRest = maxListImpParam(rest)(ordering)
        println(x + ", " + maxRest)
        if (ordering.gt(x, maxRest)) {
          println("com x:" + x)
          x // gt - x is greater than maxRest
        } else {
          println("maxRest:" + maxRest)
          maxRest
        }
    }                                             //> maxListImpParam: [T](elements: List[T])(implicit ordering: Ordering[T])T

  val implist = List(2, 3, 4, 2, 1)               //> implist  : List[Int] = List(2, 3, 4, 2, 1)
  maxListImpParam(list)                           //> x 2
                                                  //| rest : List(3, 4, 2, 1)
                                                  //| x 3
                                                  //| rest : List(4, 2, 1)
                                                  //| x 4
                                                  //| rest : List(2, 1)
                                                  //| x 2
                                                  //| rest : List(1)
                                                  //| 2, 1
                                                  //| com x:2
                                                  //| 4, 2
                                                  //| com x:4
                                                  //| 3, 4
                                                  //| maxRest:4
                                                  //| 2, 4
                                                  //| maxRest:4
                                                  //| res3: Int = 4

  // 암시적 파라미터에 대한 대입 생
  def maxList[T](elements: List[T])(implicit ordering: Ordering[T]): T =
    elements match {
      case List() => throw new IllegalArgumentException("empty list:")
      case List(x) => x
      case x :: rest =>
        println("x " + x)
        println("rest : " + rest)
        val maxRest = maxList(rest) // ordering을 암시적으로 사용
        println(x + ", " + maxRest) // 명시적으로 ordering 사용
        if (ordering.gt(x, maxRest)) {
          println("com x:" + x)
          x // gt - x is greater than maxRest
        } else {
          println("maxRest:" + maxRest)
          maxRest
        }
    }                                             //> maxList: [T](elements: List[T])(implicit ordering: Ordering[T])T

  // implicitly : 현재 영역 안에서 특정 객체의 타입의 암시적 객체를 찾고 싶은 경우 사용
  // implicit 파라미터의 이름이 변경되어도 문제가 없다.
  def maxList2[T](elements: List[T])(implicit comparator: Ordering[T]): T =
    elements match {
      case List() => throw new IllegalArgumentException("empty list:")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList2(rest) // ordering을 암시적으로 사용
        if (implicitly[Ordering[T]].gt(x, maxRest)) // implicitly로 암시적 객체를 찾아 함수를 수행
          x
        else
          maxRest
    }                                             //> maxList2: [T](elements: List[T])(implicit comparator: Ordering[T])T

	// 맥락바운드
  def maxList3[T:Ordering](elements: List[T]): T = // [T: Ordering] : T와 관련된 어떤 형태(여기서는 정렬)가 존재해야 한다는 선언
    elements match {
      case List() => throw new IllegalArgumentException("empty list:")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList3(rest) // ordering을 암시적으로 사용
        if (implicitly[Ordering[T]].gt(x, maxRest)) // implicitly로 암시적 객체를 찾아 함수를 수행
          x
        else
          maxRest
    }                                             //> maxList3: [T](elements: List[T])(implicit evidence$1: Ordering[T])T
}