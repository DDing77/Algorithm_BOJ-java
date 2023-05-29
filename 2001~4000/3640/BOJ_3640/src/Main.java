import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E;
    static int MAX;
    static int[][] c;
    static int[][] f;
    static int[][] weight;
    static int[] parent;
    static boolean[] isInQue;
    static ArrayList<Integer>[] edges;
    static int res;

    static void makeEdge(int from, int to, int capacity, int cost) {
        edges[from].add(to);
        edges[to].add(from);

        c[from][to] = capacity;
        weight[from][to] = cost;
        weight[to][from] = -cost;
    }

    static void minCostMaxFlow(int source, int sink) {
        res = 0;
        while (true) {
            parent = new int[MAX];
            Arrays.fill(parent, -1);
            isInQue = new boolean[MAX];
            int[] cost = new int[MAX];
            Arrays.fill(cost, Integer.MAX_VALUE);
            cost[source] = 0;

            Queue<Integer> que = new LinkedList<>();
            que.add(source);
            isInQue[source] = true;

            while (!que.isEmpty()) {
                int cur = que.poll();
                isInQue[cur] = false;
                for (int next : edges[cur]) {
                    if (c[cur][next] - f[cur][next] > 0 && cost[cur] + weight[cur][next] < cost[next]) {
                        cost[next] = cost[cur] + weight[cur][next];
                        parent[next] = cur;
                        if (!isInQue[next]) {
                            que.add(next);
                            isInQue[next] = true;
                        }
                    }
                }
            }

            if (parent[sink] == -1) break;

            for (int i = sink; i != source; i = parent[i]) {
                res += weight[parent[i]][i];
                f[parent[i]][i]++;
                f[i][parent[i]]--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            int sour = V * 2 + 2;
            int sink = V * 2 + 3;
            MAX = V * 2 + 4;

            c = new int[MAX][MAX];
            f = new int[MAX][MAX];
            weight = new int[MAX][MAX];
            edges = new ArrayList[MAX];
            for (int i = 0; i < MAX; i++) {
                Arrays.fill(weight[i], Integer.MAX_VALUE);
                edges[i] = new ArrayList<>();
            }

            makeEdge(sour, 1 * 2, 2, 0);
            makeEdge(V * 2 + 1, sink, 2, 0);
            makeEdge(1 * 2, 1 * 2 + 1, 2, 0);
            makeEdge(V * 2, V * 2 + 1, 2, 0);
            for (int i = 2; i < V; i++) {
                makeEdge(i * 2, i * 2 + 1, 1, 0);
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                makeEdge(from * 2 + 1, to * 2, 1, weight);
            }

            minCostMaxFlow(sour, sink);

            System.out.println(res);
        }
    }
}
