import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private ArrayList<Integer>[] edges;
    private long[] dp;

    private void execDFS(int pre, int cur) {
        for (int next : edges[cur]) {
            execDFS(cur, next);
        }

        if (dp[cur] > 0 && pre != -1) {
            dp[pre] += dp[cur];
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        dp = new long[N + 1];
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if (t == 'W') {
                dp[i] = -a;
            } else {
                dp[i] = a;
            }
            edges[p].add(i);
        }

        execDFS(-1, 1);

        System.out.println(dp[1]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
