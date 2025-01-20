import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private int[] parents;
    private ArrayList<int[]>[] adjs;
    private int resTotalMin;

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

        if (x <= y) {
            parents[x] += parents[y];
            parents[y] = x;
        } else {
            parents[y] += parents[x];
            parents[x] = y;
        }

        return true;
    }

    private int[] execBFS(int startNodeNumber) {

        Queue<int[]> que = new ArrayDeque<>();
        boolean[] isVisited = new boolean[N];
        que.add(new int[]{startNodeNumber, 0});
        isVisited[startNodeNumber] = true;

        int maxFarNodeNumber = startNodeNumber;
        int maxFar = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[1] > maxFar) {
                maxFar = cur[1];
                maxFarNodeNumber = cur[0];
            }

            for (int[] next : adjs[cur[0]]) {
                if (!isVisited[next[0]]) {
                    isVisited[next[0]] = true;
                    que.add(new int[]{next[0], cur[1] + next[1]});
                }
            }
        }

        return new int[]{maxFar, maxFarNodeNumber};
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parents = new int[N];
        Arrays.fill(parents, -1);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Edge(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        adjs = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjs[i] = new ArrayList<>();
        }

        int cnt = 0;
        while (cnt < N - 1) {
            Edge edge = pq.poll();

            if (union(edge.from, edge.to)) {
                resTotalMin += edge.weight;
                cnt++;

                adjs[edge.from].add(new int[]{edge.to, edge.weight});
                adjs[edge.to].add(new int[]{edge.from, edge.weight});
            }
        }

        int[] first = execBFS(0);
        sb.append(resTotalMin).append("\n").append(execBFS(first[1])[0]);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Edge implements Comparable<Edge> {

        int to;
        int from;
        int weight;

        public Edge(int to, int from, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {

            return Integer.compare(this.weight, o.weight);
        }
    }
}
