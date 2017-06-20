package proscala.chap14

object convariance {

class Parent(val value: Int) {
		override def toString = s"${this.getClass.getName}${value}"
	}
	
	class Child(value: Int) extends Parent(value)
	
}
