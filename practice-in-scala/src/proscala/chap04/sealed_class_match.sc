package proscala.chap04
// p207
// sealed case match
// sealed의 모든 서브타입은 같은 파일 안에서만 정의가 가능
object sealed_class_match {
	sealed abstract class HttpMethod() {
		def body: String
		def bodyLength = body.length
	}
	
	case class Connect(body:String) extends HttpMethod
	case class Delete(body:String) extends HttpMethod
	case class Get(body:String) extends HttpMethod
	case class Head(body:String) extends HttpMethod
	// 패턴 매치를 통해 정의된 객체를 생
	def handle(method: HttpMethod) = method match {
		case Connect(body) => s"connect: (length: ${method.bodyLength}) $body"
		case Delete(body) => s"delete: (length: ${method.bodyLength}) $body"
		case Get(body) => s"get: (length: ${method.bodyLength}) $body"
		case Head(body) => s"head: (length: ${method.bodyLength}) $body"
	}                                         //> handle: (method: proscala.chap04.sealed_class_match.HttpMethod)String
	
	val methods = Seq(
		Connect("connect body..."),
		Delete("delete body..."),
		Get("get body..."),
		Head("head body...")
	)                                         //> methods  : Seq[Product with Serializable with proscala.chap04.sealed_class_m
                                                  //| atch.HttpMethod] = List(Connect(connect body...), Delete(delete body...), Ge
                                                  //| t(get body...), Head(head body...))
	
	methods foreach (method => println(handle(method)))
                                                  //> connect: (length: 15) connect body...
                                                  //| delete: (length: 14) delete body...
                                                  //| get: (length: 11) get body...
                                                  //| head: (length: 12) head body...
	
}