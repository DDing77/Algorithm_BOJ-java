import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] numbers;
    private Node[] nodes;
    private long res = -1L;
    private int minLeft;
    private int minRight;

    private void buildTree(int start, int end, int nodeNum) {
        if (start == end) {
            nodes[nodeNum] = new Node(numbers[start], start);
            return;
        }

        int mid = (start + end) >> 1;
        buildTree(start, mid, nodeNum << 1);
        buildTree(mid + 1, end, nodeNum << 1 | 1);
        if (numbers[nodes[nodeNum << 1].minIdx] < numbers[nodes[nodeNum << 1 | 1].minIdx]) {
            nodes[nodeNum] = new Node(nodes[nodeNum << 1].sum + nodes[nodeNum << 1 | 1].sum, nodes[nodeNum << 1].minIdx);
        } else {
            nodes[nodeNum] = new Node(nodes[nodeNum << 1].sum + nodes[nodeNum << 1 | 1].sum, nodes[nodeNum << 1 | 1].minIdx);
        }
    }

    private Node query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < start || end < queryLeft) {
            return new Node(0, 0);
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodes[nodeNum];
        }

        int mid = (start + end) >> 1;
        Node leftNode = query(start, mid, queryLeft, queryRight, nodeNum << 1);
        Node rightNode = query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
        if (numbers[leftNode.minIdx] < numbers[rightNode.minIdx]) {
            return new Node(leftNode.sum + rightNode.sum, leftNode.minIdx);
        } else {
            return new Node(leftNode.sum + rightNode.sum, rightNode.minIdx);
        }
    }

    private void dnq(int queryLeft, int queryRight) {
        Node res1 = query(1, N, queryLeft, queryRight, 1);
        long resSum = res1.sum * numbers[res1.minIdx];

        if (resSum > res) {
            minLeft = queryLeft;
            minRight = queryRight;
            res = resSum;
        }

        if (queryLeft <= res1.minIdx - 1) {
            dnq(queryLeft, res1.minIdx - 1);
        }

        if (res1.minIdx + 1 <= queryRight) {
            dnq(res1.minIdx + 1, queryRight);
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        numbers[0] = 1_111_111;
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        nodes = new Node[N * 4];
        buildTree(1, N, 1);

        dnq(1, N);

        sb.append(res).append("\n").append(minLeft).append(" ").append(minRight);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {

        long sum;
        int minIdx;

        public Node(long sum, int minIdx) {
            this.sum = sum;
            this.minIdx = minIdx;
        }
    }
}
