package lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1_Average {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество элементов массива: ");
            int size = scanner.nextInt();
            if (size <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным.");
            }

            int[] array = new int[size];
            System.out.println("Введите элементы массива (целые числа):");

            int sum = 0;
            int count = 0;

            for (int i = 0; i < size; i++) {
                try {
                    array[i] = scanner.nextInt();
                    if (array[i] > 0) {
                        sum += array[i];
                        count++;
                    }
                } catch (InputMismatchException e) {
                    throw new IllegalArgumentException("Ошибка ввода: введена строка вместо числа на позиции " + (i + 1));
                }
            }

            if (count == 0) {
                throw new ArithmeticException("Положительные элементы отсутствуют. Среднее не может быть вычислено.");
            }

            double average = (double) sum / count;
            System.out.println("Среднее значение положительных элементов: " + average);

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Ошибка вычисления: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }
}
