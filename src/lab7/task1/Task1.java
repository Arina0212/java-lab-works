package lab7.task1;

import java.io.*;
import java.util.Scanner;


public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла для создания (без расширения): ");
        String fileName = scanner.nextLine().trim();
        if (fileName.isEmpty()) {
            fileName = "my_file";
        }

        File folder = new File("src/lab7/task1/my_folder");
        File file   = new File(folder, fileName + ".txt");

        if (folder.mkdirs()) {
            System.out.println("Папка создана: " + folder.getAbsolutePath());
        }

        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания файла: " + e.getMessage());
        }

        System.out.println("Имя файла: "  + file.getName());
        System.out.println("Размер: "      + file.length() + " байт");
        System.out.println("Путь: "        + file.getAbsolutePath());
        System.out.println("Это файл: "    + file.isFile());
        System.out.println("Это папка: "   + file.isDirectory());

        if (file.delete())   System.out.println("Файл удалён.");
        if (folder.delete()) System.out.println("Папка удалена.");

        scanner.close();
    }
}
