import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MOD = 1_000_000_007;
    private static final int LENGTH = 200_000;

    private int N;
    private long[] cntTree;
    private long[] preTree;
    private long res;

    private void update(long[] tree, int start, int end, int idx, int value, int nodeNum) {
        if (idx < start || idx > end) {
            return;
        }

        tree[nodeNum] += value;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(tree, start, mid, idx, value, nodeNum * 2);
        update(tree, mid + 1, end, idx, value, nodeNum * 2 + 1);
    }

    private long query(long[] tree, int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 0L;
        }

        if (queryLeft <= start && end <= queryRight) {
            return tree[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(tree, start, mid, queryLeft, queryRight, nodeNum * 2)
                + query(tree, mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        cntTree = new long[LENGTH * 4];
        preTree = new long[LENGTH * 4];

        int X = Integer.parseInt(br.readLine());
        update(cntTree, 0, LENGTH, X, 1, 1);
        update(preTree, 0, LENGTH, X, X, 1);

        res = 1L;
        for (int i = 1; i < N; i++) {
            X = Integer.parseInt(br.readLine());

            long left = X * query(cntTree, 0, LENGTH, 0, Math.max(0, X - 1), 1)
                    - query(preTree, 0, LENGTH, 0, Math.max(0, X - 1), 1);

            long right = query(preTree, 0, LENGTH, Math.min(X + 1, LENGTH), LENGTH, 1)
                    - X * query(cntTree, 0, LENGTH, Math.min(X + 1, LENGTH), LENGTH, 1);

            res = (left + right) % MOD * res % MOD;

            update(cntTree, 0, LENGTH, X, 1, 1);
            update(preTree, 0, LENGTH, X, X, 1);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
