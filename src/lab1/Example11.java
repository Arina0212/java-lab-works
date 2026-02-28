package lab1;

import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentYear = java.time.Year.now().getValue();

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите год рождения: ");
        int birthYear = scanner.nextInt();

        int age = currentYear - birthYear;
        System.out.println(name + ", ваш возраст: " + age + " лет");

        scanner.close();
    }
}
