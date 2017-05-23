package proscala.chap03

// 연산자 우선순위 -> 높음
// 모든글자 -> | -> ^ -> & -> <> -> =! -> : -> +- -> * / %
// = 는 우선순위가 가장 낮다
object priority_rule {
	2.0 * 4.0 / 3.0 * 5.0                     //> res0: Double = 13.333333333333332
	(((2.0 * 4.0) / 3.0) * 5.0)               //> res1: Double = 13.333333333333332
	
	// left-associative (왼쪽 결합 연산자) 는 왼쪽에서 오른쪽 순서로 묶인다.
	// 이름이 콜론( : )으로 끝나는 메서드는 항상 오른쪽으로 묶인다.
	// 이를 constructor를 줄여 cons라고 불린다. Lisp에서 유래
	val list = List('1','2','3')              //> list  : List[Char] = List(1, 2, 3)
	'0' :: list                               //> res2: List[Char] = List(0, 1, 2, 3)
	list.::('0')                              //> res3: List[Char] = List(0, 1, 2, 3)
}