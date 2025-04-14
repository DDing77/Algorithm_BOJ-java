import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX = 1_000_000_000;

    private int M;
    private int C;
    private Node rootNode;

    private void propagate(int start, int end, Node curNode) {
        if (curNode.lazy != 0) {
            curNode.cnt = (end - start + 1);
            if (start != end) {
                if (curNode.left == null) {
                    curNode.left = new Node();
                }
                if (curNode.right == null) {
                    curNode.right = new Node();
                }
                curNode.left.lazy += curNode.lazy;
                curNode.right.lazy += curNode.lazy;
            }
            curNode.lazy = 0;
        }
    }

    private void update(int start, int end, int queryLeft, int queryRight, Node curNode) {
        propagate(start, end, curNode);

        if (queryRight < start || end < queryLeft) {
            return;
        }

        if (queryLeft <= start && end <= queryRight) {
            curNode.cnt = (end - start + 1);
            if (start != end) {
                if (curNode.left == null) {
                    curNode.left = new Node();
                }
                if (curNode.right == null) {
                    curNode.right = new Node();
                }
                curNode.left.lazy = 1;
                curNode.right.lazy = 1;
            }
            return;
        }

        int mid = (start + end) >> 1;
        if (curNode.left == null) {
            curNode.left = new Node();
        }
        if (curNode.right == null) {
            curNode.right = new Node();
        }

        update(start, mid, queryLeft, queryRight, curNode.left);
        update(mid + 1, end, queryLeft, queryRight, curNode.right);

        curNode.cnt = curNode.left.cnt + curNode.right.cnt;
    }

    private int query(int start, int end, int queryLeft, int queryRight, Node curNode) {
        propagate(start, end, curNode);

        if (queryRight < start || end < queryLeft) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return curNode.cnt;
        }

        int mid = (start + end) >> 1;
        return (curNode.left != null ? query(start, mid, queryLeft, queryRight, curNode.left) : 0)
                + (curNode.right != null ? query(mid + 1, end, queryLeft, queryRight, curNode.right) : 0);
    }

    private void solution() throws IOException {
        rootNode = new Node();
        C = 0;

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (op == 1) {
                int res = query(1, MAX, left + C, right + C, rootNode);
                C = res;
                sb.append(res).append("\n");
            } else if (op == 2) {
                update(1, MAX, left + C, right + C, rootNode);
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {

        int cnt;
        int lazy;
        Node left;
        Node right;
    }
}
