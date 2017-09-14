package webshop.simulator

import webshop.framework._

class Simulator(server: Server) {
    def simulate() {
      val req1: Request =Request("POST", "products/create", Map("name" -> "Dell Inspiron 3542", "category" -> "laptop", "productId" -> "1", "quantity" -> "2", "price" -> "190000"))
      println(s"request: ${req1}")
    val resp1: Response =server.acceptRequest(req1)
    println(s"response: ${resp1}")
      val req2: Request =Request("POST", "products/create", Map("name" -> "Dell Lattitude 3131", "category" -> "laptop", "productId" -> "2", "quantity" -> "x", "price" -> "280000"))
      println(s"request: ${req2}")
    val resp2: Response =server.acceptRequest(req2)
    println(s"response: ${resp2}")
      val req3: Request =Request("POST", "products/create", Map("name" -> "Dell Inspiron 3442", "category" -> "laptop", "productId" -> "3", "quantity" -> "12", "price" -> "180000"))
      println(s"request: ${req3}")
    val resp3: Response =server.acceptRequest(req3)
    println(s"response: ${resp3}")
     
      val req4 =Request("GET", "products/search", Map())
      println(s"request: ${req4}")
    val resp4: Response =server.acceptRequest(req4)
    println(s"response: ${resp4}")

     
      val req5 =Request("GET", "products/search", Map("name"->"Dell"))
      println(s"request: ${req5}")
    val resp5: Response =server.acceptRequest(req5)
    println(s"response: ${resp5}")

    }

}