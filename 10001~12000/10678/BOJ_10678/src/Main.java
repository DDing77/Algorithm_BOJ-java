import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int A;
    private int B;
    private int C;
    private int D;
    private ArrayList<Edge>[] edges;
    private PriorityQueue<Integer> pqA;
    private PriorityQueue<Integer> pqB;

    private void execDFS(int curNodeNum, int weightSumA, int weightSumB) {

        if (curNodeNum == N) {
            pqA.add(weightSumA);
            pqB.add(weightSumB);
            return;
        }

        for (Edge next : edges[curNodeNum]) {
            execDFS(next.to, weightSumA + next.weightA,
                    weightSumB + next.weightB);
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            edges[A].add(new Edge(B, C, D));
        }

        pqA = new PriorityQueue<>();
        pqB = new PriorityQueue<>();
        execDFS(1, 0, 0);

        while (!pqA.isEmpty() && !pqB.isEmpty()) {
            if (pqA.peek().equals(pqB.peek())) {
                System.out.println(pqA.poll());
                return;
            } else if (pqA.peek() > pqB.peek()) {
                pqB.poll();
            } else {
                pqA.poll();
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Edge {

        int to;
        int weightA;
        int weightB;

        public Edge(int to, int weightA, int weightB) {
            this.to = to;
            this.weightA = weightA;
            this.weightB = weightB;
        }
    }
}
