import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1_000_000_007;
    static long N;
    static long[][] A = {{1, 1}, {1, 0}};
    static long[][] res;

    static long[][] mul(long[][] a, long[][] b) {
        long[][] temp = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    temp[i][j] += a[i][k] * b[k][j];
                    temp[i][j] %= MOD;
                }
            }
        }

        return temp;
    }

    static long[][] pow(long exp) {
        if (exp == 1l || exp == 0) return A;

        long[][] temp = pow(exp / 2);

        temp = mul(temp, temp);

        if (exp % 2 == 1l) temp = mul(temp, A);

        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());

        res = pow(N - 1);

        System.out.print(res[0][0]);
    }
}
