import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] nodes;
    static boolean[] isVisited;
    static ArrayList<Integer>[] adj;

    static int dfs(int nodeNum) {
        isVisited[nodeNum] = true;
        int cnt = 0;

        boolean isLeaf = true;
        for (int next : adj[nodeNum]) {
            if (isVisited[next]) continue;
            isLeaf = false;
            cnt += dfs(next);
        }
        if (isLeaf) return 1;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nodes = new int[N];
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        int root = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur == -1) {
                root = i;
                continue;
            }

            adj[cur].add(i);
            adj[i].add(cur);
        }

        M = Integer.parseInt(br.readLine());
        if (M == root) {
            System.out.println(0);
            return;
        }

        isVisited = new boolean[N];
        isVisited[M] = true;
        System.out.println(dfs(root));
    }
}
