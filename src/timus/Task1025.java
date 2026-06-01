package timus;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task1025 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(reader.readLine());

        String[] parts = reader.readLine().split(" ");
        int[] groups = new int[K];
        for (int i = 0; i < K; i++) {
            groups[i] = Integer.parseInt(parts[i]);
        }

        int[] thresholds = new int[K];
        for (int i = 0; i < K; i++) {
            thresholds[i] = (groups[i] + 1) / 2;
        }

        Arrays.sort(thresholds);

        int requiredGroups = (K + 1) / 2;

        int result = 0;
        for (int i = 0; i < requiredGroups; i++) {
            result += thresholds[i];
        }

        System.out.println(result);
    }

}
