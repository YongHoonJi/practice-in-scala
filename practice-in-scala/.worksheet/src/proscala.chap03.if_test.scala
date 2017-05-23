package proscala.chap03

object if_test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(179); 
	if(2 + 2 == 5) {
		println("hello from")
	}else if(2 + 2 == 3) {
		println("hello from false")
	} else {
		println("hello from else")
	};$skip(144); 
	
	// 분기문을 통한 값 리턴
	val configFile = new java.io.File("/Users/Justin/git/practice-in-scala/practice-in-scala/src/proscala/chap02/factorial.sc");System.out.println("""configFile  : java.io.File = """ + $show(configFile ));$skip(119); 
	
	val configFilePath = if(configFile.exists()) {
		configFile.getAbsolutePath()
		} else {
		configFile.getName()
		};System.out.println("""configFilePath  : String = """ + $show(configFilePath ));$skip(77); 
                                                  
		println(configFilePath)}
}
