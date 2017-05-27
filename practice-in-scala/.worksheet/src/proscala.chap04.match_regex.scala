package proscala.chap04

object match_regex {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(112); 
	val BookExtractorRE = """Book: title=([^,]+), \s+author=(.+)""".r;System.out.println("""BookExtractorRE  : scala.util.matching.Regex = """ + $show(BookExtractorRE ));$skip(73); 
	val MagazineExtractorRE = """Magazine: title=([^,]+), \s+issue(.+)""".r;System.out.println("""MagazineExtractorRE  : scala.util.matching.Regex = """ + $show(MagazineExtractorRE ));$skip(188); 
	
	val catalog = Seq(
		"Book: title=Progamming Scala Second Edition, author=Dean Wampler",
		"Magazine: title=The New Yorker, issue=January 2014",
		"Unknown: text=Who put this here?"
	);System.out.println("""catalog  : Seq[String] = """ + $show(catalog ));$skip(285); 
	
	for(item <- catalog) {
		item match {
			case BookExtractorRE(title, author) => println(s"""Book $title", written by $author""")
			case MagazineExtractorRE(title, issue) => println(s"""Magazine "$title", issue $issue""")
			case entry => println(s"Unrecognized entry: $entry")
		}}
	}
}
