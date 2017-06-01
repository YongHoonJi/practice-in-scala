package proscala.chap06

//p286
object curried_func {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(150); 
	// 커링은 여러 인자를 취하는 함수를 단하나의 인자를 취하는 여러함수의 연쇄로 바꿔준다.
  def cat1(s1: String)(s2: String) = s1 + s2;System.out.println("""cat1: (s1: String)(s2: String)String""");$skip(64); 
  // 커링의 다른 표현
 	def cat2(s1: String) = (s2: String) => s1 + s2;System.out.println("""cat2: (s1: String)String => String""");$skip(34); 
  
  val hello = cat1("Hello ") _;System.out.println("""hello  : String => String = """ + $show(hello ));$skip(17); val res$0 = 
  hello("world");System.out.println("""res0: String = """ + $show(res$0));$skip(26); val res$1 = 

  cat1("Hello")("world");System.out.println("""res1: String = """ + $show(res$1));$skip(36); 
  
  val cat2Hello = cat2("Hello ");System.out.println("""cat2Hello  : String => String = """ + $show(cat2Hello ));$skip(22); val res$2 = 
  cat2Hello("world!");System.out.println("""res2: String = """ + $show(res$2));$skip(45); 

	def cat3(s1: String, s2: String) = s1 + s2;System.out.println("""cat3: (s1: String, s2: String)String""");$skip(24); val res$3 = 
	cat3("hello", "world");System.out.println("""res3: String = """ + $show(res$3));$skip(57); 
	
	// cat3 함수를 커링 처리
	val cat3Curried = (cat3 _).curried;System.out.println("""cat3Curried  : String => (String => String) = """ + $show(cat3Curried ));$skip(31); val res$4 = 
	cat3Curried("hello")("world");System.out.println("""res4: String = """ + $show(res$4));$skip(138); 

	//부분함수는 함수의 인자 목록을 일부 적용하지만, 전부 적용하지 않은 식을 말함.
  val inverse: PartialFunction[Double, Double] = {
    case d if d != 0.0 => 1.0 / d
  };System.out.println("""inverse  : PartialFunction[Double,Double] = """ + $show(inverse ));$skip(16); val res$5 = 

  inverse(1.0);System.out.println("""res5: Double = """ + $show(res$5));$skip(15); val res$6 = 
  inverse(2.0);System.out.println("""res6: Double = """ + $show(res$6))}
  //inverse(0.0)

}
