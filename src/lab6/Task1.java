package lab6;

import java.time.LocalTime;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            long endTime = System.currentTimeMillis() + 10_000;
            while (System.currentTimeMillis() < endTime) {
                System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now());
                try { Thread.sleep(1000); }
                catch (InterruptedException e) { Thread.currentThread().interrupt(); break; }
            }
        };

        Thread t1 = new Thread(task, "Поток-1");
        Thread t2 = new Thread(task, "Поток-2");

        t1.start(); t2.start();
        t1.join();  t2.join();
    }
}
