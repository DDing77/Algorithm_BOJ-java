import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, N, LogN;
    static int[] depth;
    static int[][] parent;
    static boolean[] isRoot;
    static ArrayList<Integer>[] map;

    static void getLogN() {
        LogN = 0;
        for (int k = 1; k < N; k*=2) LogN++;
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        int root = 0;
        for (int i = 1; i <= N; i++) {
            if (isRoot[i] == false) {
                root = i;
                break;
            }
        }
        depth[root] = 1;
        que.add(root);
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : map[now]) {
                if (depth[next] == 0) {
                    depth[next] = depth[now] + 1;
                    parent[0][next] = now;
                    que.add(next);
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
        if (depth[b] > depth[a]) return getLca(b, a);
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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            getLogN();
            depth = new int[N + 1];
            isRoot = new boolean[N + 1];
            parent = new int[LogN + 1][N + 1];

            map = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                map[i] = new ArrayList<>();
            }
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                map[start].add(end);
                map[end].add(start);
                isRoot[end] = true;
            }

            bfs();
            getSparseTable();

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int res = getLca(a, b);
            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}
