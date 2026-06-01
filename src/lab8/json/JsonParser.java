package lab8.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class JsonParser {

    private static final String FILE_PATH = "src/lab8/json/example.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nJSON Парсер. Предметы университета");
            System.out.println("1. Показать все предметы");
            System.out.println("2. Поиск по преподавателю");
            System.out.println("3. Добавить предмет");
            System.out.println("4. Удалить предмет по названию");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine().trim();
            if      (choice.equals("1")) showAll();
            else if (choice.equals("2")) searchByTeacher(scanner);
            else if (choice.equals("3")) addLesson(scanner);
            else if (choice.equals("4")) deleteLesson(scanner);
            else if (choice.equals("0")) running = false;
            else System.out.println("Неверный выбор.");
        }
        System.out.println("Выход.");
    }

    @SuppressWarnings("unchecked")
    private static JSONObject loadData() throws IOException, ParseException {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return (JSONObject) new JSONParser().parse(reader);
        }
    }

    private static void saveData(JSONObject root) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(root.toJSONString());
        }
    }

    @SuppressWarnings("unchecked")
    private static JSONArray getLessons(JSONObject root) {
        return (JSONArray) root.get("lessons");
    }

    private static void printLesson(JSONObject l) {
        System.out.printf("  Предмет: %-30s Преподаватель: %-30s Семестр: %-3s Зач. ед.: %s%n",
                l.get("name"), l.get("teacher"), l.get("semester"), l.get("units"));
    }

    private static void showAll() {
        try {
            JSONArray lessons = getLessons(loadData());
            System.out.println("\nВсе предметы (" + lessons.size() + "):");
            for (Object obj : lessons) {
                printLesson((JSONObject) obj);
            }
        } catch (Exception e) {
            System.err.println("Ошибка чтения: " + e.getMessage());
        }
    }

    private static void searchByTeacher(Scanner scanner) {
        System.out.print("Введите фамилию/имя преподавателя: ");
        String query = scanner.nextLine().trim().toLowerCase();
        try {
            JSONArray lessons = getLessons(loadData());
            int count = 0;
            for (Object obj : lessons) {
                JSONObject l = (JSONObject) obj;
                String teacher = ((String) l.get("teacher")).toLowerCase();
                if (teacher.contains(query)) {
                    printLesson(l);
                    count++;
                }
            }
            if (count == 0) System.out.println("Предметы не найдены.");
            else System.out.println("Найдено: " + count);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void addLesson(Scanner scanner) {
        System.out.print("Название предмета: ");
        String name = scanner.nextLine().trim();
        System.out.print("Преподаватель: ");
        String teacher = scanner.nextLine().trim();
        System.out.print("Семестр: ");
        String semester = scanner.nextLine().trim();
        System.out.print("Зач. ед.: ");
        String units = scanner.nextLine().trim();
        try {
            JSONObject root = loadData();
            getLessons(root).add(JsonCreator.makeLesson(name, teacher, semester, units));
            saveData(root);
            System.out.println("Предмет \"" + name + "\" добавлен.");
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void deleteLesson(Scanner scanner) {
        System.out.print("Название предмета для удаления: ");
        String nameToDelete = scanner.nextLine().trim();
        try {
            JSONObject root = loadData();
            JSONArray lessons = getLessons(root);
            int before = lessons.size();
            Iterator<?> it = lessons.iterator();
            while (it.hasNext()) {
                JSONObject l = (JSONObject) it.next();
                if (nameToDelete.equalsIgnoreCase((String) l.get("name"))) {
                    it.remove();
                }
            }
            int removed = before - lessons.size();
            if (removed == 0) {
                System.out.println("Предмет \"" + nameToDelete + "\" не найден.");
            } else {
                saveData(root);
                System.out.println("Удалено записей: " + removed);
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
