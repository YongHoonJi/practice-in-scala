package proscala.chap06

object map {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(145); 
	val stateCapitals = Map(
		"alabama" -> "montagomery",
		"alaska" -> "jeneau",
		"wyoming" -> "cheyenne" );System.out.println("""stateCapitals  : scala.collection.immutable.Map[String,String] = """ + $show(stateCapitals ));$skip(68); 
		
	val lengths = stateCapitals map {
		kv => (kv._1, kv._2.length)
		};System.out.println("""lengths  : scala.collection.immutable.Map[String,Int] = """ + $show(lengths ));$skip(79); 
		
	val caps = stateCapitals map {
		case(k, v) => (k, v.toUpperCase())
	};System.out.println("""caps  : scala.collection.immutable.Map[String,String] = """ + $show(caps ));$skip(67); 
	
	val stateCapitals2 = stateCapitals + ("virginia" -> "richmond");System.out.println("""stateCapitals2  : scala.collection.immutable.Map[String,String] = """ + $show(stateCapitals2 ));$skip(94); 
	
	val stateCapitals3 = stateCapitals + ("new york" -> "albany", "illinois" -> "springfield");System.out.println("""stateCapitals3  : scala.collection.immutable.Map[String,String] = """ + $show(stateCapitals3 ))}
}
