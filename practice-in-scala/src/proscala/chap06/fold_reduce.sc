package proscala.chap06

//p312
// 접기나 축소는  더 작은 컬랙션이나 하나의 값으로 축소시킨다.
// 접기는 accumulator라는 초기값을 가지나 축소는 초기값이 없다.
object fold_reduce {
	val list = List(1,2,3,4,5,6)              //> list  : List[Int] = List(1, 2, 3, 4, 5, 6)
	
	list reduce(_ + _)                        //> res0: Int = 21
	
	list.fold(10)(_ * _)                      //> res1: Int = 7200
	// fold는 중위표기법을 사용하기 어렵다. 인자가 두개이기 때문에 아래와 같이 변형하면 중위 표기법 사용이 가능하다.
	(list fold 10)(_ * _)                     //> res2: Int = 7200
	
	// 부분 적용 함수를 만들어 중위 표기법으로 표현했다. (list fold 10)을 부분 적용하고 (_ * _)를 전체 적용하였다.
	val fold1 = (list fold 10) _              //> fold1  : ((Int, Int) => Int) => Int = <function1>
	fold1(_ * _)                              //> res3: Int = 7200
	
	
	// 빈컬랙션에 대한 reduce는 예외가 발생
	(List.empty[Int] fold 10)(_ + _)          //> res4: Int = 10
	//List.empty[Int] reduce(_ + _)
	
	// 컬랙션이 비었는지 확실치 않은 경우에는 reduceOption을 사용
	List.empty[Int] reduceOption(_ + _)       //> res5: Option[Int] = None
	List(1,2,3,4,5) reduceOption(_ + _)       //> res6: Option[Int] = Some(15)
	
}