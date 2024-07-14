import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private ArrayList<Integer>[] edges;
    private long[] dp;

    private void execDFS(int curNode, int preNode) {

        dp[curNode] += dp[preNode];

        for (int childNode : edges[curNode]) {
            execDFS(childNode, curNode);
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= N; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            edges[parentNode].add(i);
        }

        dp = new long[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            dp[nodeNum] += value;
        }

        execDFS(1, 0);

        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
