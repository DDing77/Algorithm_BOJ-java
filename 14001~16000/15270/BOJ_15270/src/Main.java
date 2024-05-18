import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private boolean[] isVisited;
    private int[][] edges;
    private int res;

    private void execDFS(int depth, int count) {

        if (depth == M) {
            res = Math.max(res, count);
            return;
        }

        if (isVisited[edges[depth][0]] || isVisited[edges[depth][1]]) {
            execDFS(depth + 1, count);
        } else {
            execDFS(depth + 1, count);
            isVisited[edges[depth][0]] = true;
            isVisited[edges[depth][1]] = true;
            execDFS(depth + 1, count + 1);
            isVisited[edges[depth][0]] = false;
            isVisited[edges[depth][1]] = false;
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        isVisited = new boolean[N + 1];
        res = 0;

        execDFS(0, 0);

        res *= 2;
        if (res < N) {
            res++;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}

