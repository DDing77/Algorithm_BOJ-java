import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T;
    static int n;
    static int m;
    static int a;
    static int b;

    public static int readInt() throws IOException {
        int c;
        int n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void solution() throws IOException {
        StringBuilder sb = new StringBuilder();

        T = readInt();
        while (T-- > 0) {
            n = readInt();
            m = readInt();

            int cnt = 0;

            for (int a = 1; a < n; a++) {
                for (int b = a + 1; b < n; b++) {
                    if (((a * a) + (b * b) + m) % (a * b) == 0) {
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
