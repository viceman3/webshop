package webshop.framework

case class Request(method:String, url:String , params:Map[String,String])
case class Response(code: Int, body : String)

trait RequestHandler {
  def handleRequest(request: Request) : Response
}

class Server(handler: RequestHandler) {
  def acceptRequest(request: Request) =handler.handleRequest(request)
  
}
