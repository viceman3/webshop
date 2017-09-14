package webshop.framework

class Order(customerId: Int, productId: Int, quantity: Int, orderDate: String, shippingDate: String) {
  require(customerId  > 0, "customer_id must be positive")
  require(productId > 0, "product_id must be positive")
  require(quantity > 0, "product_quantity must be positive")
  def change_shipping_date(shd: String) =new Order(customerId, productId, quantity, orderDate, shippingDate)
}