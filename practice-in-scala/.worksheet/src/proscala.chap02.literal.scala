package proscala.chap02

object literal {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(135); 
	// function literal. a, b는 Int, String에 대한 추
	val f1:(Int, String) => String = (a, b) => a+b;System.out.println("""f1  : (Int#1131, String#1947588) => String#1947588 = """ + $show(f1 ));$skip(57); 
	
	val f2:Function2[Int, String, String] = (i, s) => s+i;System.out.println("""f2  : (Int#1131, String#1947588) => String#1947588 = """ + $show(f2 ));$skip(144); 
                                                  
	//tuple literal. 튜플은 1급 계층값으로 immutable 하다.
	//tuple의 인덱스는 1부터 시
	val t = ("hello", 1, 2.3);System.out.println("""t  : (String#254, Int#1131, Double#1647) = """ + $show(t ));$skip(12); 
	println(t);$skip(15); 
	println(t._1);$skip(15); 
	println(t._2);$skip(15); 
	println(t._3);$skip(43); 
	
	val (t1, t2, t3) = ("world", '!', 0x22);System.out.println("""t1  : String#254 = """ + $show(t1 ));System.out.println("""t2  : Char#1791 = """ + $show(t2 ));System.out.println("""t3  : Int#1131 = """ + $show(t3 ));$skip(48); 

	val (t4, t5, t6) = Tuple3("world", '!', 0x22);System.out.println("""t4  : String#254 = """ + $show(t4 ));System.out.println("""t5  : Char#1791 = """ + $show(t5 ));System.out.println("""t6  : Int#1131 = """ + $show(t6 ));$skip(191); 
                                                  
	//option, some, null
	// Map(key -> val, key -> val)
	val stateCapitals = Map("Korea" -> "seoul", "Italia" -> "Roma", "Spain" -> "Madrid");System.out.println("""stateCapitals  : scala#27.collection#2782.immutable#5867.Map#7906[String#254,String#254] = """ + $show(stateCapitals ));$skip(46); 
	println("Korea:"+stateCapitals.get("Seoul"));$skip(48); 
	println("Italia:"+stateCapitals.get("Italia"));$skip(50); 
	println("Unknown:"+stateCapitals.get("Unknown"));$skip(75); 
	println("Unknown:"+stateCapitals.get("Unknown").getOrElse("Not Country"))}
                                                  
}
