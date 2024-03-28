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
    int M;
    int[] times;

    private long getCount(long mid) {

        long count = 0;
        for (int i = 0; i < M; i++) {
            count += mid / (long) times[i] + 1;
        }
        return count;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N <= M) {
            System.out.println(N);
            return;
        }

        times = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        long left = 0;
        long right = 2_000_000_000L * 30;
        while (left + 1 < right) {
            long mid = (left + right) >> 1;
            if (getCount(mid) >= N) {
                right = mid;
            } else {
                left = mid;
            }
        }

        long count = getCount(left);
        for (int i = 0; i < M; i++) {
            if (right % times[i] == 0) {
                count++;
            }
            if (count == N) {
                System.out.println((i + 1));
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
