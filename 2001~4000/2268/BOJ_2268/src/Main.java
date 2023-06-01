import java.io.IOException;

public class Main {

    static int N;
    static int M;
    static long[] tree;

    public static int nextInt() throws IOException {
        int n = System.in.read() & 15;
        int c;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static long getPrefixSum(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return tree[nodeNum];
        }

        return getPrefixSum(start, (start + end) >> 1, queryLeft, queryRight, nodeNum << 1) +
                getPrefixSum(((start + end) >> 1) + 1, end, queryLeft, queryRight, (nodeNum << 1) + 1);
    }

    public static long update(int start, int end, int target, int nodeNum, int val) {
        if (target < start || end < target) {
            return tree[nodeNum];
        }


        if (start == end) {
            return tree[nodeNum] = val;
        }

        return tree[nodeNum] = update(start, (start + end) >> 1, target, nodeNum << 1, val) +
                update(((start + end) >> 1) + 1, end, target, (nodeNum << 1) + 1, val);
    }

    public static void solution() throws IOException {
        StringBuilder sb = new StringBuilder();

        N = nextInt();
        M = nextInt();

        int size = 1;
        while (size < N) {
            size *= 2;
        }

        size *= 2;

        tree = new long[size + 1];

        int op;
        int a;
        int b;
        while (M-- > 0) {
            op = nextInt();
            a = nextInt();
            b = nextInt();

            if (op == 0) {
                if (a > b) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }

                sb.append(getPrefixSum(1, N, a, b, 1)).append('\n');
            }

            if (op == 1) {
                update(1, N, a, 1, b);
            }

        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
