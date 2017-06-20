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
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(372); 

  def fun1(l: List[Creature]) = {
    l.foreach { x => x.toName() }
  };System.out.println("""fun1: (l: List[proscala.chap14.co_contra_variance.Creature])Unit""");$skip(49); 

  val cl = List(new Creature(), new Creature());System.out.println("""cl  : List[proscala.chap14.co_contra_variance.Creature] = """ + $show(cl ));$skip(40); 
  val fl = List(new Fish(), new Fish());System.out.println("""fl  : List[proscala.chap14.co_contra_variance.Fish] = """ + $show(fl ));$skip(13); 

  fun1(cl);$skip(13); ;

  fun1(fl);
	// generic
  class Stack[T] {
    var elems: List[T] = Nil
    def push(x: T) { elems = x :: elems }
    def top: T = elems.head
    def pop() { elems = elems.tail }
  };$skip(201); 

  val stack = new Stack[Int];System.out.println("""stack  : proscala.chap14.co_contra_variance.Stack[Int] = """ + $show(stack ));$skip(16); 
  stack.push(1);$skip(18); 
  stack.push('a');$skip(21); 
  println(stack.top);$skip(14); 
  stack.pop();$skip(21); 
  println(stack.top)}
  
  class CoStack[+T] {
    var elems: List[T] = Nil
    def push(x: T) { elems = x :: elems }
    def top: T = elems.head
    def pop() { elems = elems.tail }
  }
}
