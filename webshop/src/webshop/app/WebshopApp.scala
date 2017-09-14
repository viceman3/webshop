package webshop.app

import webshop.framework._

class ExperimentalHandler extends RequestHandler {
  val shop: Shop =new Shop()
private def toInt(s: String): Option[Int] = {
  try {
    Some(s.toInt)
  } catch {
    case e: Exception => None
  }
}

  override def handleRequest(req: Request) : Response ={
    println(s"incoming httprequest: ${req}")
    req match {
      case Request("POST", "products/create", paramsMap) => {
        try {
        val name: String =paramsMap.get("name").getOrElse("invalid name")
        val category: String =paramsMap.get("category").getOrElse("invalid category")
        val productId: Int =toInt(paramsMap.get("productId").getOrElse("-1")).getOrElse(0)
        val quantity: Int =toInt(paramsMap.get("quantity").getOrElse("-1")).getOrElse(0)
        val price: Int =toInt(paramsMap.get("price").getOrElse("-1")).getOrElse(0)
          val product =Product(name, category, productId, quantity, price)
          shop.addProduct(product)
          Response(200, s"${product}, has been added.")
        }
        catch {
          case e: Exception => Response(400, s"${e.getMessage}, couldnt be added")
        }
      }
      case Request("GET", "products/search", paramsMap) => {
        if (paramsMap.isEmpty) {
          Response(200, shop.getProducts.toString)
        }
        else {

        Response(200, this.shop.findProduct(paramsMap.get("name").getOrElse("not found")).toString)
        }
      }
    }
  }
}


