package proscala.chap03

object yieldFor {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(81); 
	val alpha = List("abc", "bcd", "efg");System.out.println("""alpha  : List[String] = """ + $show(alpha ));$skip(98); 
	// for의 결과를 모아서 담아두는 yield
	val filtered = for{
		a <- alpha
		if a.contains("a")
	} yield alpha;System.out.println("""filtered  : List[List[String]] = """ + $show(filtered ));$skip(34); 

	for( e <- filtered ) println(e);$skip(69); 
	
	for{
		a <- alpha
		upcased = a.toUpperCase()
	} println(upcased);$skip(71); 
	val optionalAlpha = List(Some("abc"), None, Some("bcd"), Some("cde"));System.out.println("""optionalAlpha  : List[Option[String]] = """ + $show(optionalAlpha ));$skip(55); 
	// None에 대한 검사를 for에서 내부적으로 처
	println("first pass:");$skip(67); 
	for {
		aOptional <- optionalAlpha
		a <- aOptional
	} println(a)}
                                                  
	
	
	
}
