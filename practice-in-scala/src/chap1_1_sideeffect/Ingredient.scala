package chap1_1_sideeffect

case class Cafe(cup: Coffee) {
  def buyCoffee(cc: CreditCard): Coffee = {
    cc.charge(cup.price);
    cup
  }
}

class CreditCard {
  def charge(price: Int) {
    println("Pay - " + price);
    println("Connect to a payment system(exist side effect)");
  }
}

case class Coffee(price: Int) {
}

