package timus;

import java.util.Scanner;

public class Task1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int total = 0;
        for (int weight : weights) {
            total += weight;
        }

        int minDiff = total;
        int totalMasks = 1 << n; // 2^n

        for (int mask = 0; mask < totalMasks; mask++) {
            int sum1 = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum1 += weights[i];
                }
            }

            int sum2 = total - sum1;
            int diff = Math.abs(sum1 - sum2);

            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        System.out.println(minDiff);
    }

}
