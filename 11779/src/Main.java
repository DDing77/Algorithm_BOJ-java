import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static long[] dist;
    static int[] parent;
    static final long INF = Long.MAX_VALUE;
    static class Bus {
        int to;
        int weight;
        public Bus(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static class Info{
        int idx;
        long dist;
        public Info(int idx, long dist) {
            this.idx = idx;
            this.dist =dist;
        }
    }
    static ArrayList<Bus>[] buses;
    static ArrayList<Integer> routes = new ArrayList<>();

    static void solution(int start, int end) {
        Arrays.fill(dist, 1000000001);
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(o->o.dist));
        dist[start] = 0;
        parent[start] = 0;
        pq.add(new Info(start, 0));

        while(!pq.isEmpty()) {
            Info info = pq.poll();
            if(dist[info.idx] < info.dist) continue;
            for(Bus b : buses[info.idx]) {
                if(dist[info.idx] + b.weight >= dist[b.to]) continue;
                dist[b.to] = dist[info.idx] + b.weight;
                pq.add(new Info(b.to, dist[b.to]));
                parent[b.to] = info.idx;
            }
        }
        int node = end;
        while(node != 0) {
            routes.add(node);
            node = parent[node];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new long[n +1];
        parent = new int[n +1];
        buses = new ArrayList[n + 1];

        for(int i=0; i<=n; i++) {
            buses[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            buses[start].add(new Bus(end,weight));
        }
        st = new StringTokenizer(br.readLine());
        int req1 = Integer.parseInt(st.nextToken());
        int req2 = Integer.parseInt(st.nextToken());
        solution(req1, req2);

        sb.append(dist[req2]).append('\n');
        sb.append(routes.size()).append('\n');
        for(int i= routes.size()-1; i >=0; i--) {
            sb.append(routes.get(i)).append(' ');
        }
        System.out.println(sb);
    }
}