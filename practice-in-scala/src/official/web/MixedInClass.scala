package official.web

// 두개 이상의 클래스를 합성하여 사용
abstract class AbsIterator {
  type T
  def hasNext: Boolean
  def next: T
}

// 믹스드인 시킬 클래스는 trait로 정
trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit) {
    while(hasNext) f(next)
  }
};
/*
 * def : defines a method
 * val : defines a fixed value (which cannot be modified)
 * var : defines a variable (which can be modified)
 */
class StringIterator(s: String) extends AbsIterator {
  type T = Char;
  private var i = 0;
  def hasNext = i < s.length();
  def next = { val ch = s charAt i; i += 1; ch} 
};

object StringIteratorTest {
  def main(args: Array[String]) {
    class Iter extends StringIterator("mixed In") with RichIterator
    val iter = new Iter;
    iter foreach println
  }
};

