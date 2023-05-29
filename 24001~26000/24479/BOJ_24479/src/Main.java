import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static ArrayList<Integer>[] adj;
    static int[] isVisited;
    static int order;
    static void dfs(int here) {
        isVisited[here] = order++;

        for (int next : adj[here]) {
            if (isVisited[next] == 0) dfs(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            adj[to].add(from);
        }

        for (int i = 1; i <= N; i++) Collections.sort(adj[i]);
        isVisited = new int[N + 1];

        order = 1;
        dfs(R);

        for (int i = 1; i <= N; i++) sb.append(isVisited[i]).append('\n');
        System.out.print(sb);
    }
}
