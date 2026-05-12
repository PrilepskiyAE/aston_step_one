package homework_four;

public class DeadlockExemple {

   public static void invoke(){
         final Object resourceA = new Object();
         final Object resourceB = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("Поток 1: захватил ресурс A");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceB) {
                    System.out.println("Поток 1: захватил ресурс B");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("Поток 2: захватил ресурс B");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA) {
                    System.out.println("Поток 2: захватил ресурс A");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
