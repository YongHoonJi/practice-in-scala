package proscala.chap03

//page 163 값의 열거는 enum 대신 case클래스를 사
object emumeration {
	object Breed extends Enumeration{
	 type Breed = Value
	 val doberman = Value("Doberman")
	 val yorkie = Value("Yorkie")
	}
	
	import Breed._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(285); 
	for(breed <- Breed.values) println(s"${breed.id}\t$breed");$skip(67); 
	
	Breed.values filter(_.toString.endsWith("kie")) foreach println;$skip(55); 
	
	def isYorkie(b: Breed) = b.toString.endsWith("kie");System.out.println("""isYorkie: (b: proscala.chap03.emumeration.Breed.Breed)Boolean""");$skip(48); 
	
	Breed.values filter isYorkie foreach println}
}
