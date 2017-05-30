package proscala.chap05

// implicit 은 강력하다. DSL(도메인특화언어)를 만들 수 있고 준비 코드를 줄인다.
// implicit은 논란이 많으나 경험을 통해 implicit를 이해해야한다. 초보자에게는 쉽지 않은 문제이겠지만...
object implicit_args {
	def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate
                                                  //> calcTax: (amount: Float)(implicit rate: Float)Float
	
	object SimpleStateSalesTax {
		// 기본 세율에 대한 암시적인 값
		implicit val rate: Float = 0.05F
	}
	
	case class ComplicatedSalesTaxData( baseRate: Float, isTaxHoliday: Boolean, storeId: Int )
	
	object ComplicatedSalesTax {
		private def extraTaxRateForStore(id: Int): Float = {
			if(id == 1010) 0.05F
			else 0.0F
		}
		
		// 복합세율에 대한 암시적인 값
		implicit def rate(implicit cstd: ComplicatedSalesTaxData): Float =
			if(cstd.isTaxHoliday) 0.0F
			else cstd.baseRate + extraTaxRateForStore(cstd.storeId)
	}
	
	{
		// implicit rate를 SimpleStateSalesTax.rate 변수를 사용
		import SimpleStateSalesTax.rate
		val amount = 100F
		println(s"Tax on $amount = ${calcTax(amount)}")
	}                                         //> Tax on 100.0 = 5.0
	
	{
		// implicit rate를 ComplicatedSalesTax.rate 함수를 사용
		import ComplicatedSalesTax.rate
		implicit val myStore = ComplicatedSalesTaxData(0.06F, false, 1010)
		
		val amount = 100F
		println(s"Tax on $amount = ${calcTax(amount)}")
	}                                         //> Tax on 100.0 = 11.0
}