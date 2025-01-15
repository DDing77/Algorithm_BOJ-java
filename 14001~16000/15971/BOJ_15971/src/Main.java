import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int A;
    private int B;
    private ArrayList<Edge>[] edges;
    private boolean[] isVisited;

    private int execBFS() {

        isVisited = new boolean[N + 1];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{A, 0, 0});
        isVisited[A] = true;

        int res = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == B) {
                res = cur[1] - cur[2];
                break;
            }

            for (Edge nextEdge : edges[cur[0]]) {
                if (!isVisited[nextEdge.to]) {
                    isVisited[nextEdge.to] = true;
                    que.add(new int[]{nextEdge.to, cur[1] + nextEdge.distance, Math.max(cur[2], nextEdge.distance)});
                }
            }
        }

        return res;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            edges[from].add(new Edge(to, distance));
            edges[to].add(new Edge(from, distance));
        }

        System.out.println(execBFS());
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Edge {

        int to;
        int distance;

        public Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}

