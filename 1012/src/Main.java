import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int group_cnt;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();
    static int M, N, K;

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(map[nx][ny] == 0) continue;
            if(visit[nx][ny] == true) continue;
            dfs(nx, ny);
        }
    }

    static void getAns(int M, int N) {
        group_cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    group_cnt++;
                    dfs(i, j);
                }
            }
        }
        sb.append(group_cnt).append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");
            M = Integer.parseInt(str[0]);
            N = Integer.parseInt(str[1]);
            K = Integer.parseInt(str[2]);
            map = new int[M][N];
            visit = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            getAns(M, N);
        }
        System.out.println(sb);
    }
}
