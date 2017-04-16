package chap1_1_nosideeffect

class Cafe{
  def buyCoffee(cc: CreditCard): Charge = {
    val cup = new Coffee(1000);
    (Charge(cc, cup.price));
  }
}

class CreditCard(owner: String) {
  def charge(price: Int) {
    println("Pay - " + price);
    println("Connect to a payment system(exist side effect)");
  }
}

case class Coffee(price: Int) {
}

case class Charge(cc: CreditCard, amount: Int){
  def combine(other: Charge): Charge = {
    if(cc == other.cc){
      println("added ammount : " + other.amount + ", accumulated ammount : " + amount);
      Charge(cc, amount + other.amount);
    }else{
      throw new Exception("Can't combine charges to different card.");
    }
  }
}

class Payment() {
  def sendCharges(c: Charge){
    println("connect to payment system");
    println("send amount : " + c.amount);
  }
}

