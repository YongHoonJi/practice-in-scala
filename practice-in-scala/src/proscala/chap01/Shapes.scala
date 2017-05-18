package proscala.chap01

object ShapeTest extends App {
  // case 는 equals, hashcode등의 메서드를 자동 구현하며 싱글턴 객체인 동반 객체를 자동으로 만들어낸다
  // 동반객체는 싱글턴 객체이며 new 키워드 없이 객체 생성이 가능하다.
  case class Point(x: Double = 0.0, y: Double = 0.0)

  abstract class Shapes {
    def draw(f: String => Unit): Unit = f(s"draw: ${this.toString}")
  }

  case class Circle(center: Point, radius: Double) extends Shapes

  case class Rectangle(lowerLeft: Point, height: Double, width: Double) extends Shapes

  case class Triangle(point1: Point, point2: Point, point3: Point) extends Shapes

  val p00 = new Point

  val p20 = new Point(2.0)

  val p20b = new Point(2.0)

  val p02 = new Point(y = 2.0)

  println(p00 == p20)

  println(p20 == p20b)

  // 동반객체는 싱글턴 객체이며 new 키워드 없이 객체 생성이 가능하다.
  val c00 = Point.apply(1.0, 2.0)
  println(c00.toString())
  
  val circle = Circle(Point(1.0,2.0), 4.0)
  
  println(circle.draw(s => ()))

}