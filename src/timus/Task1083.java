package timus;
import java.util.Scanner;

public class Task1083 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int spaceIndex = line.indexOf(' ');
        int n = Integer.parseInt(line.substring(0, spaceIndex));
        int k = line.substring(spaceIndex + 1).length();

        int result = 1;
        for (int i = n; i > 0; i -= k) {
            result *= i;
        }

        System.out.println(result);
    }
}