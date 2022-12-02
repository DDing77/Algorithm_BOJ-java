import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int x;
        int y;
        long dist;

        public Edge(int x, int y, long dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static final int INF = 987654321;
    static ArrayList<Edge> edges;
    static int K, N;
    static long[] distance;

    static boolean bellman() {
        for (int i = 1; i <= K; i++) {
            for (Edge edge : edges) {
//                if(distance[edge.x] > INF) continue;
                if (distance[edge.y] > distance[edge.x] + edge.dist) {
                    if (i == K) return false;
                    distance[edge.y] = distance[edge.x] + edge.dist;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        distance = new long[K + 1];
        edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            edges.add(new Edge(x - 1, y, r));
            edges.add(new Edge(y, x - 1, -r));
        }

        for (int i = 0; i < K; i++) {
            edges.add(new Edge(i, i + 1, 1));
            edges.add(new Edge(i + 1, i, 0));
        }

        Arrays.fill(distance, INF);

        if (!bellman()) {
            sb.append("NONE");
        } else {
            for (int i = 1; i <= K; i++) {
                if (distance[i - 1] < distance[i]) sb.append('#');
                else sb.append('-');
            }
        }
        System.out.println(sb);
    }
}
