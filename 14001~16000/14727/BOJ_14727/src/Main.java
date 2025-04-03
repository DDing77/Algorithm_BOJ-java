import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] heights;
    private int[] minIdxTree;

    private int buildMinIdxTree(int start, int end, int nodeNum) {
        if (start == end) {
            return minIdxTree[nodeNum] = start;
        }

        int mid = (start + end) >> 1;
        int leftMinIdx = buildMinIdxTree(start, mid, nodeNum * 2);
        int rightMinIdx = buildMinIdxTree(mid + 1, end, nodeNum * 2 + 1);
        if (heights[leftMinIdx] < heights[rightMinIdx]) {
            return minIdxTree[nodeNum] = leftMinIdx;
        }
        return minIdxTree[nodeNum] = rightMinIdx;
    }

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return minIdxTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        int leftMinIdx = query(start, mid, queryLeft, queryRight, nodeNum * 2);
        int rightMinIdx = query(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
        if (heights[leftMinIdx] <= heights[rightMinIdx]) {
            return leftMinIdx;
        }
        return rightMinIdx;
    }

    private long getResult(int queryLeft, int queryRight) {
        int minIdx = query(1, N, queryLeft, queryRight, 1);
        long area = (queryRight - queryLeft + 1) * (long) heights[minIdx];

        if (minIdx - 1 > queryLeft) {
            area = Math.max(area, getResult(queryLeft, minIdx - 1));
        }
        if (minIdx + 1 < queryRight) {
            area = Math.max(area, getResult(minIdx + 1, queryRight));
        }
        return area;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        heights = new int[N + 1];
        heights[0] = 1_000_001;
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        minIdxTree = new int[N * 4];
        buildMinIdxTree(1, N, 1);
        System.out.println(getResult(1, N));
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
