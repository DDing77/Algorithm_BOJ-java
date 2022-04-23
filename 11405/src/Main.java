import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static final int MAX = 205, source = 1, sink = 2;
    static int N, M;
    static Queue<Integer> que;
    static ArrayList<Integer>[] adj;
    static int[][] capacity;
    static int[][] flow;
    static int[][] cost;
    static int[] parent;
    static int[] dist;
    static boolean[] inQueue;
    static int res;

    static void MCMF() {
        res = 0;
        while (true) {
            inQueue = new boolean[MAX];
            parent = new int[MAX];
            dist = new int[MAX];

            Arrays.fill(parent, -1);
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(inQueue, false);


            que = new LinkedList<>();
            dist[source] = 0;
            parent[source] = source;
            que.add(source);
            inQueue[source] = true;

            while (!que.isEmpty()) {
                int now = que.poll();
                inQueue[now] = false;
                for (int next : adj[now]) {
                    if (capacity[now][next] - flow[now][next] > 0 && dist[next] > dist[now] + cost[now][next]) {
                        dist[next] = dist[now] + cost[now][next];
                        parent[next] = now;
                        if (!inQueue[next]) {
                            que.add(next);
                            inQueue[next] = true;
                        }
                    }
                }
            }

            if (parent[sink] == -1) break;

            int minFlow = Integer.MAX_VALUE;
            for (int i = sink; i != source; i = parent[i])
                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);

            for (int i = sink; i != source; i = parent[i]) {
                res += minFlow * cost[parent[i]][i];
                flow[parent[i]][i] += minFlow;
                flow[i][parent[i]] -= minFlow;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        capacity = new int[MAX][MAX];
        flow = new int[MAX][MAX];
        cost = new int[MAX][MAX];
        adj = new ArrayList[MAX];
        for (int i = 0; i < MAX; i++) adj[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = M + 3; i < M + N + 3; i++) {
            adj[i].add(sink);
            adj[sink].add(i);

            capacity[i][sink] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 3; i < M + 3; i++) {
            adj[source].add(i);
            adj[i].add(source);

            capacity[source][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 3; i < M + 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = M + 3; j < M + N + 3; j++) {
                adj[i].add(j);
                adj[j].add(i);
                capacity[i][j] = Integer.MAX_VALUE;
                cost[i][j] = Integer.parseInt(st.nextToken());
                cost[j][i] = -cost[i][j];
            }
        }

        MCMF();
        System.out.println(res);
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static int N, M;
//    static final int MAX_SIZE = 850, src = 0, dest = 849, work = 400;
//    static Queue<Integer> que;
//    static ArrayList<Integer>[] adj = new ArrayList[MAX_SIZE];
//    static int[][] capacity;
//    static int[][] flow;
//    static int[][] cost;
//    static int[] parent;
//    static int[] dist;
//    static boolean[] inQueue;
//    static int cnt = 0;
//    static int ans = 0;
//
//    static void MCMF() {
//        while (true) {
//            parent = new int[MAX_SIZE];
//            dist = new int[MAX_SIZE];
//            inQueue = new boolean[MAX_SIZE];
//
//            Arrays.fill(parent, -1);
//            Arrays.fill(dist, Integer.MAX_VALUE);
//            Arrays.fill(inQueue, false);
//
//            que = new LinkedList<>();
//            que.add(src);
//            inQueue[src] = true;
//            dist[src] = 0;
//            parent[src] = src;
//
//            while (!que.isEmpty()) {
//                int now = que.poll();
//                inQueue[now] = false;
//
//                for (int next : adj[now]) {
//                    int nextWeight = cost[now][next];
//
//                    if (capacity[now][next] - flow[now][next] > 0 && dist[next] > dist[now] + nextWeight) {
//                        dist[next] = dist[now] + nextWeight;
//                        parent[next] = now;
//                        if (!inQueue[next]) {
//                            inQueue[next] = true;
//                            que.add(next);
//                        }
//                    }
//                }
//            }
//
//            if (parent[dest] == -1) break;
//
//            int minFlow = Integer.MAX_VALUE;
//            for (int i = dest; i != src; i = parent[i])
//                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
//
//            for (int i = dest; i != src; i = parent[i]) {
//                ans += minFlow * cost[parent[i]][i];
//
//                flow[parent[i]][i] += minFlow;
//                flow[i][parent[i]] -= minFlow;
//            }
//
//            cnt++;
//
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        capacity = new int[MAX_SIZE][MAX_SIZE];
//        cost = new int[MAX_SIZE][MAX_SIZE];
//        flow = new int[MAX_SIZE][MAX_SIZE];
//
//        for (int i = 0; i < MAX_SIZE; i++) adj[i] = new ArrayList<>();
//
//        for (int i = 1; i <= N; i++) {
//            capacity[src][i] = 1;
//
//            adj[src].add(i);
//            adj[i].add(src);
//        }
//
//        for (int i = 1; i <= M; i++) {
//            capacity[work + i][dest] = 1;
//
//            adj[work + i].add(dest);
//            adj[dest].add(work + i);
//        }
//
//
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            int jobs = Integer.parseInt(st.nextToken());
//            for (int j = 0; j < jobs; j++) {
//                int to = Integer.parseInt(st.nextToken());
//                int weight = Integer.parseInt(st.nextToken());
//
//                adj[i].add(work + to);
//                adj[work + to].add(i);
//
//                cost[i][work + to] = weight;
//                cost[work + to][i] = -weight;
//
//                capacity[i][work + to] = 1;
//            }
//        }
//
//        MCMF();
//
//        sb.append(cnt).append('\n');
//        sb.append(ans).append('\n');
//        System.out.print(sb);
//    }
//}
