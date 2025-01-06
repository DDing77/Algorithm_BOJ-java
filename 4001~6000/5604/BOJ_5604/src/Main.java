import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] res;

    private void execDFS(int depth, int pre, int remain) {

        if (depth == N || remain == 0) {
            for (int i = 0; i < depth; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = pre; i >= 1; i--) {
            res[depth] = i;
            if (remain - i < 0) {
                continue;
            }
            execDFS(depth + 1, i, remain - i);
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        res = new int[N + 1];

        execDFS(0, N, N);

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
