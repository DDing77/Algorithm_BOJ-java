import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int P;
    private int[] nodeWeights;
    private PriorityQueue<int[]> edges;
    private int[] parents;
    private int minNodeWeight;
    private int minMstWeight;

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

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        nodeWeights = new int[N + 1];
        minNodeWeight = 1000;
        for (int i = 1; i <= N; i++) {
            nodeWeights[i] = Integer.parseInt(br.readLine());
            minNodeWeight = Math.min(minNodeWeight, nodeWeights[i]);
        }

        edges = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new int[]{from, to, nodeWeights[from] + nodeWeights[to] + weight * 2});
        }

        parents = new int[N + 1];
        Arrays.fill(parents, -1);
        int cnt = 0;
        while (!edges.isEmpty() && cnt < N - 1) {
            int[] edge = edges.poll();

            if (union(edge[0], edge[1])) {
                cnt++;
                minMstWeight += edge[2];
            }
        }

        System.out.println(minMstWeight + minNodeWeight);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
