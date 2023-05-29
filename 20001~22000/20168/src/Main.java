import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Info {
        int idx;
        long length;

        public Info(int idx, long length) {
            this.idx = idx;
            this.length = length;
        }
    }

    static ArrayList<Info>[] edges;
    static int n, m, a, b;
    static long c;
    static long[] dist;
    static long INF = Long.MAX_VALUE;

    static boolean dijkstra(long x) {
        Arrays.fill(dist, INF);
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.length));
        dist[a] = 0;
        pq.add(new Info(a, 0));
        while (!pq.isEmpty()) {
            Info now = pq.poll();
            if (dist[now.idx] < now.length) continue;
            for (Info edge : edges[now.idx]) {
                if (edge.length > x) continue;
                if (dist[edge.idx] > dist[now.idx] + edge.length) {
                    dist[edge.idx] = dist[now.idx] + edge.length;
                    pq.add(new Info(edge.idx, dist[edge.idx]));
                }
            }
        }
        return dist[b] <= c;
    }

    static void solution() {
        dist = new long[n + 1];
        long left = 1;
        long right = 1000000001;
        long ans = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (dijkstra(mid)) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        if (ans == 1000000001) ans = -1;
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Long.parseLong(st.nextToken());

        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long length = Long.parseLong(st.nextToken());
            edges[start].add(new Info(end, length));
            edges[end].add(new Info(start, length));
        }

        solution();
    }
}
