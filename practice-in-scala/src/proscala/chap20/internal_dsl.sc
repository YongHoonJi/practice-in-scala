package proscala.chap20

// p662
object internal_dsl {
  println("")

  object common {
    sealed trait Amount { def amount: Double }

    case class Percentage(amount: Double) extends Amount {
      override def toString = s"$amount%"
    }

    case class Dollars(amount: Double) extends Amount {
      override def toString = s"$$$amount"
    }

    implicit class Unit(amount: Double) {
      def percent = Percentage(amount)
      def dollars = Dollars(amount)
    }

    case class Deduction(name: String, amount: Amount) {
      override def toString = s"$name: $amount"
    }

    case class Deductions(
        name: String,
        divisorFromAnnualPay: Double = 1.0,
        val deductions: Vector[Deduction] = Vector.empty) {
      def gross(annualSalary: Double): Double = annualSalary / divisorFromAnnualPay

      def net(annualSalary: Double): Double = {
        val g = gross(annualSalary) // accumulator
        (deductions foldLeft g) {
          case (total, Deduction(deduction, amount)) => amount match {
            case Percentage(value) => total - (g * value / 100.0)
            case Dollars(value) => total - value
          }
        }
      }
    }
  }
  
  object dsl {
  	def biweekly(f: DeductionBuilder => Deductions) =
  		f(new DeductionBuilder("Biweekly", 26.0)
  		
  	class DeductionBuilder(
  		name: String,
  		devisor: Double = 1.0
  		deducts: Vector[Deduction] = Vector.empty) extends Deductions(
  			name, divisor, deducts){
  			
  			def federal_tax(amount: Amount): DeductionBuilder = {
  				deductions = deductions :+ Deduction("federal taxes", amount)
  				this
  			}
  	
  	}
  	
  }

  // test dsl
  import scala.language.postfixOps

  val biweeklyDeductions = biweekly {
    deduct =>
      deduct federal_tax (25.0 percent)
      deduct state_tax (5.0 percent)
      deduct insurance_premiums (500.0 percent)
      deduct retirement_savings (10.0 percent)
  }

  println(biweeklyDeductions)

  val annualGross = 100000.0
  val gross = biweeklyDeductions.gross(annualGraoss)
  val net = biweeklyDeductions(annualGross)
  print(f"Biweekly pay (annual: $$${annualGross}%.2f): ")
  println(f"Gross: $$${gross}%.2f, Net: $$${net}%.2f")
}