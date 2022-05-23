import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final long MOD = 1000000007;
    static int N, M;
    static long[] arr;
    static long[] tree;
    static long[][] lazy;

    static long initTD(int start, int end, int nodeNum) {
        if (start == end) return tree[nodeNum] = arr[start];

        int mid = (start + end) >> 1;
        return tree[nodeNum] = (initTD(start, mid, nodeNum * 2)
                + initTD(mid + 1, end, nodeNum * 2 + 1)) % MOD;
    }

    static void lazyTD(int start, int end, int nodeNum) {
        long left = lazy[nodeNum][0];
        long right = lazy[nodeNum][1];
        if (left == 1 && right == 0) return;
        if (start != end) {
            for (int i : new int[]{nodeNum * 2, nodeNum * 2 + 1}) {
                long left2 = lazy[i][0];
                long right2 = lazy[i][1];
                lazy[i][0] = left * left2;
                lazy[i][0] %= MOD;
                lazy[i][1] = left * right2 + right;
                lazy[i][1] %= MOD;
            }
        }
        tree[nodeNum] = left * tree[nodeNum] + (end - start + 1) * right;
        tree[nodeNum] %= MOD;

        lazy[nodeNum][0] = 1;
        lazy[nodeNum][1] = 0;
    }

    static void updateTD(int start, int end, int queryLeft, int queryRight, long mul, long sum, int nodeNum) {
        lazyTD(start, end, nodeNum);
        if (queryRight < start || end < queryLeft) return;
        if (queryLeft <= start && end <= queryRight) {
            lazy[nodeNum][0] *= mul;
            lazy[nodeNum][0] %= MOD;
            lazy[nodeNum][1] *= mul;
            lazy[nodeNum][1] %= MOD;
            lazy[nodeNum][1] += sum;
            lazy[nodeNum][1] %= MOD;
            lazyTD(start, end, nodeNum);
            return;
        }

        int mid = (start + end) >> 1;
        updateTD(start, mid, queryLeft, queryRight, mul, sum, nodeNum * 2);
        updateTD(mid + 1, end, queryLeft, queryRight, mul, sum, nodeNum * 2 + 1);
        tree[nodeNum] = (tree[nodeNum * 2] + tree[nodeNum * 2 + 1]) % MOD;
    }

    static long queryTD(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        lazyTD(start, end, nodeNum);
        if (queryRight < start || end < queryLeft) return 0;
        if (queryLeft <= start && end <= queryRight) return tree[nodeNum] % MOD;

        int mid = (start + end) >> 1;
        return (queryTD(start, mid, queryLeft, queryRight, nodeNum * 2)
                + queryTD(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1)) % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new long[N + 1];

        int startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
        int length = startLeaf * 2;

        tree = new long[length + 1];
        lazy = new long[length + 1][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        initTD(1, N, 1);

        for (int i = 0; i <= length; i++) {
            lazy[i][0] = 1;
            lazy[i][1] = 0;
        }

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                long v = Long.parseLong(st.nextToken());
                updateTD(1, N, x, y, 1, v, 1);
            } else if (op == 2) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                long v = Long.parseLong(st.nextToken());
                updateTD(1, N, x, y, v, 0, 1);
            } else if (op == 3) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                long v = Long.parseLong(st.nextToken());
                updateTD(1, N, x, y, 0, v, 1);
            } else {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                sb.append(queryTD(1, N, x, y, 1)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
