package proscala.chap02

object func_and_procedure {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(126); 
	// 함수 우변 전에 등호가 없는 경우 리턴값이 없는 프로시저로 정의
	def procDouble(i: Int) { 2 * i };System.out.println("""procDouble: (i#2054552: Int#1131)Unit#2658""");$skip(24); 
	println(procDouble(2));$skip(72); 
	// 함수 우변 전에 등호가 있으면 리턴값이 있는 함수로 정의
	def funcDouble(i: Int) = { 2 * i };System.out.println("""funcDouble: (i#2054555: Int#1131)Int#1131""");$skip(24); 
	println(funcDouble(2))}
}
