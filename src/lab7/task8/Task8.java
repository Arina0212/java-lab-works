package lab7.task8;

import java.io.*;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "src/lab7/task8/student.ser";

        System.out.println("Введите данные студента:");

        System.out.print("  Имя: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Алексей Петров";

        System.out.print("  Возраст: ");
        int age = 20;
        try { age = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { /* оставляем значение по умолчанию */ }

        System.out.print("  Группа: ");
        String group = scanner.nextLine().trim();
        if (group.isEmpty()) group = "МП-101";

        System.out.print("  Средний балл (GPA): ");
        double gpa = 4.5;
        try { gpa = Double.parseDouble(scanner.nextLine().trim().replace(",", ".")); }
        catch (NumberFormatException e) { /* оставляем значение по умолчанию */ }

        Student student = new Student(name, age, group, gpa);
        System.out.println("\nСоздан объект: " + student);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(student);
            System.out.println("Объект сериализован в файл: " + filePath);
            System.out.println("Размер файла: " + new File(filePath).length() + " байт");
        } catch (Exception e) {
            System.out.println("Ошибка сериализации: " + e.getMessage());
        }

        System.out.println("\nВосстановление объекта из файла...");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Student restored = (Student) ois.readObject();
            System.out.println("Объект успешно восстановлен!");
            System.out.println("  Имя: "          + restored.getName());
            System.out.println("  Возраст: "      + restored.getAge());
            System.out.println("  Группа: "       + restored.getGroup());
            System.out.printf ("  Средний балл: %.2f%n", restored.getGpa());
            System.out.println("Полное представление: " + restored);
        } catch (Exception e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
        }

        new File(filePath).delete();
        scanner.close();
    }
}
