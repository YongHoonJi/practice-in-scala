package proscala.chap03

//page 163 값의 열거는 enum 대신 case클래스를 사
object emumeration {
	object Breed extends Enumeration{
	 type Breed = Value
	 val doberman = Value("Doberman")
	 val yorkie = Value("Yorkie")
	}
	
	import Breed._
	for(breed <- Breed.values) println(s"${breed.id}\t$breed")
                                                  //> 0	Doberman
                                                  //| 1	Yorkie
	
	Breed.values filter(_.toString.endsWith("kie")) foreach println
                                                  //> Yorkie
	
	def isYorkie(b: Breed) = b.toString.endsWith("kie")
                                                  //> isYorkie: (b: proscala.chap03.emumeration.Breed.Breed)Boolean
	
	Breed.values filter isYorkie foreach println
                                                  //> Yorkie
}