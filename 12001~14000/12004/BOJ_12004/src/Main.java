import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] parent;
    private ArrayList<Integer>[] adjList;
    private int[] close;

    private int find(int x) {
        if (parent[x] < 0) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        if (parent[x] < parent[y]) {
            parent[x] += parent[y];
            parent[y] = x;
        } else {
            parent[y] += parent[x];
            parent[x] = y;
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        close = new int[N];
        for (int i = 0; i < N; i++) {
            close[i] = Integer.parseInt(br.readLine());
        }

        boolean[] opened = new boolean[N+1];
        boolean[] ansRev = new boolean[N];

        parent = new int[N+1];
        Arrays.fill(parent, -1);
        int comp = 0;

        for (int k = N-1; k >= 0; k--) {
            int v = close[k];
            opened[v] = true;
            comp++;

            for (int u : adjList[v]) {
                if (!opened[u]) {
                    continue;
                }
                if (find(u) != find(v)) {
                    union(u, v);
                    comp--;
                }
            }

            ansRev[k] = (comp == 1);
        }

        for (int i = 0; i < N; i++) {
            sb.append(ansRev[i] ? "YES" : "NO").append('\n');
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
