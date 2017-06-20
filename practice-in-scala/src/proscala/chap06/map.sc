package proscala.chap06

object map {
	val stateCapitals = Map(
		"alabama" -> "montagomery",
		"alaska" -> "jeneau",
		"wyoming" -> "cheyenne" )         //> stateCapitals  : scala.collection.immutable.Map[String,String] = Map(alabama
                                                  //|  -> montagomery, alaska -> jeneau, wyoming -> cheyenne)
		
	val lengths = stateCapitals map {
		kv => (kv._1, kv._2.length)       //> lengths  : scala.collection.immutable.Map[String,Int] = Map(alabama -> 11, a
                                                  //| laska -> 6, wyoming -> 8)
		}
		
	val caps = stateCapitals map {
		case(k, v) => (k, v.toUpperCase())
	}                                         //> caps  : scala.collection.immutable.Map[String,String] = Map(alabama -> MONTA
                                                  //| GOMERY, alaska -> JENEAU, wyoming -> CHEYENNE)
	
	val stateCapitals2 = stateCapitals + ("virginia" -> "richmond")
                                                  //> stateCapitals2  : scala.collection.immutable.Map[String,String] = Map(alabam
                                                  //| a -> montagomery, alaska -> jeneau, wyoming -> cheyenne, virginia -> richmon
                                                  //| d)
	
	val stateCapitals3 = stateCapitals + ("new york" -> "albany", "illinois" -> "springfield")
                                                  //> stateCapitals3  : scala.collection.immutable.Map[String,String] = Map(wyomin
                                                  //| g -> cheyenne, alabama -> montagomery, illinois -> springfield, alaska -> je
                                                  //| neau, new york -> albany)
}