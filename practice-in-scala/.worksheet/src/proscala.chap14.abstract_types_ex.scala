package proscala.chap14

//p536  추상타입
object abstract_types_ex {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("")}
  
  trait exampleTrait {
    type t1
    type t2 >: t3 <: t1 // t2는 t3의 수펴타입이면서 t1의 서브타입이어야함
    type t3 <: t1 // t3는 t1의 서브타입이어야 함
    type t4 <: Seq[t1] // t4는 Seq[t1]의 서브타입이어야

    val v1: t1
    val v2: t2
    val v3: t3
    val v4: t4
  }

  trait T1 { val name1: String }
  trait T2 extends T1 { val name2: String }
  case class C(name1: String, name2: String) extends T2
  
  object example extends exampleTrait {
  	type t1 = T1
  	type t2 = T2
  	type t3 = C
  	type t4 = Vector[T1]
  	
  	val v1 = new T1 { val name = "T1" }
  	val v2 = new T2 { val name = "T1"; val name2 = "T2" }
  	val v3 = C("1", "2")
  	val v4 = Vector(C("3", "4"))
  }
}
