package proscala.chap15
//p567
object value_type {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // tuple type
  
  val t1: Tuple3[String, Int, Double] = ("one", 2, 3.14)
                                                  //> t1  : (String, Int, Double) = (one,2,3.14)
  val t2: (String, Int, Double) = ("one", 2, 3.14)//> t2  : (String, Int, Double) = (one,2,3.14)
  
  // function type
  val f1: Function2[Int, Double, String] = (i, d) => s"Int $i, double $d"
                                                  //> f1  : (Int, Double) => String = <function2>
  val f2:(Int, Double) => String = (i, d) => s"Int $i, double $d"
                                                  //> f2  : (Int, Double) => String = <function2>
                                                  
	// 중위 타입 : 타입 매개변수가 두 개인 매개변수화 타입은 중위 표기가 가능
	val left1: Either[String, Int] = Left("hello")
                                                  //> left1  : Either[String,Int] = Left(hello)
	
	val left2: String Either Int = Left("hello")
                                                  //> left2  : Either[String,Int] = Left(hello)
	
	val right1: Either[String, Int] = Right(1)//> right1  : Either[String,Int] = Right(1)
	
	val right2: String Either Int = Right(2)  //> right2  : Either[String,Int] = Right(2)
	
	// 고계타입 (High order type)

	trait Add[T] {
		def add(t1: T, t2: T): T
	}
	
	object Add {
		implicit val addInt = new Add[Int] {
			def add(i1: Int, i2: Int): Int = i1 + i2
		}
	
		implicit val addIntIntPair = new Add[(Int, Int)] {
			def add(p1: (Int, Int), p2: (Int, Int)): (Int, Int) =
				(p1._1 + p2._1, p1._2 + p2._2)
		}
	}

	
  def sumSeq[T: Add](seq: Seq[T]): T =
  	seq reduce(implicitly[Add[T]].add(_,_))   //> sumSeq: [T](seq: Seq[T])(implicit evidence$1: proscala.chap15.value_type.Ad
                                                  //| d[T])T
                                                  
	sumSeq(Vector(1 -> 10, 2 -> 20, 3 -> 30)) //> res0: (Int, Int) = (6,60)
	
	sumSeq(1 to 10)                           //> res1: Int = 55
	
	//sumSeq (Option(2))
}