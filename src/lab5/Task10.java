package lab5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task10 {
    public static List<String> filterOnlyLetters(List<String> list) {
        return list.stream()
                .filter(s -> s != null && !s.isEmpty() && s.chars().allMatch(Character::isLetter))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "123abc", "World", "Java8", "Pure");
        System.out.println(filterOnlyLetters(words));
    }
}
