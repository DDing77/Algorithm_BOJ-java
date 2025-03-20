import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] A;
    private Node[] nodeTree;

    private Node build(int start, int end, int nodeNum) {
        if (start == end) {
            return nodeTree[nodeNum] = new Node(A[start]);
        }

        int mid = (start + end) >> 1;
        build(start, mid, nodeNum * 2);
        build(mid + 1, end, nodeNum * 2 + 1);

        return nodeTree[nodeNum] = new Node(nodeTree[nodeNum * 2], nodeTree[nodeNum * 2 + 1]);
    }

    private Node query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return new Node(-123456789);
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodeTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        Node leftNode = query(start, mid, queryLeft, queryRight, nodeNum * 2);
        Node rightNode = query(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
        return new Node(leftNode, rightNode);
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        nodeTree = new Node[N * 4];
        build(1, N, 1);

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            Node res = query(1, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
            sb.append(res.maxSub).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {

        long leftMax;
        long rightMax;
        long total;
        long maxSub;

        public Node(int value) {
            this.leftMax = value;
            this.rightMax = value;
            this.total = value;
            this.maxSub = value;
        }

        public Node(Node leftNode, Node rightNode) {
            this.leftMax = Math.max(leftNode.leftMax, leftNode.total + rightNode.leftMax);
            this.rightMax = Math.max(rightNode.rightMax, rightNode.total + leftNode.rightMax);
            this.total = leftNode.total + rightNode.total;
            this.maxSub = Math.max(leftNode.rightMax + rightNode.leftMax, Math.max(leftNode.maxSub, rightNode.maxSub));
        }
    }
}
