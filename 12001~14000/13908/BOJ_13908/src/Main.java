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
    private boolean[] selected = new boolean[10];
    private int res;

    private void execDFS(int depth, int count) {
        if (count + N - depth < M) {
            return;
        }
        if (depth == N) {
            if (count == M) {
                res++;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (selected[i]) {
                selected[i] = false;
                execDFS(depth + 1, count + 1);
                selected[i] = true;
            } else {
                execDFS(depth + 1, count);
            }

        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                selected[Integer.parseInt(st.nextToken())] = true;
            }
        }

        execDFS(0, 0);
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
