package lab6;

import java.util.concurrent.*;

public class Task5 {
    public static void main(String[] args) throws Exception {
        int[] array = {12, 45, 7, 89, 23, 56, 90, 34, 67, 11, 3, 99};
        System.out.println("Максимум: " + findMaxParallel(array));
    }

    public static int findMaxParallel(int[] array) throws Exception {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        int chunkSize = (int) Math.ceil((double) array.length / cores);
        Future<Integer>[] futures = new Future[cores];
        int idx = 0;

        for (int i = 0; i < cores; i++) {
            int start = idx;
            int end = Math.min(idx + chunkSize, array.length);
            if (start >= array.length) break;
            futures[i] = executor.submit(() -> {
                int max = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) if (array[j] > max) max = array[j];
                return max;
            });
            idx = end;
        }

        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> f : futures) {
            if (f != null) globalMax = Math.max(globalMax, f.get());
        }
        executor.shutdown();
        return globalMax;
    }
}
