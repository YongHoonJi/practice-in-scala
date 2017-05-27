package proscala.chap02
// 부분함수는 함수가 모든 가능한 입력에 대해 결과를 정의하지 않는다. 지정한 케이스절에서 어느하나의 일치하는 입력에 대해서만 결과를 정의한다.
// 입력이 미뤄진 함수 블럭이라고 하자
// http://www.scala-lang.org/api/2.12.0/scala/PartialFunction.html
object partial_functions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(292); 
  val pf1: PartialFunction[Any, String] = { case s: String => "YES" };System.out.println("""pf1  : PartialFunction[Any,String] = """ + $show(pf1 ));$skip(70); 
  val pf2: PartialFunction[Any, String] = { case d: Double => "YES" };System.out.println("""pf2  : PartialFunction[Any,String] = """ + $show(pf2 ));$skip(27); 

  val pf = pf1 orElse pf2;System.out.println("""pf  : PartialFunction[Any,String] = """ + $show(pf ));$skip(130); 

  def tryPF(x: Any, f: PartialFunction[Any, String]): String =
    try { f(x).toString } catch { case _: MatchError => "Error" };System.out.println("""tryPF: (x: Any, f: PartialFunction[Any,String])String""");$skip(78); 

  def d(x: Any, f: PartialFunction[Any, String]) = f.isDefinedAt(x).toString;System.out.println("""d: (x: Any, f: PartialFunction[Any,String])String""");$skip(59); 

  println(" 	| pf1 - String | pdf2 - Double | pf - All ");$skip(63); 
  println(" x	| def? | pf1(x) | def? | pf2(x) | def? | pf(x)");$skip(196); 
  List("str", 3.14, 10) foreach { x =>
    printf("%-5s | %-5s | %-6s | %-5s | %-6s | %-5s | %-6s\n",
      x.toString, d(x, pf1), tryPF(x, pf1), d(x, pf2), tryPF(x, pf2), d(x, pf), tryPF(x, pf))
  };$skip(28); 

  val sample = 1 to 10;System.out.println("""sample  : scala.collection.immutable.Range.Inclusive = """ + $show(sample ));$skip(94); 
  val isEven: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => x + " is even"
  };System.out.println("""isEven  : PartialFunction[Int,String] = """ + $show(isEven ));$skip(122); 

  // the method collect can use isDefinedAt to select which members to collect
  val evenNumbers = sample collect isEven;System.out.println("""evenNumbers  : scala.collection.immutable.IndexedSeq[String] = """ + $show(evenNumbers ));$skip(93); 

  val isOdd: PartialFunction[Int, String] = {
    case x if x % 2 == 1 => x + " is odd"
  };System.out.println("""isOdd  : PartialFunction[Int,String] = """ + $show(isOdd ));$skip(163); 

  // the method orElse allows chaining another partial function to handle
  // input outside the declared domain
  val numbers = sample map (isEven orElse isOdd);System.out.println("""numbers  : scala.collection.immutable.IndexedSeq[String] = """ + $show(numbers ))}
}
