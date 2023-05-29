import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] depth;
    static long[] distance;
    static int[][] parent;

    static class Info {
        int to;
        int weight;

        public Info(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<Info>[] list;
    static int LogN;

    static void getLogN() {
        LogN = 0;
        for (int k = 1; k < N; k *= 2) LogN++;
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        depth[start] = 1;
        distance[start] = 0;
        que.add(start);
        while (!que.isEmpty()) {
            int now = que.poll();
            for (Info next : list[now]) {
                if (depth[next.to] == 0) {
                    depth[next.to] = depth[now] + 1;
                    parent[0][next.to] = now;
                    distance[next.to] = distance[now] + next.weight;
                    que.add(next.to);
                }
            }
        }
    }

    static void makeSparseTable() {
        for (int i = 1; i <= LogN; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
    }

    static int getLCA(int a, int b) {
        if (depth[b] > depth[a]) return getLCA(b, a);
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
        N = Integer.parseInt(br.readLine());
        getLogN();
        distance = new long[N + 1];
        depth = new int[N + 1];
        parent = new int[LogN + 1][N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[a].add(new Info(b, weight));
            list[b].add((new Info(a, weight)));
        }
        bfs(1);
        makeSparseTable();

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                sb.append(distance[a] + distance[b] - 2 * distance[getLCA(a, b)]).append('\n');
            } else {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                int root = getLCA(u, v);
                int leftDepth = depth[u] - depth[root] + 1;
                // 왼쪽 서브트리
                if (leftDepth > k) {
                    k--;
//                    System.out.println("test");
                    for (int j = 0; j <= LogN; j++) {
                        if ((k & (1 << j)) >= 1) {
                            u = parent[j][u];
                        }
                    }
                    sb.append(u).append('\n');
                } else if (leftDepth == k) {
                    sb.append(root).append('\n');
                } else {
                    int rightK = leftDepth + depth[v] - depth[root] - k + 1;
                    rightK--;
                    for (int j = 0; j <= LogN; j++) {
                        if ((rightK & (1 << j)) >= 1) {
                            v = parent[j][v];
                        }
                    }
                    sb.append(v).append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}
