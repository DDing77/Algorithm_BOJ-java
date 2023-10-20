import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    int p;
    int w;
    int c;
    int v;
    int[] rank;
    PriorityQueue<Edge> pq;

    public int find(int x) {
        if (rank[x] < 0) {
            return x;
        }
        return rank[x] = find(rank[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (rank[a] < rank[b]) {
            rank[a] += rank[b];
            rank[b] = a;
        } else {
            rank[b] += rank[a];
            rank[a] = b;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        rank = new int[p];
        Arrays.fill(rank, -1);

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.add(new Edge(from, to, weight));
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            union(cur.from, cur.to);

            if (find(c) == find(v)) {
                System.out.println(cur.weight);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return o.weight - this.weight;
        }
    }
}
