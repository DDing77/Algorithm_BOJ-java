public class Main {

    static int N;
    static int M;
    static int[] num;
    static int[] tree;

    public static int nextInt() throws Exception {
        int c;
        int n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static int initTD(int start, int end, int nodeNum) {
        if (start == end) {
            return tree[nodeNum] = num[start];
        }

        return tree[nodeNum] = Math.min(initTD(start, (start + end) >> 1, nodeNum << 1),
                initTD(((start + end) >> 1) + 1, end, (nodeNum << 1) + 1));
    }

    public static int queryTD(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return Integer.MAX_VALUE;
        }

        if (queryLeft <= start && end <= queryRight) {
            return tree[nodeNum];
        }

        return Math.min(queryTD(start, (start + end) >> 1, queryLeft, queryRight, nodeNum * 2),
                queryTD(((start + end) >> 1) + 1, end, queryLeft, queryRight, nodeNum * 2 + 1));
    }

    public static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();

        N = nextInt();
        M = nextInt();

        num = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = nextInt();
        }

        int size = 1;
        while (size < N) {
            size *= 2;
        }

        size *= 2;

        tree = new int[size + 1];

        initTD(1, N, 1);

        while (M-- > 0) {
            sb.append(queryTD(1, N, nextInt(), nextInt(), 1)).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
