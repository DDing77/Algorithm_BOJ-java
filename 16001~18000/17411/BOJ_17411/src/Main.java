import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final int MOD = 1_000_000_007;

    private int N;
    private int[] A;
    private int[] compressedA;
    private Node[] nodeTree;
    private Node emptyNode = new Node(0, 0);

    private Node merge(Node left, Node right) {
        if (left.length > right.length) {
            return left;
        }
        if (left.length < right.length) {
            return right;
        }
        return new Node(left.length, (left.count + right.count) % MOD);
    }

    private Node query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < start || end < queryLeft) {
            return emptyNode;
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodeTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        Node leftNode = query(start, mid, queryLeft, queryRight, nodeNum << 1);
        Node rightNode = query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);

        return merge(leftNode, rightNode);
    }

    private void update(int start, int end, int targetIdx, Node queryResult, int nodeNum) {
        if (targetIdx < start || end < targetIdx) {
            return;
        }

        if (start == end) {
            nodeTree[nodeNum] = merge(nodeTree[nodeNum], queryResult);
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, targetIdx, queryResult, nodeNum << 1);
        update(mid + 1, end, targetIdx, queryResult, nodeNum << 1 | 1);
        nodeTree[nodeNum] = merge(nodeTree[nodeNum << 1], nodeTree[nodeNum << 1 | 1]);
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());


        A = new int[N];
        int[] copyA = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            copyA[i] = A[i];
        }

        Arrays.sort(copyA);
        int seq = 1;
        Map<Integer, Integer> mappingTable = new HashMap<>();
        for (int value : copyA) {
            if (!mappingTable.containsKey(value)) {
                mappingTable.put(value, seq++);
            }
        }

        compressedA = new int[N];
        for (int i = 0; i < N; i++) {
            compressedA[i] = mappingTable.get(A[i]);
        }

        seq = mappingTable.size();
        nodeTree = new Node[seq * 4];
        for (int i = 0; i < nodeTree.length; i++) {
            nodeTree[i] = new Node(0, 0);
        }

        for (int value : compressedA) {
            Node queryResult = query(1, seq, 1, value - 1, 1);
            update(1, seq, value, queryResult.addLength(), 1);
        }

        sb.append(nodeTree[1].length).append(" ").append(nodeTree[1].count);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {
        int length;
        int count;

        public Node(int length, int count) {
            this.length = length;
            this.count = count;
        }

        public Node addLength() {
            Node newNode = new Node(length + 1, count);
            if (newNode.count == 0) {
                newNode.count++;
            }
            return newNode;
        }
    }
}
