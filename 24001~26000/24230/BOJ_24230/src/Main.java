import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private List<Node> edges;
    private boolean[] isVisited;
    private int res;

    private void execDFS(Node curNode, int parentColor) {

        isVisited[curNode.nodeNum] = true;

        if (curNode.targetColor != parentColor) {
            res++;
            parentColor = curNode.targetColor;
        }

        if (curNode.curColor != curNode.targetColor) {
            curNode.curColor = curNode.targetColor;
        }

        for (Node nextNode : curNode.child) {
            if (!isVisited[nextNode.nodeNum]) {
                execDFS(nextNode, parentColor);
            }
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            edges.add(new Node(i + 1, 0, Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            edges.get(from).child.add(edges.get(to));
            edges.get(to).child.add(edges.get(from));
        }

        isVisited = new boolean[N + 1];
        execDFS(edges.get(0), 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Node {

        int nodeNum;
        int curColor;
        int targetColor;
        List<Node> child;

        public Node(int nodeNum, int curColor, int targetColor) {
            this.nodeNum = nodeNum;
            this.curColor = curColor;
            this.targetColor = targetColor;
            child = new ArrayList<>();
        }
    }
}
