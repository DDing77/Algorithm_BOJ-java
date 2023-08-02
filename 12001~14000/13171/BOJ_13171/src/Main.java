import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    final int MOD = 1_000_000_007;
    long A;
    long X;
    long res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Long.parseLong(br.readLine());
        X = Long.parseLong(br.readLine());
        res = 1L;

        A %= MOD;

        while (X != 0) {
            if ((X & 1) == 1) {
                res = res * A % MOD;
            }

            X >>= 1;
            A = A * A % MOD;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
