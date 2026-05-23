package lab7.task4;

import java.io.*;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String srcPath = "src/lab7/task4/source.txt";
        String dstPath = "src/lab7/task4/copy.txt";

        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(srcPath), "UTF-8"))) {
            bw.write("Это содержимое исходного файла.");
            bw.newLine();
            bw.write("Строка вторая.");
            bw.newLine();
            bw.write("Строка третья — конец файла.");
            System.out.println("Исходный файл создан: " + srcPath);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.print("Источник (Enter — тестовый файл): ");
        String inputSrc = scanner.nextLine().trim();
        if (!inputSrc.isEmpty()) srcPath = inputSrc;

        System.out.print("Копия (Enter — copy.txt): ");
        String inputDst = scanner.nextLine().trim();
        if (!inputDst.isEmpty()) dstPath = inputDst;

        long bytesCopied = 0;
        try (BufferedInputStream bis  = new BufferedInputStream(new FileInputStream(srcPath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dstPath))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
                bytesCopied += bytesRead;
            }
            System.out.println("Файл скопирован: " + srcPath + " → " + dstPath);
            System.out.println("Скопировано байт: " + bytesCopied);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка копирования: " + e.getMessage());
        }

        System.out.println("\nСодержимое скопированного файла:");
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(dstPath), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        new File(srcPath).delete();
        new File(dstPath).delete();
        scanner.close();
    }
}
