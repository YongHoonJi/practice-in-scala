package proscala.chap11

//p470
object class_abs_field {
	abstract class AbstractC1{
	val name: String
	var count: Int
	}
	
	// 추상 클래스의 추상 필드를 구현하므로 override 키워드가 필요없다.
	class ClassWithAbstractC1 extends AbstractC1 {
		val name = "ClassWithAbstractC1"
		var count = 1
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(307); 
	
	val c = new ClassWithAbstractC1();System.out.println("""c  : proscala.chap11.class_abs_field.ClassWithAbstractC1 = """ + $show(c ));$skip(17); 
	println(c.name);$skip(18); 
	println(c.count)}
}
