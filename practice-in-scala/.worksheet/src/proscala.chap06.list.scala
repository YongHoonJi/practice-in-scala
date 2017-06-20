package proscala.chap06

object list {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
	val list1 = List("programming", "scala");System.out.println("""list1  : List[String] = """ + $show(list1 ));$skip(53); 
	val list2 = "People" :: "should" :: "read" :: list1;System.out.println("""list2  : List[String] = """ + $show(list2 ));$skip(45); 
	val list3 = "programming" :: "scala" :: Nil;System.out.println("""list3  : List[String] = """ + $show(list3 ));$skip(51); 
	val list4 = "people" :: "should" :: "read" :: Nil;System.out.println("""list4  : List[String] = """ + $show(list4 ));$skip(30); 
	
	val list5 = list4 ++ list3;System.out.println("""list5  : List[String] = """ + $show(list5 ))}
	
}
