package proscala.chap05

// implicit 은 강력하다. DSL(도메인특화언어)를 만들 수 있고 준비 코드를 줄인다.
// implicit은 논란이 많으나 경험을 통해 implicit를 이해해야한다. 초보자에게는 쉽지 않은 문제이겠지만...
// 암시적 인자의 장점
// 1.준비코드를 생략. 2. 매개변수화된 타입을 받는 메서드를 사용해서 버그를 줄임
// 용도 : 실행 맥락을 넘길 경우 사용하고 실행 원자성을 보장하는 곳에 사용. 트렌잭션, 데이터베이스 연결, 스레드 풀, 사용자 세션 등
// implicit function은 람다식이 가능하게 한다.
// http://hamait.tistory.com/605

// 암시는 과도하지 않게 명시적으로 사용한다. 코드를 읽기 힘들게 만들 수 있는 것이 암시이지만
// 준비코드를 제공하는 것, 매개변수화한 타입을 받는 메서드에 사용해서 버그를 줄이거나 허용되는 타입을 제한하기 위한 제약 사항으로 사용하는 것이다.

// 암시적 인자를 사용하는 시나리오
// 1. 실행 맥락 제공 : 실행 맥락을 넘길 경우 사용하고 실행 원자성을 보장하는 곳에 사용. 트렌잭션, 데이터베이스 연결, 스레드 풀, 사용자 세션 등
/*
apply[T](body => T)(implicit executor: ExecutionContext): Future[T]
*/
// 2. 세션의 권한 유무에 따라 데이터의 가시성이나 특정 api 호출 가능여부를 체크할 수 있다.
/*
	def createMenu(implicit session: Session) Menu = {
		val defaultItems = List(helpItem, searchItem)
		val accountItems =
			if(session.loggein()) List(viewAccountItem, editAccountItem)
			else List(logginItem)
		Menu(defaultItem ++ accountItems)
	}
*/

 
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