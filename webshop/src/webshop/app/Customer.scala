package webshop.framework

case class Customer(val name: String, val personId: Int, val contacts: List[String]) {
  require(personId > 0, "person_id must be positive")
  
}

