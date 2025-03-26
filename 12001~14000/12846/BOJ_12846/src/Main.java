import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] T;
    private int[] minIdxTree;
    private long res;

    private int build(int start, int end, int nodeNum) {
        if (start == end) {
            return minIdxTree[nodeNum] = start;
        }

        int mid = (start + end) >> 1;
        int leftMinIdx = build(start, mid, nodeNum * 2);
        int rightMinIdx = build(mid + 1, end, nodeNum * 2 + 1);
        if (T[leftMinIdx] > T[rightMinIdx]) {
            return minIdxTree[nodeNum] = rightMinIdx;
        }
        return minIdxTree[nodeNum] = leftMinIdx;
    }

    private int queryMinIdx(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return minIdxTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        int leftMinIdx = queryMinIdx(start, mid, queryLeft, queryRight, nodeNum * 2);
        int rightMinIdx = queryMinIdx(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
        if (T[leftMinIdx] > T[rightMinIdx]) {
            return rightMinIdx;
        }
        return leftMinIdx;
    }

    private void query(int queryLeft, int queryRight) {
        int minIdx = queryMinIdx(1, N, queryLeft, queryRight, 1);
        long area = (long) (queryRight - queryLeft + 1) * T[minIdx];
        res = Math.max(res, area);

        if (queryLeft < minIdx - 1) {
            query(queryLeft, minIdx - 1);
        }
        if (minIdx + 1 < queryRight) {
            query(minIdx + 1, queryRight);
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        T[0] = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }

        minIdxTree = new int[N * 4];
        build(1, N, 1);

        query(1, N);
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
