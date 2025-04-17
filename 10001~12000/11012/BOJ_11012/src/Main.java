import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX = 100_001;

    private int T;
    private int N;
    private int M;
    private List<Node> versionRoots;
    private List<Integer> xList;

    private Node insert(Node prev, int l, int r, int pos) {
        if (l > pos || r < pos) return prev;
        if (l == r) return new Node(null, null, prev == null ? 1 : prev.count + 1);

        int mid = (l + r) / 2;
        Node left = insert(prev == null ? null : prev.left, l, mid, pos);
        Node right = insert(prev == null ? null : prev.right, mid + 1, r, pos);
        int cnt = (left == null ? 0 : left.count) + (right == null ? 0 : right.count);
        return new Node(left, right, cnt);
    }

    private int query(Node node, int l, int r, int ql, int qr) {
        if (node == null || r < ql || l > qr) return 0;
        if (ql <= l && r <= qr) return node.count;
        int mid = (l + r) / 2;
        return query(node.left, l, mid, ql, qr) + query(node.right, mid + 1, r, ql, qr);
    }

    private int lowerBound(List<Integer> arr, int target) {
        int l = 0, r = arr.size() - 1, res = arr.size();
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) >= target) {
                res = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return res;
    }

    private int upperBound(List<Integer> arr, int target) {
        int l = 0, r = arr.size() - 1, res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) <= target) {
                res = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return res;
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[][] points = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

            versionRoots = new ArrayList<>();
            xList = new ArrayList<>();
            Node root = null;
            for (int i = 0; i < N; i++) {
                xList.add(points[i][0]);
                root = insert(root, 0, MAX, points[i][1]);
                versionRoots.add(root);
            }

            long total = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                int idxR = upperBound(xList, r);
                int idxL = lowerBound(xList, l);

                int countR = idxR >= 0 ? query(versionRoots.get(idxR), 0, MAX, b, t) : 0;
                int countL = idxL > 0 ? query(versionRoots.get(idxL - 1), 0, MAX, b, t) : 0;
                total += countR - countL;
            }

            System.out.println(total);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {

        Node left;
        Node right;
        int count;

        Node() {
        }

        Node(Node l, Node r, int c) {
            this.left = l;
            this.right = r;
            this.count = c;
        }
    }
}
