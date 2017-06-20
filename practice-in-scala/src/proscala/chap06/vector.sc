package proscala.chap06

//p297
// list, vector, linked list : http://seeit.kr/36
// vector는 연산에서 O(1)시간을 제공한다. 중간 원소에 대한 직접 접근이 가능하다. (리스트는 특정 원소 검색에 O(n)의 시간이 필요하다.)

import util.TicToc;

object vector {
	val vect1 = Vector("programming", "scala")//> vect1  : scala.collection.immutable.Vector[String] = Vector(programming, sca
                                                  //| la)
	val vect2 = "people" +: "should" +: "read" +: vect1
                                                  //> vect2  : scala.collection.immutable.Vector[String] = Vector(people, should, 
                                                  //| read, programming, scala)
	
	val vect3 = "programming" +: "scala" +: Vector.empty
                                                  //> vect3  : scala.collection.immutable.Vector[String] = Vector(programming, sca
                                                  //| la)
	
	val vect4 = "people" +: "should" +: "read" +: Vector.empty
                                                  //> vect4  : scala.collection.immutable.Vector[String] = Vector(people, should, 
                                                  //| read)
	
	
	val vect5 = vect4 ++ vect3                //> vect5  : scala.collection.immutable.Vector[String] = Vector(people, should, 
                                                  //| read, programming, scala)
                
	val list3 = "programming" :: "scala" :: Nil
                                                  //> list3  : List[String] = List(programming, scala)
	val list4 = "people" :: "should" :: "read" :: Nil
                                                  //> list4  : List[String] = List(people, should, read)
	
	val list5 = list4 ++ list3                //> list5  : List[String] = List(people, should, read, programming, scala)
	
	// 상수 시간에 첨자를 기반으로 원소에 접근. 아래 리스트와의 접근 실행시간을 비교해보아라.
	TicToc.time(vect5(3))                     //> Elapsed time: 20876ns
                                                  //| res0: String = programming
	
	TicToc.time(list5(3))                     //> Elapsed time: 41917ns
                                                  //| res1: String = programming
}