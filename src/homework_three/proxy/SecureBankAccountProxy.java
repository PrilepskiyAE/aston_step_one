package homework_three.proxy;

public class SecureBankAccountProxy implements BankAccount {
    private RealBankAccount realAccount;
    private boolean isAuthorized;

    public SecureBankAccountProxy(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    @Override
    public void deposit(double amount) {
        if (isAuthorized) {
            if (realAccount == null) realAccount = new RealBankAccount();
            realAccount.deposit(amount);
        } else {
            System.out.println("❌ Доступ запрещён: недостаточно прав");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (isAuthorized) {
            if (realAccount == null) realAccount = new RealBankAccount();
            realAccount.withdraw(amount);
        } else {
            System.out.println("❌ Доступ запрещён: недостаточно прав");
        }
    }

    @Override
    public double getBalance() {
        if (isAuthorized && realAccount != null) {
            return realAccount.getBalance();
        } else {
            System.out.println("❌ Доступ запрещён: недостаточно прав");
            return 0;
        }
    }
}
