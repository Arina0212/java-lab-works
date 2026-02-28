package lab1;

import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentYear = java.time.Year.now().getValue();

        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        int birthYear = currentYear - age;
        System.out.println("Год вашего рождения: " + birthYear);

        scanner.close();
    }
}
