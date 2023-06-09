import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int n;
    static int[] num;
    static double res;


    public static int readInt() throws IOException {
        int c;
        int n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void solution() throws IOException {
        n = readInt();
        num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = readInt();
        }

        Arrays.sort(num);

        int start = (int) Math.round(n * 0.15);

        res = 0.0;

        for (int i = start; i < n - start; i++) {
            res += num[i];
        }

        System.out.println((int) Math.round(res / (n - start * 2)));
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}