import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    long K;
    long[] total;
    long[] patty;

    private long recur(int level, long idx) {

        if (level == 0) {
            if (idx == 1) {
                return 1L;
            }
            return 0L;
        }

        if (idx == 0) {
            return 0L;
        }

        if (idx == total[level]) {
            return patty[level];
        } else if (idx == total[level - 1] + 2) {
            return patty[level - 1] + 1;
        } else if (idx < total[level - 1] + 2) {
            return recur(level - 1, idx - 1);
        } else {
            return patty[level - 1] + 1 + recur(level - 1, idx - total[level - 1] - 2);
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        total = new long[N + 1];
        patty = new long[N + 1];
        total[0] = 1L;
        patty[0] = 1L;
        for (int i = 1; i <= N; i++) {
            total[i] = total[i - 1] * 2 + 3;
            patty[i] = patty[i - 1] * 2 + 1;
        }

        System.out.println(recur(N, K));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
