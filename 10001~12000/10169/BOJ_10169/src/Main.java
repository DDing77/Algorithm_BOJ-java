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
    private List<Edge> edges;

    private UnionFind uf;
    private List<Integer>[] mstEdges;
    private boolean[] isMstEdge;

    private HLD hld;

    private long[] res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, weight, i));
        }
        Collections.sort(edges);

        uf = new UnionFind(N);
        mstEdges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            mstEdges[i] = new ArrayList<>();
        }
        isMstEdge = new boolean[M];
        int count = 0;
        for (int i = 0; i < M; i++) {
            Edge edge = edges.get(i);
            if (uf.union(edge.a, edge.b)) {
                count++;
                uf.mstSum += edge.weight;
                mstEdges[edge.a].add(edge.b);
                mstEdges[edge.b].add(edge.a);
                isMstEdge[i] = true;
            }
            if (count == N - 1) {
                break;
            }
        }

        if (count != N - 1) {
            for (int i = 0; i < M; i++) {
                sb.append("-1").append("\n");
            }
            System.out.print(sb);
            return;
        }

        hld = new HLD(N);
        hld.initHLD(N, mstEdges);
        for (int i = 0; i < M; i++) {
            if (!isMstEdge[i]) {
                Edge edge = edges.get(i);
                hld.updatePath(N, edge.a, edge.b, edge.weight);
            }
        }

        res = new long[M];
        Arrays.fill(res, uf.mstSum);
        for (int i = 0; i < M; i++) {
            System.out.println("i = " + i);
            if (isMstEdge[i]) {
                Edge edge = edges.get(i);
                int queryRes = hld.queryPath(N, edge.a, edge.b);
                System.out.println("Main.solution");
                if (queryRes == Integer.MAX_VALUE) {
                    res[edge.idx] = -1;
                } else {
                    res[edge.idx] = uf.mstSum - edge.weight + queryRes;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class UnionFind {

        int[] parent;
        long mstSum = 0L;

        public UnionFind(int N) {
            parent = new int[N + 1];
            Arrays.fill(parent, -1);
        }

        public int find(int x) {
            if (parent[x] < 0) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y) {
            x = find(x);
            y = find(y);

            if (x == y) {
                return false;
            }

            if (parent[x] < parent[y]) {
                parent[x] += parent[y];
                parent[y] = x;
            } else {
                parent[y] += parent[x];
                parent[x] = y;
            }
            return true;
        }
    }

    static class Edge implements Comparable<Edge> {

        int a;
        int b;
        int weight;
        int idx;

        public Edge(int a, int b, int weight, int idx) {
            this.a = a;
            this.b = b;
            this.weight = weight;
            this.idx = idx;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static class HLD {

        int eulerIdx = 0;
        int[] size;
        int[] depth;
        int[] parent;
        int[] in;
        int[] out;
        int[] top;
        boolean[] isVisited;
        List<Integer>[] hldEdges;

        int[] nodeTree;

        public HLD(int N) {
            size = new int[N + 1];
            depth = new int[N + 1];
            parent = new int[N + 1];
            in = new int[N + 1];
            out = new int[N + 1];
            top = new int[N + 1];
            top[1] = 1;
            isVisited = new boolean[N + 1];
            hldEdges = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                hldEdges[i] = new ArrayList<>();
            }
        }

        public void initHLD(int N, List<Integer>[] mstEdges) {
            setHLDEdge(1, mstEdges);
            dfsHLD1(1);
            dfsHLD2(1);

            nodeTree = new int[N * 4];
            Arrays.fill(nodeTree, Integer.MAX_VALUE);
        }

        private void setHLDEdge(int cur, List<Integer>[] mstEdges) {
            isVisited[cur] = true;
            for (int next : mstEdges[cur]) {
                if (!isVisited[next]) {
                    hldEdges[cur].add(next);
                    setHLDEdge(next, mstEdges);
                }
            }
        }

        private void dfsHLD1(int cur) {
            size[cur] = 1;
            for (int i = 0; i < hldEdges[cur].size(); i++) {
                int next = hldEdges[cur].get(i);
                depth[next] = depth[cur] + 1;
                parent[next] = cur;
                dfsHLD1(next);
                size[cur] += size[next];
                if (size[next] > size[hldEdges[cur].get(0)]) {
                    Collections.swap(hldEdges[cur], i, 0);
                }
            }
        }

        private void dfsHLD2(int cur) {
            in[cur] = ++eulerIdx;
            for (int next : hldEdges[cur]) {
                if (next == hldEdges[cur].get(0)) {
                    top[next] = top[cur];
                } else {
                    top[next] = next;
                }
                dfsHLD2(next);
            }
            out[cur] = eulerIdx;
        }

        private void update(int start, int end, int queryLeft, int queryRight, int weight, int nodeNum) {
            if (queryRight < start || end < queryLeft) {
                return;
            }

            if (queryLeft <= start && end <= queryRight) {
                nodeTree[nodeNum] = weight;
                return;
            }

            int mid = (start + end) >> 1;
            update(start, mid, queryLeft, queryRight, weight, nodeNum << 1);
            update(mid + 1, end, queryLeft, queryRight, weight, nodeNum << 1 | 1);
            nodeTree[nodeNum] = Math.min(nodeTree[nodeNum << 1], nodeTree[nodeNum << 1 | 1]);
        }

        private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
            if (queryRight < start || end < queryLeft) {
                return Integer.MAX_VALUE;
            }

            if (queryLeft <= start && end <= queryRight) {
                return nodeTree[nodeNum];
            }

            int mid = (start + end) >> 1;
            return Math.min(query(start, mid, queryLeft, queryRight, nodeNum << 1),
                    query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1));
        }

        public void updatePath(int N, int a, int b, int weight) {
            while (top[a] != top[b]) {
                if (depth[top[a]] < depth[top[b]]) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                update(1, N, in[top[a]], in[a], weight, 1);
                a = parent[top[a]];
            }

            if (depth[a] > depth[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            update(1, N, in[a] + 1, in[b], weight, 1);
        }

        public int queryPath(int N, int a, int b) {
            int res = Integer.MAX_VALUE;
            while (top[a] != top[b]) {
                if (depth[top[a]] < depth[top[b]]) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                res = Math.min(res, query(1, N, in[top[a]], in[a], 1));
                a = parent[top[a]];
            }

            if (depth[a] > depth[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            res = Math.min(res, query(1, N, in[a] + 1, in[b], 1));
            return res;
        }
    }
}
