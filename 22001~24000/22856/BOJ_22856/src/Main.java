import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private Node[] nodes;
    private ArrayList<Integer> inorderRoute;
    private boolean[] isVisited;
    private int resCnt;

    private void inorder(Node curNode) {

        if (curNode.left != null) {
            inorder(curNode.left);
        }

        inorderRoute.add(curNode.nodeNumber);

        if (curNode.right != null) {
            inorder(curNode.right);
        }
    }

    private void similarInorder(Node curNode) {

        if (curNode.left != null) {
            similarInorder(curNode.left);
            resCnt++;
        }

        if (curNode.nodeNumber == inorderRoute.get(N - 1)) {
            System.out.println(resCnt);
            return;
        } else {
            resCnt++;
        }

        if (curNode.right != null) {
            similarInorder(curNode.right);
            resCnt++;
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parentNum = Integer.parseInt(st.nextToken());
            int leftChildNum = Integer.parseInt(st.nextToken());
            int rightChildNum = Integer.parseInt(st.nextToken());

            if (leftChildNum != -1) {
                nodes[parentNum].setLeftChild(nodes[leftChildNum]);
            }
            if (rightChildNum != -1) {
                nodes[parentNum].setRightChild(nodes[rightChildNum]);
            }
        }

        inorderRoute = new ArrayList<>();
        inorder(nodes[1]);
        similarInorder(nodes[1]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Node {

        int nodeNumber;
        Node left;
        Node right;

        public Node(int nodeNumber) {
            this.nodeNumber = nodeNumber;
        }

        public void setLeftChild(Node left) {
            this.left = left;
        }

        public void setRightChild(Node right) {
            this.right = right;
        }
    }
}
