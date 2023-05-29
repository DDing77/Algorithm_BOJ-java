import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        int idx;
        int dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static ArrayList<Edge>[] edges;

    static int V, E, P;
    static int[] distance;

    static void dijkstra(int start) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        distance[start] = 0;
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info now = pq.poll();
            if (distance[now.idx] < now.dist) continue;
            for (Edge e : edges[now.idx]) {
                if (distance[e.to] < distance[now.idx] + e.weight) continue;
                distance[e.to] = distance[now.idx] + e.weight;
                pq.add(new Info(e.to, distance[e.to]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        distance = new int[V + 1];
        edges = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[start].add(new Edge(end, weight));
            edges[end].add(new Edge(start, weight));
        }
        dijkstra(1);
        int totalDistance = distance[V];
        dijkstra(P);
        int temp = distance[1] + distance[V];
        if (totalDistance >= temp) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
    }
}
