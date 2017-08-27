package quiz

object chap02 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet");$skip(81); 
  
  
  def partial1[A,B,C](a: A, f: (A,B) => C): B => C =
    (b: B) => f(a, b);System.out.println("""partial1: [A, B, C](a: A, f: (A, B) => C)B => C""");$skip(79); 
    
  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b);System.out.println("""curry: [A, B, C](f: (A, B) => C)A => (B => C)""")}
  
}
