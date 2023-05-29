import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static class Node {
        long mx;
        long mx2;
        long cntMx;
        long sum;

        public Node(long mx, long mx2, long cntMx, long sum) {
            this.mx = mx;
            this.mx2 = mx2;
            this.cntMx = cntMx;
            this.sum = sum;
        }
    }

    static long[] arr;
    static Node[] tree;

    static Node init(int start, int end, int nodeNum) {
        if (start == end) return tree[nodeNum] = new Node(arr[start], -1, 1, arr[start]);

        int mid = (start + end) >> 1;
        return tree[nodeNum] = merge(init(start, mid, nodeNum * 2), init(mid + 1, end, nodeNum * 2 + 1));
    }

    static Node merge(Node left, Node right) {
        if (left.mx == right.mx)
            return new Node(left.mx, Math.max(left.mx2, right.mx2), left.cntMx + right.cntMx, left.sum + right.sum);
        if (left.mx > right.mx) {
            Node temp = left;
            left = right;
            right = temp;
        }
        return new Node(right.mx, Math.max(left.mx, right.mx2), right.cntMx, left.sum + right.sum);
    }

    static void push(int start, int end, int nodeNum) {
        if (start == end) return;
        for (int i : new int[]{nodeNum * 2, nodeNum * 2 + 1}) {
            if (tree[nodeNum].mx < tree[i].mx) {
                tree[i].sum -= tree[i].cntMx * (tree[i].mx - tree[nodeNum].mx);
                tree[i].mx = tree[nodeNum].mx;
            }
        }
    }

    static void update(int start, int end, int queryLeft, int queryRight, long val, int nodeNum) {
        push(start, end, nodeNum);
        if (queryRight < start || end < queryLeft || tree[nodeNum].mx <= val) return;
        if (queryLeft <= start && end <= queryRight && tree[nodeNum].mx2 < val) {
            tree[nodeNum].sum -= tree[nodeNum].cntMx * (tree[nodeNum].mx - val);
            tree[nodeNum].mx = val;
            push(start, end, nodeNum);
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, queryLeft, queryRight, val, nodeNum * 2);
        update(mid + 1, end, queryLeft, queryRight, val, nodeNum * 2 + 1);
        tree[nodeNum] = merge(tree[nodeNum * 2], tree[nodeNum * 2 + 1]);
    }

    static long getMax(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        push(start, end, nodeNum);
        if (queryRight < start || end < queryLeft) return 0;
        if (queryLeft <= start && end <= queryRight) return tree[nodeNum].mx;

        int mid = (start + end) >> 1;
        return Math.max(getMax(start, mid, queryLeft, queryRight, nodeNum * 2),
                getMax(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1));
    }

    static long getSum(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        push(start, end, nodeNum);
        if (queryRight < start || end < queryLeft) return 0;
        if (queryLeft <= start && end <= queryRight) return tree[nodeNum].sum;

        int mid = (start + end) >> 1;
        return getSum(start, mid, queryLeft, queryRight, nodeNum * 2) +
                getSum(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
        int length = startLeaf * 2;

        tree = new Node[length + 1];
        init(1, N, 1);


        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                long X = Integer.parseInt(st.nextToken());
                update(1, N, L, R, X, 1);
            } else if (op == 2) {
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                sb.append(getMax(1, N, L, R, 1)).append('\n');
            } else {
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                sb.append(getSum(1, N, L, R, 1)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
