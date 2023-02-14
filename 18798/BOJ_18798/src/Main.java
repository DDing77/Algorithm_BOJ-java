import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, M;
    static int op, l, r, X;
    static int startLeaf;
    static int[] arr;
    static int[] fenTree;
    static int[] tree;

    public static void getStartLeaf() {
        startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
    }

    public static int fenwick_query(int idx) {
        int res = 0;

        while (idx > 0) {
            res += fenTree[idx];
            idx &= (idx - 1);
        }

        return res;
    }

    public static void fenwick_update(int x, int value) {
        while (x <= N) {
            fenTree[x] += value;
            x += (x & -x);
        }
    }

    public static void initTD(int start, int end, int nodeNum) {
        if (start == end) {
            tree[nodeNum] = arr[start];
            return;
        }

        int mid = start + end >> 1;

        initTD(start, mid, nodeNum << 1);
        initTD(mid + 1, end, nodeNum << 1 | 1);

        tree[nodeNum] = tree[nodeNum << 1] & tree[nodeNum << 1 | 1];
    }

    public static void updateTD(int queryLeft, int queryRight, int start, int end, int X, int nodeNUm) {
        if (end < queryLeft || start > queryRight) return;
        if (queryLeft <= start && end <= queryRight && ((tree[nodeNUm] & X) == X)) return;
        if (start == end) {
            if (tree[nodeNUm] == K) {
                fenwick_update(start, -1);
            }
            tree[nodeNUm] |= X;
            if (tree[nodeNUm] == K) {
                fenwick_update(start, 1);
            }
            return;
        }

        X = X & (~tree[nodeNUm]);

        if (X <= 0) return;

        int mid = start + end >> 1;

        updateTD(queryLeft, queryRight, start, mid, X, nodeNUm << 1);
        updateTD(queryLeft, queryRight, mid + 1, end, X, nodeNUm << 1 | 1);

        tree[nodeNUm] = tree[nodeNUm << 1] & tree[nodeNUm << 1 | 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        getStartLeaf();
        tree = new int[startLeaf * 2 + 1];
        fenTree = new int[startLeaf * 2 + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == K) {
                fenwick_update(i, 1);
            }
        }

        initTD(1, N, 1);

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            op = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            if (op == 1) {
                X = Integer.parseInt(st.nextToken());
                updateTD(l, r, 1, N, X, 1);
            } else {
                sb.append(fenwick_query(r) - fenwick_query(l - 1)).append('\n');
            }
        }

        System.out.print(sb);
    }
}
