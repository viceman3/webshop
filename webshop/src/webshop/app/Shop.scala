package webshop.framework

class Shop {
  var products: List[Product] =List()
  var users: List[Customer] =List()
  var orders: List[Order] =List()
  def addProduct(product: Product) ={
      this.products =product :: this.products
  }
  def addOrder(order: Order) ={
    this.orders =order :: this.orders
  }
  def addUser(user: Customer) ={
    this.users =user :: this.users
  }
  def findProduct(nam: String) : List[Product] =this.products.filter(_.name.contains(nam))
  def getProducts: List[Product] =this.products
}
