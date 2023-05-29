import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int from;
        int to;
        String color;

        public Edge(int from, int to, String color) {
            this.from = from;
            this.to = to;
            this.color = color;
        }
    }

    static Edge[] edges;
    static int N, M, K;
    static int[] node;

    static int find(int x) {
        if (node[x] < 0) return x;
        return node[x] = find(node[x]);
    }

    static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) return false;

        if (node[a] < node[b]) {
            node[a] += node[b];
            node[b] = a;
        } else {
            node[b] += node[a];
            node[a] = b;
        }

        return true;
    }

    static int makeMST() {
        Arrays.fill(node, -1);

        int cnt = 0;
        int bCnt = 0;

        for (int i = 0; i < M; i++) {
            if (union(edges[i].from, edges[i].to)) {
                cnt++;
                if (edges[i].color.equals("B")) bCnt++;
            }
            if (cnt == N - 1) break;
        }

        return bCnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0 && K == 0) break;

            node = new int[N + 1];
            edges = new Edge[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String c = st.nextToken();
                int f = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                edges[i] = new Edge(f, t, c);
            }

            Arrays.sort(edges, Comparator.comparing(o -> o.color));
            int maxB = makeMST();
            Arrays.sort(edges, (o1, o2) -> o2.color.compareTo(o1.color));
            int minB = makeMST();

            if (minB <= K && K <= maxB) sb.append(1).append('\n');
            else sb.append(0).append('\n');

        }

        System.out.println(sb);
    }
}
