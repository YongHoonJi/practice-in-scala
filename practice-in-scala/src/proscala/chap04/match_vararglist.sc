package proscala.chap04


// p201
// 가변인자 목록과 일치시키기
// SQL 의 where 절에 대한 표
object Op extends Enumeration {
		type Op = Value
		val EQ = Value("=")
		val NE = Value("!=")
		val LTGT = Value("<>")
		val LT = Value("<")
		val LE = Value("<=")
		val GT = Value(">")
		val GE = Value(">=")
}
		
object match_vararglist {
		import Op._
		
		// 'Where x op value' 를 표현
		case class WhereOp[T](columnName: String, op: Op, value: T)
		case class WhereIn[T](columnName: String, val1: T, vals: T*)
		
		val wheres = Seq(
			WhereIn("state","IL","CA","VA"),
			WhereOp("state",EQ, "IL"),
			WhereOp("name",EQ, "Buck Trends"),
			WhereOp("age",GT, 29)
			)
			
			for(where <- wheres) {
				where match {
					case WhereIn(col, val1, vals @_*) =>
						val valStr = (val1 +: vals).mkString(", ")
						println(s"where #col In ($valStr)")
					case WhereOp(col, op, value) => println(s"where $col $op $value")
					case _ => println(s"error: unknown expression: $where")
				}
			}
}