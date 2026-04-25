package lab5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task7 {
    public static List<Integer> filterDivisibleBy(List<Integer> numbers, int divisor) {
        if (divisor == 0) throw new IllegalArgumentException("Divisor cannot be zero");
        return numbers.stream()
                .filter(n -> n % divisor == 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 15, 20, 21, 30);
        System.out.println(filterDivisibleBy(nums, 3));
    }
}
