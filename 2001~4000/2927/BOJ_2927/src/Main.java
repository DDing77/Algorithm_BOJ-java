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
    private int Q;
    private int[] counts;
    private List<QueryInfo> queryList = new ArrayList<QueryInfo>();
    private List<Integer>[] edges;
    private List<Integer>[] hldEdges;
    private boolean[] isVisited;
    private int[] depth;
    private int[] size;
    private int[] hldParent;
    private int[] in;
    private int[] out;
    private int[] top;

    private void setHLDEdges(int cur) {
        isVisited[cur] = true;
        for (int next : edges[cur]) {
            if (!isVisited[next]) {
                hldEdges[cur].add(next);
                setHLDEdges(next);
            }
        }
    }

    private void dfsHLD1(int cur) {
        size[cur] = 1;
        for (int i = 0; i < hldEdges[cur].size(); i++) {
            int next = hldEdges[cur].get(i);
            depth[next] = depth[cur] + 1;
            hldParent[next] = cur;
            dfsHLD1(next);
            size[cur] += size[next];
            if (size[next] > size[hldEdges[cur].get(0)]) {
                Collections.swap(hldEdges[cur], 0, i);
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

    private int querySum(SegmentTree segmentTree,int left, int right) {
        int sum = 0;
        while (top[left] != top[right]) {
            if (depth[top[left]] < depth[top[right]]) {
                int temp = left;
                left = right;
                right = temp;
            }

            sum += segmentTree.query(1, N, in[top[left]], in[left], 1);
            left = hldParent[top[left]];
        }

        if (depth[left] > depth[right]) {
            int temp = left;
            left = right;
            right = temp;
        }

        sum += segmentTree.query(1, N, in[left], in[right], 1);
        return sum;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        counts = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }

        UnionFind uf = new UnionFind(N);
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String message = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queryList.add(new QueryInfo(message, a, b));

            if (message.equals("bridge") && uf.union(a, b)) {
                edges[a].add(b);
                edges[b].add(a);
            }
        }

        for (int i = 2; i <= N; i++) {
            if (uf.union(1, i)) {
                edges[1].add(i);
//                edges[i].add(1);
            }
        }

        hldEdges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            hldEdges[i] = new ArrayList<>();
        }
        isVisited = new boolean[N + 1];
        setHLDEdges(1);

        size = new int[N + 1];
        depth = new int[N + 1];
        hldParent = new int[N + 1];
        dfsHLD1(1);

        in = new int[N + 1];
        out = new int[N + 1];
        top = new int[N + 1];
        dfsHLD2(1);

        int[] temp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            temp[in[i]] = counts[i];
        }
        counts = temp;

        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.buildTree(counts, 1, N, 1);

        uf.clear();

        for (QueryInfo queryInfo : queryList) {
            if (queryInfo.message.equals("bridge")) {
                if (uf.union(queryInfo.a, queryInfo.b)) {
                    sb.append("yes").append("\n");
                } else {
                    sb.append("no").append("\n");
                }
            } else if (queryInfo.message.equals("penguins")) {
                segmentTree.update(1, N, in[queryInfo.a], queryInfo.b, 1);
            } else if (queryInfo.message.equals("excursion")) {
                if (uf.find(queryInfo.a) != uf.find(queryInfo.b)) {
                    sb.append("impossible").append("\n");
                } else {
                    sb.append(querySum(segmentTree, queryInfo.a, queryInfo.b)).append("\n");
                }
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class SegmentTree {

        int[] nodes;

        public SegmentTree(int N) {
            this.nodes = new int[N * 4];
        }

        public void buildTree(int[] values, int start, int end, int nodeNum) {
            if (start == end) {
                nodes[nodeNum] = values[start];
                return;
            }

            int mid = (start + end) >> 1;
            buildTree(values, start, mid, nodeNum << 1);
            buildTree(values, mid + 1, end, nodeNum << 1 | 1);
            nodes[nodeNum] = nodes[nodeNum << 1] + nodes[nodeNum << 1 | 1];
        }

        public void update(int start, int end, int targetIdx, int value, int nodeNum) {
            if (targetIdx < start || end < targetIdx) {
                return;
            }

            if (start == end) {
                nodes[nodeNum] = value;
                return;
            }

            int mid = (start + end) >> 1;
            update(start, mid, targetIdx, value, nodeNum << 1);
            update(mid + 1, end, targetIdx, value, nodeNum << 1 | 1);
            nodes[nodeNum] = nodes[nodeNum << 1] + nodes[nodeNum << 1 | 1];
        }

        public int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
            if (queryRight < start || end < queryLeft) {
                return 0;
            }

            if (queryLeft <= start && end <= queryRight) {
                return nodes[nodeNum];
            }

            int mid = (start + end) >> 1;
            return query(start, mid, queryLeft, queryRight, nodeNum << 1)
                    + query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
        }
    }

    static class QueryInfo {

        String message;
        int a;
        int b;

        public QueryInfo(String message, int a, int b) {
            this.message = message;
            this.a = a;
            this.b = b;
        }
    }

    static class UnionFind {

        int[] parents;

        public UnionFind(int N) {
            this.parents = new int[N + 1];
            Arrays.fill(this.parents, -1);
        }

        int find(int a) {
            if (parents[a] < 0) {
                return a;
            }
            return parents[a] = find(parents[a]);
        }

        boolean union(int a, int b) {
            a = find(a);
            b = find(b);

            if (a == b) {
                return false;
            }

            if (parents[a] < parents[b]) {
                parents[a] += parents[b];
                parents[b] = a;
            } else {
                parents[b] += parents[a];
                parents[a] = b;
            }

            return true;
        }

        public void clear() {
            Arrays.fill(parents, -1);
        }
    }
}
