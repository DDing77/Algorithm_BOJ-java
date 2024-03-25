import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    long M;
    long[] times;
    long answer;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        long left = 0L;
        long right = 0L;
        times = new long[(int) N];
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, times[i]);
        }

        Arrays.sort(times);

        right *= M;
        answer = right;
        while (left < right) {
            long mid = (left + right) >> 1;
            long sum = 0;

            for (long time : times) {
                if (sum >= M) {
                    break;
                }
                sum += (mid / time);
            }

            if (sum < M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
