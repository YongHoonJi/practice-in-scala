package proscala.chap04

object match_boolean {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
	val bools = Seq(true, false);System.out.println("""bools  : Seq[Boolean] = """ + $show(bools ));$skip(112); 
	
	for(b <- bools) {
		b match {
			case true => println("got heads")
			case false => println("got tails")
		}
	};$skip(371); 
	
	
	// 컴파일러가 모든 case절이 반환하는 값에서 가장 가까운 수퍼타입을 추론(최소상위바운드(least upper bound))한다.
	// 여기서 x는 모든 case의 상위타입인 Any이다.
	for{
		x <- Seq(1,2,2.7,"one","two",'four)
	} {
		val str = x match {
			case 1 => "int 1"
			case _:Int => x
			case _:Double => x
			case "one" => "string one"
			case _:String => "other sting:"+x
			case _ => "unexpected:"+ x
		}
		
		println(str)
	};$skip(168); 
	
	def checkY(y: Int) = {
		for{
			x <- Seq(99, 100, 101)
		} {
			val str = x match {
				case y => "found y! : " + y
				case i:Int => i
			}
			println(str)
		}
	};System.out.println("""checkY: (y: Int)Unit""");$skip(13); 
	checkY(100);$skip(244); 
 	for{
 		x <- Seq(1,2,2.7,"one","two",'four)
 	}{
 		val str = x match{
 			case _:Int | _:Double => "a number:"+x
 			case "one" => "string one"
 			case _:String => "other string:"+x
 			case _ => "unexpected : "+ x
 		}
 		println(str)
 	}}
	
}
