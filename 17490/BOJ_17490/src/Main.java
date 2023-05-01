import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int M;
    private long K;
    private int[] parent;
    private int[] cost;
    private boolean[] isCut;
    private long res;

    public int find(int x) {
        if (parent[x] < 0) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (cost[a] <= cost[b]) {
            parent[a] += parent[b];
            parent[b] = a;
        } else {
            parent[b] += parent[a];
            parent[a] = b;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        if (K <= 1) {
            System.out.println("YES");
            return;
        }

        parent = new int[N + 1];
        cost = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            parent[i] = -1;
            cost[i] = Integer.parseInt(st.nextToken());
        }

        isCut = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            isCut[to] = true;
        }

        for (int i = 1; i <= N; i++) {
            int from = i;
            int to = (i + 1) % (N + 1);

            if (to == 0) {
                to = 1;
            }

            if (!isCut[to]) {
                union(from, to);
            }
        }
        res = 0;
        for (int i = 1; i <= N; i++) {
            if (parent[i] < 0) {
                res += cost[i];
            }
        }

        if (res <= K) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
