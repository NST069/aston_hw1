package m3.Strategy;

public class CashPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Оплата " + amount + " наличными");
    }
}