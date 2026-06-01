package lab8.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;


public class JsonCreator {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONArray lessons = new JSONArray();
        lessons.add(makeLesson("Математический анализ",   "Иванов Иван Иванович",       "1", "5"));
        lessons.add(makeLesson("Линейная алгебра",         "Петрова Мария Сергеевна",    "1", "4"));
        lessons.add(makeLesson("Программирование на Java", "Сидоров Алексей Николаевич", "2", "6"));
        lessons.add(makeLesson("Базы данных",              "Козлова Елена Дмитриевна",   "3", "5"));
        lessons.add(makeLesson("Операционные системы",     "Новиков Сергей Павлович",    "3", "4"));

        JSONObject root = new JSONObject();
        root.put("lessons", lessons);

        try (FileWriter writer = new FileWriter("src/lab8/json/example.json")) {
            writer.write(root.toJSONString());
            System.out.println("JSON-файл успешно создан: src/lab8/json/example.json");
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    static JSONObject makeLesson(String name, String teacher, String semester, String units) {
        JSONObject lesson = new JSONObject();
        lesson.put("name",     name);
        lesson.put("teacher",  teacher);
        lesson.put("semester", semester);
        lesson.put("units",  units);
        return lesson;
    }
}
