import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    final int MOD = 1_000_000_007;
    int N;
    int M;
    ArrayList<Integer>[] edges;
    boolean[] isVisited;
    long res;

    public int execDFS(int node) {
        int cnt = 1;

        for (int next : edges[node]) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                cnt += execDFS(next);
            }
        }
        return cnt;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[from].add(to);
            edges[to].add(from);
        }

        isVisited = new boolean[N + 1];
        res = 1L;
        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                res = (res * execDFS(i)) % MOD;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
