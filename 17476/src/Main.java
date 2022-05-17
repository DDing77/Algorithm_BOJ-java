import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, q;
    static long[] tmp1;
    static long[] tmp2;

    static class Node {
        long mx;
        long mn;
        long sum;

        public Node(long mx, long mn, long sum) {
            this.mx = mx;
            this.mn = mn;
            this.sum = sum;
        }

        public Node() {
            this.mx = 0;
            this.mn = 0;
            this.sum = 0;
        }
    }

    static Node[] tree;

    static Node merge(Node a, Node b) {
        return new Node(Math.max(a.mx, b.mx), Math.min(a.mn, b.mn), a.sum + b.sum);
    }

    static void push(int start, int end, int nodeNum) {
        if (tmp1[nodeNum] == 0 && tmp2[nodeNum] == 0) return;
        if (tmp2[nodeNum] == 0) {
            tree[nodeNum].mx += tmp1[nodeNum];
            tree[nodeNum].mn += tmp1[nodeNum];
            tree[nodeNum].sum += (end - start + 1) * tmp1[nodeNum];
            if ((start ^ end) > 0) {
                tmp1[nodeNum * 2] += tmp1[nodeNum];
                tmp1[nodeNum * 2 + 1] += tmp1[nodeNum];
            }
        } else {
            tree[nodeNum].mx = tree[nodeNum].mn = tmp1[nodeNum] + tmp2[nodeNum];
            tree[nodeNum].sum = (end - start + 1) * (tmp1[nodeNum] + tmp2[nodeNum]);
            if ((start ^ end) > 0) {
                tmp1[nodeNum * 2] = tmp1[nodeNum];
                tmp1[nodeNum * 2 + 1] = tmp1[nodeNum];
                tmp2[nodeNum * 2] = tmp2[nodeNum];
                tmp2[nodeNum * 2 + 1] = tmp2[nodeNum];
            }
        }
        tmp1[nodeNum] = tmp2[nodeNum] = 0;
    }

    static void add(int start, int end, int queryLeft, int queryRight, long val, int nodeNum) {
        push(start, end, nodeNum);
        if (queryRight < start || end < queryLeft) return;
        if (queryLeft <= start && end <= queryRight) {
            tmp1[nodeNum] = val;
            push(start, end, nodeNum);
            return;
        }
        int mid = (start + end) >> 1;
        add(start, mid, queryLeft, queryRight, val, nodeNum * 2);
        add(mid + 1, end, queryLeft, queryRight, val, nodeNum * 2 + 1);
        tree[nodeNum] = merge(tree[nodeNum * 2], tree[nodeNum * 2 + 1]);
    }

    static long query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        push(start, end, nodeNum);
        if (queryRight < start || end < queryLeft) return 0;
        if (queryLeft <= start && end <= queryRight) return tree[nodeNum].sum;
        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum * 2) +
                query(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
    }

    static void sq(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        push(start, end, nodeNum);
        if (queryRight < start || end < queryLeft) return;
        if (queryLeft <= start && end <= queryRight) {
            if (Math.floor(Math.sqrt(tree[nodeNum].mn)) == Math.floor(Math.sqrt(tree[nodeNum].mx))) {
                tmp2[nodeNum] = (long) Math.floor(Math.sqrt(tree[nodeNum].mx));
                push(start, end, nodeNum);
                return;
            }
            if (tree[nodeNum].mn + 1 == tree[nodeNum].mx) {
                tmp1[nodeNum] = (long) (Math.floor(Math.sqrt(tree[nodeNum].mn)) - tree[nodeNum].mn);
                push(start, end, nodeNum);
                return;
            }
        }
        int mid = (start + end) >> 1;
        sq(start, mid, queryLeft, queryRight, nodeNum * 2);
        sq(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
        tree[nodeNum] = merge(tree[nodeNum * 2], tree[nodeNum * 2 + 1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        int startLeaf = 1;
        while (startLeaf < n) startLeaf *= 2;
        int length = startLeaf * 2;

        tree = new Node[length + 1];
        tmp1 = new long[length + 1];
        tmp2 = new long[length + 1];

        for (int i = 0; i <= length; i++) {
            tree[i] = new Node();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            long t;
            t = Integer.parseInt(st.nextToken());
            add(1, n, i, i, t, 1);
        }

        q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                add(1, n, a, b, c, 1);
            } else if (op == 2) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sq(1, n, a, b, 1);
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                query(1, n, a, b, 1);
                sb.append(query(1, n, a, b, 1)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
