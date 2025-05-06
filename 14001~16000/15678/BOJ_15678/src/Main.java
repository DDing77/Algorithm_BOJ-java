import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static long INF = -100_000_000_000_000L;
    private int N;
    private int D;
    private int[] K;
    private long[] nodes;
    private long res;

    private long query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < start || end < queryLeft) {
            return INF;
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodes[nodeNum];
        }

        int mid = (start + end) >> 1;
        return Math.max(query(start, mid, queryLeft, queryRight, nodeNum << 1),
                 query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1));
    }

    private void update(int start, int end, int targetIdx, long value, int nodeNum) {
        if (targetIdx < start || end < targetIdx) {
            return;
        }

        if (start == end) {
            nodes[nodeNum] = value;
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, targetIdx, value, nodeNum << 1);
        update(mid + 1, end, targetIdx, value, nodeNum << 1 | 1);
        nodes[nodeNum] = Math.max(nodes[nodeNum << 1], nodes[nodeNum << 1 | 1]);
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            K[i] = Integer.parseInt(st.nextToken());
        }

        nodes = new long[N * 4];
        res = INF;
        for (int i = 1; i <= N; i++) {
            long queryRes = query(1, N, i - D, i - 1, 1);
            long maxValue = Math.max(K[i], queryRes + K[i]);
            update(1, N, i, maxValue, 1);
            res = Math.max(res, maxValue);
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
