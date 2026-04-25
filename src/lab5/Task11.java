package lab5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task11 {
    public static List<Integer> filterLessThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n < threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 10, 15, 2);
        System.out.println(filterLessThan(nums, 10));
    }
}
