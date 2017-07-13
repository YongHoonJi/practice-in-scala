package proscala.chap11
//p457
// template method pattern
/*
- 정의 : 상위 클래스는 탬플릿을 이용하여 공통 알고리즘을 가지며 하위 클래스는 구체적인 구현을 상위 클래스의 알고리즘을 상세기능을 구체화.
	즉 로직을 공통화
- 사용용도 : 공통 알고리즘 처리시 하위 클래스에서 상세 기능 구현

- override 사용 조건
1.추상 메소드, 변수를 구현시는 미사용
2.구체화된 메소드, 변수를 구현시는 명시
*/
object override_payroll_template_method {
	case class Address(city: String, state: String, zip: String)
	case class Employee(name: String, salary: Double, address: Address)
	
	abstract class Payroll {
		def netPay(employee: Employee): Double = {
			val fedTaxes = calFedTaxes(employee.salary)
			val stateTaxes = calStateTaxes(employee.salary, employee.address)
			employee.salary - fedTaxes - stateTaxes
		}
		
		def calFedTaxes(salary: Double): Double
		def calStateTaxes(salary: Double, address: Address): Double
	}
	
	object Payroll2014 extends Payroll {
		val stateRate = Map(
			"XX" -> 0.05,
			"YY" -> 0.03,
			"ZZ" -> 0.0)
			
		override def calFedTaxes(salary:Double) = salary * 0.25
		
		override def calStateTaxes(salary:Double, address:Address): Double = {
			salary * stateRate(address.state)
		}
	}
	
	val tom = Employee("Tom Jones", 100000.0, Address("MyTown", "XX", "123456"))
	val jane  = Employee("Jane Doe", 110000.0, Address("BigCity", "YY", "67890"))
	
	Payroll2014.netPay(tom)
	Payroll2014.netPay(jane)
	
}