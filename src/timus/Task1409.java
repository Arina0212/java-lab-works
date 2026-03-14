package timus;

import java.util.Scanner;

public class Task1409 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int harry = scanner.nextInt();
        int larry = scanner.nextInt();
        int total = harry + larry - 1;
        System.out.println((total - harry) + " " + (total - larry));
    }
}
