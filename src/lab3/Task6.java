package lab3;
import java.util.*;

public class Task6 {
    public static int arrayList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }
        return list.getFirst();
    }

    public static int linkedList(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }
        return list.getFirst();
    }

    public static void main(String[] args) {
        int n = 100000; // для замера времени
        long start = System.nanoTime();
        int res1 = arrayList(n);
        long timeAL = System.nanoTime() - start;
        start = System.nanoTime();
        int res2 = linkedList(n);
        long timeLL = System.nanoTime() - start;
        System.out.println("ArrayList: " + timeAL + " ns, результат " + res1);
        System.out.println("LinkedList: " + timeLL + " ns, результат " + res2);
    }
}
