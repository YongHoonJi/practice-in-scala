package proscala.chap04

//p196
object pattern_match_infix {
	case class With[A,B](a: A, b: B);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(139); 
	val with1: With[String,Int] = With("Foo",1);System.out.println("""with1  : proscala.chap04.pattern_match_infix.With[String,Int] = """ + $show(with1 ));$skip(45); 
	val with2: With[String,Int] = With("Bar",2);System.out.println("""with2  : proscala.chap04.pattern_match_infix.With[String,Int] = """ + $show(with2 ));$skip(191); 
	
	Seq(with1, with2) foreach { w =>
		w match {
			case s With i => println(s"$s with $i")
			//case With(s, i) => println(s"$s with $i") 동일한 타입 시그니쳐
			case _ => println(s"Unknown: $w")
		}}
	}
}
