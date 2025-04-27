import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int Q;
    private List<Integer>[] edges;
    private HLDTree hldTree;

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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        hldTree = new HLDTree(N);
        hldTree.setHLDEdges(edges, 1, 1);
        hldTree.initHLDInfo(1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String w = st.nextToken();
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (w.equals("P")) {
                hldTree.update(N, u, v);
            } else if (w.equals("Q")) {
                sb.append(hldTree.query(N, u, v)).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class HLDTree {

        static int eulerIdx = 0;

        int[] size;
        int[] depth;
        int[] parent;
        int[] top;
        int[] in;
        List<Integer>[] hldEdges;
        SegmentTree segmentTree;

        public HLDTree(int leafNodeSize) {
            size = new int[leafNodeSize + 1];
            depth = new int[leafNodeSize + 1];
            parent = new int[leafNodeSize + 1];
            top = new int[leafNodeSize + 1];
            in = new int[leafNodeSize + 1];
            top[1] = 1;

            hldEdges = new ArrayList[leafNodeSize + 1];
            for (int i = 1; i <= leafNodeSize; i++) {
                hldEdges[i] = new ArrayList<>();
            }

            segmentTree = new SegmentTree(leafNodeSize);
        }

        private void setHLDEdges(List<Integer>[] edges, int pre, int cur) {
            for (int next : edges[cur]) {
                if (next != pre) {
                    hldEdges[cur].add(next);
                    setHLDEdges(edges, cur, next);
                }
            }
        }

        private void initHLDInfo(int rootNodeNum) {
            dfsHLD1(rootNodeNum);
            dfsHLD2(rootNodeNum);
        }

        private void dfsHLD1(int curNodeNum) {
            size[curNodeNum] = 1;
            for (int i = 0; i < hldEdges[curNodeNum].size(); i++) {
                int nextNodeNum = hldEdges[curNodeNum].get(i);
                depth[nextNodeNum] = depth[curNodeNum] + 1;
                parent[nextNodeNum] = curNodeNum;
                dfsHLD1(nextNodeNum);
                size[curNodeNum] += size[nextNodeNum];
                if (size[nextNodeNum] > size[hldEdges[curNodeNum].get(0)]) {
                    Collections.swap(hldEdges[curNodeNum], 0, i);
                }
            }
        }

        private void dfsHLD2(int curNodeNum) {
            in[curNodeNum] = ++eulerIdx;
            for (int next : hldEdges[curNodeNum]) {
                if (next == hldEdges[curNodeNum].get(0)) {
                    top[next] = top[curNodeNum];
                } else {
                    top[next] = next;
                }
                dfsHLD2(next);
            }
        }

        public void printHLDInfo() {
            System.out.println("Arrays.toString(in) = " + Arrays.toString(in));
            System.out.println("Arrays.toString(top) = " + Arrays.toString(top));
            System.out.println("Arrays.toString(parent) = " + Arrays.toString(parent));
        }

        public void update(int leafNodeSize, int u, int v) {
            while (top[u] != top[v]) {
                if (depth[top[u]] < depth[top[v]]) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
                segmentTree.update(1, leafNodeSize, in[top[u]], in[u], 1);
                u = parent[top[u]];
            }

            if (in[u] > in[v]) {
                int temp = u;
                u = v;
                v = temp;
            }
            segmentTree.update(1, leafNodeSize, in[u] + 1, in[v], 1);
        }

        private int query(int leafNodeSize, int u, int v) {
            int sum = 0;
            while (top[u] != top[v]) {
                if (depth[top[u]] < depth[top[v]]) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
                sum += segmentTree.query(1, leafNodeSize, in[top[u]], in[u], 1);
                u = parent[top[u]];
            }

            if (in[u] > in[v]) {
                int temp = u;
                u = v;
                v = temp;
            }
            sum += segmentTree.query(1, leafNodeSize, in[u] + 1, in[v], 1);
            return sum;
        }
    }

    static class SegmentTree {

        int[] nodes;
        int[] lazyNodes;

        public SegmentTree(int leafNodeSize) {
            nodes = new int[leafNodeSize * 4];
            lazyNodes = new int[leafNodeSize * 4];
        }

        private void propagate(int start, int end, int nodeNum) {
            if (lazyNodes[nodeNum] != 0) {
                nodes[nodeNum] += (end - start + 1) * lazyNodes[nodeNum];
                if (start != end) {
                    lazyNodes[nodeNum << 1] += lazyNodes[nodeNum];
                    lazyNodes[nodeNum << 1 | 1] += lazyNodes[nodeNum];
                }
                lazyNodes[nodeNum] = 0;
            }
        }

        public void update(int start, int end, int queryLeft, int queryRight, int nodeNum) {
            propagate(start, end, nodeNum);
            if (queryRight < start || end < queryLeft) {
                return;
            }

            if (queryLeft <= start && end <= queryRight) {
                nodes[nodeNum] += (end - start + 1);
                if (start != end) {
                    lazyNodes[nodeNum << 1]++;
                    lazyNodes[nodeNum << 1 | 1]++;
                }
                return;
            }

            int mid = (start + end) >> 1;
            update(start, mid, queryLeft, queryRight, nodeNum << 1);
            update(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
            nodes[nodeNum] = nodes[nodeNum << 1] + nodes[nodeNum << 1 | 1];
        }

        public int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
            propagate(start, end, nodeNum);

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
}