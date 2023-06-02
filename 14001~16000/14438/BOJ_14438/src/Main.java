import java.io.IOException;

public class Main {

    static int N;
    static int M;
    static int[] num;
    static int[] tree;

    public static int read() throws IOException {
        int c;
        int n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static int init(int start, int end, int nodeNum) {
        if (start == end) {
            return tree[nodeNum] = num[start];
        }

        return tree[nodeNum] = Math.min(init(start, (start + end) >> 1, nodeNum << 1),
                init(((start + end) >> 1) + 1, end, (nodeNum << 1) + 1));
    }

    public static int update(int start, int end, int target, int val, int nodeNum) {
        if (target < start || end < target) {
            return tree[nodeNum];
        }

        if (start == end) {
            return tree[nodeNum] = val;
        }

        return tree[nodeNum] = Math.min(update(start, (start + end) >> 1, target, val, nodeNum << 1),
                update(((start + end) >> 1) + 1, end, target, val, (nodeNum << 1) + 1));
    }

    public static int getMinValue(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return Integer.MAX_VALUE;
        }

        if (queryLeft <= start && end <= queryRight) {
            return tree[nodeNum];
        }

        return Math.min(getMinValue(start, (start + end) >> 1, queryLeft, queryRight, nodeNum << 1),
                getMinValue(((start + end) >> 1) + 1, end, queryLeft, queryRight, (nodeNum << 1) + 1));
    }

    public static void solution() throws IOException {
        StringBuilder sb = new StringBuilder();

        N = read();
        num = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = read();
        }

        int size = 1;
        while (size < N) {
            size *= 2;
        }
        size *= 2;

        tree = new int[size + 1];
        init(1, N, 1);

        M = read();
        while (M-- > 0) {
            int op = read();
            int a = read();
            int b = read();

            if (op == 1) {
                update(1, N, a, b, 1);
            }

            if (op == 2) {
                sb.append(getMinValue(1, N, a, b, 1)).append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
