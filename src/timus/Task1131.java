package timus;

import java.util.Scanner;

public class Task1131 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();

        long computers = 1;
        long hours = 0;

        while (computers < k && computers < n) {
            computers *= 2;
            hours++;
        }

        if (computers < n) {
            long remaining = n - computers;
            hours += (remaining + k - 1) / k;
        }

        System.out.println(hours);
    }

}
