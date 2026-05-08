package timus;

import java.util.Scanner;

public class Task1014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println(10);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }

        StringBuilder digits = new StringBuilder();

        for (int d = 9; d >= 2; d--) {
            while (n % d == 0) {
                digits.append(d);
                n /= d;
            }
        }

        if (n > 1) {
            System.out.println(-1);
        } else {
            System.out.println(digits.reverse().toString());
        }

        scanner.close();
    }
}
