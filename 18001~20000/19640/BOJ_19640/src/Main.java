import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int K;
    private Queue<Node>[] nodeQues;
    private int resCnt;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nodeQues = new Queue[M];
        for (int i = 0; i < M; i++) {
            nodeQues[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < N; i++) {
            int lineNum = i % M;
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            nodeQues[lineNum].add(new Node(i, lineNum, D, H));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            if (!nodeQues[i].isEmpty()) {
                pq.add(nodeQues[i].poll());
            }
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.orderNumber == K) {
                break;
            }

            if (!nodeQues[cur.lineNumber].isEmpty()) {
                pq.add(nodeQues[cur.lineNumber].poll());
            }
            resCnt++;
        }

        System.out.println(resCnt);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node implements Comparable<Node> {
        int orderNumber;
        int lineNumber;
        int D;
        int H;

        public Node(int orderNumber, int lineNumber, int d, int h) {
            this.orderNumber = orderNumber;
            this.lineNumber = lineNumber;
            D = d;
            H = h;
        }

        @Override
        public int compareTo(Node o) {
            if (this.D == o.D) {
                if (this.H == o.H) {
                    return this.lineNumber - o.lineNumber;
                }
                return o.H - this.H;
            }
            return o.D - this.D;
        }
    }
}
