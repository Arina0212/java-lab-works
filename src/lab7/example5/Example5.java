package lab7.example5;

import java.io.*;

public class Example5 {
    public static void main(String[] args) {
        String inputPath  = "src/lab7/example5/input.txt";
        String outputPath = "src/lab7/example5/output.txt";

        try (FileOutputStream fos = new FileOutputStream(inputPath);
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write("hello world");
            bw.newLine();
            bw.write("это тестовая строка на русском");
            bw.newLine();
            bw.write("java io streams example");
            System.out.println("Входной файл создан: " + inputPath);
        } catch (Exception e) {
            System.out.println("Ошибка создания входного файла: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(inputPath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr);
             FileOutputStream fos = new FileOutputStream(outputPath);
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             BufferedWriter bw = new BufferedWriter(osw)) {

            String line;
            while ((line = br.readLine()) != null) {
                String upperLine = line.toUpperCase();
                bw.write(upperLine);
                bw.newLine();
            }
            System.out.println("Данные преобразованы и записаны в: " + outputPath);
        } catch (Exception e) {
            System.out.println("Ошибка обработки: " + e.getMessage());
        }

        System.out.println("Содержимое output.txt:");
        try (FileInputStream fis = new FileInputStream(outputPath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        new File(inputPath).delete();
        new File(outputPath).delete();
        System.out.println("Временные файлы удалены.");
    }
}
