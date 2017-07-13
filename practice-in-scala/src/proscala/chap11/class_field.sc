object class_field {
	class C1 {
		val name = "C1"
		var count = 0
	}
	
	class ClassWithC1 extends C1 {
		override val name = "ClassWithC1"
		count = 1 // val에 대해서는 override가 필요하지만 var은 오버라이드가 필요없다.
	}
	
	val c = new ClassWithC1()                 //> c  : class_field.ClassWithC1 = class_field$ClassWithC1@3581c5f3
	
	println(c.name)                           //> ClassWithC1
	println(c.count)                          //> 1
}