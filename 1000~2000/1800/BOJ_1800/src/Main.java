import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int P;
    int K;
    ArrayList<Edge>[] edges;
    int[] distance;

    private boolean check(int mid) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        distance = new int[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new int[]{1, 0});
        distance[1] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (distance[cur[0]] < cur[1]) {
                continue;
            }

            for (Edge next : edges[cur[0]]) {
                int nextDistance = cur[1];
                if (next.weight > mid) {
                    nextDistance++;
                }

                if (distance[next.to] > nextDistance) {
                    distance[next.to] = nextDistance;
                    pq.add(new int[]{next.to, nextDistance});
                }

            }
        }

        return distance[N] <= K;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }

        int left = -1;
        int right = 1_000_001;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;

            if (check(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (right == 1_000_001) {
            System.out.println(-1);
        } else {
            System.out.println(right);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Edge {

        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
