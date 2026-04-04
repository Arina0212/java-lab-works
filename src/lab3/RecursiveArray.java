package lab3;
import java.util.Scanner;

public class RecursiveArray {
    static Scanner sc = new Scanner(System.in);

    public static void inputArray(int[] arr, int index) {
        if (index == arr.length) return;
        System.out.print("arr[" + index + "] = ");
        arr[index] = sc.nextInt();
        inputArray(arr, index + 1);
    }

    public static void outputArray(int[] arr, int index) {
        if (index == arr.length) return;
        System.out.print(arr[index] + " ");
        outputArray(arr, index + 1);
    }

    public static void main(String[] args) {
        System.out.print("Размер массива: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        inputArray(arr, 0);
        System.out.print("Массив: ");
        outputArray(arr, 0);
    }
}
