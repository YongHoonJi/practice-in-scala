package seminar

object MemoizationExample extends App {
  
  val cache = scala.collection.mutable.Map[Int, Int]();
  
  def sumOfFactors(number: Int):Int = {
    //println(cache)
    //println("requested number - "+number)
	  return cache.getOrElseUpdate(number, factorsOf(number))
	}
	
	def factorsOf(number: Int): Int = {
	  //println("number:"+number)
	  var sum = 0;
		for( a <- 1 to number-1){
			if(number % a == 0){
				sum += a;
			}
		}
		return sum;
 	}
	
	var startTime = System.currentTimeMillis
	val limit = 40000
	println("Start memoization")
	for( a <- 1 to limit){
		sumOfFactors(a);
	}
	for( a <- 1 to limit){
		sumOfFactors(a);
	}
	var stopTime = System.currentTimeMillis - startTime
	println("Elapse - " + (stopTime) / 1000)
}