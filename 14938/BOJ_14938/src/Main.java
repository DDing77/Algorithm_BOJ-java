import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int num;
        int weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node arg0) {
            return weight - arg0.weight;
        }

    }

    static int N, M, R;
    static ArrayList<Node>[] adj;
    static int[] item;
    static int[] dist;
    static boolean[] isVisited;
    static int res;

    public static int dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(isVisited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (!isVisited[cur.num]) {
                isVisited[cur.num] = true;

                for (Node next : adj[cur.num]) {
                    if (!isVisited[next.num]) {
                        if (dist[next.num] > dist[cur.num] + next.weight) {
                            dist[next.num] = dist[cur.num] + next.weight;
                            pq.add(new Node(next.num, dist[next.num]));
                        }
                    }
                }
            }
        }

        int res = 0;

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= M) {
                res += item[i];
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        isVisited = new boolean[N + 1];
        item = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) item[i] = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[start].add(new Node(end, weight));
            adj[end].add(new Node(start, weight));
        }

        res = 0;
        for (int i = 1; i <= N; i++) res = Math.max(res, dijkstra(i));

        System.out.println(res);
    }
}
