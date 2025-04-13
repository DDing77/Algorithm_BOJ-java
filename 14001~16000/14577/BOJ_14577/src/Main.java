import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final long MAX = (long) 1e14 + 1;

    private int N;
    private int M;
    private long[] locations;
    private Node rootNode;

    private void add(long start, long end, long value, Node curNode) {
        if (start == end) {
            curNode.count += 1;
            return;
        }

        long mid = (start + end) >> 1;
        if (value <= mid) {
            if (curNode.left == null) {
                curNode.left = new Node(0);
            }
            add(start, mid, value, curNode.left);
        } else {
            if (curNode.right == null) {
                curNode.right = new Node(0);
            }
            add(mid + 1, end, value, curNode.right);
        }

        curNode.count = (curNode.left != null ? curNode.left.count : 0)
                + (curNode.right != null ? curNode.right.count : 0);
    }

    private void subtract(long start, long end, long value, Node curNode) {
        if (start == end) {
            curNode.count -= 1;
            return;
        }

        long mid = (start + end) >> 1;
        if (value <= mid) {
            subtract(start, mid, value, curNode.left);
        } else {
            subtract(mid + 1, end, value, curNode.right);
        }

        curNode.count = (curNode.left != null ? curNode.left.count : 0)
                + (curNode.right != null ? curNode.right.count : 0);
    }

    private int countQuery(long start, long end, long queryLeft, long queryRight, Node curNode) {
        if (queryRight < start || end < queryLeft) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return curNode.count;
        }

        long mid = (start + end) >> 1;
        return (curNode.left != null ? countQuery(start, mid, queryLeft, queryRight, curNode.left) : 0)
                + (curNode.right != null ? countQuery(mid + 1, end, queryLeft, queryRight, curNode.right) : 0);
    }

    private long orderQuery(long start, long end, int T, Node curNode) {
        if (start == end) {
            return start;
        }

        long mid = (start + end) >> 1;
        int rightCount = (curNode.right != null ? curNode.right.count : 0);

        if (T <= rightCount) {
            return orderQuery(mid + 1, end, T, curNode.right);
        } else {
            return orderQuery(start, mid, T - rightCount, curNode.left);
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rootNode = new Node(0);

        locations = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            long value = Long.parseLong(st.nextToken());
            locations[i] += value;
            add(0, MAX, value, rootNode);
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int i = Integer.parseInt(st.nextToken());
                long x = Long.parseLong(st.nextToken());
                subtract(0, MAX, locations[i], rootNode);
                locations[i] += x;
                add(0, MAX, locations[i], rootNode);
            } else if (op == 2) {
                int i = Integer.parseInt(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                subtract(0, MAX, locations[i], rootNode);
                locations[i] = Math.max(0, locations[i] - y);
                add(0, MAX, locations[i], rootNode);
            } else if (op == 3) {
                long left = Long.parseLong(st.nextToken());
                long right = Long.parseLong(st.nextToken());
                sb.append(countQuery(0, MAX, left, right, rootNode)).append("\n");
            } else if (op == 4) {
                int T = Integer.parseInt(st.nextToken());
                sb.append(orderQuery(0, MAX, T, rootNode)).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {

        int count;
        Node left;
        Node right;

        public Node(int count) {
            this.count = count;
        }
    }
}
