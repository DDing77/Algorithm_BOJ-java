import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int R;
    ArrayList<Integer>[] edges;
    int[] order;
    int[] depth;
    int cnt;
    long res;

    public void execDFS(int here, int dep) {
        depth[here] = dep;
        order[here] = cnt++;

        for (int next : edges[here]) {
            if (depth[next] != -1) {
                continue;
            }
            execDFS(next, dep + 1);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        order = new int[N + 1];
        depth = new int[N + 1];
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

        for (int i = 1; i <= N; i++) {
            depth[i] = -1;
            Collections.sort(edges[i]);
        }

        cnt = 1;
        execDFS(R, 0);

        res = 0;
        for (int i = 1; i <= N; i++) {
            res += (long)order[i] * depth[i];
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
