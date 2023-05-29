import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] fib;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        fib = new int[32];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= 31; i++) fib[i] = fib[i - 2] + fib[i - 1];

        int res = N;

        while (true) {
            int temp = res;
            for (int i = 1; i <= 31; i++) {
                if (temp < fib[i]) {
                    temp = fib[i - 1];
                    break;
                }

            }
            if (temp == res) break;
            res -= temp;
        }

        if (N == res) sb.append(-1);
        else sb.append(res);

        System.out.println(sb);
    }
}
