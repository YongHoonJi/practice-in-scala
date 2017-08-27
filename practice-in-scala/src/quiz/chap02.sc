package quiz

object chap02 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  def partial1[A,B,C](a: A, f: (A,B) => C): B => C =
    (b: B) => f(a, b)                             //> partial1: [A, B, C](a: A, f: (A, B) => C)B => C
    
  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b)                             //> curry: [A, B, C](f: (A, B) => C)A => (B => C)
  
}

