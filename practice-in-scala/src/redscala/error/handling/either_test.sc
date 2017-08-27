package redscala.error.handling

object either_test {
	def mean(xs: IndexedSeq[Int]): Either[String, Double] = {
		if(xs.isEmpty)
			Left("mean of empty list")
		else
			Right(xs.sum / xs.length)
	}                                         //> mean: (xs: IndexedSeq[Int])redscala.error.handling.Either[String,Double]
	
	val nums = IndexedSeq(1,2,3,4,5)          //> nums  : IndexedSeq[Int] = Vector(1, 2, 3, 4, 5)
	mean(nums)                                //> res0: redscala.error.handling.Either[String,Double] = Right(3.0)
	
	val emptyNums = IndexedSeq()              //> emptyNums  : IndexedSeq[Nothing] = Vector()
	mean(emptyNums)                           //> res1: redscala.error.handling.Either[String,Double] = Left(mean of empty lis
                                                  //| t)
	
	// 에외 추적 정보가 필요한 경우
	def safeDiv(x: Int, y: Int): Either[Exception, Int] =
		try Right( x / y )
		catch { case e: Exception => Left(e) }
                                                  //> safeDiv: (x: Int, y: Int)redscala.error.handling.Either[Exception,Int]
	// 예외를 값으로 변환
	def Try[A](a: => A): Either[Exception, A] =
		try Right(a)
		catch { case e: Exception => Left(e) }
                                                  //> Try: [A](a: => A)redscala.error.handling.Either[Exception,A]
                                                  
	//자료 유효성 점검에 활용
	case class Person(name: Name, age: Age)
	sealed class Name(val value: String)
	sealed class Age(val value: Int)
	
	def mkName(name: String): Either[String, Name] =
		if(name == "" || name == null) Left("Name is empty.")
		else Right(new Name(name))        //> mkName: (name: String)redscala.error.handling.Either[String,redscala.error.h
                                                  //| andling.either_test.Name]
		
	def mkAge(age: Int): Either[String, Age] =
		if(age < 0) Left("Age is out of range")
		else Right(new Age(age))          //> mkAge: (age: Int)redscala.error.handling.Either[String,redscala.error.handli
                                                  //| ng.either_test.Age]

	def mkPerson(name: String, age: Int): Either[String, Person] =
		mkName(name).map2(mkAge(age))(Person(_,_))
                                                  //> mkPerson: (name: String, age: Int)redscala.error.handling.Either[String,red
                                                  //| scala.error.handling.either_test.Person]
		
}