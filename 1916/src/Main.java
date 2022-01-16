import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, start, end;
    static int sum[];

    static class City {
        int to, cost;

        public City(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Info {
        int idx, sum;

        public Info(int idx, int sum) {
            this.idx = idx;
            this.sum = sum;
        }
    }

    static ArrayList<City>[] cities;

    static void dijkstra(int start) {
        for (int i = 1; i <= N; i++) {
            sum[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.sum));
        pq.add(new Info(start, 0));
        sum[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (sum[info.idx] < info.sum) continue;
            for (City c : cities[info.idx]) {
                if (sum[info.idx] + c.cost >= sum[c.to]) continue;
                sum[c.to] = sum[info.idx] + c.cost;
                pq.add(new Info(c.to, sum[c.to]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        sum = new int[N + 1];
        cities = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            cities[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            cities[from].add(new City(to, cost));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(sum[end]);
    }
}
