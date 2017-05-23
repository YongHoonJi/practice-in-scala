package proscala.chap03

object no_dot_better {
	def isEven(n: Int) = ( n % 2 ) == 0       //> isEven: (n: Int)Boolean
	List(1,2,3,4) filter isEven foreach println
                                                  //> 2
                                                  //| 4
                                                  
	// cons
	val list = List('a', 'b', 'c')            //> list  : List[Char] = List(a, b, c)
	// 리스트 맨 왼쪽에 추가
	'a' :: list                               //> res0: List[Char] = List(a, a, b, c)
}