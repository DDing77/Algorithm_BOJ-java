import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int INF = 98765;

    private int N;
    private int Q;
    private ArrayList<Line> lines = new ArrayList<>();
    private int[][] dp;

    private boolean check(int aLineIdx, int bLineIdx) {
        Line aLine = lines.get(aLineIdx);
        Line bLine = lines.get(bLineIdx);

        return !(bLine.right < aLine.left || aLine.right < bLine.left);
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            lines.add(new Line(left, right));
        }

        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i; j < N; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }
                if (check(i, j)) {
                    dp[i][j] = 1;
                    dp[j][i] = 1;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int aLineIdx = Integer.parseInt(st.nextToken()) - 1;
            int bLineIdx = Integer.parseInt(st.nextToken()) - 1;

            if (dp[aLineIdx][bLineIdx] == INF) {
                sb.append(-1);
            } else {
                sb.append(dp[aLineIdx][bLineIdx]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Line {
        int left;
        int right;

        public Line(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
