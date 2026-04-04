package lab3;
import java.util.Scanner;

public class BinaryRecursion {
    public static String toBinary(int n) {
        if (n == 0) return "";
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int num = sc.nextInt();
        String binary = num == 0 ? "0" : toBinary(num);
        System.out.println("Двоичное представление: " + binary);
    }
}