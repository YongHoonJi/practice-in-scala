package chap1_1_soc

case class Cafe() {
  def buyCoffee(cc: CreditCard, p: Payment): Coffee = {
    var cup = Coffee(1000);
    p.charge(cc, cup.price);
    cup; 
  }
}

case class CreditCard(owner: String) {
}

trait Payment{
  def charge(card: CreditCard, price: Int);
}

class RealPayment extends Payment{
  def charge(card: CreditCard, price: Int) {
      println("Pay with the payment class - " + card.owner +", "+ price);
      println("Connect to a payment system(exist side effect)");
    }
}

case class Coffee(price: Int) {
}

