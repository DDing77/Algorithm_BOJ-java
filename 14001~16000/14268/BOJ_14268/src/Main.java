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
    private int[] inIdx;
    private int[] outIdx;
    private List<Integer>[] edges;
    private int[] nodeTree;
    private int[] lazyTree;

    private void eulerPath(int curNodeNum) {
        inIdx[curNodeNum] = ++eulerIdx;
        for (int nextCurNodeNum : edges[curNodeNum]) {
            eulerPath(nextCurNodeNum);
        }
        outIdx[curNodeNum] = eulerIdx;
    }

    private void propagate(int start, int end, int nodeNum) {
        if (lazyTree[nodeNum] != 0) {
            nodeTree[nodeNum] += lazyTree[nodeNum];
            if (start != end) {
                lazyTree[nodeNum << 1] += lazyTree[nodeNum];
                lazyTree[nodeNum << 1 | 1] += lazyTree[nodeNum];
            }
            lazyTree[nodeNum] = 0;
        }
    }

    private int query(int start, int end, int targetIdx, int nodeNum) {
        propagate(start, end, nodeNum);

        if (targetIdx < start || end < targetIdx) {
            return 0;
        }

        if (start == end) {
            return nodeTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, targetIdx, nodeNum << 1) + query(mid + 1, end, targetIdx, nodeNum << 1 | 1);
    }

    private void update(int start, int end, int queryLeft, int queryRight, int value, int nodeNum) {
        propagate(start, end, nodeNum);

        if (queryRight < start || end < queryLeft) {
            return;
        }

        if (queryLeft <= start && end <= queryRight) {
            nodeTree[nodeNum] += value;
            if (start != end) {
                lazyTree[nodeNum << 1] += value;
                lazyTree[nodeNum << 1 | 1] += value;
            }
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, queryLeft, queryRight, value, nodeNum << 1);
        update(mid + 1, end, queryLeft, queryRight, value, nodeNum << 1 | 1);
        nodeTree[nodeNum] = nodeTree[nodeNum << 1] + nodeTree[nodeNum << 1 | 1];
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        childs = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int parentNum = Integer.parseInt(st.nextToken());
            if (parentNum == -1) {
                continue;
            }
            edges[parentNum].add(i);
        }

        inIdx = new int[N + 1];
        outIdx = new int[N + 1];
        eulerPath(1);

        nodeTree = new int[N * 4];
        lazyTree = new int[N * 4];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            if (op == 1) {
                int w = Integer.parseInt(st.nextToken());
                update(1, N, inIdx[i], outIdx[i], w, 1);
            } else if (op == 2) {
                sb.append(query(1, N, inIdx[i], 1)).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
