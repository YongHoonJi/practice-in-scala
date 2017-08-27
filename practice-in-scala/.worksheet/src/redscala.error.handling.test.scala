package redscala.error.handling

import scala.{Option => _, Either => _, _}

object test {
  
  case class Employee(name: String, department: String, managers: List[String]);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(336); 
  
  def lookupByName(name: String): Option[Employee] = name match {
   	case "John" => Some(Employee(name, "dept", List("Mike", "Steve")))
   	case _ => None
  };System.out.println("""lookupByName: (name: String)redscala.error.handling.Option[redscala.error.handling.test.Employee]""");$skip(40); val res$0 = 
	lookupByName("John").map(_.department);System.out.println("""res0: redscala.error.handling.Option[String] = """ + $show(res$0));$skip(118); 
	
	val dept: String =
		lookupByName("John").
		map(_.department).
		filter(_ != "dept").
		getOrElse("Default dept");System.out.println("""dept  : String = """ + $show(dept ))}
		
		
	
}
