package webshop.framework {

  case class Product(val name: String, val category: String, val productId: Int, val quantity: Int, val price: Int) {
  require(productId > 0, "product_id must be positive")
  require(quantity > 0, "quantity must be positive")
  require(price > 0, "price must be positive")
  def changeQuantity(quan: Int) : Product =new Product(name, category, productId, quantity, price)
  def changePrice(pr: Int) : Product = new Product(name, category, productId, quantity, price)
  
}
}
