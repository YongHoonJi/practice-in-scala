package proscala.chap06
//p302
object set {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
	val states = Set("apple", "banna", "c");System.out.println("""states  : scala.collection.immutable.Set[String] = """ + $show(states ));$skip(44); 
	val lengths = states map (st => st.length);System.out.println("""lengths  : scala.collection.immutable.Set[Int] = """ + $show(lengths ));$skip(28); 
	val states2 = states + "d";System.out.println("""states2  : scala.collection.immutable.Set[String] = """ + $show(states2 ));$skip(38); 
	
	val state3 = states2 + ("a1", "f");System.out.println("""state3  : scala.collection.immutable.Set[String] = """ + $show(state3 ))}
}
