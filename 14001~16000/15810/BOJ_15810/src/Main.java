import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int[] requiredTimes;
    long left;
    long right;

    private void solution() {
        long mid;
        while (left < right) {
            mid = (left + right) >> 1;
            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += mid / requiredTimes[i];
            }

            if (cnt >= M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        left = 0;
        right = Integer.MIN_VALUE;
        requiredTimes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            requiredTimes[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, requiredTimes[i]);
        }
        right *= M;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
