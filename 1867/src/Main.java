import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static boolean[] visited;
    static int[] match;
    static ArrayList<Integer>[] edges;

    static boolean DFS(int now) {
        for (int next : edges[now]) {
            if (visited[next]) continue;
            visited[next] = true;
            if (match[next] == 0 || DFS(match[next])) {
                match[next] = now;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        match = new int[n + 1];

        edges = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) edges[i] = new ArrayList<>();

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            edges[row].add(col);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            if (DFS(i)) cnt++;
        }
        System.out.println(cnt);
    }
}
