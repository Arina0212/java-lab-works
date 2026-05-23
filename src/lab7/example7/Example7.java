package lab7.example7;

import java.io.*;


public class Example7 {
    public static void main(String[] args) {
        String filePath = "src/lab7/example7/person.ser";

        Person person = new Person("Иван Иванов", 25, "ivan@example.com");
        System.out.println("Исходный объект: " + person);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(person);
            System.out.println("Объект сериализован в файл: " + filePath);
        } catch (Exception e) {
            System.out.println("Ошибка сериализации: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Person restoredPerson = (Person) ois.readObject();
            System.out.println("Объект восстановлен из файла: " + restoredPerson);
            System.out.println("  Имя: "    + restoredPerson.getName());
            System.out.println("  Возраст: " + restoredPerson.getAge());
            System.out.println("  Email: "  + restoredPerson.getEmail());
        } catch (Exception e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
        }

        new File(filePath).delete();
        System.out.println("Файл сериализации удалён.");
    }
}
