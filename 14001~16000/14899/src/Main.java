import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        long mn;
        long mx;
        long sum;

        public Node(long mn, long mx, long sum) {
            this.mn = mn;
            this.mx = mx;
            this.sum = sum;
        }

        public Node() {
        }
    }

    static Node[] tree;
    static int n, q;
    static long[] temp1;
    static long[] temp2;

    static void lazy(int start, int end, int nodeNum) {
        if (temp2[nodeNum] <= Long.MIN_VALUE) {
            tree[nodeNum].mx += temp1[nodeNum];
            tree[nodeNum].mn += temp1[nodeNum];
            tree[nodeNum].sum += (end - start + 1) * temp1[nodeNum];
            if ((start ^ end) > 0) {
                temp1[nodeNum * 2] += temp1[nodeNum];
                temp1[nodeNum * 2 + 1] += temp1[nodeNum];
            }
        } else {
            tree[nodeNum].mx = tree[nodeNum].mn = temp1[nodeNum] + temp2[nodeNum];
            tree[nodeNum].sum = (end - start + 1) * (temp1[nodeNum] + temp2[nodeNum]);
            if ((start ^ end) > 0) {
                temp1[nodeNum * 2] = temp1[nodeNum];
                temp1[nodeNum * 2 + 1] = temp1[nodeNum];
                temp2[nodeNum * 2] = temp2[nodeNum];
                temp2[nodeNum * 2 + 1] = temp2[nodeNum];
            }
        }
        temp1[nodeNum] = 0;
        temp2[nodeNum] = Long.MIN_VALUE;
    }

    static Node merge(Node left, Node right) {
        return new Node(Math.min(left.mn, right.mn),
                Math.max(left.mx, right.mx),
                left.sum + right.sum);
    }

    static void add(int start, int end, int queryLeft, int queryRight, long val, int nodeNum) {
        lazy(start, end, nodeNum);
        if (queryRight < start || end < queryLeft) return;
        if (queryLeft <= start && end <= queryRight) {
            temp1[nodeNum] = val;
            lazy(start, end, nodeNum);
            return;
        }

        int mid = (start + end) >> 1;
        add(start, mid, queryLeft, queryRight, val, nodeNum * 2);
        add(mid + 1, end, queryLeft, queryRight, val, nodeNum * 2 + 1);
        tree[nodeNum] = merge(tree[nodeNum * 2], tree[nodeNum * 2 + 1]);
    }

    static void div(int start, int end, int queryLeft, int queryRight, long d, int nodeNum) {
        lazy(start, end, nodeNum);
        if (queryRight < start || end < queryLeft) return;
        if (queryLeft <= start && end <= queryRight) {
            if (Math.floor((double) tree[nodeNum].mn / d) == Math.floor((double) tree[nodeNum].mx / d)) {
                temp2[nodeNum] = (long) Math.floor((double) tree[nodeNum].mn / d);
                lazy(start, end, nodeNum);
                return;
            }
            if (tree[nodeNum].mn + 1 == tree[nodeNum].mx) {
                temp1[nodeNum] = (long) (Math.floor((double) tree[nodeNum].mn / d) - tree[nodeNum].mn);
                lazy(start, end, nodeNum);
                return;
            }
        }

        int mid = (start + end) >> 1;
        div(start, mid, queryLeft, queryRight, d, nodeNum * 2);
        div(mid + 1, end, queryLeft, queryRight, d, nodeNum * 2 + 1);
        tree[nodeNum] = merge(tree[nodeNum * 2], tree[nodeNum * 2 + 1]);
    }

    static Node query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        lazy(start, end, nodeNum);
        if (queryRight < start || end < queryLeft) return new Node(Long.MAX_VALUE, Long.MIN_VALUE, 0);
        if (queryLeft <= start && end <= queryRight) return tree[nodeNum];

        int mid = (start + end) >> 1;
        return merge(query(start, mid, queryLeft, queryRight, nodeNum * 2),
                query(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        int startLeaf = 1;
        while (startLeaf < n) startLeaf *= 2;
        int length = startLeaf * 2;

        tree = new Node[length + 1];
        temp1 = new long[length + 1];
        temp2 = new long[length + 1];

        for (int i = 0; i <= length; i++) tree[i] = new Node();

        Arrays.fill(temp2, Long.MIN_VALUE);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            add(0, n - 1, i, i, input, 1);
        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                add(0, n - 1, l, r, c, 1);
            } else if (op == 2) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());
                div(0, n - 1, l, r, d, 1);
            } else {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                Node now = query(0, n - 1, l, r, 1);
                if (op == 4) sb.append(now.sum).append('\n');
                else sb.append(now.mn).append('\n');
            }
        }
        System.out.print(sb);
    }
}
