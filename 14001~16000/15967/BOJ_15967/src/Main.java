import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int Q1;
    private int Q2;
    private int[] damages;
    private long[] sumTree;
    private long[] lazyTree;

    private void buildSumTree(int start, int end, int nodeNum) {
        if (start == end) {
            sumTree[nodeNum] = damages[start];
            return;
        }

        int mid = (start + end) >> 1;
        buildSumTree(start, mid, nodeNum << 1);
        buildSumTree(mid + 1, end, nodeNum << 1 | 1);
        sumTree[nodeNum] = sumTree[nodeNum << 1] + sumTree[nodeNum << 1 | 1];
    }

    private void propagate(int start, int end, int nodeNum) {
        if (lazyTree[nodeNum] != 0) {
            sumTree[nodeNum] += (end - start + 1) * lazyTree[nodeNum];
            if (start != end) {
                lazyTree[nodeNum << 1] += lazyTree[nodeNum];
                lazyTree[nodeNum << 1 | 1] += lazyTree[nodeNum];
            }
            lazyTree[nodeNum] = 0;
        }
    }

    private long query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        propagate(start, end, nodeNum);
        if (queryRight < start || end < queryLeft) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return sumTree[nodeNum];
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
            sumTree[nodeNum] += (end - start + 1) * (long) value;
            if (start != end) {
                lazyTree[nodeNum << 1] += value;
                lazyTree[nodeNum << 1 | 1] += value;
            }
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, queryLeft, queryRight, value, nodeNum << 1);
        update(mid + 1, end, queryLeft, queryRight, value, nodeNum << 1 | 1);

        sumTree[nodeNum] = sumTree[nodeNum << 1] + sumTree[nodeNum << 1 | 1];
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q1 = Integer.parseInt(st.nextToken());
        Q2 = Integer.parseInt(st.nextToken());

        damages = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            damages[i] = Integer.parseInt(st.nextToken());
        }

        sumTree = new long[N * 4];
        buildSumTree(1, N, 1);

        lazyTree = new long[N * 4];
        for (int i = 1; i <= Q1 + Q2; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (op == 1) {
                sb.append(query(1, N, left, right, 1)).append("\n");
            } else if (op == 2) {
                int value = Integer.parseInt(st.nextToken());
                update(1, N, left, right, value, 1);
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
