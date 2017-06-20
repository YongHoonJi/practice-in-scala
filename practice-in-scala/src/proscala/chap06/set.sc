package proscala.chap06
//p302
object set {
	val states = Set("apple", "banna", "c")   //> states  : scala.collection.immutable.Set[String] = Set(apple, banna, c)
	val lengths = states map (st => st.length)//> lengths  : scala.collection.immutable.Set[Int] = Set(5, 1)
	val states2 = states + "d"                //> states2  : scala.collection.immutable.Set[String] = Set(apple, banna, c, d)
	
	val state3 = states2 + ("a1", "f")        //> state3  : scala.collection.immutable.Set[String] = Set(banna, f, apple, c, a
                                                  //| 1, d)
}