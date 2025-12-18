import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private List<Node> nodes = new ArrayList<>();
    private long res;

    private long cal(int type) {
        int[] colorArr = new int[N];
        colorArr[0] = type;

        Queue<Node> que = new ArrayDeque<>();
        que.add(nodes.get(0));

        while (!que.isEmpty()) {
            Node curNode = que.poll();

            for (Node child : curNode.children) {
                if (colorArr[curNode.nodeNumber] == 1) {
                    colorArr[child.nodeNumber] = 2;
                } else {
                    colorArr[child.nodeNumber] = 1;
                }
                que.add(child);
            }
        }

        long sum = 0L;
        for (int i = 0; i < N; i++) {
            if (colorArr[i] == 1) {
                sum += nodes.get(i).white;
            } else {
                sum += nodes.get(i).black;
            }
        }

        return sum;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i, 0, 0));
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes.get(p).children.add(nodes.get(c));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int white = Integer.parseInt(st.nextToken());
            int black = Integer.parseInt(st.nextToken());
            Node node = nodes.get(i);
            node.white = white;
            node.black = black;
        }

        long firstRes = cal(1);
        long secondRes = cal(2);

        res = Math.min(firstRes, secondRes);
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {
        int nodeNumber;
        int white;
        int black;
        boolean isWhite;
        List<Node> children;

        public Node(int nodeNumber, int white, int black) {
            this.nodeNumber = nodeNumber;
            this.white = white;
            this.black = black;
            children = new ArrayList<>();
        }
    }
}
