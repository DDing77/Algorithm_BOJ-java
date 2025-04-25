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
    private int[] size;
    private int[] depth;
    private int[] parent;
    private int[] in;
    private int[] out;
    private int[] top;

    private void dfsHLD1(int cur) {
        size[cur] = 1;
        for (int i = 0; i < edges[cur].size(); i++) {
            int next = edges[cur].get(i);
            depth[next] = depth[cur] + 1;
            parent[next] = cur;
            dfsHLD1(next);
            size[cur] += size[next];
            if (size[next] > size[edges[cur].get(0)]) {
                Collections.swap(edges[cur], i, 0);
            }
        }
    }

    private void dfsHLD2(int cur) {
        in[cur] = ++eulerIdx;
        for (int next : edges[cur]) {
            if (next == edges[cur].get(0)) {
                top[next] = top[cur];
            } else {
                top[next] = next;
            }
            dfsHLD2(next);
        }
        out[cur] = eulerIdx;
    }

    private int queryPath(SegmentTree segmentTree, int b, int c) {
        int res = 1;
        while (top[b] != top[c]) {
            if (depth[top[b]] < depth[top[c]]) {
                int temp = b;
                b = c;
                c = temp;
            }
            res &= segmentTree.query(1, N, in[top[b]], in[b], 1);
            b = parent[top[b]];
        }

        if (depth[b] > depth[c]) {
            int temp = b;
            b = c;
            c = temp;
        }
        res &= segmentTree.query(1, N, in[b] + 1, in[c], 1);
        return res;
    }

    private void updateNode(SegmentTree segmentTree, int targetNode) {
        segmentTree.update(1, N, in[targetNode], 1);
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            edges[Integer.parseInt(br.readLine())].add(i);
        }

        size = new int[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];
        dfsHLD1(1);

        in = new int[N + 1];
        out = new int[N + 1];
        top = new int[N + 1];
        top[1] = 1;
        dfsHLD2(1);

        SegmentTree segmentTree = new SegmentTree(N);
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int queryRes = queryPath(segmentTree, b, c);
            if (queryRes == 1) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }

            if (d == 1) {
                if (queryRes == 1) {
                    updateNode(segmentTree, b);
                } else {
                    updateNode(segmentTree, c);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class SegmentTree {

        int[] nodeTree;

        public SegmentTree(int leafSize) {
            this.nodeTree = new int[leafSize * 4];
            Arrays.fill(nodeTree, 1);
        }

        public void update(int start, int end, int targetIdx, int nodeNum) {
            if (targetIdx < start || end < targetIdx) {
                return;
            }

            if (start == end) {
                nodeTree[nodeNum] = 0;
                return;
            }

            int mid = (start + end) >> 1;
            update(start, mid, targetIdx, nodeNum << 1);
            update(mid + 1, end, targetIdx, nodeNum << 1 | 1);
            nodeTree[nodeNum] = nodeTree[nodeNum << 1] & nodeTree[nodeNum << 1| 1];
        }

        public int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
            if (queryRight < start || end < queryLeft) {
                return 1;
            }

            if (queryLeft <= start && end <= queryRight) {
                return nodeTree[nodeNum];
            }

            int mid = (start + end) >> 1;
            int leftRes = query(start, mid, queryLeft, queryRight, nodeNum << 1);
            int rightRes = query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
            return leftRes & rightRes;
        }
    }
}
