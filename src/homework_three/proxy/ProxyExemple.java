package homework_three.proxy;

public class ProxyExemple {
    public static void invoke(){
        System.out.println("=== ТЕСТ БАНКОВСКОГО ПРОКСИ ===");

        BankAccount authorizedAccount = new SecureBankAccountProxy(true);
        BankAccount unauthorizedAccount = new SecureBankAccountProxy(false);

        System.out.println("\n--- Работа авторизованного пользователя ---");
        authorizedAccount.deposit(1000);
        authorizedAccount.withdraw(300);
        System.out.println("Баланс: $" + authorizedAccount.getBalance());

        System.out.println("\n--- Работа неавторизованного пользователя ---");
        unauthorizedAccount.deposit(500);
        unauthorizedAccount.withdraw(100);
        System.out.println("Баланс: $" + unauthorizedAccount.getBalance());

        System.out.println("\n--- Дополнительная проверка авторизованного ---");
        authorizedAccount.withdraw(800);
        System.out.println("Финальный баланс: $" + authorizedAccount.getBalance());
    }
}
