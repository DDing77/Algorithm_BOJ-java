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
    private int K;
    private ArrayList<int[]>[] edges;
    private long[][] distances;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, weight});
            edges[b].add(new int[]{a, weight});
        }

        distances = new long[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(distances[i], Long.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.weight));
        pq.add(new Node(1, 0, 0));
        distances[1][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight > distances[cur.nodeNum][cur.cnt]) {
                continue;
            }

            for (int[] nextNodeInfo : edges[cur.nodeNum]) {
                if (distances[nextNodeInfo[0]][cur.cnt] > distances[cur.nodeNum][cur.cnt] + nextNodeInfo[1]) {
                    distances[nextNodeInfo[0]][cur.cnt] = distances[cur.nodeNum][cur.cnt] + nextNodeInfo[1];
                    pq.add(new Node(nextNodeInfo[0], distances[nextNodeInfo[0]][cur.cnt], cur.cnt));
                }

                if (cur.cnt < K && distances[nextNodeInfo[0]][cur.cnt + 1] > distances[cur.nodeNum][cur.cnt]) {
                    distances[nextNodeInfo[0]][cur.cnt + 1] = distances[cur.nodeNum][cur.cnt];
                    pq.add(new Node(nextNodeInfo[0], distances[nextNodeInfo[0]][cur.cnt + 1], cur.cnt + 1));
                }
            }
        }

        long res = Long.MAX_VALUE;
        for (int i = 1; i <= K; i++) {
            res = Math.min(res, distances[N][i]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {
        int nodeNum;
        long weight;
        int cnt;

        public Node(int nodeNum, long weight, int cnt) {
            this.nodeNum = nodeNum;
            this.weight = weight;
            this.cnt = cnt;
        }
    }
}
