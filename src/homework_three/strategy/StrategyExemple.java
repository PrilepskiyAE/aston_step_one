package homework_three.strategy;

public class StrategyExemple {
    public static void invoke(){
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new PayPalPayment("alexey_prilepskiy@example.com"));
        cart.checkout(150.0);

        cart.setPaymentStrategy(new CreditCardPayment("1234567890123456", "123"));
        cart.checkout(200.0);
    }
}
