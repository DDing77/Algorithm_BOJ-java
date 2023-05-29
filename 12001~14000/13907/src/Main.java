import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,K;
    static int start, end;
    static class Edge{
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
    static int[] dist;

    static int dijkstra(int start){
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.dist));
        dist[start] = 0;
        pq.add(new Info(start, 0));
        while(!pq.isEmpty()) {
            Info info = pq.poll();
            if(dist[info.idx] < info.dist) continue;
            for(Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
        return dist[end];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        edges = new ArrayList[N+1];

        for(int i=0; i<=N; i++) {
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[start].add(new Edge(end,weight));
            edges[end].add(new Edge(start,weight));
        }

        sb.append(dijkstra(start));
        for(int i=0; i<K;i ++) {
            int diff = Integer.parseInt(br.readLine());

        }

        System.out.println(dijkstra(start));
    }
}
