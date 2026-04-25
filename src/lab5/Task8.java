package lab5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task8 {
    public static List<String> filterLongerThan(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s != null && s.length() > minLength)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("ok", "hello", "world", "a", "stream");
        System.out.println(filterLongerThan(words, 4));
    }
}
