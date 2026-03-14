package timus;

import java.util.Scanner;

public class Task1787 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        int remaining = 0;
        for (int i = 0; i < n; i++) {
            int cars = scanner.nextInt();
            remaining = remaining + cars - k;
            if (remaining < 0) {
                remaining = 0;
            }
        }

        System.out.println(remaining);
    }
}
