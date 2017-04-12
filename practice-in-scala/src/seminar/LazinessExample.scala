package seminar

object LazinessExample extends App {

  println("*** eager")
  val eagerX = { println("eager"); "fellow" }
  println("first")
  println(eagerX)

  println("*** lazy")
  lazy val lazyX = { println("lazy"); "fellow" }
  println("first")
  println(lazyX)

  var x = () => {  (console.log("foo"), 10) }
  console.log("bar")
  console.log(x())
}