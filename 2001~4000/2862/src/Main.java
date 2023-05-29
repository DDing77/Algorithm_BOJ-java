import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long N;
    static long[] fib;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Long.parseLong(br.readLine());

        fib = new long[75];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= 74; i++) fib[i] = fib[i - 2] + fib[i - 1];

        long res = N;

        while (true) {
            long temp = res;
            for (int i = 1; i <= 74; i++) {
                if (temp < fib[i]) {
                    temp = fib[i - 1];
                    break;
                }

            }
            if (temp == res) break;
            res -= temp;
        }

        if (N == res) sb.append(N);
        else sb.append(res);

        System.out.println(sb);
    }
}
