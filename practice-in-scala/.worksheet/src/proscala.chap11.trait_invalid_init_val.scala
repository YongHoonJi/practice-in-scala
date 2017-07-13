package proscala.chap11

//p462
object trait_invalid_init_val {
	trait AbstractT2{
		println("In AbstractT2:")
		val value: Int
		val inverse = 1.0 / value // inverse값이 평가되기전에 계산됨.
		println("AbstractT2: value = "+value+", inverse = "+inverse)
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(316); 
	
	val obj = new AbstractT2{
		println("In obj:")
		val value = 10
	};System.out.println("""obj  : proscala.chap11.trait_invalid_init_val.AbstractT2 = """ + $show(obj ));$skip(66); 
	
	
	println("obj.value = "+obj.value+", inverse = "+obj.inverse)
                                                  
	/* 초기화 값에 대한 지연평가 */
	trait AbstractT3{
		println("In AbstractT3:")
		val value: Int
		lazy val inverse = 1.0 / value // 지연 평가로 인해 평가시 초기화가 이루어짐.
	};$skip(272); 
	
	val obj2 = new AbstractT3{
		println("In obj:")
		val value = 10
	};System.out.println("""obj2  : proscala.chap11.trait_invalid_init_val.AbstractT3 = """ + $show(obj2 ));$skip(65); 
	println("obj.value = "+obj2.value+", inverse = "+ obj2.inverse);$skip(123); 
                                                  
	/* 초기화 필드를 활용 */
	val obj3 = new {
		val value = 10
	} with AbstractT2;System.out.println("""obj3  : proscala.chap11.trait_invalid_init_val.AbstractT2 = """ + $show(obj3 ));$skip(67); 
	
	println("obj.value = "+obj3.value+", inverse = "+ obj3.inverse)}
}
