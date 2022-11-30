import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static final int INF = 987654321;
    static int TC;
    static int N, M, W;
    static ArrayList<Edge>[] edges;
    static int[] distance;

    static boolean bellman(int start) {
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        boolean canUpdate = false;


        for (int i = 1; i <= N; i++) {
            canUpdate = false;
            for (int j = 1; j <= N; j++) {
                for (Edge edge : edges[j])
                    if (distance[edge.to] > distance[j] + edge.weight) {
                        canUpdate = true;
                        distance[edge.to] = distance[j] + edge.weight;
                    }
            }

            if (!canUpdate) break;
        }

        if (canUpdate) {
            for (int j = 1; j <= N; j++) {
                for (Edge edge : edges[j])
                    if (distance[edge.to] > distance[j] + edge.weight) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            edges = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) edges[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edges[from].add(new Edge(to, weight));
                edges[to].add(new Edge(from, weight));
            }

            for (int i = M; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edges[from].add(new Edge(to, -weight));
            }

            if (bellman(1)) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.print(sb);
    }
}
