import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    final int MOD = 1_000_000_007;
    final int NODE_COUNT = 8;
    int D;
    long[][] dp;
    ArrayList<Integer>[] edges;

    private void makeEdge() {
        edges = new ArrayList[NODE_COUNT];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        edges[0].add(1);
        edges[0].add(2);

        edges[1].add(0);
        edges[1].add(2);
        edges[1].add(3);

        edges[2].add(0);
        edges[2].add(1);
        edges[2].add(3);
        edges[2].add(5);

        edges[3].add(1);
        edges[3].add(2);
        edges[3].add(4);
        edges[3].add(5);

        edges[4].add(3);
        edges[4].add(5);
        edges[4].add(6);

        edges[5].add(2);
        edges[5].add(3);
        edges[5].add(4);
        edges[5].add(7);

        edges[6].add(4);
        edges[6].add(7);

        edges[7].add(5);
        edges[7].add(6);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        D = Integer.parseInt(br.readLine());

        dp = new long[D + 1][NODE_COUNT];
        dp[0][0] = 1;

        makeEdge();

        for (int i = 0; i < D; i++) {
            for (int j = 0; j < edges.length; j++) {
                for (int next : edges[j]) {
                    dp[i + 1][j] += dp[i][next];
                }
                dp[i + 1][j] %= MOD;
            }
        }

        System.out.println(dp[D][0]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
