package timus;

import java.util.Scanner;

public class Task1068 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n > 0) {
            System.out.println(n * (n + 1) / 2);
        } else {
            int sum = 0;
            for (int i = n; i <= 1; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
        scanner.close();
    }
}
