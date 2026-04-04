package lab3;
import java.util.*;

public class HashMapTask {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, "str" + i);
        }

        System.out.print("Ключи > 5: ");
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getKey() > 5) System.out.print(e.getValue() + " ");
        }

        if (map.containsKey(0)) {
            System.out.println("\nСтроки через запятую: " + String.join(",", map.values()));
        }

        long product = 1;
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getValue().length() > 5) product *= e.getKey();
        }
        System.out.println("Произведение ключей (длина строки > 5): " + product);
    }
}
