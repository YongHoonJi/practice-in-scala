package proscala.chap04

object match_regex {
	val BookExtractorRE = """Book: title=([^,]+), \s+author=(.+)""".r
                                                  //> BookExtractorRE  : scala.util.matching.Regex = Book: title=([^,]+), \s+autho
                                                  //| r=(.+)
	val MagazineExtractorRE = """Magazine: title=([^,]+), \s+issue(.+)""".r
                                                  //> MagazineExtractorRE  : scala.util.matching.Regex = Magazine: title=([^,]+), 
                                                  //| \s+issue(.+)
	
	val catalog = Seq(
		"Book: title=Progamming Scala Second Edition, author=Dean Wampler",
		"Magazine: title=The New Yorker, issue=January 2014",
		"Unknown: text=Who put this here?"
	)                                         //> catalog  : Seq[String] = List(Book: title=Progamming Scala Second Edition, a
                                                  //| uthor=Dean Wampler, Magazine: title=The New Yorker, issue=January 2014, Unkn
                                                  //| own: text=Who put this here?)
	
	for(item <- catalog) {
		item match {
			case BookExtractorRE(title, author) => println(s"""Book $title", written by $author""")
			case MagazineExtractorRE(title, issue) => println(s"""Magazine "$title", issue $issue""")
			case entry => println(s"Unrecognized entry: $entry")
		}                                 //> Unrecognized entry: Book: title=Progamming Scala Second Edition, author=Dean
                                                  //|  Wampler
                                                  //| Unrecognized entry: Magazine: title=The New Yorker, issue=January 2014
                                                  //| Unrecognized entry: Unknown: text=Who put this here?
	}
}