package lab6;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        NumberPrinter printer = new NumberPrinter();
        Thread even = new Thread(printer::printEven, "Чётный");
        Thread odd  = new Thread(printer::printOdd,  "Нечётный");

        even.start(); odd.start();
        even.join();  odd.join();
    }
}

class NumberPrinter {
    private int current = 1;
    private final int max = 10;
    private final Object lock = new Object();

    void printEven() {
        synchronized (lock) {
            while (current <= max) {
                while (current % 2 != 0) {
                    try { lock.wait(); } catch (InterruptedException e) { return; }
                }
                System.out.println(Thread.currentThread().getName() + ": " + current);
                current++;
                lock.notifyAll();
            }
        }
    }

    void printOdd() {
        synchronized (lock) {
            while (current <= max) {
                while (current % 2 == 0) {
                    try { lock.wait(); } catch (InterruptedException e) { return; }
                }
                System.out.println(Thread.currentThread().getName() + ": " + current);
                current++;
                lock.notifyAll();
            }
        }
    }
}
