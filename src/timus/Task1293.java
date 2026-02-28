package timus;

import java.io.PrintWriter;
import java.util.Scanner;

public class Task1293 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int result = a * b * c * 2;

        System.out.println(result);
        out.flush();
    }
}
