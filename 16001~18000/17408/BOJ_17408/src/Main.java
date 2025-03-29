import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] numbers;
    private int[] nodeTree;

    private int build(int start, int end, int nodeNum) {
        if (start == end) {
            return nodeTree[nodeNum] = start;
        }

        int mid = (start + end) >> 1;
        int leftIdx = build(start, mid, nodeNum * 2);
        int rightIdx = build(mid + 1, end, nodeNum * 2 + 1);
        if (numbers[leftIdx] > numbers[rightIdx]) {
            return nodeTree[nodeNum] = leftIdx;
        }
        return nodeTree[nodeNum] = rightIdx;
    }

    private int update(int start, int end, int idx, int value, int nodeNum) {
        if (idx < start || end < idx) {
            return nodeTree[nodeNum];
        }

        if (start == end) {
            numbers[idx] = value;
            return nodeTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        int leftIdx = update(start, mid, idx, value, nodeNum * 2);
        int rightIdx = update(mid + 1, end, idx, value, nodeNum * 2 + 1);
        if (numbers[leftIdx] > numbers[rightIdx]) {
            return nodeTree[nodeNum] = leftIdx;
        }
        return nodeTree[nodeNum] = rightIdx;

    }

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodeTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        int leftIdx = query(start, mid, queryLeft, queryRight, nodeNum * 2);
        int rightIdx = query(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
        if (numbers[leftIdx] > numbers[rightIdx]) {
            return leftIdx;
        }
        return rightIdx;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        nodeTree = new int[N * 4];
        build(1, N, 1);

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int i = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                update(1, N, i, v, 1);
            } else if (op == 2) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                int firstIdx = query(1, N, l, r, 1);
                int leftIdx = query(1, N, l, firstIdx - 1, 1);
                int rightIdx = query(1, N, firstIdx + 1, r, 1);

                sb.append(numbers[firstIdx] + Math.max(numbers[leftIdx], numbers[rightIdx])).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
