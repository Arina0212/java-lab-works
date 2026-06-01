package timus;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1196 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] teacherList = new int[N];
        for (int i = 0; i < N; i++) {
            teacherList[i] = Integer.parseInt(reader.readLine());
        }

        int M = Integer.parseInt(reader.readLine());

        int count = 0;

        for (int i = 0; i < M; i++) {
            int year = Integer.parseInt(reader.readLine());
            if (binarySearch(teacherList, year)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
