package proscala.chap03

object basic_for {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
	val alpha = List("a", "b", "C");System.out.println("""alpha  : List[String] = """ + $show(alpha ));$skip(30); 
	for(a <- alpha)
		println(a);$skip(77); 
 	for( a <- alpha)
 		if(a.contains("a") && a.startsWith("a"))
 		println(a);$skip(34); 
 		
	for(i <- 1 to 10) println(i)}
}
