import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int MOD = 1_000_000;

    int N;
    int[] size;
    int[] disc;
    int[] cnt;
    int res;

    private void makeCnt() {
        cnt = new int[N];
        cnt[0] = 1;
        for (int i = 1; i < N; i++) {
            cnt[i] = cnt[i - 1] * 2 % MOD;
        }
    }

    private void execHanoi(int N, int to) {
        if (N == 0) {
            return;
        }

        int now = disc[N];

        if (to == now) {
            execHanoi(N - 1, to);
        } else {
            to = 6 - (now + to);
            res += cnt[N - 1];
            res %= MOD;
            execHanoi(N - 1, to);
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        size = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        disc = new int[N + 1];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size[i]; j++) {
                disc[Integer.parseInt(st.nextToken())] = i + 1;
            }

        }

        makeCnt();

        res = 0;
        execHanoi(N, disc[N]);

        sb.append(disc[N]).append("\n").append(res);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
