import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int T;
    private int n;
    private int[] nodes;
    private boolean[] isVisited;
    private boolean[] finished;
    private int res;

    public void dfs(int cur) {
        isVisited[cur] = true;
        int next = nodes[cur];

        if (!isVisited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                res--;
                for (int i = next; i != cur; i = nodes[i]) {
                    res--;
                }
            }
        }

        finished[cur] = true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            nodes = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                nodes[i] = Integer.parseInt(st.nextToken());
            }

            isVisited = new boolean[n + 1];
            finished = new boolean[n + 1];
            res = n;
            for (int i = 1; i <= n; i++) {
                if (!isVisited[i]) {
                    dfs(i);
                }
            }

            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
