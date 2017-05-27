package proscala.chap04
//패턴 매칭은 데이터 구조로 부터 데이터를 뽑아내는 유연하고 간결한 기법이다.
object match_boolean {
	val bools = Seq(true, false)              //> bools  : Seq[Boolean] = List(true, false)
	
	for(b <- bools) {
		b match {
			case true => println("got heads")
			case false => println("got tails")
		}                                 //> got heads
                                                  //| got tails
	}
	
	
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
	}                                         //> int 1
                                                  //| 2
                                                  //| 2.7
                                                  //| string one
                                                  //| other sting:two
                                                  //| unexpected:'four
	
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
	}                                         //> checkY: (y: Int)Unit
	checkY(100)                               //> found y! : 99
                                                  //| found y! : 100
                                                  //| found y! : 101
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
 	}                                         //> a number:1
                                                  //| a number:2
                                                  //| a number:2.7
                                                  //| string one
                                                  //| other string:two
                                                  //| unexpected : 'four
	
}