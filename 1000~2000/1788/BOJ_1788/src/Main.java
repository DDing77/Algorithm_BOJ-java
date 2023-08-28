import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    final int MOD = 1_000_000_000;
    int N;
    int res;
    int[] fib;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        if (N == 0) {
            sb.append(0).append('\n').append(0);
            System.out.println(sb);
            return;
        }

        boolean isMinus = false;
        if (N < 0) {
            isMinus = true;
            N = Math.abs(N);
        }

        boolean isEven = false;
        if (N % 2 == 0) {
            isEven = true;
        }

        fib = new int[N + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= N; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
        }

        if (isEven && isMinus) {
            sb.append(-1);
        } else {
            sb.append(1);
        }
        sb.append('\n');

        sb.append(fib[N] % MOD);

        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}