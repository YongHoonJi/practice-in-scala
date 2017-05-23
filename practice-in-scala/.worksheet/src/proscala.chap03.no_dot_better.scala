package proscala.chap03

object no_dot_better {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
	def isEven(n: Int) = ( n % 2 ) == 0;System.out.println("""isEven: (n: Int)Boolean""");$skip(45); 
	List(1,2,3,4) filter isEven foreach println;$skip(92); 
                                                  
	// cons
	val list = List('a', 'b', 'c');System.out.println("""list  : List[Char] = """ + $show(list ));$skip(30); val res$0 = 
	// 리스트 맨 왼쪽에 추가
	'a' :: list;System.out.println("""res0: List[Char] = """ + $show(res$0))}
}
