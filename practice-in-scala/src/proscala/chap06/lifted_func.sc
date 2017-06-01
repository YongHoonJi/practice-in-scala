package proscala.chap06
//p292
// 부분함수와 옵션을 반환하는 함수 lift
object lifted_func {
	val finicky: PartialFunction[String,String] = {
		case "finicky" => "Finicky"
	}                                         //> finicky  : PartialFunction[String,String] = <function1>
	
	finicky("finicky")                        //> res0: String = Finicky
	//finicky("other")    // scala.MatchError: other (of class java.lang.String)
	// lift는 함수를 끌어올리는 개념으로 부분함수에 더 이상 적용할 파라미터가 없는 경우에도 Option을 반환하도록 한다.
	val finickyOption = finicky.lift          //> finickyOption  : String => Option[String] = <function1>
		
	finickyOption("finicky")                  //> res1: Option[String] = Some(Finicky)
	finickyOption("other")                    //> res2: Option[String] = None
	
	val finicky2 = Function.unlift(finickyOption)
                                                  //> finicky2  : PartialFunction[String,String] = <function1>
	
	finicky2("finicky")                       //> res3: String = Finicky
	finicky2("other")                         //> scala.MatchError: other (of class java.lang.String)
                                                  //| 	at scala.PartialFunction$$anon$1.apply(PartialFunction.scala:253)
                                                  //| 	at scala.PartialFunction$$anon$1.apply(PartialFunction.scala:251)
                                                  //| 	at proscala.chap06.lifted_func$$anonfun$main$1$$anonfun$1.applyOrElse(pr
                                                  //| oscala.chap06.lifted_func.scala:5)
                                                  //| 	at proscala.chap06.lifted_func$$anonfun$main$1$$anonfun$1.applyOrElse(pr
                                                  //| oscala.chap06.lifted_func.scala:5)
                                                  //| 	at scala.runtime.AbstractPartialFunction.apply(AbstractPartialFunction.s
                                                  //| cala:36)
                                                  //| 	at proscala.chap06.lifted_func$$anonfun$main$1.apply$mcV$sp(proscala.cha
                                                  //| p06.lifted_func.scala:20)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at proscala.chap06.li
                                                  //| Output exceeds cutoff limit.
	
}