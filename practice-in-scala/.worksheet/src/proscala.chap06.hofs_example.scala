package proscala.chap06
//p276
object hofs_example {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(211); val res$0 = 
	// reduce 축약한다. 전달 함수는 결합의 법칙이 성립해야 한다(뎃셈, 곱셈의 결합법칙). 왜냐면 컬랙션 원소를 어느 방향(왼쪽 아니면 오른쪽)으로
	// 처리할지 모른다.
	(1 to 10) filter (_ % 2 == 0) map (_ * 2) reduce (_ * _);System.out.println("""res0: Int = """ + $show(res$0))}
}
