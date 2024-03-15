import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    HashMap<Integer, Node> nodes;
    int rootNode;
    int[] minLeft;
    int[] maxRight;
    int count;
    int maxDepth;

    private void execDFS(int depth, int rootNode) {
        maxDepth = Math.max(maxDepth, depth);

        Node cur = nodes.get(rootNode);

        if (cur.left != -1) {
            execDFS(depth + 1, cur.left);
        }

        minLeft[depth] = Math.min(minLeft[depth], count);
        maxRight[depth] = count;
        count++;

        if (cur.right != -1) {
            execDFS(depth + 1, cur.right);
        }
    }

    private void solution() throws IOException {

        nodes = new HashMap<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            nodes.put(i, new Node(-1, -1));
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            Node node = nodes.get(num);
            node.left = left;
            node.right = right;

            if (left != -1) {
                nodes.get(left).parent = num;
            }

            if (right != -1) {
                nodes.get(right).parent = num;
            }
        }

        maxRight = new int[N + 1];
        Arrays.fill(maxRight, 0);
        minLeft = new int[N + 1];
        Arrays.fill(minLeft, N);

        for (int num : nodes.keySet()) {
            if (nodes.get(num).parent == -1) {
                rootNode = num;
                break;
            }
        }

        count = 1;
        maxDepth = 0;
        execDFS(1, rootNode);

        int resMinDepth = 0;
        int maxDistance = 0;
        for (int i = 1; i <= maxDepth; i++) {
            int distance = maxRight[i] - minLeft[i] + 1;
            if (distance > maxDistance) {
                maxDistance = distance;
                resMinDepth = i;
            }
        }

        sb.append(resMinDepth).append(" ").append(maxDistance);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Node {
        int parent;
        int left;
        int right;

        public Node(int left, int right) {
            this.parent = -1;
            this.left = left;
            this.right = right;
        }
    }
}
