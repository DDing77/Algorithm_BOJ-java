import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N, K;
    private int[] sums;
    private int res;


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sums[i] = sums[i - 1] + Integer.parseInt(st.nextToken());
        }

        res = Integer.MIN_VALUE;
        for (int i = 1; i <= N - K + 1; i++) {
            res = Math.max(res, sums[i + K - 1] - sums[i - 1]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
