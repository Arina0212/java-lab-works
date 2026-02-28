package lab1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int num = scanner.nextInt();

        int first = num - 1;
        int second = num;
        int third = num + 1;
        int sum = first + second + third;
        int fourth = sum * sum;

        System.out.println("Числа: " + first + ", " + second + ", " + third);
        System.out.println("Квадрат суммы: " + fourth);

        scanner.close();
    }
}
