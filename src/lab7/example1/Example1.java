package lab7.example1;

import java.io.File;

public class Example1 {
    public static void main(String[] args) {
        File folder = new File("src/lab7/example1/example_folder");

        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Папка создана: " + folder.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать папку.");
            }
        } else {
            System.out.println("Папка уже существует: " + folder.getAbsolutePath());
        }

        File file = new File(folder, "example_file.txt");
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Файл создан: " + file.getAbsolutePath());
                } else {
                    System.out.println("Не удалось создать файл.");
                }
            } else {
                System.out.println("Файл уже существует: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }

        System.out.println("Имя файла: " + file.getName());
        System.out.println("Размер файла: " + file.length() + " байт");
        System.out.println("Файл доступен для чтения: " + file.canRead());
        System.out.println("Файл доступен для записи: " + file.canWrite());

        if (file.delete()) {
            System.out.println("Файл удалён: " + file.getName());
        } else {
            System.out.println("Не удалось удалить файл.");
        }

        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getName());
        } else {
            System.out.println("Не удалось удалить папку.");
        }
    }
}
