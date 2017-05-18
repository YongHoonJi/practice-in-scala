package proscala.chap02

object person {
  class Person(val name: String, var age: Int)
  val p = new Person("Justin", 29)                //> p  : proscala.chap02.person.Person = proscala.chap02.person$Person@3581c5f3
  p.name                                          //> res0: String = Justin
  p.age                                           //> res1: Int = 29
  //p.name = "Nick"
  p.age = 30
  p.age                                           //> res2: Int = 30

  val p1 = new Point(x = 3.3, y = 4.4)            //> p1  : proscala.chap02.Point = Point(3.3,4.4)
  val p2 = p1.copy(y = 6.6)                       //> p2  : proscala.chap02.Point = Point(3.3,6.6)

  val s = Circle(Point(0.0, 0.0), 5.0)            //> s  : proscala.chap02.Circle = Circle(Point(0.0,0.0),5.0)
  
  s.draw(Point(0.0, 0.0))(s => println(s"shapes of myheart"))
                                                  //> shapes of myheart

}