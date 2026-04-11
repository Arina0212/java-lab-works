package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Task1785 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);

        int n = Integer.parseInt(in.readLine().trim());

        if (n >= 1 && n <= 4) {
            out.println("few");
        } else if (n >= 5 && n <= 9) {
            out.println("several");
        } else if (n >= 10 && n <= 19) {
            out.println("pack");
        } else if (n >= 20 && n <= 49) {
            out.println("lots");
        } else if (n >= 50 && n <= 99) {
            out.println("horde");
        } else if (n >= 100 && n <= 249) {
            out.println("throng");
        } else if (n >= 250 && n <= 499) {
            out.println("swarm");
        } else if (n >= 500 && n <= 999) {
            out.println("zounds");
        } else if (n >= 1000) {
            out.println("legion");
        }

        in.close();
        out.close();
    }
}
