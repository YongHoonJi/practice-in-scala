package seminar


// var : variable, val : variable + final
class FunctonalExample {

  /////////////////////////////// fuctional programing example /////////////////////////////// 
  val employees = List("jack", "paul", "alto", "nick")
  val result = employees
    .filter(_.length() > 1)
    .map(_.capitalize)
    .reduce(_ + "," + _)
  println(result)

  // filter
  val naturalNumbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println("Odd : " + naturalNumbers.filter(_ % 2 == 1))

  // map
  val leagues = List("EPL", "Laliga", "Liga1", "SeriaA", "Super Leguge")
  println("Map : " + leagues.map(_.length))
  
  /////////////////////////////// closure /////////////////////////////// 
  // closure 1
  class Employee(val name:String, val salary:Int)
  
  def paidMore = (a:Int) => {e:Employee => e.salary > a}
  
  val isHighPaid = paidMore(5000)
  
  val plumber = new Employee("Fred", 12000)
  val casher = new Employee("Nick", 10000)
  println(isHighPaid(plumber))
  println(isHighPaid(casher))
  
  val isHighPaid2 = paidMore(60000)
  val nurse = new Employee("John", 50000)
  println(isHighPaid2(nurse))
  
  // closure 2
  var acc = 0;
  def makeCounter(i: Int) = () => { println(acc +=  i) } 
  val counter = makeCounter(2)
  counter();
  counter();
  
  // closure 3
  def saySomething(prefix: String) = (s: String) => {
    prefix + " " + s
  }
  
  val sayHello = saySomething("Hello")
  val salutation = sayHello("Al")
  println(salutation)
  
  // closure 4
  import scala.collection.mutable.ArrayBuffer
  val fruits = ArrayBuffer("apple")
  val addToBasket = (s: String) => {
      fruits += s
      println(fruits.mkString(", "))
  }
  
  addToBasket("banan")
  
  /////////////////////////////// currying /////////////////////////////// 
  def add(a: Int)(b: Int) = a + b
  
  val onePlusFive = add(1)(5) // 6
  
  val addFour = add(4)_ // (Int => Int)
  
  val twoPlusFour = addFour(2) // 6
  
  println(onePlusFive +" == " + twoPlusFour)  
  
  /////////////////////////////// common blocks(reduce&fold) /////////////////////////////// 
  val numbers = List(1, 10, 100, 1000)
  def add = (a: Int, b: Int) =>  ( a + b )
  // reduce
  println("reduce : " + numbers.reduceLeft(add))
  
  // fold
  println("fold : " + numbers.foldLeft(1)(add))  // with start value 1
  
}