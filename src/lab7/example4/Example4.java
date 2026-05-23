package lab7.example4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

public class Example4 {
    public static void main(String[] args) {
        String data = "Буферизованный ввод/вывод ускоряет работу с файлами. BufferedReader, BufferedWriter.";
        File file = new File("src/lab7/example4/example_file.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(data);
            bw.newLine();
            bw.write("Вторая строка данных.");
            System.out.println("Данные записаны в файл: " + file.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        System.out.println("Чтение файла построчно:");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNum = 1;
            while ((line = br.readLine()) != null) {
                System.out.println("  Строка " + lineNum + ": " + line);
                lineNum++;
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        if (file.delete()) {
            System.out.println("Файл удалён: " + file.getName());
        } else {
            System.out.println("Не удалось удалить файл.");
        }
    }
}
