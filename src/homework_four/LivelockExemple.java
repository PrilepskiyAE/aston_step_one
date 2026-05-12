package homework_four;

import java.util.concurrent.TimeUnit;

public class LivelockExemple {
    private static volatile boolean aliceCanEnter = true;
    private static volatile boolean bobCanEnter = true;

    public static void invoke(){

        Thread alice = new Thread(() -> {
            while (true) {
                if (bobCanEnter) {
                    System.out.println("Алиса: вижу, что Боб может войти, уступаю ему...");
                    aliceCanEnter = false;
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Алиса: Боб не может войти, я могу войти!");
                    aliceCanEnter = true; // Пытаемся снова
                }
            }
        });
        Thread bob = new Thread(() -> {
            while (true) {
                if (aliceCanEnter) {
                    System.out.println("Боб: вижу, что Алиса может войти, уступаю ей...");
                    bobCanEnter = false;
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Боб: Алиса не может войти, я могу войти!");
                    bobCanEnter = true; // Пытаемся снова
                }
            }
        });
        alice.start();
        bob.start();

    }
}
