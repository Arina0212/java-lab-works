package lab5;

import java.util.Arrays;

public class Task2 {
    public static int[] filterEvenNumbers(int[] array) {
        return Arrays.stream(array)
                .filter(n -> n % 2 == 0)
                .toArray();
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6};
        int[] result = filterEvenNumbers(input);
        System.out.println(Arrays.toString(result));
    }
}
