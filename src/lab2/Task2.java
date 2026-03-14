package lab2;

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        int value = 1;

        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 5; j++) {
                    matrix[i][j] = value++;
                }
            } else {
                for (int j = 4; j >= 0; j--) {
                    matrix[i][j] = value++;
                }
            }
        }

        System.out.println("Массив, заполненный змейкой:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
