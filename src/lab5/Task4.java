package lab5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task4 {
    public static List<String> filterByUppercaseStart(List<String> list) {
        return list.stream()
                .filter(s -> s != null && !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "world", "Java", "");
        System.out.println(filterByUppercaseStart(words));
    }
}
