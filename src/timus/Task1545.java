package timus;

import java.util.Scanner;

public class Task1545 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        String[] syllables = new String[n];

        for (int i = 0; i < n; i++) {
            syllables[i] = scanner.nextLine();
        }

        String letter = scanner.nextLine();

        scanner.close();

        for (int i = 0; i < n; i++) {
            if (syllables[i].startsWith(letter)) {
                System.out.println(syllables[i]);
            }
        }
    }
}
