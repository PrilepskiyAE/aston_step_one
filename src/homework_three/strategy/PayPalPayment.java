package homework_three.strategy;

public class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Оплачено $" + amount + " через PayPal (аккаунт: " + email + ")");
    }
}
