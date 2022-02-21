import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Comparator;

// author : DDing
// solution : LCA, Sparse Array, BitMasking, Union-Find, BFS, Kruskal

public class Main {
    // 깊이 차이
    static void getLogN() {
        LogN = 0;
        for (int k = 1; k < V; k *= 2) {
            LogN++;
        }
    }

    // depth, sparseTable, max, secMax 테이블 초기화
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        depth[start] = 1;
        que.add(start);

        while (!que.isEmpty()) {
            int now = que.poll();
            for (Edge next : list[now]) {
                if (depth[next.end] == 0) {
                    depth[next.end] = depth[now] + 1;
                    lcaParent[0][next.end] = now;
                    secMaxDist[0][next.end] = -1;
                    maxDist[0][next.end] = next.weight;
                    que.add(next.end);
                }
            }
        }
    }

    static class Edge {
        int start;
        int end;
        int weight;
        boolean isShortest = false;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.isShortest = false;
        }

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static ArrayList<Edge> edgeList;
    static ArrayList<Edge>[] list;
    static int V, E;
    static int LogN;
    static int cnt;
    static int mstValue;
    static int[] parent;
    static int[] depth;
    static int[][] lcaParent;
    static int[][] maxDist;
    static int[][] secMaxDist;

    // union-find
    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;
        parent[py] = px;
        return true;
    }

    static void makeSparseTable() {
        int parentMax, parentSecMax;
        int max, secMax;
        for (int i = 0; i < LogN; i++) {
            for (int j = 1; j <= V; j++) {
                int parentId = lcaParent[i][j];
                if (parentId != 0 && lcaParent[i][parentId] != 0) {
                    max = maxDist[i][j];
                    secMax = secMaxDist[i][j];
                    parentMax = maxDist[i][parentId];
                    parentSecMax = secMaxDist[i][parentId];

                    if (max > parentMax) {
                        maxDist[i + 1][j] = max;
                        secMaxDist[i + 1][j] = Math.max(parentMax, secMax);
                    } else if (max < parentMax) {
                        maxDist[i + 1][j] = parentMax;
                        secMaxDist[i + 1][j] = Math.max(max, parentSecMax);
                    } else {
                        maxDist[i + 1][j] = max;
                        secMaxDist[i + 1][j] = Math.max(secMax, parentSecMax);
                    }
                    lcaParent[i + 1][j] = lcaParent[i][parentId];
                }
            }
        }
    }

    static int check(int a, int b, int cost) {
        if (depth[a] < depth[b]) return check(b, a, cost);

        int ret = -1;

        for (int i = 0; i <= LogN; i++) {
            if (((depth[a] - depth[b]) & (1 << i)) >= 1) {
                if (maxDist[i][a] != cost) {
                    ret = Math.max(ret, maxDist[i][a]);
                } else if (secMaxDist[i][a] != -1) {
                    ret = Math.max(ret, secMaxDist[i][a]);
                }
                a = lcaParent[i][a];
            }
        }

        if (a == b) return ret;

        for (int i = LogN; i >= 0; i--) {
            if (lcaParent[i][a] != lcaParent[i][b]) {

                if (maxDist[i][a] != cost) {
                    ret = Math.max(ret, maxDist[i][a]);
                } else if (secMaxDist[i][a] != -1) {
                    ret = Math.max(ret, secMaxDist[i][a]);
                }

                if (maxDist[i][b] != cost) {
                    ret = Math.max(ret, maxDist[i][b]);
                } else if (secMaxDist[i][b] != -1) {
                    ret = Math.max(ret, secMaxDist[i][b]);
                }

                a = lcaParent[i][a];
                b = lcaParent[i][b];
            }
        }

        if (maxDist[0][a] != cost) {
            ret = Math.max(ret, maxDist[0][a]);
        } else if (secMaxDist[0][a] != -1) {
            ret = Math.max(ret, secMaxDist[0][a]);
        }

        if (maxDist[0][b] != cost) {
            ret = Math.max(ret, maxDist[0][b]);
        } else if (secMaxDist[0][b] != -1) {
            ret = Math.max(ret, secMaxDist[0][b]);
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();

        parent = new int[V + 1];
        list = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(start, end, weight));
        }

        Collections.sort(edgeList, Comparator.comparingInt(o -> o.weight));
        cnt = 0;
        mstValue = 0;

        // MST
        for (int i = 0; i < E; i++) {
            if (cnt == V - 1) break;
            Edge now = edgeList.get(i);

            if (!union(now.start, now.end)) continue;
            mstValue += now.weight;
            now.isShortest = true;
            cnt++;

            list[now.start].add(new Edge(now.end, now.weight));
            list[now.end].add(new Edge(now.start, now.weight));
        }

        if (cnt != V - 1) {
            System.out.println(-1);
            System.exit(0);
        }

        // LCA
        getLogN();

        depth = new int[V + 1];
        lcaParent = new int[LogN + 1][V + 1];
        secMaxDist = new int[LogN + 1][V + 1];
        maxDist = new int[LogN + 1][V + 1];

        bfs(1);
        makeSparseTable();

        long ans = Long.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < edgeList.size(); i++) {
            Edge now = edgeList.get(i);
            if (now.isShortest) continue;
            max = check(now.start, now.end, now.weight);
            if (max == -1 || max == now.weight) continue;
            ans = Math.min(ans, now.weight - max);
        }

        if (ans == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        long res = ans + mstValue;
        System.out.println(res);
    }
}
