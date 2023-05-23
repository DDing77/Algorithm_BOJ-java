import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long[] prefixSum;
    static long res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        prefixSum = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        res = 0L;
        for (int i = 2; i < N; i++) {
            res = Math.max(res, (prefixSum[i] - prefixSum[1]) + (prefixSum[N - 1] - prefixSum[i - 1]));
        }

        for (int i = 2; i < N; i++) {
            res = Math.max(res, (prefixSum[N] - prefixSum[1] - (prefixSum[i] - prefixSum[i - 1])) + (prefixSum[N] - prefixSum[i]));
        }

        for (int i = 2; i < N; i++) {
            res = Math.max(res, (prefixSum[i - 1]) + (prefixSum[N - 1] - (prefixSum[i] - prefixSum[i - 1])));
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
