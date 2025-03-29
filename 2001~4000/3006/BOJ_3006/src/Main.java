import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] numberIdx;
    private int[] nodeTree;

    private int build(int start, int end, int nodeNum) {
        if (start == end) {
            return nodeTree[nodeNum] = 1;
        }

        int mid = (start + end) >> 1;
        return nodeTree[nodeNum] = build(start, mid, nodeNum * 2)
                + build(mid + 1, end, nodeNum * 2 + 1);
    }

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodeTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum * 2)
                + query(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
    }

    private void update(int start, int end, int idx, int nodeNum) {
        if (idx < start || idx > end) {
            return;
        }

        nodeTree[nodeNum]--;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, idx, nodeNum * 2);
        update(mid + 1, end, idx, nodeNum * 2 + 1);
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        nodeTree = new int[N * 4];
        build(1, N, 1);

        numberIdx = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numberIdx[Integer.parseInt(br.readLine())] = i;
        }

        int left = 1;
        int right = N;
        while (left < right) {
            sb.append(query(1, N, 1, numberIdx[left] - 1, 1)).append("\n");
            update(1, N, numberIdx[left], 1);
            left++;
            sb.append(query(1, N, numberIdx[right] + 1, N, 1)).append("\n");
            update(1, N, numberIdx[right], 1);
            right--;
        }

        if (N % 2 != 0) {
            sb.append(0);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
