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

  //  call by need
  def callbyneed(cond: Boolean, i: Int, i2: Int) {
    if (cond)
      println(i);
    else
      println(i2);
  }
  callbyneed(true, 7*0, 7/0);
  
  val employees = List("jack", "paul", "alto", "nick")
  val result = employees
    .filter(_.length() > 1)
    .map(_.capitalize)
    .reduce(_ + "," + _)
    println(result)
}