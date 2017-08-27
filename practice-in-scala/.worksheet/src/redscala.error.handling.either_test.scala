package redscala.error.handling

object either_test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(198); 
	def mean(xs: IndexedSeq[Int]): Either[String, Double] = {
		if(xs.isEmpty)
			Left("mean of empty list")
		else
			Right(xs.sum / xs.length)
	};System.out.println("""mean: (xs: IndexedSeq[Int])redscala.error.handling.Either[String,Double]""");$skip(36); 
	
	val nums = IndexedSeq(1,2,3,4,5);System.out.println("""nums  : IndexedSeq[Int] = """ + $show(nums ));$skip(12); val res$0 = 
	mean(nums);System.out.println("""res0: redscala.error.handling.Either[String,Double] = """ + $show(res$0));$skip(32); 
	
	val emptyNums = IndexedSeq();System.out.println("""emptyNums  : IndexedSeq[Nothing] = """ + $show(emptyNums ));$skip(17); val res$1 = 
	mean(emptyNums);System.out.println("""res1: redscala.error.handling.Either[String,Double] = """ + $show(res$1));$skip(140); 
	
	// 에외 추적 정보가 필요한 경우
	def safeDiv(x: Int, y: Int): Either[Exception, Int] =
		try Right( x / y )
		catch { case e: Exception => Left(e) };System.out.println("""safeDiv: (x: Int, y: Int)redscala.error.handling.Either[Exception,Int]""");$skip(116); 
	// 예외를 값으로 변환
	def Try[A](a: => A): Either[Exception, A] =
		try Right(a)
		catch { case e: Exception => Left(e) }
                                                  
	//자료 유효성 점검에 활용
	case class Person(name: Name, age: Age)
	sealed class Name(val value: String)
	sealed class Age(val value: Int);System.out.println("""Try: [A](a: => A)redscala.error.handling.Either[Exception,A]""");$skip(318); 
	
	def mkName(name: String): Either[String, Name] =
		if(name == "" || name == null) Left("Name is empty.")
		else Right(new Name(name));System.out.println("""mkName: (name: String)redscala.error.handling.Either[String,redscala.error.handling.either_test.Name]""");$skip(116); 
		
	def mkAge(age: Int): Either[String, Age] =
		if(age < 0) Left("Age is out of range")
		else Right(new Age(age));System.out.println("""mkAge: (age: Int)redscala.error.handling.Either[String,redscala.error.handling.either_test.Age]""");$skip(110); 

	def mkPerson(name: String, age: Int): Either[String, Person] =
		mkName(name).map2(mkAge(age))(Person(_,_));System.out.println("""mkPerson: (name: String, age: Int)redscala.error.handling.Either[String,redscala.error.handling.either_test.Person]""")}
		
}
