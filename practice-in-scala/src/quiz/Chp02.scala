package quiz

object chp02 extends App {
  
  // 2.1 fibonacci
	def fib(n: Int): Int = {
			@annotation.tailrec
	    def loop(n: Int, prev: Int, cur: Int): Int = {
			  if(n == 0) prev
			  else loop(n-1, cur, prev + cur)
	    }
			
	    loop(n, 0, 1)
	}
	
	println(fib(10));
	
	
	// 2.2 isSorted
	val orderedNumbers = Array(1, 2, 3, 4);
	val notOrderedNumbers = Array(1, 2, 4, 3); 
	
	def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean = {
	  @annotation.tailrec
	  def loop(n: Int): Boolean = {
	    if(n >= as.length-1) true
	    else if(gt(as(n), as(n+1))) false
	    else loop(n+1)
	  }
	  
	 loop(0)
	}
	
	println(isSorted(orderedNumbers, (a: Int, b: Int) => a > b));
	println(isSorted(notOrderedNumbers, (a: Int, b: Int) => a > b));
  
	
	// 2.3 currying
	def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
	  a => b => f(a,b)
	}
	
	// 2.4 uncurrying
	def uncurry[A,B,C](f :A => B => C): (A, B) => C = {
	  (a, b) => f(a)(b);
	}
	
	// 2.5 compose
	def compose[A,B,C](f : B => C, g: A => B): A => C = {
	  a => f(g(a))
	}
	
	
}