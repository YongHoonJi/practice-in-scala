package proscala.chap06
// p271
object factorial {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(215); 
	def factorial(i: Int): Long = {
		def fact(i: Int, accumulator: Int): Long = {
			if(i <= 1) accumulator
			else fact(i -1, i * accumulator)
		}
		
		fact(i, 1)
	};System.out.println("""factorial: (i: Int)Long""");$skip(49); 
	
	(0 to 5) foreach( i => println(factorial(i)))}
}
