package lab6;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            final int num = i + 1;
            threads[i] = new Thread(() -> System.out.println("Поток №" + num + " выполнен"), "Worker-" + num);
            threads[i].start();
        }
        for (Thread t : threads) t.join();
    }
}