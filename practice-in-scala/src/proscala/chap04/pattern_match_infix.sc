package proscala.chap04

//p196
object pattern_match_infix {
	case class With[A,B](a: A, b: B)
	val with1: With[String,Int] = With("Foo",1)
                                                  //> with1  : proscala.chap04.pattern_match_infix.With[String,Int] = With(Foo,1)
	val with2: With[String,Int] = With("Bar",2)
                                                  //> with2  : proscala.chap04.pattern_match_infix.With[String,Int] = With(Bar,2)
	
	Seq(with1, with2) foreach { w =>
		w match {
			case s With i => println(s"$s with $i")
			//case With(s, i) => println(s"$s with $i") 동일한 타입 시그니쳐
			case _ => println(s"Unknown: $w")
		}                                 //> Foo with 1
                                                  //| Bar with 2
	}
}