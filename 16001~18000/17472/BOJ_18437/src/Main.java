import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int eulerIdx = 0;

    private int N;
    private int M;
    private int[] childs;
    private List<Integer>[] edges;
    private int[] nodeTree;
    private int[] in;
    private int[] out;
    private SegmentTree segmentTree;

    private void euler(int cur) {
        in[cur] = ++eulerIdx;
        for (int next : edges[cur]) {
            euler(next);
        }
        out[cur] = eulerIdx;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        childs = new int[N + 1];

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (i == 1) {
                continue;
            }
            edges[input].add(i);
        }

        in = new int[N + 1];
        out = new int[N + 1];
        euler(1);
        segmentTree = new SegmentTree(N);

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            if (op == 1) {
                segmentTree.update(1, N, in[i] + 1, out[i], 1, 1);
            } else if (op == 2) {
                segmentTree.update(1, N, in[i] + 1, out[i], -1, 1);
            } else if (op == 3) {
                int queryRes = segmentTree.query(1, N, in[i] + 1, out[i], 1);
                sb.append(queryRes).append("\n");
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
        int[] lazyTree;

        public SegmentTree(int leafNodeSize) {
            nodeTree = new int[leafNodeSize * 4 + 4];
            lazyTree = new int[leafNodeSize * 4 + 4];
            buildTree(1, leafNodeSize, 1);
        }

        private void buildTree(int start, int end, int nodeNum) {
            if (start == end) {
                nodeTree[nodeNum] = 1;
                return;
            }

            int mid = (start + end) >> 1;
            buildTree(start, mid, nodeNum << 1);
            buildTree(mid + 1, end, nodeNum << 1 | 1);
            nodeTree[nodeNum] = nodeTree[nodeNum << 1] + nodeTree[nodeNum << 1 | 1];
        }

        private void propagate(int start, int end, int nodeNum) {
            if (lazyTree[nodeNum] == 1) {
                nodeTree[nodeNum] = (end - start + 1);
                if (start != end) {
                    lazyTree[nodeNum << 1] = 1;
                    lazyTree[nodeNum << 1 | 1] = 1;
                }
            } else if (lazyTree[nodeNum] == -1) {
                nodeTree[nodeNum] = 0;
                if (start != end) {
                    lazyTree[nodeNum << 1] = -1;
                    lazyTree[nodeNum << 1 | 1] = -1;
                }
            }
            lazyTree[nodeNum] = 0;
        }

        public void update(int start, int end, int queryLeft, int queryRight, int value, int nodeNum) {
            propagate(start, end, nodeNum);

            if (queryRight < start || end < queryLeft) {
                return;
            }

            if (queryLeft <= start && end <= queryRight) {
                if (value == 1) {
                    nodeTree[nodeNum] = (end - start + 1);
                    if (start != end) {
                        lazyTree[nodeNum << 1] = 1;
                        lazyTree[nodeNum << 1 | 1] = 1;
                    }
                } else if (value == -1) {
                    nodeTree[nodeNum] = 0;
                    if (start != end) {
                        lazyTree[nodeNum << 1] = -1;
                        lazyTree[nodeNum << 1 | 1] = -1;
                    }
                }
                return;
            }

            int mid = (start + end) >> 1;
            update(start, mid, queryLeft, queryRight, value, nodeNum << 1);
            update(mid + 1, end, queryLeft, queryRight, value, nodeNum << 1 | 1);
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
