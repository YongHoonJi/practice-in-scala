package proscala.chap02

case class Point(x: Double = 0.0, y: Double = 0.0) {
  def shift(deltax: Double = 0, deltay: Double = 0.0) = {
    // 케이스 클래스의 기존 인스턴스를 복사하면서 인자로 필드를 변
    copy(x + deltax, y + deltay)
  }
}

  