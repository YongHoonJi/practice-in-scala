package chap1_1_sideeffect

object CafeWithSideEffectExample extends App {
  val coffeeMenu = Cafe(Coffee(1000));
  val myCreditCard = new CreditCard();
  coffeeMenu.buyCoffee(myCreditCard);
}