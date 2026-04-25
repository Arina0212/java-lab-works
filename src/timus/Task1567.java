package timus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1567 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String slogan = scanner.nextLine();

        int cost = calculateCost(slogan);
        System.out.println(cost);
    }

    public static int calculateCost(String slogan) {
        Map<Character, Integer> keyMap = createKeyMap();

        return slogan.chars()
                .map(c -> keyMap.get((char) c))
                .sum();
    }

    private static Map<Character, Integer> createKeyMap() {
        Map<Character, Integer> map = new HashMap<>();

        map.put('a', 1); map.put('b', 2); map.put('c', 3);
        map.put('d', 1); map.put('e', 2); map.put('f', 3);
        map.put('g', 1); map.put('h', 2); map.put('i', 3);
        map.put('j', 1); map.put('k', 2); map.put('l', 3);
        map.put('m', 1); map.put('n', 2); map.put('o', 3);
        map.put('p', 1); map.put('q', 2); map.put('r', 3);
        map.put('s', 1); map.put('t', 2); map.put('u', 3);
        map.put('v', 1); map.put('w', 2); map.put('x', 3);
        map.put('y', 1); map.put('z', 2);
        map.put('.', 1); map.put(',', 2); map.put('!', 3);
        map.put(' ', 1);

        return map;
    }
}
