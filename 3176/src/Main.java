import java.awt.*;
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

    static int N, M, LogN;
    static int min, max;
    static int[] depth;
    static int[][] maxDistance;
    static int[][] minDistance;
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
        que.add(start);

        while (!que.isEmpty()) {
            int now = que.poll();
            for (Info next : map[now]) {
                if (depth[next.to] == 0) {
                    depth[next.to] = depth[now] + 1;
                    parent[0][next.to] = now;
                    maxDistance[0][next.to] = next.w;
                    minDistance[0][next.to] = next.w;
                    que.add(next.to);
                }
            }
        }
    }

    static void getSparseTable() {
        for (int i = 1; i <= LogN; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
                minDistance[i][j] = Math.min(minDistance[i-1][j], minDistance[i-1][parent[i-1][j]]);
                maxDistance[i][j] = Math.max(maxDistance[i-1][j], maxDistance[i-1][parent[i-1][j]]);
            }
        }
    }

    static int getLca(int a, int b) {
        if (depth[b] > depth[a]) {
            return getLca(b, a);
        }
        min = 1000001;
        max = 0;

        for (int i = 0; i <= LogN; i++) {
            if (((depth[a] - depth[b]) & (1 << i)) >= 1) {
                min = Math.min(min, minDistance[i][a]);
                max = Math.max(max, maxDistance[i][a]);
                a = parent[i][a];
            }
        }
        if (a == b) return a;

        for (int i = LogN; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                min = Math.min(min, Math.min(minDistance[i][a], minDistance[i][b]));
                max = Math.max(max, Math.max(maxDistance[i][a], maxDistance[i][b]));
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        min = Math.min(min, Math.min(minDistance[0][a], minDistance[0][b]));
        max = Math.max(max, Math.max(maxDistance[0][a], maxDistance[0][b]));
        return parent[0][a];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        depth = new int[N + 1];
        map = new ArrayList[N + 1];

        getLogN();
        parent = new int[LogN + 1][N + 1];
        maxDistance = new int[LogN+ 1][N + 1];
        minDistance = new int[LogN+ 1][N + 1];
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
            getLca(a,b);
            sb.append(min).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
    }
}
