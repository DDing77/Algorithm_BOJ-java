import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k;
    static final int INF = 1000 * 1000 + 1;
    static PriorityQueue<Integer>[] dist;

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static class Info{
        int idx;
        int dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static ArrayList<Edge>[] edges;

    static void solution() {
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.dist));
        dist[1].add(0);
        pq.add(new Info(1,0));

        while(!pq.isEmpty()) {
            Info info = pq.poll();

            if(info.dist > dist[info.idx].peek()) {
                continue;
            }

            for(Edge e : edges[info.idx]) {
                if(dist[e.to].size() < k) {
                    dist[e.to].add(info.dist+ e.weight);
                    pq.add(new Info(e.to, info.dist+ e.weight));
                } else if ( dist[e.to].peek() > info.dist + e.weight) {
                    dist[e.to].poll();
                    dist[e.to].add(info.dist + e.weight);
                    pq.add(new Info(e.to, info.dist+ e.weight));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dist = new PriorityQueue[n+1];
        edges = new ArrayList[n+1];

        for(int i=0; i<=n; i++) {
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[start].add(new Edge(end,weight));
        }

        solution();

        for(int i=1; i<=n; i++) {
            if(dist[i].size() == k) {
                sb.append(dist[i].peek()).append('\n');
            } else{
                sb.append(-1).append('\n');
            }
        }
        System.out.println(sb);
    }
}
