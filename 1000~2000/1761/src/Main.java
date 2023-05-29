import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Info {
        int to;
        int w;

        public Info(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static int N, M, LogN, sum;
    static int[] depth;
    static long[] distance;
    static int[][] parent;
    static ArrayList<Info>[] map;

    static void getLogN() {
        LogN = 0;
        for (int k = 1; k < N; k *= 2) {
            LogN++;
        }
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        depth[start] = 1;
        distance[start] = 0;
        que.add(start);
        while (!que.isEmpty()) {
            int now = que.poll();
            for (Info next : map[now]) {
                if (depth[next.to] == 0) {
                    depth[next.to] = depth[now] + 1;
                    distance[next.to] = distance[now] + next.w;
                    parent[0][next.to] = now;
                    que.add(next.to);
                }
            }
        }
    }

    static void getSparseTable() {
        for (int i = 1; i <= LogN; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
    }

    static int getLca(int a, int b) {
        if (depth[b] > depth[a]) {
            return getLca(b, a);
        }
        for (int i = 0; i <= LogN; i++) {
            if (((depth[a] - depth[b]) & (1 << i)) >= 1) {
                a = parent[i][a];
            }
        }
        if (a == b) return a;

        for (int i = LogN; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        depth = new int[N + 1];
        distance = new long[N + 1];
        map = new ArrayList[N + 1];
        getLogN();
        parent = new int[LogN + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[start].add(new Info(end, w));
            map[end].add(new Info(start, w));
        }

        bfs(1);
        getSparseTable();

        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lca = getLca(a, b);
//            System.out.println("lca : " + lca);
            long sum = distance[a] + distance[b] - 2 * distance[lca];
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
//        System.out.println(Arrays.toString(distance));
    }
}
