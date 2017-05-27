package proscala.chap02
// 부분함수는 함수가 모든 가능한 입력에 대해 결과를 정의하지 않는다. 지정한 케이스절에서 어느하나의 일치하는 입력에 대해서만 결과를 정의한다.
// 입력이 미뤄진 함수 블럭이라고 하자
// http://www.scala-lang.org/api/2.12.0/scala/PartialFunction.html
object partial_functions {
  val pf1: PartialFunction[Any, String] = { case s: String => "YES" }
                                                  //> pf1  : PartialFunction[Any,String] = <function1>
  val pf2: PartialFunction[Any, String] = { case d: Double => "YES" }
                                                  //> pf2  : PartialFunction[Any,String] = <function1>

  val pf = pf1 orElse pf2                         //> pf  : PartialFunction[Any,String] = <function1>

  def tryPF(x: Any, f: PartialFunction[Any, String]): String =
    try { f(x).toString } catch { case _: MatchError => "Error" }
                                                  //> tryPF: (x: Any, f: PartialFunction[Any,String])String

  def d(x: Any, f: PartialFunction[Any, String]) = f.isDefinedAt(x).toString
                                                  //> d: (x: Any, f: PartialFunction[Any,String])String

  println(" 	| pf1 - String | pdf2 - Double | pf - All ")
                                                  //>  	| pf1 - String | pdf2 - Double | pf - All 
  println(" x	| def? | pf1(x) | def? | pf2(x) | def? | pf(x)")
                                                  //>  x	| def? | pf1(x) | def? | pf2(x) | def? | pf(x)
  List("str", 3.14, 10) foreach { x =>
    printf("%-5s | %-5s | %-6s | %-5s | %-6s | %-5s | %-6s\n",
      x.toString, d(x, pf1), tryPF(x, pf1), d(x, pf2), tryPF(x, pf2), d(x, pf), tryPF(x, pf))
                                                  //> str   | true  | YES    | false | Error  | true  | YES   
                                                  //| 3.14  | false | Error  | true  | YES    | true  | YES   
                                                  //| 10    | false | Error  | false | Error  | false | Error 
  }

  val sample = 1 to 10                            //> sample  : scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 
                                                  //| 6, 7, 8, 9, 10)
  val isEven: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => x + " is even"
  }                                               //> isEven  : PartialFunction[Int,String] = <function1>

  // the method collect can use isDefinedAt to select which members to collect
  val evenNumbers = sample collect isEven         //> evenNumbers  : scala.collection.immutable.IndexedSeq[String] = Vector(2 is 
                                                  //| even, 4 is even, 6 is even, 8 is even, 10 is even)

  val isOdd: PartialFunction[Int, String] = {
    case x if x % 2 == 1 => x + " is odd"
  }                                               //> isOdd  : PartialFunction[Int,String] = <function1>

  // the method orElse allows chaining another partial function to handle
  // input outside the declared domain
  val numbers = sample map (isEven orElse isOdd)  //> numbers  : scala.collection.immutable.IndexedSeq[String] = Vector(1 is odd,
                                                  //|  2 is even, 3 is odd, 4 is even, 5 is odd, 6 is even, 7 is odd, 8 is even, 
                                                  //| 9 is odd, 10 is even)
}