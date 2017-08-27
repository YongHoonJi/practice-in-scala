package redscala.error.handling

object lift_test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(95); 
  println("Welcome to the Scala worksheet");$skip(104); 

  def Try[A](a: => A): Option[A] = {
      try Some(a)
      catch { case e: Exception => None }
    };System.out.println("""Try: [A](a: => A)redscala.error.handling.Option[A]""");$skip(89); 
    
    def calculateInsuranceRateQuote(age: Int, tickets: Int): Double = age * tickets;System.out.println("""calculateInsuranceRateQuote: (age: Int, tickets: Int)Double""");$skip(303); 

    def parseInsuranceRateQuote(
      age: String,
      numberOfSpeedingTickets: String): Option[Double] = {
      val optAge: Option[Int] = Try(age.toInt)
      val optTickets: Option[Int] = Try(numberOfSpeedingTickets.toInt)
      map2_compre(optAge, optTickets)(calculateInsuranceRateQuote)
    };System.out.println("""parseInsuranceRateQuote: (age: String, numberOfSpeedingTickets: String)redscala.error.handling.Option[Double]""");$skip(143); 
    
		def map2_compre[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
			for {
				aa <- a
				bb <- b
			} yield f(aa, bb);System.out.println("""map2_compre: [A, B, C](a: redscala.error.handling.Option[A], b: redscala.error.handling.Option[B])(f: (A, B) => C)redscala.error.handling.Option[C]""");$skip(172); 
			
		// 두 option 값 중 하나라도 None이면 결과 역시 None
    def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
      a flatMap (aa => b map (bb => f(aa, bb)));System.out.println("""map2: [A, B, C](a: redscala.error.handling.Option[A], b: redscala.error.handling.Option[B])(f: (A, B) => C)redscala.error.handling.Option[C]""");$skip(87); val res$0 = 
                                                  
		parseInsuranceRateQuote("2", "3");System.out.println("""res0: redscala.error.handling.Option[Double] = """ + $show(res$0))}
      
}
