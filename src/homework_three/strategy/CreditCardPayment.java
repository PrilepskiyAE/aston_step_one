package homework_three.strategy;

public class CreditCardPayment  implements PaymentStrategy {
    private final String cardNumber;
    private final String cvv;

    public CreditCardPayment(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Оплачено $" + amount + " с карты " + cardNumber.substring(12));
    }
}
