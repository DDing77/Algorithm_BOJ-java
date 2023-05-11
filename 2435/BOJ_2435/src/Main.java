import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int K;
    private int[] prefixSum;
    private int max;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        prefixSum = new int[N + 1];

        max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] += prefixSum[i - 1] + Integer.parseInt(st.nextToken());
            if (i >= K) {
                max = Math.max(max, prefixSum[i] - prefixSum[i - K]);
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

