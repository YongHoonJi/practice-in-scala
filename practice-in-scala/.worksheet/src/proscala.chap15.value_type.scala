package proscala.chap15
//p567
object value_type {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(94); 
  println("Welcome to the Scala worksheet");$skip(79); 
  
  // tuple type
  
  val t1: Tuple3[String, Int, Double] = ("one", 2, 3.14);System.out.println("""t1  : (String, Int, Double) = """ + $show(t1 ));$skip(51); 
  val t2: (String, Int, Double) = ("one", 2, 3.14);System.out.println("""t2  : (String, Int, Double) = """ + $show(t2 ));$skip(96); 
  
  // function type
  val f1: Function2[Int, Double, String] = (i, d) => s"Int $i, double $d";System.out.println("""f1  : (Int, Double) => String = """ + $show(f1 ));$skip(66); 
  val f2:(Int, Double) => String = (i, d) => s"Int $i, double $d";System.out.println("""f2  : (Int, Double) => String = """ + $show(f2 ));$skip(145); 
                                                  
	// 중위 타입 : 타입 매개변수가 두 개인 매개변수화 타입은 중위 표기가 가능
	val left1: Either[String, Int] = Left("hello");System.out.println("""left1  : Either[String,Int] = """ + $show(left1 ));$skip(48); 
	
	val left2: String Either Int = Left("hello");System.out.println("""left2  : Either[String,Int] = """ + $show(left2 ));$skip(46); 
	
	val right1: Either[String, Int] = Right(1);System.out.println("""right1  : Either[String,Int] = """ + $show(right1 ));$skip(44); 
	
	val right2: String Either Int = Right(2)
	
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
	};System.out.println("""right2  : Either[String,Int] = """ + $show(right2 ));$skip(418); 

	
  def sumSeq[T: Add](seq: Seq[T]): T =
  	seq reduce(implicitly[Add[T]].add(_,_));System.out.println("""sumSeq: [T](seq: Seq[T])(implicit evidence$1: proscala.chap15.value_type.Add[T])T""");$skip(94); val res$0 = 
                                                  
	sumSeq(Vector(1 -> 10, 2 -> 20, 3 -> 30));System.out.println("""res0: (Int, Int) = """ + $show(res$0));$skip(19); val res$1 = 
	
	sumSeq(1 to 10);System.out.println("""res1: Int = """ + $show(res$1))}
	
	//sumSeq (Option(2))
}
