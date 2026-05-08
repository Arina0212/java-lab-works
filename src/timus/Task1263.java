package timus;
import java.util.Scanner;
import java.util.Locale;

public class Task1263 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] votes = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int candidate = scanner.nextInt();
            votes[candidate]++;
        }

        for (int i = 1; i <= n; i++) {
            double percent = (double) votes[i] / m * 100;
            System.out.printf(Locale.US, "%.2f%%\n", percent);
        }

        scanner.close();
    }
}
