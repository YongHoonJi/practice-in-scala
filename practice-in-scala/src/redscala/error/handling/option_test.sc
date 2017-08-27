package redscala.error.handling

import scala.{Option => _, Either => _, _}

object test {
  
  case class Employee(name: String, department: String, managers: List[String])
  
  def lookupByName(name: String): Option[Employee] = name match {
   	case "John" => Some(Employee(name, "dept", List("Mike", "Steve")))
   	case _ => None
  }                                               //> lookupByName: (name: String)redscala.error.handling.Option[redscala.error.ha
                                                  //| ndling.test.Employee]
	lookupByName("John").map(_.department)    //> res0: redscala.error.handling.Option[String] = Some(dept)
	
	val dept: String =
		lookupByName("John").
		map(_.department).
		filter(_ != "dept").
		getOrElse("Default dept")         //> dept  : String = Default dept
		
		
	
}