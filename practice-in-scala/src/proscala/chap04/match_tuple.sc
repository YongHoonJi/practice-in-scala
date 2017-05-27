package proscala.chap04

object match_tuple {
  val langs = Seq(
  ("scala", "martin", "ordersy"),
  ("clojure", "rich", "hichey"),
  ("lisp","john","mccarthy")
  )                                               //> langs  : Seq[(String, String, String)] = List((scala,martin,ordersy), (cloju
                                                  //| re,rich,hichey), (lisp,john,mccarthy))
  // 각 튜플의 타입을 추론하여 3원소 튜플에 일치하는 것을 매칭. 관심 대상 원소 (scala)를 매칭시킬 수도 있다.
  for(tuple <- langs) {
  	tuple match {
  		case ("scala",_,_) => println("found scala")
  		case (lang,first,last) =>  println(s"found other language: $lang($first,$last)")
  	}                                         //> found scala
                                                  //| found other language: clojure(rich,hichey)
                                                  //| found other language: lisp(john,mccarthy)
  }
  
}