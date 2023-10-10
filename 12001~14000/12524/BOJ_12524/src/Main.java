import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ - 12524
 * author - devteo77
 */

public class Main {

    int T;
    int N;
    ArrayList<Integer>[] edges;
    boolean[] isVisited;

    public int execDFS(int node) {
        int res = 1;

        for (int next : edges[node]) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                res += execDFS(next);
            }
        }

        return res;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        int tc = 1;
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            edges = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                edges[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                edges[Integer.parseInt(st.nextToken())].add(i);
            }


            sb.append("Case #").append(tc++).append(":\n");
            for (int i = 1; i <= N; i++) {
                isVisited = new boolean[N + 1];
                isVisited[i] = true;
                sb.append(execDFS(i)).append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
