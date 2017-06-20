package proscala.chap06

//p312
// 접기나 축소는  더 작은 컬랙션이나 하나의 값으로 축소시킨다.
// 접기는 accumulator라는 초기값을 가지나 축소는 초기값이 없다.
object fold_reduce {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(163); 
	val list = List(1,2,3,4,5,6);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(22); val res$0 = 
	
	list reduce(_ + _);System.out.println("""res0: Int = """ + $show(res$0));$skip(24); val res$1 = 
	
	list.fold(10)(_ * _);System.out.println("""res1: Int = """ + $show(res$1));$skip(92); val res$2 = 
	// fold는 중위표기법을 사용하기 어렵다. 인자가 두개이기 때문에 아래와 같이 변형하면 중위 표기법 사용이 가능하다.
	(list fold 10)(_ * _);System.out.println("""res2: Int = """ + $show(res$2));$skip(108); 
	
	// 부분 적용 함수를 만들어 중위 표기법으로 표현했다. (list fold 10)을 부분 적용하고 (_ * _)를 전체 적용하였다.
	val fold1 = (list fold 10) _;System.out.println("""fold1  : ((Int, Int) => Int) => Int = """ + $show(fold1 ));$skip(14); val res$3 = 
	fold1(_ * _);System.out.println("""res3: Int = """ + $show(res$3));$skip(66); val res$4 = 
	
	
	// 빈컬랙션에 대한 reduce는 예외가 발생
	(List.empty[Int] fold 10)(_ + _);System.out.println("""res4: Int = """ + $show(res$4));$skip(115); val res$5 = 
	//List.empty[Int] reduce(_ + _)
	
	// 컬랙션이 비었는지 확실치 않은 경우에는 reduceOption을 사용
	List.empty[Int] reduceOption(_ + _);System.out.println("""res5: Option[Int] = """ + $show(res$5));$skip(37); val res$6 = 
	List(1,2,3,4,5) reduceOption(_ + _);System.out.println("""res6: Option[Int] = """ + $show(res$6))}
	
}
