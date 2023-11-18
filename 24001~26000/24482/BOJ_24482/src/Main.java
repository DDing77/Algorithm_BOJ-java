import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int R;
    int[] depth;
    ArrayList<Integer>[] edges;

    public void execBFS(int here, int dep) {
        depth[here] = dep;

        for (int next : edges[here]) {
            if (depth[next] == -1) {
                execBFS(next, dep + 1);
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            edges[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(edges[i], Collections.reverseOrder());
        }

        depth = new int[N + 1];
        Arrays.fill(depth, -1);

        execBFS(R, 0);

        for (int i = 1; i <= N; i++) {
            sb.append(depth[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
