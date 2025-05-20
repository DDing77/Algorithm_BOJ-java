import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int eulerIdx = 0;

    private int N;
    private int M;
    private SegmentTree downTree;
    private SegmentTree upTree;
    private List<Integer>[] edges;
    private int[] in;
    private int[] out;

    private void getEuler(int cur) {
        in[cur] = ++eulerIdx;
        for (int next : edges[cur]) {
            getEuler(next);
        }
        out[cur] = eulerIdx;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (i == 1) {
                continue;
            }
            edges[parent].add(i);
        }

        in = new int[N + 1];
        out = new int[N + 1];
        getEuler(1);

        downTree = new SegmentTree(N);
        upTree = new SegmentTree(N);

        int dir = 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int x = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                if (dir == 1) {
                    downTree.update(1, N, in[x], out[x], w, 1);
                } else if (dir == -1) {
                    upTree.update(1, N, in[x], in[x], w, 1);
                }
            } else if (op == 2) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(downTree.query(1, N, in[x], in[x], 1) + upTree.query(1, N, in[x], out[x], 1)).append("\n");
            } else if (op == 3) {
                dir *= -1;
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
        int[] lazyNodes;

        public SegmentTree(int leftNodeSize) {
            nodes = new int[leftNodeSize * 4];
            lazyNodes = new int[leftNodeSize * 4];
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

        public int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
            propagate(start, end, nodeNum);

            if (queryRight < start || end < queryLeft) {
                return 0;
            }

            if (start == end) {
                return nodes[nodeNum];
            }

            int mid = (start + end) >> 1;
            return query(start, mid, queryLeft, queryRight, nodeNum << 1)
                    + query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
        }

        private void update(int start, int end, int queryLeft, int queryRight, int value, int nodeNum) {
            propagate(start, end, nodeNum);

            if (queryRight < start || end < queryLeft) {
                return;
            }

            if (queryLeft <= start && end <= queryRight) {
                nodes[nodeNum] += (end - start + 1) * value;
                if (start != end) {
                    lazyNodes[nodeNum << 1] += value;
                    lazyNodes[nodeNum << 1 | 1] += value;
                }
                return;
            }

            int mid = (start + end) >> 1;
            update(start, mid, queryLeft, queryRight, value, nodeNum << 1);
            update(mid + 1, end, queryLeft, queryRight, value, nodeNum << 1 | 1);
            nodes[nodeNum] = nodes[nodeNum << 1] + nodes[nodeNum << 1 | 1];
        }
    }
}
