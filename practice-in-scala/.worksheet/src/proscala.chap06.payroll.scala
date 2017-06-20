package proscala.chap06

//p329
// oop의 generative(생성적)한계
// 객체는 합성의 근본 단위가 되기에는 단위가 크며 더 근본적인 해결이 필요하다.
// http, 디지털 직접회로는 기본적인 단순함과 표준으로 컴포넌트화 되었고 이를 기반으로 더 복잡한 표준들이 만들어졌다.
// FP는 조합수학의 콤비네이터를 사용하여 그 사용 범위를 더 넓힐 수 있디.(combinatory logic)
// 데이터와 동작이 한 곳에 있는 클래스를 지향하는 OOP에 비해 FP는 데이터와 그 동작을 분리할 수 있다.
object payroll {
	case class Employee (
		name: String,
		title: String,
		annualSalary: Double,
		taxRate: Double,
		insurancePremiumPerWeek: Double
	);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(651); 
	
	val employees = List(
		Employee("Buck Trends", "CEO", 200000, 0.25, 100.0),
		Employee("Cindy Banks", "CFO", 170000, 0.22, 120.0),
		Employee("Joe Coder", "Developer", 130000, 0.20, 120.0)
		);System.out.println("""employees  : List[proscala.chap06.payroll.Employee] = """ + $show(employees ));$skip(143); 
	//주간 급여를 계산
	val netPay = employees map { e =>
		val net = (1.0 - e.taxRate) * (e.annualSalary / 52.0) - e.insurancePremiumPerWeek
		(e, net)
	};System.out.println("""netPay  : List[(proscala.chap06.payroll.Employee, Double)] = """ + $show(netPay ));$skip(43); 
	
	// 급여표를 출력
	println("** PayChecks:");$skip(85); 
	netPay foreach {
		case (e, net) => println(f" ${e.name+':'}%-16s ${net}%10.2f")
	};$skip(235); 
	
	//보고서를 작성한다
	val report = (netPay foldLeft(0.0,0.0,0.0)) {
		case ((totalSalary, totalNet, totalInsurance), (e,net) )=>
			(totalSalary + e.annualSalary / 52.0,
				totalNet + net,
				totalInsurance + e.insurancePremiumPerWeek)
	};System.out.println("""report  : (Double, Double, Double) = """ + $show(report ));$skip(27); 
	
	println("\n*** Report");$skip(48); 
	println(f"	Total Salary : ${report._1}%10.2f");$skip(45); 
	println(f"	Total Net : ${report._2}%10.2f");$skip(51); 
	println(f"	Total Insurance : ${report._3}%10.2f")}
	
}
