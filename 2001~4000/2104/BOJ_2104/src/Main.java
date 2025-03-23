import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] A;
    private int[] minNodeTree;
    private long[] prefixNodeTree;

    private int buildMinTree(int start, int end, int nodeNum) {
        if (start == end) {
            return minNodeTree[nodeNum] = start;
        }

        int mid = (start + end) >> 1;
        int leftMinIdx = buildMinTree(start, mid, nodeNum * 2);
        int rightMinIdx = buildMinTree(mid + 1, end, nodeNum * 2 + 1);

        if (A[leftMinIdx] < A[rightMinIdx]) {
            return minNodeTree[nodeNum] = leftMinIdx;
        }
        return minNodeTree[nodeNum] = rightMinIdx;
    }

    private long buildPrefixNodeTree(int start, int end, int nodeNum) {
        if (start == end) {
            return prefixNodeTree[nodeNum] = A[start];
        }

        int mid = (start + end) >> 1;
        return prefixNodeTree[nodeNum] = buildPrefixNodeTree(start, mid, nodeNum * 2)
                + buildPrefixNodeTree(mid + 1, end, nodeNum * 2 + 1);
    }

    private long query(int queryLeft, int queryRight) {
        int minIdx = queryMinIdx(1, N, queryLeft, queryRight, 1);
        long prefixSum = queryPrefix(1, N, queryLeft, queryRight, 1);
        long res = prefixSum * A[minIdx];

        if (queryLeft == queryRight) {
            return res;
        }

        if (queryLeft < minIdx) {
            res = Math.max(res, query(queryLeft, minIdx - 1));
        }
        if (minIdx < queryRight) {
            res = Math.max(res, query(minIdx + 1, queryRight));
        }
        return res;
    }

    private long queryPrefix(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return prefixNodeTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        return queryPrefix(start, mid, queryLeft, queryRight, nodeNum * 2)
                + queryPrefix(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
    }

    private int queryMinIdx(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return minNodeTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        int leftMinIdx = queryMinIdx(start, mid, queryLeft, queryRight, nodeNum * 2);
        int rightMinIdx = queryMinIdx(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
        if (A[leftMinIdx] < A[rightMinIdx]) {
            return leftMinIdx;
        }
        return rightMinIdx;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        A[0] = 1_000_001;

        minNodeTree = new int[N * 4];
        buildMinTree(1, N, 1);

        prefixNodeTree = new long[N * 4];
        buildPrefixNodeTree(1, N, 1);

        System.out.println(query(1, N));
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
