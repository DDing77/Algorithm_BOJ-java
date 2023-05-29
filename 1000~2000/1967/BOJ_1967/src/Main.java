import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<Node>[] adj;
    static boolean[] isVisited;
    static int N;
    static int res;
    static int max;
    static int maxIdx;

    static void dfs(int here, int sum) {
        if (max < sum) {
            max = sum;
            maxIdx = here;
        }

        for (Node next : adj[here]) {
            if (!isVisited[next.to]) {
                isVisited[next.to] = true;
                dfs(next.to, sum + next.weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[from].add(new Node(to, weight));
            adj[to].add(new Node(from, weight));
        }

        res = 0;
        max = 0;
        maxIdx = 0;

        isVisited = new boolean[N + 1];
        isVisited[1] = true;
        dfs(1, 0);

        isVisited = new boolean[N + 1];
        isVisited[maxIdx] = true;
        dfs(maxIdx, 0);

        System.out.println(max);
    }
}
