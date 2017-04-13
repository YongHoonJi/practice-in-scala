package seminar

object LazinessExample extends App {

  val calNumbers: List[Int] = List(2 + 1, 3 * 2, 1 / 0, 5 - 4);

  println("*** eager")
  val eagerX = { println("eager"); "fellow" }
  println("first")
  println(eagerX)

  println("*** lazy")
  lazy val lazyX = { println("lazy"); "fellow" }
  println("first")
  println(lazyX)

  var x = () => { (println("lazy"), 10) }
  println("first")
  println(x())
  println(x())

  def callbyneed(cond: Boolean, i: Int, i2: Int) {
    if (cond)
      println(i);
    else
      println(i2);
  }

  callbyneed(true, 7*0, 7/0);
  // https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
  // 스트림은 데이터가 저장되는 데이터 구조가 아니고 요소들을 연관 함수와 전달하는 파이프라인이다.
  // intermediate operation : stream-producing, terminal operation : value or side-effect-producing
  // 종료 함수가 호출되기 전까지 중간함수는  lazy상태이다. 종료함수 호출시 중간함수의 표현, 연산은 실행된다.
  // * 종료함수는 최종 결과 값 혹은 부수작용이 포함된다.
  // 그럼 중간함수는 무엇을 하는가. 각 중간함수는 새로운 스트림을 만들고 주어진 연산자나 함수를 저장하고 종료함수를 기다린다.
  // 조인과 select + select를 생각해보자. JPA의 eagar와 laziness도 같은 개념이다.
  // https://www.cs.cornell.edu/courses/cs3110/2011sp/lectures/lec24-streams/streams.htm
  val employees = List("jack", "paul", "alto", "nick")
  val result = employees
    .filter(_.length() > 1)
    .map(_.capitalize)
    .reduce(_ + "," + _)
  println(result)
}