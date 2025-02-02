import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private double maxWeight;
    private int N;
    private HashMap<String, Integer> nameTable;
    private int M;

    private int[] parents;

    private int find(int x) {

        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private boolean union(int x, int y) {

        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        if (parents[x] <= parents[y]) {
            parents[x] += parents[y];
            parents[y] = x;
        } else {
            parents[y] += parents[x];
            parents[x] = y;
        }

        return true;
    }

    private void solution() throws IOException {

        maxWeight = Double.parseDouble(br.readLine());
        N = Integer.parseInt(br.readLine());

        nameTable = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();

            if (!nameTable.containsKey(name)) {
                nameTable.put(name, i);
            }
        }
        parents = new int[N];
        Arrays.fill(parents, -1);
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.weight));

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String from = st.nextToken();
            String to = st.nextToken();
            double weight = Double.parseDouble(st.nextToken());

            pq.add(new Edge(nameTable.get(from), nameTable.get(to), weight));
        }

        int cnt = 0;
        double totalSum = 0.;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (union(edge.from, edge.to)) {
                cnt++;
                totalSum += edge.weight;
            }

            if (cnt == N - 1) {
                break;
            }
        }

        if (totalSum > maxWeight) {
            System.out.println("Not enough cable");
        } else {
            sb.append("Need ").append(String.format("%.1f", totalSum)).append(" miles of cable");
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Edge {

        int from;
        int to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
