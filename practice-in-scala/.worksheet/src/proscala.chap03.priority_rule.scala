package proscala.chap03

// 연산자 우선순위 -> 높음
// 모든글자 -> | -> ^ -> & -> <> -> =! -> : -> +- -> * / %
// = 는 우선순위가 가장 낮다
object priority_rule {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(162); val res$0 = 
	2.0 * 4.0 / 3.0 * 5.0;System.out.println("""res0: Double = """ + $show(res$0));$skip(29); val res$1 = 
	(((2.0 * 4.0) / 3.0) * 5.0);System.out.println("""res1: Double = """ + $show(res$1));$skip(171); 
	
	// left-associative (왼쪽 결합 연산자) 는 왼쪽에서 오른쪽 순서로 묶인다.
	// 이름이 콜론( : )으로 끝나는 메서드는 항상 오른쪽으로 묶인다.
	// 이를 constructor를 줄여 cons라고 불린다. Lisp에서 유래
	val list = List('1','2','3');System.out.println("""list  : List[Char] = """ + $show(list ));$skip(13); val res$2 = 
	'0' :: list;System.out.println("""res2: List[Char] = """ + $show(res$2));$skip(14); val res$3 = 
	list.::('0');System.out.println("""res3: List[Char] = """ + $show(res$3))}
}
