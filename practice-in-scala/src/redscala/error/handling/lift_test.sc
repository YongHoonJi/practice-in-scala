package redscala.error.handling

object lift_test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

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
      a flatMap (aa => b map (bb => f(aa, bb)))   //> map2: [A, B, C](a: redscala.error.handling.Option[A], b: redscala.error.hand
                                                  //| ling.Option[B])(f: (A, B) => C)redscala.error.handling.Option[C]
                                                  
		parseInsuranceRateQuote("2", "3") //> res0: redscala.error.handling.Option[Double] = Some(6.0)
      
}