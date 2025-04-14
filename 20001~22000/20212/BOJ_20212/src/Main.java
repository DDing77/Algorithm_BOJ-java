import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX = 1_000_000_000;
    private int N;

    private Node rootNode = new Node();
    private List<Query> queries1 = new ArrayList<>();
    private List<Query> queries2 = new ArrayList<>();
    private long[] result;

    private void propagate(int start, int end, Node curNode) {
        if (curNode.lazy != 0) {
            curNode.sum += (end - start + 1) * curNode.lazy;
            if (start != end) {
                if (curNode.left == null) {
                    curNode.left = new Node();
                }
                curNode.left.lazy += curNode.lazy;

                if (curNode.right == null) {
                    curNode.right = new Node();
                }
                curNode.right.lazy += curNode.lazy;
            }
            curNode.lazy = 0;
        }
    }

    private void update(int start, int end, int queryLeft, int queryRight, int value, Node curNode) {
        propagate(start, end, curNode);

        if (queryRight < start || end < queryLeft) {
            return;
        }

        if (queryLeft <= start && end <= queryRight) {
            curNode.sum += (end - start + 1) * (long) value;
            if (start != end) {
                if (curNode.left == null) {
                    curNode.left = new Node();
                }
                if (curNode.right == null) {
                    curNode.right = new Node();
                }
                curNode.left.lazy += value;
                curNode.right.lazy += value;
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

        update(start, mid, queryLeft, queryRight, value, curNode.left);
        update(mid + 1, end, queryLeft, queryRight, value, curNode.right);

        curNode.sum = curNode.left.sum + curNode.right.sum;
    }

    private long getResult(int start, int end, int queryLeft, int queryRight, Node curNode) {
        propagate(start, end, curNode);

        if (queryRight < start || end < queryLeft) {
            return 0L;
        }

        if (queryLeft <= start && end <= queryRight) {
            return curNode.sum;
        }

        int mid = (start + end) >> 1;

        return (curNode.left != null ? getResult(start, mid, queryLeft, queryRight, curNode.left) : 0)
                + (curNode.right != null ? getResult(mid + 1, end, queryLeft, queryRight, curNode.right) : 0);
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        int query2Idx = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (op == 1) {
                queries1.add(new Query(i, j, k));
            } else if (op == 2) {
                queries2.add(new Query(query2Idx++, i, j, k));
            }
        }

        Collections.sort(queries2, Comparator.comparingInt(a -> a.k));

        int curQuery1Idx = 0;
        result = new long[query2Idx];
        for (Query query : queries2) {
            while (curQuery1Idx < query.k) {
                Query curQuery = queries1.get(curQuery1Idx);
                int left = curQuery.left;
                int right = curQuery.right;
                int k = curQuery.k;
                update(1, MAX, left, right, k, rootNode);
                curQuery1Idx++;
            }

            result[query.idx] = getResult(1, MAX, query.left, query.right, rootNode);
        }

        for (long res : result) {
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Query {

        int idx;
        int left;
        int right;
        int k;

        public Query(int left, int right, int k) {
            this.left = left;
            this.right = right;
            this.k = k;
        }

        public Query(int idx, int left, int right, int k) {
            this.idx = idx;
            this.left = left;
            this.right = right;
            this.k = k;
        }
    }

    static class Node {

        long sum;
        long lazy;
        Node left;
        Node right;

        public Node() {
            this.sum = 0L;
            this.lazy = 0L;
        }
    }
}
