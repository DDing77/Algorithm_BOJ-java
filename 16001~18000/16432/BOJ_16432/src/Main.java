import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private List<Integer>[] riceCakes;
    private boolean[][] dp;
    private int[] trace;
    private boolean res;


    private void execDFS(int depth, int pre) {
        if (depth == N) {
            res = true;
            return;
        }

        for (int i = 0; i < riceCakes[depth].size(); i++) {
            int riceCake = riceCakes[depth].get(i);
            if (!dp[depth][riceCake] && pre != riceCake) {
                dp[depth][riceCake] = true;
                trace[depth] = riceCake;
                execDFS(depth + 1, riceCake);

                if (res) {
                    return;
                }
            }
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        riceCakes = new ArrayList[N];

        dp = new boolean[N][10];

        for (int i = 0; i < N; i++) {
            riceCakes[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                riceCakes[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        trace = new int[N];
        execDFS(0, -1);
        if (res) {
            for (int i : trace) {
                sb.append(i).append("\n");
            }
            System.out.print(sb);
        } else {
            System.out.println(-1);
        }

    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
