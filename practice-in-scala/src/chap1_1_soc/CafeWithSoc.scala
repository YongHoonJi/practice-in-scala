package chap1_1_soc

object CafeWithSoc extends App {
  val coffeeMenu = Cafe();
  val myCreditCard = new CreditCard("Mark");
  coffeeMenu.buyCoffee(myCreditCard, new RealPayment());
}
