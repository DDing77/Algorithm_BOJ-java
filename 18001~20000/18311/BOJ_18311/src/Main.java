import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private long K;
    private long[] dist;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        dist = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        long sumDist = 0L;
        for (int i = 1; i <= N; i++) {
            sumDist += dist[i];
            if (sumDist == K) {
                if (i == N) {
                    System.out.println(N);
                } else {
                    System.out.println(i + 1);
                }
                return;
            } else if (sumDist > K) {
                System.out.println(i);
                return;
            }
        }

        for (int i = N; i >= 1; i--) {
            sumDist += dist[i];
            if (sumDist == K) {
                int ans = i - 1;
                if (ans < 1) {
                    ans = 1;
                }
                System.out.println(ans);
                return;
            } else if (sumDist > K) {
                System.out.println(i);
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
