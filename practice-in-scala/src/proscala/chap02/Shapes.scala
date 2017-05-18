package proscala.chap02

abstract class Shapes {
  def draw(offset: Point = Point(0.0, 0.0))(f: String => Unit): Unit = {
    f(s"draw(offset = $offset),${this.toString}")
  }
}

case class Circle(center: Point, radius: Double) extends Shapes

case class Rentagle(lowerLeft: Point, height: Double, width: Double) extends Shapes