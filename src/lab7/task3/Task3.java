package lab7.task3;

import java.io.*;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String testFile = "src/lab7/task3/test_lines.txt";

        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(testFile), "UTF-8"))) {
            bw.write("Первая строка файла");  bw.newLine();
            bw.write("Вторая строка файла"); bw.newLine();
            bw.write("Третья строка файла"); bw.newLine();
            bw.write("Четвёртая строка");    bw.newLine();
            bw.write("Пятая строка — последняя");
            System.out.println("Тестовый файл создан: " + testFile);
        } catch (Exception e) {
            System.out.println("Ошибка создания файла: " + e.getMessage());
        }

        System.out.print("\nВведите путь к файлу (Enter — использовать тестовый файл): ");
        String inputPath = scanner.nextLine().trim();
        if (inputPath.isEmpty()) {
            inputPath = testFile;
        }

        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputPath), "UTF-8"))) {
            while (br.readLine() != null) {
                lineCount++;
            }
            System.out.println("Файл: " + inputPath);
            System.out.println("Количество строк: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + inputPath);
        } catch (Exception e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        new File(testFile).delete();
        scanner.close();
    }
}
