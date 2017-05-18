package proscala.chap02

object Test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def equalsing(s: String) =
    println("eq:" + s)                            //> equalsing: (s: String)Unit

  equalsing("me")                                 //> eq:me
  val array: Array[String] = new Array(5)         //> array  : Array[String] = Array(null, null, null, null, null)
  //array = new Array(2)
  array(0) = "Hello"
  
  array                                           //> res0: Array[String] = Array(Hello, null, null, null, null)

}