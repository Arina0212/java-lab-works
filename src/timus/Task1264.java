package timus;

import java.util.Scanner;

public class Task1264 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(n * (m + 1));
        scanner.close();
    }
}
