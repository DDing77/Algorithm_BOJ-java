import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int M;
    private int[] parents;
    private int[] odd;
    private Edge[] edges;
    private int res;

    private class Edge {
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public int find(int x) {
        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (parents[a] <= parents[b]) {
            parents[a] += parents[b];
            parents[b] = a;
            odd[a] += odd[b];
        } else {
            parents[b] += parents[a];
            parents[a] = b;
            odd[b] += odd[a];
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        odd = new int[N + 1];
        edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to);
            odd[from]++;
            odd[to]++;
        }

        for (int i = 1; i <= N; i++) {
            parents[i] = -1;
            odd[i] %= 2;
        }

        for (int i = 0; i < M; i++) {
            union(edges[i].from, edges[i].to);
        }

        res = 0;
        for (int i = 1; i <= N; i++) {
            if (parents[i] < -1) {
                res += Math.max(odd[i] / 2, 1);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
