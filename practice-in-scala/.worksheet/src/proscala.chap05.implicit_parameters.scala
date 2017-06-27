package proscala.chap05

object implicit_parameters {
	class PreferredPrompt(val pre: String)
	class PreferredDrink(val pre: String)
	
	object Greeter {
		def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) = {
			println("Welcome, "  + name + ". The system is ready.")
			println("drink : "+drink.pre)
			println("prompt : "+prompt.pre)
		}
	}
	
	object JoesPrefs {
		implicit val propmt = new PreferredPrompt("Yes master >")
		implicit val drink = new PreferredDrink("tea")
	}
	
	import JoesPrefs._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(554); 
	Greeter.greet("Justin")
  // sorting
  import scala.util.Sorting;$skip(99); 
	val pairs = Array(("a", 5, 2), ("c", 3, 1), ("b", 1, 3));System.out.println("""pairs  : Array[(String, Int, Int)] = """ + $show(pairs ));$skip(96); 
	
	// sort by 2nd element
	Sorting.quickSort(pairs)(Ordering.by[(String, Int, Int), Int](_._2));$skip(7); val res$0 = 
	pairs;System.out.println("""res0: Array[(String, Int, Int)] = """ + $show(res$0));$skip(111); 
	// sort by the 3rd element, then 1st
	Sorting.quickSort(pairs)(Ordering[(Int, String)].on(x => (x._3, x._1)));$skip(7); val res$1 = 
	pairs;System.out.println("""res1: Array[(String, Int, Int)] = """ + $show(res$1));$skip(529); 
	
	
	// not using implicit
	def maxListOrdering[T](elements: List[T])(ordering: Ordering[T]): T =
		elements match {
			case List() => throw new IllegalArgumentException("empty list:")
			case List(x) => x
			case x :: rest =>
				println("x " + x)
				println("rest : "+rest)
				val maxRest = maxListOrdering(rest)(ordering)
				println(x +", "+maxRest)
				if(ordering.gt(x, maxRest)){
					println("com x:"+x)
					x // gt - x is greater than maxRest
					}
				else{
					println("maxRest:"+maxRest)
					maxRest
					}
		};System.out.println("""maxListOrdering: [T](elements: List[T])(ordering: Ordering[T])T""");$skip(32); 
		
		val list = List(2,3,4,2,1);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(39); val res$2 = 
		maxListOrdering(list)(Ordering[Int]);System.out.println("""res2: Int = """ + $show(res$2));$skip(535); 
		
		// using implicit
		def maxListImpParam[T](elements: List[T])(implicit ordering: Ordering[T]): T =
		elements match {
			case List() => throw new IllegalArgumentException("empty list:")
			case List(x) => x
			case x :: rest =>
				println("x " + x)
				println("rest : "+rest)
				val maxRest = maxListImpParam(rest)(ordering)
				println(x +", "+maxRest)
				if(ordering.gt(x, maxRest)){
					println("com x:"+x)
					x // gt - x is greater than maxRest
					}
				else{
					println("maxRest:"+maxRest)
					maxRest
					}
		};System.out.println("""maxListImpParam: [T](elements: List[T])(implicit ordering: Ordering[T])T""");$skip(35); 
		
		val implist = List(2,3,4,2,1);System.out.println("""implist  : List[Int] = """ + $show(implist ));$skip(24); val res$3 = 
		maxListImpParam(list);System.out.println("""res3: Int = """ + $show(res$3))}
}
