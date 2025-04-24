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
    private List<Integer>[] edges;
    private List<Integer>[] hldEdges;
    private boolean[] isVisited;
    private int[] size;
    private int[] depth;
    private int[] parents;
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
            parents[next] = cur;
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

    private void updateQuery(SegmentTree segmentTree, int x, int mul, int sum) {
        segmentTree.update(1, N, in[x], out[x], mul, sum, 1);
    }

    private void updateQuery(SegmentTree segmentTree, int x, int y, int mul, int sum) {
        while (top[x] != top[y]) {
            if (depth[top[x]] < depth[top[y]]) {
                int temp = x;
                x = y;
                y = temp;
            }
            segmentTree.update(1, N, in[top[x]], in[x], mul, sum, 1);
            x = parents[top[x]];
        }

        if (depth[x] > depth[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        segmentTree.update(1, N, in[x], in[y], mul, sum, 1);
    }

    private int sumQuery(SegmentTree segmentTree, int x) {
        return segmentTree.query(1, N, in[x], out[x], 1);
    }

    private int sumQuery(SegmentTree segmentTree, int x, int y) {
        int sum = 0;

        while (top[x] != top[y]) {
            if (depth[top[x]] < depth[top[y]]) {
                int temp = x;
                x = y;
                y = temp;
            }
            sum += segmentTree.query(1, N, in[top[x]], in[x], 1);
            x = parents[top[x]];
        }

        if (depth[x] > depth[y]) {
            int temp = x;
            x = y;
            y = temp;
        }

        sum += segmentTree.query(1, N, in[x], in[y], 1);
        return sum;
    }

    private long mod(int value) {
        if (value < 0) {
            return (1L << 32) + value;
        }
        return value;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            edges[to].add(from);
        }

        hldEdges = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            hldEdges[i] = new ArrayList<>();
        }
        setHLDEdges(1);

        size = new int[N + 1];
        depth = new int[N + 1];
        parents = new int[N + 1];
        dfsHLD1(1);

        in = new int[N + 1];
        out = new int[N + 1];
        top = new int[N + 1];
        top[1] = 1;
        dfsHLD2(1);

        SegmentTree segmentTree = new SegmentTree(N);
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y;
            int v;
            if (op == 1) {
                v = Integer.parseInt(st.nextToken());
                updateQuery(segmentTree, x, 1, v);
            } else if (op == 2) {
                y = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                updateQuery(segmentTree, x, y, 1, v);
            } else if (op == 3) {
                v = Integer.parseInt(st.nextToken());
                updateQuery(segmentTree, x, v, 0);
            } else if (op == 4) {
                y = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                updateQuery(segmentTree, x, y, v, 0);
            } else if (op == 5) {
                sb.append(mod(sumQuery(segmentTree, x))).append("\n");
            } else if (op == 6) {
                y = Integer.parseInt(st.nextToken());
                sb.append(mod(sumQuery(segmentTree, x, y))).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class SegmentTree {

        int[] nodeTree;
        int[][] lazyTree;

        public SegmentTree(int leafSize) {
            this.nodeTree = new int[leafSize * 4];
            this.lazyTree = new int[leafSize * 4][2];
            for (int i = 0; i < lazyTree.length; i++) {
                lazyTree[i][0] = 1;
            }
        }

        public void propagate(int start, int end, int nodeNum) {
            if (lazyTree[nodeNum][0] == 1 && lazyTree[nodeNum][1] == 0) return;

            nodeTree[nodeNum] *= lazyTree[nodeNum][0];
            nodeTree[nodeNum] += (end - start + 1) * lazyTree[nodeNum][1];

            if (start != end) {
                int left = nodeNum << 1, right = nodeNum << 1 | 1;

                lazyTree[left][0] *= lazyTree[nodeNum][0];
                lazyTree[left][1] *= lazyTree[nodeNum][0];
                lazyTree[left][1] += lazyTree[nodeNum][1];

                lazyTree[right][0] *= lazyTree[nodeNum][0];
                lazyTree[right][1] *= lazyTree[nodeNum][0];
                lazyTree[right][1] += lazyTree[nodeNum][1];
            }

            lazyTree[nodeNum][0] = 1;
            lazyTree[nodeNum][1] = 0;
        }

        public void update(int start, int end, int queryLeft, int queryRight, int mul, int add, int nodeNum) {
            propagate(start, end, nodeNum);

            if (queryRight < start || end < queryLeft) {
                return;
            }

            if (queryLeft <= start && end <= queryRight) {
                nodeTree[nodeNum] *= mul;
                nodeTree[nodeNum] += (end - start + 1) * add;

                if (start != end) {
                    int left = nodeNum << 1, right = nodeNum << 1 | 1;

                    lazyTree[left][0] *= mul;
                    lazyTree[left][1] *= mul;
                    lazyTree[left][1] += add;

                    lazyTree[right][0] *= mul;
                    lazyTree[right][1] *= mul;
                    lazyTree[right][1] += add;
                }
                return;
            }

            int mid = (start + end) >> 1;
            update(start, mid, queryLeft, queryRight, mul, add, nodeNum << 1);
            update(mid + 1, end, queryLeft, queryRight, mul, add, nodeNum << 1 | 1);
            nodeTree[nodeNum] = nodeTree[nodeNum << 1] + nodeTree[nodeNum << 1 | 1];
        }

        public int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
            propagate(start, end, nodeNum);
            if (queryRight < start || end < queryLeft) {
                return 0;
            }

            if (queryLeft <= start && end <= queryRight) {
                return nodeTree[nodeNum];
            }

            int mid = (start + end) >> 1;
            return query(start, mid, queryLeft, queryRight, nodeNum << 1)
                    + query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
        }
    }
}

