package proscala.chap06

object list {
	val list1 = List("programming", "scala")  //> list1  : List[String] = List(programming, scala)
	val list2 = "People" :: "should" :: "read" :: list1
                                                  //> list2  : List[String] = List(People, should, read, programming, scala)
	val list3 = "programming" :: "scala" :: Nil
                                                  //> list3  : List[String] = List(programming, scala)
	val list4 = "people" :: "should" :: "read" :: Nil
                                                  //> list4  : List[String] = List(people, should, read)
	
	val list5 = list4 ++ list3                //> list5  : List[String] = List(people, should, read, programming, scala)
	
}