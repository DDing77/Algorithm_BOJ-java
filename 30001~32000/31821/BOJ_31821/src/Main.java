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
    private int[] cost;
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        cost = new int[N];
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            int idx = Integer.parseInt(br.readLine()) - 1;
            res += cost[idx];
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
