import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int K;
    int[] levels;
    int left;
    int right;
    int res;

    private long getRequireExp(long value) {
        long sum = 0;
        for (int level : levels) {
            if (value > level) {
                sum += value - level;
            }
        }
        return sum;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        left = Integer.MAX_VALUE;
        levels = new int[N];
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
            left = Math.min(left, levels[i]);
        }

        right = left + K;
        res = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            long required = getRequireExp(mid);
            if (required <= K) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
