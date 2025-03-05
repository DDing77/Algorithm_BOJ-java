import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private int[] scores;
    private int res;

    private boolean check(int mid) {
        int groutCnt = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += scores[i];
            if (sum >= mid) {
                groutCnt++;
                sum = 0;
            }
        }

        if (groutCnt >= K) {
            return true;
        } else {
            return false;
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int left = Integer.MAX_VALUE;
        int right = 1;

        scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            left = Math.min(left, scores[i]);
            right += scores[i];
        }

        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
