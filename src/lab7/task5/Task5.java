package lab7.task5;

import java.io.*;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String testPath = "src/lab7/task5/test_size.txt";
        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(testPath), "UTF-8"))) {
            for (int i = 1; i <= 20; i++) {
                pw.println("Строка номер " + i + " — тестовый файл для проверки размера.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка создания тестового файла: " + e.getMessage());
        }

        System.out.print("Введите путь к файлу (Enter — тестовый файл): ");
        String filePath = scanner.nextLine().trim();
        if (filePath.isEmpty()) {
            filePath = testPath;
        }

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Файл не найден: " + filePath);
        } else if (!file.isFile()) {
            System.out.println("Указанный путь — не файл: " + filePath);
        } else {
            long sizeBytes = file.length();
            double sizeKB  = sizeBytes / 1024.0;
            double sizeMB  = sizeKB   / 1024.0;

            System.out.println("\nИнформация о файле:");
            System.out.println("  Имя: "    + file.getName());
            System.out.println("  Путь: "   + file.getAbsolutePath());
            System.out.printf ("  Размер: %d байт (%.2f КБ / %.4f МБ)%n",
                    sizeBytes, sizeKB, sizeMB);
            System.out.println("  Доступен для чтения: " + file.canRead());
            System.out.println("  Доступен для записи: " + file.canWrite());
        }

        new File(testPath).delete();
        scanner.close();
    }
}
