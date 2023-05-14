import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private final String message = "Go away!";
    private int N;
    private int M;
    private long[] prefixSum;

    public int lowerBound(long target) {
        int left = 1;
        int right = M + 1;
        int mid;

        while (left < right) {
            mid = left + right >> 1;

            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prefixSum = new long[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            prefixSum[i] += prefixSum[i - 1] + Long.parseLong(st.nextToken());
        }

        int lowerIdx;
        while (N-- > 0) {
            lowerIdx = lowerBound(Long.parseLong(br.readLine()));
            if (lowerIdx > M) {
                sb.append(message);
            } else {
                sb.append(lowerIdx);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}