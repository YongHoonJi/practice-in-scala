package proscala.chap06

object curried_func2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(127); 
	val f1: String => String => String =
		(s1: String) => (s2: String) => s1 + s2;System.out.println("""f1  : String => (String => String) = """ + $show(f1 ));$skip(85); 
		
	val f2: String => (String => String) =
		(s1: String) => (s2: String) => s1 + s2;System.out.println("""f2  : String => (String => String) = """ + $show(f2 ));$skip(23); val res$0 = 
	f1("hello ")("world");System.out.println("""res0: String = """ + $show(res$0));$skip(23); val res$1 = 
	f2("hello ")("world");System.out.println("""res1: String = """ + $show(res$1));$skip(61); 
	
	// uncurrying
	def cat3(s1: String, s2: String) = s1 + s2;System.out.println("""cat3: (s1: String, s2: String)String""");$skip(36); 
	val cat3Curried = (cat3 _).curried;System.out.println("""cat3Curried  : String => (String => String) = """ + $show(cat3Curried ));$skip(31); val res$2 = 
	cat3Curried("hello")("world");System.out.println("""res2: String = """ + $show(res$2));$skip(53); 
	val cat3Uncurried = Function.uncurried(cat3Curried);System.out.println("""cat3Uncurried  : (String, String) => String = """ + $show(cat3Uncurried ));$skip(33); val res$3 = 
	cat3Uncurried("hello", "world");System.out.println("""res3: String = """ + $show(res$3));$skip(36); 
	
	val ff1 = Function.uncurried(f1);System.out.println("""ff1  : (String, String) => String = """ + $show(ff1 ));$skip(24); val res$4 = 
	
	ff1("hello","world");System.out.println("""res4: String = """ + $show(res$4));$skip(106); 
	
	
	// 커링의 실용적인 사용은 함수를 특정 데이터에 대해 특화시크는 것이다. 다음 예를 보자
	def multiplier(i: Int)(factor: Int) = i * factor;System.out.println("""multiplier: (i: Int)(factor: Int)Int""");$skip(30); 
	val byFive = multiplier(5) _;System.out.println("""byFive  : Int => Int = """ + $show(byFive ));$skip(30); 
	val byTen = multiplier(10) _;System.out.println("""byTen  : Int => Int = """ + $show(byTen ));$skip(11); val res$5 = 
	byFive(2);System.out.println("""res5: Int = """ + $show(res$5));$skip(10); val res$6 = 
	byTen(2);System.out.println("""res6: Int = """ + $show(res$6));$skip(125); 
	
	
	// 커링과 부분함수는 크게 구분없이 쓰인다. 중한 것은 어떻게 응용하는 것인가 이다.
	// 튜플에 대한 응용을 보자
	def mult(d1:Double, d2:Double,d3:Double) = d1*d2*d3;System.out.println("""mult: (d1: Double, d2: Double, d3: Double)Double""");$skip(24); 
	val d3 = (2.2,3.3,4.4);System.out.println("""d3  : (Double, Double, Double) = """ + $show(d3 ));$skip(29); val res$7 = 
	
	mult(d3._1, d3._2, d3._3);System.out.println("""res7: Double = """ + $show(res$7));$skip(75); 
	
	// 아래는 3원소 튜플을 단일인자로 받는 경우이다.
	val multTupled = Function.tupled(mult _);System.out.println("""multTupled  : ((Double, Double, Double)) => Double = """ + $show(multTupled ));$skip(16); val res$8 = 
	multTupled(d3);System.out.println("""res8: Double = """ + $show(res$8))}
}
