import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int H;
    static int W;
    static int N;
    static int[][] map;
    static int[][] dp;
    static StringBuilder sb;

    public static void execDFS(int x, int y) {
        if (x > H || y > W) {
            sb.append(x + " " + y).append('\n');
            return;
        }

        if (map[x][y] == 1) {
            execDFS(x, y + 1);
        } else {
            execDFS(x + 1, y);
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[H + 1][W + 1];
        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[H + 2][W + 2];
        dp[1][1] = N - 1;
        int visitedCnt;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                visitedCnt = dp[i][j];
                if (map[i][j] == 1) {
                    dp[i][j + 1] += (++visitedCnt / 2);
                    dp[i + 1][j] += (--visitedCnt / 2);
                } else {
                    dp[i + 1][j] += (++visitedCnt / 2);
                    dp[i][j + 1] += (--visitedCnt / 2);
                }
            }
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (dp[i][j] % 2 == 1) {
                    map[i][j] = (map[i][j] + 1) % 2;
                }
            }
        }

        sb = new StringBuilder();
        execDFS(1, 1);
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
