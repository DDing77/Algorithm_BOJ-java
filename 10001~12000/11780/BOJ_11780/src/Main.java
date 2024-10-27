import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int n;
    private int m;
    private int[][] edges;
    private int[][] traces;

    private void solution() throws IOException {

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        edges = new int[n + 1][n + 1];
        traces = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    edges[i][j] = 98765432;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from][to] = Math.min(edges[from][to], weight);
            traces[from][to] = to;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (edges[i][j] > edges[i][k] + edges[k][j]) {
                        edges[i][j] = edges[i][k] + edges[k][j];
                        traces[i][j] = traces[i][k];
                    }
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (edges[i][j] == 98765432) {
                    sb.append(0);
                } else {
                    sb.append(edges[i][j]);
                }
                sb.append(" ");
            }
            sb.append('\n');
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || edges[i][j] == 98765432) {
                    sb.append(0);
                } else {
                    StringBuilder traceRoute = new StringBuilder();
                    traceRoute.append(i).append(" ");
                    int cur = i;
                    int size = 1;

                    while (cur != j) {
                        traceRoute.append(traces[cur][j]).append(" ");
                        cur = traces[cur][j];
                        size++;
                    }
                    sb.append(size).append(" ").append(traceRoute);
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
