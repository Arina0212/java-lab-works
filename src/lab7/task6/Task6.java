package lab7.task6;

import java.io.*;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String testPath = "src/lab7/task6/test_search.txt";
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(testPath), "UTF-8"))) {
            bw.write("Java — объектно-ориентированный язык программирования."); bw.newLine();
            bw.write("Потоки ввода/вывода — основа работы с файлами в Java."); bw.newLine();
            bw.write("Python также популярный язык программирования."); bw.newLine();
            bw.write("Java широко используется в enterprise-разработке."); bw.newLine();
            bw.write("Сериализация позволяет сохранять объекты Java в файл."); bw.newLine();
            bw.write("Это обычная строка без ключевого слова.");
            System.out.println("Тестовый файл создан: " + testPath);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.print("Введите путь к файлу (Enter — тестовый файл): ");
        String filePath = scanner.nextLine().trim();
        if (filePath.isEmpty()) filePath = testPath;

        System.out.print("Введите слово для поиска: ");
        String keyword = scanner.nextLine().trim();
        if (keyword.isEmpty()) keyword = "Java";

        System.out.println("\nПоиск слова \"" + keyword + "\" в файле: " + filePath);

        int matchCount = 0;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                lineNum++;
                if (line.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println("  Строка " + lineNum + ": " + line);
                    matchCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        if (matchCount == 0) {
            System.out.println("Слово \"" + keyword + "\" не найдено.");
        } else {
            System.out.println("Найдено совпадений: " + matchCount);
        }

        new File(testPath).delete();
        scanner.close();
    }
}
