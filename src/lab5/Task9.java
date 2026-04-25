package lab5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task9 {
    public static List<Integer> filterGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 10, 15, 20);
        System.out.println(filterGreaterThan(nums, 10));
    }
}
