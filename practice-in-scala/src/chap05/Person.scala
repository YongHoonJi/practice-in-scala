package chap05

sealed class Name(val value: String)
sealed class Age(val value: Int)

class Person(name: Name, age: Age) {
  def mkName(name: String): Either[String, Name] = {
    if (name == "" || name == null) Left("Name is empty.")
    else Right(new Name(name))
  }
  
  def mkAge(age: Int): Either[String, Age] = {
    if(age < 0) Left("Age is out of ranage")
    else Right(new Age(age))
  }
}
  
