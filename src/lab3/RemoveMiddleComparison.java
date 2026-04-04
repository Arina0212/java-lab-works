package lab3;

import java.util.*;

public class RemoveMiddleComparison {
    private static final int N = 6_000_000;

    public static void main(String[] args) {
        // 1. ArrayList
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) arrayList.add(i);
        long start = System.nanoTime();
        arrayList.remove(N / 2);
        long timeArrayList = System.nanoTime() - start;

        // 2. LinkedList
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < N; i++) linkedList.add(i);
        start = System.nanoTime();
        linkedList.remove(N / 2);
        long timeLinkedList = System.nanoTime() - start;

        // 3. LinkedHashMap
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) linkedHashMap.put(i, "val" + i);
        start = System.nanoTime();
        linkedHashMap.remove(N / 2);
        long timeLinkedHashMap = System.nanoTime() - start;

        // Вывод таблицы
        System.out.println("Таблица. Время удаления элемента из середины (нс)");
        System.out.printf("%-15s %-20s\n", "Коллекция", "время удаления из середины");
        System.out.printf("%-15s %-20d\n", "ArrayList", timeArrayList);
        System.out.printf("%-15s %-20d\n", "LinkedList", timeLinkedList);
        System.out.printf("%-15s %-20d\n", "LinkedHashMap", timeLinkedHashMap);
    }
}