package lab6;

import java.util.concurrent.*;

public class Task6 {
    public static void main(String[] args) throws Exception {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Сумма: " + sumParallel(array));
    }

    public static long sumParallel(int[] array) throws Exception {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        int chunkSize = (int) Math.ceil((double) array.length / cores);
        Future<Long>[] futures = new Future[cores];
        int idx = 0;

        for (int i = 0; i < cores; i++) {
            int start = idx;
            int end = Math.min(idx + chunkSize, array.length);
            if (start >= array.length) break;
            futures[i] = executor.submit(() -> {
                long sum = 0;
                for (int j = start; j < end; j++) sum += array[j];
                return sum;
            });
            idx = end;
        }

        long total = 0;
        for (Future<Long> f : futures) if (f != null) total += f.get();
        executor.shutdown();
        return total;
    }
}