import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private List<Integer>[] edges;
    private HLDTree hldTree;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
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
        hldTree.setHldEdges(edges, 1, 1);
        hldTree.initHLDTree(1);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (op == 1) {
                hldTree.update(N, x);
            } else {
                sb.append(hldTree.query(N, x)).append("\n");
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

        SegmentTree segmentTree;
        List<Integer>[] hldEdges;
        int[] size;
        int[] depth;
        int[] parent;
        int[] in;
        int[] top;
        int[] revers;

        public HLDTree(int leafNodeSize) {
            segmentTree = new SegmentTree(leafNodeSize);
            size = new int[leafNodeSize + 1];
            depth = new int[leafNodeSize + 1];
            parent = new int[leafNodeSize + 1];
            in = new int[leafNodeSize + 1];
            top = new int[leafNodeSize + 1];
            revers = new int[leafNodeSize + 1];

            top[1] = 1;
            hldEdges = new ArrayList[leafNodeSize + 1];
            for (int i = 1; i <= leafNodeSize; i++) {
                hldEdges[i] = new ArrayList<>();
            }
        }

        public void setHldEdges(List<Integer>[] edges, int pre, int cur) {
            for (int next : edges[cur]) {
                if (next == pre) {
                    continue;
                }
                hldEdges[cur].add(next);
                setHldEdges(edges, cur, next);
            }
        }

        private void initHLDTree(int rootNodeNum) {
            dfsHLD1(rootNodeNum);
            dfsHLD2(rootNodeNum);
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
            revers[eulerIdx] = cur;
            for (int next : hldEdges[cur]) {
                if (next == hldEdges[cur].get(0)) {
                    top[next] = top[cur];
                } else {
                    top[next] = next;
                }
                dfsHLD2(next);
            }
        }

        private void update(int leafNodeSize, int targetIdx) {
            segmentTree.update(1,leafNodeSize, in[targetIdx], 1);
        }

        private int query(int leafNodeSize, int x) {
            int res = -1;
            while (top[x] != top[1]) {
                int left = segmentTree.query(1, leafNodeSize, in[top[x]], in[x] , 1);
                if (left != -1) {
                    res = left;
                }
                x = parent[top[x]];
            }

            int left = segmentTree.query(1, leafNodeSize, in[1], in[x] , 1);
            if (left != -1) {
                res = left;
            }

            if (res != -1) {
                return revers[res];
            }
            return -1;
        }
    }

    static class SegmentTree {

        int[] nodes;

        public SegmentTree(int leafNodeSize) {
            nodes = new int[leafNodeSize * 4];
        }

        public void update(int start, int end, int targetIdx, int nodeNum) {
            if (targetIdx < start || end < targetIdx) {
                return;
            }

            if (start == end) {
                nodes[nodeNum] ^= 1;
                return;
            }

            int mid = (start + end) >> 1;
            update(start, mid, targetIdx, nodeNum << 1);
            update(mid + 1, end, targetIdx, nodeNum << 1 | 1);
            nodes[nodeNum] = nodes[nodeNum << 1] + nodes[nodeNum << 1 | 1];
        }

        public int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
            if (queryRight < start || end < queryLeft) {
                return -1;
            }

            if (nodes[nodeNum] == 0) {
                return -1;
            }

            if (start == end) {
                return start;
            }

            int mid = (start + end) >> 1;
            int left = query(start, mid, queryLeft, queryRight, nodeNum << 1);
            if (left != -1) {
                return left;
            }
            return query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
        }
    }
}
