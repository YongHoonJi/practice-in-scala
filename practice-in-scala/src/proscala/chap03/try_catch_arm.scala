package proscala.chap03

//page 158
import scala.language.reflectiveCalls
import scala.util.control.NonFatal
// manage를 대문자로 시작하지 않고 소문자로 시작했다. while처럼 DSL를 만들었다.
// structural type : method로 타입을 구분하는 방법. reflection을 사용하므로 느리다...
// http://coding-korea.blogspot.kr/2012/12/structural-type.html
// <: 은 어떤 것의 서브 타입이라는 뜻으로 R <: L 는 R이 L의 서브타입을 말한다. 
object manage {
  def apply[R <: { def close(): Unit },     //close메소드가 있는 서브타입 R
                  T]                        //익명함수 f에서 반환할 타입 
                  (resource: => R)          //resource(Source)에서 R타입을 반환하는 함수. call by name
                  (f: R => T) = {           // R을 받아서 T타입을 출력하는 함수 
    var res: Option[R] = None
    try {
      res = Some(resource) // resource 함수가 참조(수행)되는 시점. laziness  
      f(res.get)
    } catch {
      case NonFatal(ex) => println(s"Non fatal exception! $ex")
    } finally {
      if (res != None) {
        println(s"close resource...")
        res.get.close
      }
    }
  } //end of apply

}

object TryCatchARM extends App{

  import scala.io.Source
  
  def countLines(fileName: String) = {
    println()
    manage(Source.fromFile(fileName)) { source =>
    	val size = source.getLines.size
    	println(s"file $fileName has $size lines")
    	if(size > 20) throw new RuntimeException("Big file!")
    }
  }
  	countLines("/Users/Justin/git/practice-in-scala/practice-in-scala/src/proscala/chap03/basic_for.sc");
  	
  	
}