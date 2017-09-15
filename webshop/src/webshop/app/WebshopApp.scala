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
        val name =paramsMap.get("name")
        if (name.isEmpty) {
          throw(new IllegalArgumentException("name not found"))
        }

        val category =paramsMap.get("category")
        if (category.isEmpty) {
          throw(new IllegalArgumentException("category not found"))
        }
        val productId =paramsMap.get("productId")
            if (productId.isEmpty) {
              throw(new IllegalArgumentException("productId not found"))
            }
        val quantity =paramsMap.get("quantity")
            if (quantity.isEmpty) {
              throw(new IllegalArgumentException("quantity not found"))
            }
        val price =paramsMap.get("price")
        if (price.isEmpty) {
          throw(new IllegalArgumentException("price not found"))
        }
          val product =Product(name.get, category.get, toInt(productId.get).getOrElse(0), toInt(quantity.get).getOrElse(0), toInt(price.get).getOrElse(0))
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


