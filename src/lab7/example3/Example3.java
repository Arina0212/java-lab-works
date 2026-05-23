package lab7.example3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

public class Example3 {
    public static void main(String[] args) {
        String data = "Привет, символьные потоки Java! FileReader и FileWriter.";
        File file = new File("src/lab7/example3/example_file.txt");

        try (FileWriter fw = new FileWriter(file)) {
            fw.write(data);
            System.out.println("Данные записаны в файл: " + file.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        try (FileReader fr = new FileReader(file)) {
            char[] buffer = new char[(int) file.length()];
            int charsRead = fr.read(buffer);
            String result = new String(buffer, 0, charsRead);
            System.out.println("Данные прочитаны из файла: " + result);
            System.out.println("Прочитано символов: " + charsRead);
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
