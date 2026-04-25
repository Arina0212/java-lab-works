package lab5;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Task3 {
    public static int[] commonElements(int[] a, int[] b) {
        Set<Integer> setB = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return Arrays.stream(a)
                .filter(setB::contains)
                .distinct()
                .toArray();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(commonElements(a, b)));
    }
}
