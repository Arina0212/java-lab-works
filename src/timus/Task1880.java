package timus;

import java.util.*;

public class Task1880 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }
        }
        long count = freq.values().stream().filter(v -> v == 3).count();
        System.out.println(count);
    }
}
