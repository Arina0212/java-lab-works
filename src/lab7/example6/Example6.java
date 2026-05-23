package lab7.example6;

import java.io.*;

public class Example6 {
    public static void main(String[] args) {
        String filePath = "src/lab7/example6/example_file.txt";

        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"))) {
            pw.println("Первая строка — PrintWriter очень удобен!");
            pw.println("Вторая строка — поддерживает разные типы данных:");
            pw.println("Целое число: " + 42);
            pw.println("Число с плавающей точкой: " + 3.14);
            pw.println("Логическое значение: " + true);
            pw.print("Строка без переноса ");
            pw.println("— продолжение в той же строке.");
            System.out.println("Данные записаны в файл: " + filePath);
        } catch (Exception e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        System.out.println("\nСодержимое файла:");
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        System.out.println("\nДемонстрация PrintWriter → System.out:");
        PrintWriter consolePw = new PrintWriter(System.out, true);
        consolePw.println("PrintWriter выводит в консоль быстрее, чем System.out.println()");
        consolePw.printf("Форматированный вывод: %s = %.2f%n", "Pi", Math.PI);

        new File(filePath).delete();
        System.out.println("Файл удалён.");
    }
}
