package m3.Strategy;

public class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Оплата " + amount + " картой");
    }
}
