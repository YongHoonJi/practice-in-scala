package redscala.error.handling

object lift_test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(111); 
	def lift[A,B](f: A => B): Option[A] => Option[B] = _ map f;System.out.println("""lift: [A, B](f: A => B)redscala.error.handling.Option[A] => redscala.error.handling.Option[B]""");$skip(54); 
	val abs1:Option[Int] => Option[Int] = lift(math.abs);System.out.println("""abs1  : redscala.error.handling.Option[Int] => redscala.error.handling.Option[Int] = """ + $show(abs1 ));$skip(61); 
	val abs0: Option[Double] => Option[Double] = lift(math.abs);System.out.println("""abs0  : redscala.error.handling.Option[Double] => redscala.error.handling.Option[Double] = """ + $show(abs0 ));$skip(14); val res$0 = 
	math.abs(-1);System.out.println("""res0: Int = """ + $show(res$0));$skip(18); val res$1 = 
  abs0(Some(1.0));System.out.println("""res1: redscala.error.handling.Option[Double] = """ + $show(res$1));$skip(23); 
  
  val sx = Some(-1);System.out.println("""sx  : redscala.error.handling.Some[Int] = """ + $show(sx ));$skip(19); val res$2 = 
  sx.map(math.abs);System.out.println("""res2: redscala.error.handling.Option[Int] = """ + $show(res$2));$skip(16); val res$3 = 
	abs1(Some(-1));System.out.println("""res3: redscala.error.handling.Option[Int] = """ + $show(res$3));$skip(105); 
	
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
      a flatMap (aa => b map (bb => f(aa, bb)));System.out.println("""map2: [A, B, C](a: redscala.error.handling.Option[A], b: redscala.error.handling.Option[B])(f: (A, B) => C)redscala.error.handling.Option[C]""");$skip(87); val res$4 = 
                                                  
		parseInsuranceRateQuote("2", "3");System.out.println("""res4: redscala.error.handling.Option[Double] = """ + $show(res$4))}
      
}
