import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int INF = Integer.MAX_VALUE;
    private int N;
    private int M;
    private ArrayList<Integer>[] edges;
    private boolean[][] friends;
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        friends = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            friends[from][to] = true;
            friends[to][from] = true;
            edges[from].add(to);
            edges[to].add(from);
        }

        res = INF;
        for (int i = 1; i <= N - 2; i++) {
            for (int j = i + 1; j <= N - 1; j++) {
                if (friends[i][j]) {
                    for (int k = j + 1; k <= N; k++) {
                        if (!(friends[i][k] && friends[j][k])) {
                            continue;
                        }
                        int sum = edges[i].size() + edges[j].size() + edges[k].size() - 6;
                        res = Math.min(res, sum);
                    }
                }
            }
        }

        if (res == INF) {
            res = -1;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
