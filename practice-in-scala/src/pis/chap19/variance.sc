package pis.chap19

object variance {
	class Publication(val title: String)
	class Book(title: String) extends Publication(title)
	
	object Library {
		val books: Set[Book] =
			Set(
				new Book("Programming in scala"),
				new Book("Walden")
			)
		// 반공변성
		def printBookList(info: Book => AnyRef) = {
			for( book <- books) println(info(book))
		}
	}
	
	def getTitle(p: Publication): String = p.title
                                                  //> getTitle: (p: pis.chap19.variance.Publication)String
	Library.printBookList(getTitle)           //> Programming in scala
                                                  //| Walden
}