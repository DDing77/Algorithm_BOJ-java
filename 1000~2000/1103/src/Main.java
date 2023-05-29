import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean visit[][];
    static int[][] map;
    static int[][] dp;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌 , 우
    static int ans = 0;
    static void dfs(int x, int y, int cnt) {
        if(ans < cnt) ans = cnt;
        dp[x][y] = cnt;
        for (int k = 0; k < 4; k++) {
            int len = map[x][y];
            int nx = x + dir[k][0]*len;
            int ny = y + dir[k][1]*len;
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == Integer.MAX_VALUE) continue;
            // 다시 원점으로 복귀하면 무한으로 돌 수 있음 -> 종료
            if (visit[nx][ny]) {
                System.out.println(-1);
                System.exit(0);
            }
            if(dp[nx][ny] > cnt) continue;
            visit[nx][ny] = true;
            dfs(nx,ny,cnt+1);
            visit[nx][ny] = false;
        }
    }

    static void solution() {
        dp[0][0] = 1;
        visit[0][0] = true;
        dfs(0, 0 ,1);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == 'H') map[i][j] = Integer.MAX_VALUE;
                else {
                    map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
                }
            }
        }
        solution();
    }
}
