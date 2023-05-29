import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int t, n;
    static long[] fib;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        fib = new long[68];
        fib[0] = 1;
        fib[1] = 1;
        fib[2] = 2;
        fib[3] = 4;

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            if (n < 4) {
                sb.append(fib[n]).append('\n');
                continue;
            }

            if (fib[n] == 0) {
                for (int j = 4; j <= n; j++) {
                    if (fib[j] == 0) {
                        fib[j] = fib[j - 4] + fib[j - 3] + fib[j - 2] + fib[j - 1];
                    }
                }
            }

            sb.append(fib[n]).append('\n');
        }

        System.out.print(sb);

    }
}
