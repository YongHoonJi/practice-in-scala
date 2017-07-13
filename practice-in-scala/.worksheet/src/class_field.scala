object class_field {
	class C1 {
		val name = "C1"
		var count = 0
	}
	
	class ClassWithC1 extends C1 {
		override val name = "ClassWithC1"
		count = 1 // val에 대해서는 override가 필요하지만 var은 오버라이드가 필요없다.
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(230); 
	
	val c = new ClassWithC1();System.out.println("""c  : class_field.ClassWithC1 = """ + $show(c ));$skip(19); 
	
	println(c.name);$skip(18); 
	println(c.count)}
}
