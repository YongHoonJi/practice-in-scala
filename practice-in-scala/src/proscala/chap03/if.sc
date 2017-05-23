package proscala.chap03

object if_test {
	if(2 + 2 == 5) {
		println("hello from")
	}else if(2 + 2 == 3) {
		println("hello from false")
	} else {
		println("hello from else")
	}                                         //> hello from else
	
	// 분기문을 통한 값 리턴
	val configFile = new java.io.File("/Users/Justin/git/practice-in-scala/practice-in-scala/src/proscala/chap02/factorial.sc")
                                                  //> configFile  : java.io.File = /Users/Justin/git/practice-in-scala/practice-in
                                                  //| -scala/src/proscala/chap02/factorial.sc
	
	val configFilePath = if(configFile.exists()) {
		configFile.getAbsolutePath()
		} else {
		configFile.getName()
		}                                 //> configFilePath  : String = /Users/Justin/git/practice-in-scala/practice-in-s
                                                  //| cala/src/proscala/chap02/factorial.sc
                                                  
		println(configFilePath)           //> /Users/Justin/git/practice-in-scala/practice-in-scala/src/proscala/chap02/fa
                                                  //| ctorial.sc
}