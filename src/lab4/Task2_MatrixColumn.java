package lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2_MatrixColumn {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            System.out.println("Исходная матрица:");
            for (int[] row : matrix) {
                for (int val : row) {
                    System.out.print(val + "\t");
                }
                System.out.println();
            }

            System.out.print("Введите номер столбца для вывода (начиная с 1): ");
            int column;
            try {
                column = scanner.nextInt();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Ошибка: введена строка вместо числа.");
            }

            if (column < 1 || column > matrix[0].length) {
                throw new ArrayIndexOutOfBoundsException("Столбец с номером " + column + " не существует.");
            }

            System.out.println("Столбец " + column + ":");
            for (int[] ints : matrix) {
                System.out.println(ints[column - 1]);
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка ввода: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка диапазона: " + e.getMessage());
        }
    }
}