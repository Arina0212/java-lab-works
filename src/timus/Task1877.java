package timus;

import java.util.Scanner;

public class Task1877 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int code1 = scanner.nextInt();
        int code2 = scanner.nextInt();

        if (code1 % 2 == 0 || code2 % 2 != 0) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
