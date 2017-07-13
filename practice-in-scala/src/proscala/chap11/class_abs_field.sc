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
	}
	
	val c = new ClassWithAbstractC1()         //> c  : proscala.chap11.class_abs_field.ClassWithAbstractC1 = proscala.chap11.c
                                                  //| lass_abs_field$ClassWithAbstractC1@3581c5f3
	println(c.name)                           //> ClassWithAbstractC1
	println(c.count)                          //> 1
}