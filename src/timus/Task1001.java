package timus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task1001 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Long> numbers = new ArrayList<>();
            while (scanner.hasNextLong()) {
                numbers.add(scanner.nextLong());
            }

            Collections.reverse(numbers);

            for (long num : numbers) {
                System.out.printf("%.4f%n", Math.sqrt(num));
            }
        } catch (Exception e) {
            System.err.println("Ошибка обработки данных");
        }
    }
}
