import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static Edge[] edges;
    static int N, M, Q;
    static long res;
    static int[] node;
    static boolean[] cutEdge;
    static int[] query;

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b) return;
        if (node[a] < node[b]) {
            node[a] += node[b];
            node[b] = a;
        } else {
            node[b] += node[a];
            node[a] = b;
        }
    }

    static int find(int x) {
        if (node[x] < 0) return x;
        return node[x] = find(node[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        node = new int[N + 1];
        Arrays.fill(node, -1);

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to);
        }

        cutEdge = new boolean[M];
        query = new int[Q];
        for (int i = 0; i < Q; i++) {
            query[i] = Integer.parseInt(br.readLine()) - 1;
            cutEdge[query[i]] = true;
        }

        for (int i = 0; i < M; i++) {
            if (cutEdge[i]) continue;
            union(edges[i].from, edges[i].to);
        }

        res = 0;
        for (int i = Q - 1; i >= 0; i--) {
            int idx = query[i];
            if (find(edges[idx].from) != find(edges[idx].to)) {
                res += (long) node[find(edges[idx].from)] * (long) node[find(edges[idx].to)];
                union(edges[idx].from, edges[idx].to);
            } else union(edges[idx].from, edges[idx].to);
        }

        System.out.println(res);
    }
}
