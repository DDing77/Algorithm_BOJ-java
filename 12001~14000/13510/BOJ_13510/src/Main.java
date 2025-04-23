import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int eulerIdx = 0;

    private int N;
    private int M;
    private int[] in;
    private int[] out;
    private int[] size;
    private int[] depth;
    private int[] parent;
    private int[] top;
    private List<Edge> edgeInfo;
    private List<Integer>[] edges;
    private int[] edgeToVertex;
    private List<Integer>[] treeEdges;
    private int[] weights;
    private boolean[] isVisited;
    private int[] nodeTree;

    private void setTreeEdge(int cur) {
        isVisited[cur] = true;
        for (int next : edges[cur]) {
            if (!isVisited[next]) {
                treeEdges[cur].add(next);
                setTreeEdge(next);
            }
        }
    }

    private void hld1(int cur) {
        size[cur] = 1;
        for (int i = 0; i < treeEdges[cur].size(); i++) {
            int next = treeEdges[cur].get(i);
            parent[next] = cur;
            depth[next] = depth[cur] + 1;

            hld1(next);

            size[cur] += size[next];

            if (size[next] > size[treeEdges[cur].get(0)]) {
                int tmp = next;
                treeEdges[cur].set(i, treeEdges[cur].get(0));
                treeEdges[cur].set(0, tmp);
            }
        }
    }

    private void hld2(int cur) {
        in[cur] = ++eulerIdx;
        for (int next : treeEdges[cur]) {
            if (next == treeEdges[cur].get(0)) {
                top[next] = top[cur];
            } else {
                top[next] = next;
            }
            hld2(next);
        }
        out[cur] = eulerIdx;
    }

    private void buildTree(int start, int end, int nodeNum) {
        if (start == end) {
            nodeTree[nodeNum] = weights[start];
            return;
        }

        int mid = (start + end) >> 1;
        buildTree(start, mid, nodeNum << 1);
        buildTree(mid + 1, end, nodeNum << 1 | 1);
        nodeTree[nodeNum] = Math.max(nodeTree[nodeNum << 1], nodeTree[nodeNum << 1 | 1]);
    }

    private void update(int start, int end, int targetIdx, int value, int nodeNum) {
        if (targetIdx < start || end < targetIdx) {
            return;
        }

        if (start == end) {
            nodeTree[nodeNum] = value;
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, targetIdx, value, nodeNum << 1);
        update(mid + 1, end, targetIdx, value, nodeNum << 1 | 1);

        nodeTree[nodeNum] = Math.max(nodeTree[nodeNum << 1], nodeTree[nodeNum << 1 | 1]);
    }

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < start || end < queryLeft) {
            return 0 ;
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodeTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        return Math.max(query(start, mid, queryLeft, queryRight, nodeNum << 1),
                query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1));
    }

    private int queryMax(int u, int v) {

        int res = 0;
        while (top[u] != top[v]) {
            if (depth[top[u]] < depth[top[v]]) {
                int tmp = u;
                u = v;
                v = tmp;
            }

            res = Math.max(res, query(1, N, in[top[u]], in[u], 1));
            u = parent[top[u]];
        }

        if (u == v) {
            return res;
        }
        if (depth[u] > depth[v] ) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        res = Math.max(res, query(1, N, in[u] + 1, in[v], 1));
        return res;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        nodeTree = new int[N * 4];

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        edgeInfo = new ArrayList<>();
        edgeInfo.add(new Edge(-1, -1, -1));
        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeInfo.add(new Edge(a, b, weight));
            edges[a].add(b);
            edges[b].add(a);
        }

        isVisited = new boolean[N + 1];
        treeEdges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            treeEdges[i] = new ArrayList<>();
        }
        setTreeEdge(1);

        size = new int[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];
        hld1(1);

        in = new int[N + 1];
        out = new int[N + 1];
        top = new int[N + 1];
        hld2(1);

        edgeToVertex = new int[N + 1];
        weights = new int[N + 1];
        for (int i = 1; i <= N - 1; i++) {
            Edge edge = edgeInfo.get(i);
            if (depth[edge.a] < depth[edge.b]) {
                edgeToVertex[i] = edge.b;
            } else {
                edgeToVertex[i] = edge.a;
            }
            weights[in[edgeToVertex[i]]] = edge.weight;
        }

        buildTree(1, N, 1);

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int i = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                update(1, N, in[edgeToVertex[i]], c, 1);
            } else {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                sb.append(queryMax(u, v)).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Edge {

        int a;
        int b;
        int weight;

        public Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }
}
