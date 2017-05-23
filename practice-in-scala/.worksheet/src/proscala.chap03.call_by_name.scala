package proscala.chap03

//page 160
object call_by_name{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(202); 
	//@annotation.tailrec
	def countinue(conditional: => Boolean)(body: => Unit){
		if(conditional) {
			body
			countinue(conditional)(body)
		}
	};System.out.println("""countinue: (conditional: => Boolean)(body: => Unit)Unit""");$skip(71); 
	
	def c( i:Int): Boolean = {
		println("condition")
		return i < 5
	};System.out.println("""c: (i: Int)Boolean""");$skip(20); 
	
	
	var count = 0;System.out.println("""count  : Int = """ + $show(count ));$skip(57); ;
	countinue(count < 3){
		println(count);
		count += 1
	}}
}
