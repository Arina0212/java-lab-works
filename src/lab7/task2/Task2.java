package lab7.task2;

import java.io.*;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "src/lab7/task2/output.txt";

        System.out.println("Введите текст для записи в файл (пустая строка — конец ввода):");
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            sb.append(line).append(System.lineSeparator());
        }
        String data = sb.toString();

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] bytes = data.getBytes("UTF-8");
            fos.write(bytes);
            System.out.println("Записано байт: " + bytes.length + " в файл: " + filePath);
        } catch (Exception e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[(int) file.length()];
            int bytesRead = fis.read(buffer);
            System.out.println("\nСодержимое файла:");
            System.out.println(new String(buffer, 0, bytesRead, "UTF-8"));
        } catch (Exception e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        file.delete();
        scanner.close();
    }
}
