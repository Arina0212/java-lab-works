package lab7.task7;

import java.io.*;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла для записи: ");
        String fileName = scanner.nextLine().trim();
        if (fileName.isEmpty()) fileName = "user_output.txt";
        if (!fileName.endsWith(".txt")) fileName += ".txt";

        String filePath = "src/lab7/task7/" + fileName;

        System.out.println("Введите текст для записи (пустая строка — завершить):");
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            sb.append(line).append(System.lineSeparator());
        }
        String text = sb.toString();

        int charCount = 0;
        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"))) {
            pw.print(text);
            charCount = text.length();
            System.out.println("\nТекст записан в файл: " + filePath);
            System.out.println("Количество записанных символов: " + charCount);
        } catch (Exception e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        System.out.println("\nСодержимое файла \"" + fileName + "\":");
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
                System.out.println("  " + fileLine);
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        new File(filePath).delete();
        scanner.close();
    }
}
