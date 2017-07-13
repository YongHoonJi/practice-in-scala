package proscala.chap05

object implicit_phantom_types_pipeline {
	import scala.language.implicitConversions
	
	object Pipelin{
		implicit class toPiped[V](value: V){
			def |>[R](f: V => R) = f(value)
		}
		
		object CalculatePayroll2 {
			def main(args: Array
		}
	}
}
