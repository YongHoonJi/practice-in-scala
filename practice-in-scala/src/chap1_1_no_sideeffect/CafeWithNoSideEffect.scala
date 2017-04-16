package chap1_1_no_sideeffect

import chap1_1_nosideeffect.Cafe;
import chap1_1_nosideeffect.CreditCard;
import chap1_1_nosideeffect.Coffee;
import chap1_1_nosideeffect.Charge;
import chap1_1_nosideeffect.Payment;

object CafeWithNoSideEffect extends App {
  
  val myCreditCard = new CreditCard("Mark");
  
  def buyCoffee(cc: CreditCard): Charge = {
    val coffee = new Coffee(1000);
    val charge = new Charge(cc, coffee.price);
    charge;
  }
  
  def buyCoffees(cc: CreditCard, n: Int): Charge = {
    val purchases: List[Charge] = List.fill(n)(buyCoffee(cc));
    purchases.reduce((c1, c2) => c1.combine(c2))
  }
  
  val card = new CreditCard("Nick");
  val charges = buyCoffees(card, 10);
  
  val p = new Payment();
  p.sendCharges(charges);
}

