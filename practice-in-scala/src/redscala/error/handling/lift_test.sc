package redscala.error.handling

object lift_test {
	def lift[A,B](f: A => B): Option[A] => Option[B] = _ map f
                                                  //> lift: [A, B](f: A => B)redscala.error.handling.Option[A] => redscala.error.h
                                                  //| andling.Option[B]
	val abs1:Option[Int] => Option[Int] = lift(math.abs)
                                                  //> abs1  : redscala.error.handling.Option[Int] => redscala.error.handling.Optio
                                                  //| n[Int] = <function1>
	val abs0: Option[Double] => Option[Double] = lift(math.abs)
                                                  //> abs0  : redscala.error.handling.Option[Double] => redscala.error.handling.Op
                                                  //| tion[Double] = <function1>
	math.abs(-1)                              //> res0: Int = 1
  abs0(Some(1.0))                                 //> res1: redscala.error.handling.Option[Double] = Some(1.0)
  
  val sx = Some(-1)                               //> sx  : redscala.error.handling.Some[Int] = Some(-1)
  sx.map(math.abs)                                //> res2: redscala.error.handling.Option[Int] = Some(1)
	abs1(Some(-1))                            //> res3: redscala.error.handling.Option[Int] = Some(1)
	
  def Try[A](a: => A): Option[A] = {
      try Some(a)
      catch { case e: Exception => None }
    }                                             //> Try: [A](a: => A)redscala.error.handling.Option[A]
    
    def calculateInsuranceRateQuote(age: Int, tickets: Int): Double = age * tickets
                                                  //> calculateInsuranceRateQuote: (age: Int, tickets: Int)Double

    def parseInsuranceRateQuote(
      age: String,
      numberOfSpeedingTickets: String): Option[Double] = {
      val optAge: Option[Int] = Try(age.toInt)
      val optTickets: Option[Int] = Try(numberOfSpeedingTickets.toInt)
      map2_compre(optAge, optTickets)(calculateInsuranceRateQuote)
    }                                             //> parseInsuranceRateQuote: (age: String, numberOfSpeedingTickets: String)redsc
                                                  //| ala.error.handling.Option[Double]
    
		def map2_compre[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
			for {
				aa <- a
				bb <- b
			} yield f(aa, bb)         //> map2_compre: [A, B, C](a: redscala.error.handling.Option[A], b: redscala.err
                                                  //| or.handling.Option[B])(f: (A, B) => C)redscala.error.handling.Option[C]
			
		// 두 option 값 중 하나라도 None이면 결과 역시 None
    def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
      a flatMap (aa => b map (bb => f(aa, bb)))   //> map2: [A, B, C](a: redscala.error.handling.Option[A], b: redscala.error.han
                                                  //| dling.Option[B])(f: (A, B) => C)redscala.error.handling.Option[C]
                                                  
		parseInsuranceRateQuote("2", "3") //> res4: redscala.error.handling.Option[Double] = Some(6.0)
      
}