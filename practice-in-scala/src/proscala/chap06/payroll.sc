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
	)
	
	val employees = List(
		Employee("Buck Trends", "CEO", 200000, 0.25, 100.0),
		Employee("Cindy Banks", "CFO", 170000, 0.22, 120.0),
		Employee("Joe Coder", "Developer", 130000, 0.20, 120.0)
		)                                 //> employees  : List[proscala.chap06.payroll.Employee] = List(Employee(Buck Tre
                                                  //| nds,CEO,200000.0,0.25,100.0), Employee(Cindy Banks,CFO,170000.0,0.22,120.0),
                                                  //|  Employee(Joe Coder,Developer,130000.0,0.2,120.0))
	//주간 급여를 계산
	val netPay = employees map { e =>
		val net = (1.0 - e.taxRate) * (e.annualSalary / 52.0) - e.insurancePremiumPerWeek
		(e, net)                          //> netPay  : List[(proscala.chap06.payroll.Employee, Double)] = List((Employee(
                                                  //| Buck Trends,CEO,200000.0,0.25,100.0),2784.6153846153848), (Employee(Cindy Ba
                                                  //| nks,CFO,170000.0,0.22,120.0),2430.0), (Employee(Joe Coder,Developer,130000.0
                                                  //| ,0.2,120.0),1880.0))
	}
	
	// 급여표를 출력
	println("** PayChecks:")                  //> ** PayChecks:
	netPay foreach {
		case (e, net) => println(f" ${e.name+':'}%-16s ${net}%10.2f")
	}                                         //>  Buck Trends:        2784.62
                                                  //|  Cindy Banks:        2430.00
                                                  //|  Joe Coder:          1880.00
	
	//보고서를 작성한다
	val report = (netPay foldLeft(0.0,0.0,0.0)) {
		case ((totalSalary, totalNet, totalInsurance), (e,net) )=>
			(totalSalary + e.annualSalary / 52.0,
				totalNet + net,
				totalInsurance + e.insurancePremiumPerWeek)
	}                                         //> report  : (Double, Double, Double) = (9615.384615384615,7094.615384615385,3
                                                  //| 40.0)
	
	println("\n*** Report")                   //> 
                                                  //| *** Report
	println(f"	Total Salary : ${report._1}%10.2f")
                                                  //> 	Total Salary :    9615.38
	println(f"	Total Net : ${report._2}%10.2f")
                                                  //> 	Total Net :    7094.62
	println(f"	Total Insurance : ${report._3}%10.2f")
                                                  //> 	Total Insurance :     340.00
	
}