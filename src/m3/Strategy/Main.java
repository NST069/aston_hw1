package m3.Strategy;

public class Main {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(1000);

        cart.setPaymentStrategy(new CashPayment());
        cart.checkout(500);
    }
}
