import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int xs;
    private int ys;
    private int xe;
    private int ye;
    private long[] distances;

    private ArrayList<Pos> posList = new ArrayList<>();
    private ArrayList<Edge>[] edges;

    private int getDistance(Pos a, Pos b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private void dijkstra() {
        distances = new long[posList.size()];
        Arrays.fill(distances, 9876543211L);

        distances[0] = 0L;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.dist));
        pq.add(new Info(0, 0L));

        while (!pq.isEmpty()) {
            Info cur = pq.poll();

            if (distances[cur.nodeNum] < cur.dist) {
                continue;
            }

            for (Edge e : edges[cur.nodeNum]) {
                if (distances[cur.nodeNum] + e.weight < distances[e.to]) {
                    distances[e.to] = distances[cur.nodeNum] + e.weight;
                    pq.add(new Info(e.to, distances[e.to]));
                }
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        xs = Integer.parseInt(st.nextToken());
        ys = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        xe = Integer.parseInt(st.nextToken());
        ye = Integer.parseInt(st.nextToken());

        posList.add(new Pos(xs, ys));
        posList.add(new Pos(xe, ye));


        edges = new ArrayList[8];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        edges[0].add(new Edge(1, getDistance(posList.get(0), posList.get(1))));

        for (int i = 2; i < 8; i += 2) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            Pos aPos = new Pos(x1, y1);
            Pos bPos = new Pos(x2, y2);
            posList.add(aPos);
            posList.add(bPos);

            edges[0].add(new Edge(i, getDistance(posList.get(0), aPos)));
            edges[0].add(new Edge(i + 1, getDistance(posList.get(0), bPos)));
            edges[i].add(new Edge(1, getDistance(posList.get(1), aPos)));
            edges[i + 1].add(new Edge(1, getDistance(posList.get(1), bPos)));
            edges[i].add(new Edge(i + 1, 10));
            edges[i + 1].add(new Edge(i, 10));
        }

        for (int i = 2; i < posList.size() - 1; i++) {
            for (int j = i + 1; j < posList.size(); j++) {
                edges[i].add(new Edge(j, getDistance(posList.get(i), posList.get(j))));
                edges[j].add(new Edge(i, getDistance(posList.get(i), posList.get(j))));
            }
        }
        dijkstra();

        System.out.println(distances[1]);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        int nodeNum;
        long dist;

        public Info(int nodeNum, long dist) {
            this.nodeNum = nodeNum;
            this.dist = dist;
        }
    }
}
