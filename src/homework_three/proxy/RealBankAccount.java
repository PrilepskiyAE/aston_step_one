package homework_three.proxy;

public class RealBankAccount implements BankAccount {
    private double balance;

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Пополнено на: $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Снято: $" + amount);
        } else {
            System.out.println("Недостаточно средств!");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

