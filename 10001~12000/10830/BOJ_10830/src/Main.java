import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1_000;
    static int N;
    static long B;
    static int[][] A;
    static int[][] res;

    static int[][] mul(int[][] a, int[][] b) {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[i][j] += a[i][k] * b[k][j];
                    temp[i][j] %= MOD;
                }
            }
        }

        return temp;
    }

    static int[][] pow(long exp) {
        if (exp == 1l) return A;

        int[][] temp = pow(exp / 2);

        temp = mul(temp, temp);

        if (exp % 2 == 1l) temp = mul(temp, A);

        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        A = new int[N][N];
        res = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) A[i][j] = Integer.parseInt(st.nextToken()) % MOD;
        }

        res = pow(B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) sb.append(res[i][j] + " ");
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
