package proscala.chap14

import com.sun.org.apache.xalan.internal.xsltc.compiler.ForEach

object co_contra_variance {
  // generic
  class Creature {
    def toName() {
      println("creature");
    }
  }

  class Fish extends Creature {
    override def toName() {
      println("fish");
    }
  }

  def fun1(l: List[Creature]) = {
    l.foreach { x => x.toName() }
  }

  val cl = List(new Creature(), new Creature())
  val fl = List(new Fish(), new Fish())

  fun1(cl);

  fun1(fl);
	// generic
  class Stack[T] {
    var elems: List[T] = Nil
    def push(x: T) { elems = x :: elems }
    def top: T = elems.head
    def pop() { elems = elems.tail }
  }

  val stack = new Stack[Int]
  stack.push(1)
  stack.push('a')
  println(stack.top)
  stack.pop()
  println(stack.top)
  
  class CoStack[+T] {
    var elems: List[T] = Nil
    def push(x: T) { elems = x :: elems }
    def top: T = elems.head
    def pop() { elems = elems.tail }
  }
}