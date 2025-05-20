import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] numbers;
    private int[] left;
    private int[] right;
    private int[] nodes;
    private long res;

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < start || end < queryLeft) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodes[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum << 1)
                + query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
    }

    private void update(int start, int end, int targetIdx, int nodeNum) {
        if (targetIdx < start || end < targetIdx) {
            return;
        }

        nodes[nodeNum]++;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, targetIdx, nodeNum << 1);
        update(mid + 1, end, targetIdx, nodeNum << 1 | 1);
        nodes[nodeNum] = nodes[nodeNum << 1] + nodes[nodeNum << 1 | 1];
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        nodes = new int[N * 4];
        left = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            left[i] = query(1, N, numbers[i] + 1, N, 1);
            update(1, N, numbers[i], 1);
        }

        nodes = new int[N * 4];
        right = new int[N + 1];
        for (int i = N; i >= 1; i--) {
            right[i] = query(1, N, 1, numbers[i] - 1, 1);
            update(1, N, numbers[i], 1);
        }

        res = 0L;
        for (int i = 1; i <= N; i++) {
            res += left[i] * (long) right[i];
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
