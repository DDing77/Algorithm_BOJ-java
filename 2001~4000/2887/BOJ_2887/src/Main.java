import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    ArrayList<int[]> planets;
    int[] parent;
    int res;

    private int find(int x) {
        if (parent[x] < 0) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (parent[x] < parent[y]) {
            parent[x] += parent[y];
            parent[y] = x;
        } else {
            parent[y] += parent[x];
            parent[x] = y;
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        planets = new ArrayList<>();
        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            planets.add(new int[]{i, Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())});
        }


        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= 3; i++) {
            int finalI = i;
            planets.sort(Comparator.comparing(o -> o[finalI]));

            for (int j = 0; j < N - 1; j++) {
                int[] planetA = planets.get(j);
                int[] planetB = planets.get(j + 1);
                pq.add(new Edge(planetA[0], planetB[0], Math.abs(planetA[finalI] - planetB[finalI])));
            }
        }

        res = 0;
        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();

            if (find(curEdge.from) != find(curEdge.to)) {
                res += curEdge.weight;
                union(curEdge.from, curEdge.to);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
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
            return Integer.compare(this.weight, o.weight);
        }
    }
}
