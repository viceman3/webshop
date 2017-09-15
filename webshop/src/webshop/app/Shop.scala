package webshop.framework

import collection.mutable._

class Shop {
  val products: ListBuffer[Product] =ListBuffer()
  val users: ListBuffer[Customer] =ListBuffer()
  val orders: ListBuffer[Order] =ListBuffer()
  def addProduct(product: Product) ={
      this.products +=product
  }
  def addOrder(order: Order) ={
    this.orders +=order
  }
  def addUser(user: Customer) ={
    this.users +=user
  }
  def findProduct(nam: String) : ListBuffer[Product] =this.products.filter(_.name.contains(nam))
  def getProducts: ListBuffer[Product] =this.products
}
