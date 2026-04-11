package lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3_ByteSum {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество элементов массива byte: ");
            int size = scanner.nextInt();
            if (size <= 0) throw new IllegalArgumentException("Размер должен быть > 0");

            byte[] array = new byte[size];
            int sum = 0;

            System.out.println("Введите элементы (числа от -128 до 127):");
            for (int i = 0; i < size; i++) {
                try {
                    int input = scanner.nextInt();
                    if (input < Byte.MIN_VALUE || input > Byte.MAX_VALUE) {
                        throw new ArithmeticException("Значение " + input + " выходит за границы типа byte [-128, 127].");
                    }
                    array[i] = (byte) input;

                    int newSum = sum + array[i];
                    if (newSum < Byte.MIN_VALUE || newSum > Byte.MAX_VALUE) {
                        throw new ArithmeticException("Вычисление суммы привело к переполнению типа byte. Текущая сумма: " + newSum);
                    }
                    sum = newSum;

                } catch (InputMismatchException e) {
                    throw new IllegalArgumentException("Ошибка: введена строка вместо числа на позиции " + (i + 1));
                }
            }

            System.out.println("Сумма элементов массива (byte): " + (byte) sum);

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка ввода: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Ошибка диапазона чисел: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Общая ошибка: " + e.getMessage());
        }
    }
}
