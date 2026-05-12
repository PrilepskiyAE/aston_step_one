package homework_four;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class AlertOutput {
    private static final Semaphore semaphore1 = new Semaphore(1);
    private static final Semaphore semaphore2 = new Semaphore(0);

    public static void invoke(){

        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    semaphore1.acquire();
                    System.out.println("1");
                    semaphore2.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    semaphore2.acquire();
                    System.out.println("2");
                    semaphore1.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        thread1.start();
        thread2.start();
    }

}
