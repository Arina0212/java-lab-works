package lab7.example2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

public class Example2 {
    public static void main(String[] args) {
        String data = "Hello, Java IO! Байтовый поток.";
        File file = new File("src/lab7/example2/example_file.txt");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] bytes = data.getBytes("UTF-8");
            fos.write(bytes);
            System.out.println("Данные записаны в файл: " + file.getAbsolutePath());
            System.out.println("Записано байт: " + bytes.length);
        } catch (Exception e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[(int) file.length()];
            int bytesRead = fis.read(buffer);
            String result = new String(buffer, 0, bytesRead, "UTF-8");
            System.out.println("Данные прочитаны из файла: " + result);
            System.out.println("Прочитано байт: " + bytesRead);
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
