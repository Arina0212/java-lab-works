package timus;

import java.util.Scanner;

public class Task1197 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dx = {2,2,-2,-2,1,1,-1,-1};
        int[] dy = {1,-1,1,-1,2,-2,2,-2};
        for (int i = 0; i < n; i++) {
            String pos = sc.next();
            int x = pos.charAt(0) - 'a' + 1;
            int y = pos.charAt(1) - '0';
            int count = 0;
            for (int j = 0; j < 8; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) count++;
            }
            System.out.println(count);
        }
    }
}