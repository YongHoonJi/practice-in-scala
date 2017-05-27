package proscala.chap04


// p201
// 가변인자 목록과 일치시키기
// SQL 의 where 절에 대한 표
object Op extends Enumeration {
		type Op = Value;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(146); 
		val EQ = Value("=");System.out.println("""EQ  : proscala.chap04.Op.Value = """ + $show(EQ ));$skip(23); 
		val NE = Value("!=");System.out.println("""NE  : proscala.chap04.Op.Value = """ + $show(NE ));$skip(25); 
		val LTGT = Value("<>");System.out.println("""LTGT  : proscala.chap04.Op.Value = """ + $show(LTGT ));$skip(22); 
		val LT = Value("<");System.out.println("""LT  : proscala.chap04.Op.Value = """ + $show(LT ));$skip(23); 
		val LE = Value("<=");System.out.println("""LE  : proscala.chap04.Op.Value = """ + $show(LE ));$skip(22); 
		val GT = Value(">");System.out.println("""GT  : proscala.chap04.Op.Value = """ + $show(GT ));$skip(23); 
		val GE = Value(">=");System.out.println("""GE  : proscala.chap04.Op.Value = """ + $show(GE ))}
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
